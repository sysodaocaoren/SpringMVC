package com.onlineMarket.business.util.page.impl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineMarket.business.util.page.PageMapper;



@Component
public class PageManager<E> extends BasePageManager<E> implements PageMapper<E> {

	@Autowired(required = false)
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}

