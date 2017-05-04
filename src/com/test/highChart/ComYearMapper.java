/*package com.ecode.land.persistence.deskTop;

import java.util.List;

import com.ecode.land.domain.contract.Contract;
import com.ecode.land.domain.deskTop.ComYearTable;
import com.ecode.land.domain.deskTop.ComYearZQ;
*//**
 * 首页综合看板，按年度综合查询mapper
 * @author 朱玉猛
 *
 *//*
public interface ComYearMapper {
	*//**
	 * 查询出首页年度综合看板  左上角的表格
	 * @param string 
	 * @return
	 *//*
	ComYearTable queryTable(String string);
	*//**
	 * 查询出地王的信息
	 * @param comYearTable 
	 * @return
	 *//*
	List<Contract> loadSearchLandKing(ComYearTable comYearTable);
	*//**
	 * 宗地数钻取
	 * @param comYearTable
	 * @return
	 *//*
	List<ComYearZQ> viewlandCount(ComYearTable comYearTable);
	*//**
	 * 查询出各个熟化主体 对应应收尽收进度
	 * @param comYearTable6
	 * @return
	 *//*
	List<ComYearTable> loadPlan(ComYearTable comYearTable6);
	*//**
	 * 查询出全部的比例
	 * @param comYearTable6
	 * @return
	 *//*
	
	ComYearTable findTotalComTable(ComYearTable comYearTable6);
	*//**
	 * 月度综合看板
	 * @param comYearTable6
	 * @return
	 *//*
	List<ComYearTable> incom(ComYearTable comYearTable6);
	*//**
	 * 清算单支出
	 * @param comYearTable6
	 * @return
	 *//*
	List<ComYearTable> costQSD(ComYearTable comYearTable6);
	*//**
	 * 资金分配支出
	 * @param comYearTable6
	 * @return
	 *//*
	List<ComYearTable> costAllocation(ComYearTable comYearTable6);
	*//**
	 * 获取所有的熟化主体的名称
	 * @return
	 *//*
	List<String> getCurmainName();
	*//**
	 * 查询15年合同的信息
	 * @param string
	 * @return
	 *//*
	ComYearTable queryContract(String string);

}
*/