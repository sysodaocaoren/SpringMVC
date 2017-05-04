package com.onlineMarket.business.util.page.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import com.onlineMarket.business.util.page.Page;



public class BasePageManager<E> extends DaoSupport {

	protected String yourMapper;
	protected SqlSession sqlSession;
	protected boolean externalSqlSession;
	protected String splitFix=".";
	protected String typeName="typeName";
	protected String result="result";

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (!this.externalSqlSession) {
			this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		}
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSession = sqlSessionTemplate;
		this.externalSqlSession = true;
	}

	public SqlSession getSqlSession() {
		return this.sqlSession;
	}

	protected void checkDaoConfig() {
		Assert.notNull(this.sqlSession,"Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
	}

	public void getSqlSession(SqlSessionTemplate sqlSession) {
		setSqlSessionTemplate(sqlSession);
	}

	@SuppressWarnings("unchecked")
	public List<E> selectPage(Object queryObject, Page page, String selectName) {
		setPageCount(queryObject, page, selectName, null);
		return getSqlSession().selectList(selectName, queryObject,	new RowBounds(page.getOffset(), page.getLimit()));
	}
    /**
     * 计算分页的总数
     * @param queryObject
     * @param page
     * @param selectName
     * @param pos
     */
	private void setPageCount(Object queryObject, Page page, String selectName,	Integer pos) {
		String sql = sqlTemplet(queryObject, selectName, pos);//首先获取sql
		page.setSql("FROM " + sql);
		
		page.setCount(((Integer) getSqlSession().selectOne("page.count", page)).intValue());
		if (!page.getPagReamrk().equals("T")) {
			page.setNowPage(1);
			page.setPagReamrk("T");
		} else {
			page.setNowPage((page.getCount() % page.getPageSize() != 0 ? page.getCount() / page.getPageSize() + 1 : page.getCount()
					/ page.getPageSize()) < page.getNowPage() ? 1 : page.getNowPage());
		}
	}

	private String sqlTemplet(Object queryObject, String selectName, Integer pos) {
		
		String sql = getSqlSession().getConfiguration().getMappedStatement(selectName).getSqlSource().getBoundSql(queryObject).getSql();
		List<ParameterMapping>  l =   getSqlSession().getConfiguration().getMappedStatement(selectName).getBoundSql(queryObject).getParameterMappings();
		
		Field field = null;
		for (int i = 0; i < l.size(); i++) {
			try {
				
				Object currentQueryObject = queryObject;
				String column = ((ParameterMapping) l.get(i)).getProperty();
				
				Map<String,Object> queryResMap = this.getFiledAndQueryObject(column,currentQueryObject,field);
				
				sql = sql.replaceAll("\"", "");
				String prefix = "'";
				String suffix = "'";

				if ("%".equals(sql.substring(sql.indexOf("?") - 1,sql.indexOf("?")))) {
					prefix = prefix + "%";
					sql = sql.replaceFirst("\\%\\?", "?");
				}

				if (sql.indexOf("?") + 1 < sql.length()) {
					if ("%".equals(sql.substring(sql.indexOf("?") + 1,sql.indexOf("?") + 2))) {
						suffix = "%" + suffix;
						sql = sql.replaceFirst("\\?\\%", "?");
					}
				}

				if (("int".equals(typeName)) || ("Integer".equals(typeName)))
					sql = sql.replaceFirst("\\?", queryResMap.get(result).toString());
				else {
					sql = sql.replaceFirst("\\?", prefix + queryResMap.get(result).toString() + suffix);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (pos != null)
			for (int i = 0; i < pos.intValue(); i++) {
				int num = sql.indexOf("FROM");
				sql = sql.substring(num + 4);
			}
		else {
			sql = sql.substring(sql.toUpperCase().indexOf("FROM") + 4);
		}

		if (sql.contains("ORDER")) {
			sql = sql.substring(0, sql.indexOf("ORDER"));
		}
		return sql;
	}

	/**
	 * 递归获取要查询属性的�?
	 * @param column
	 * @param currentQueryObject
	 * @param field
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> getFiledAndQueryObject(String column,Object currentQueryObject, Field field) throws Exception {
		
		if(column.contains(".")){
			
			String queryColumn = column.substring(0, column.indexOf(splitFix));
			field =	currentQueryObject.getClass().getDeclaredField(queryColumn);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			currentQueryObject = field.get(currentQueryObject);
			field.setAccessible(accessible);
			String otherColunm = column.substring(column.indexOf(splitFix)+1);
			
			return	getFiledAndQueryObject(otherColunm, currentQueryObject, field);
			
		}else{
			
			field =	currentQueryObject.getClass().getDeclaredField(column);
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			Object resultObject = field.get(currentQueryObject);
			field.setAccessible(accessible);
			
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put(result, resultObject);
			resultMap.put(typeName, field.getType().getName());
			
			return resultMap;
		}
	}


	public String getYourMapper() {
		return this.yourMapper;
	}

	public void setYourMapper(String yourMapper) {
		this.yourMapper = yourMapper;
	}

	@SuppressWarnings("unchecked")
	public List<E> selectPage(Object queryObject, Page page, String selectName,	Integer pos) {
		setPageCount(queryObject, page, selectName, pos);

		return getSqlSession().selectList(selectName, queryObject,new RowBounds(page.getOffset(), page.getLimit()));
	}
}

