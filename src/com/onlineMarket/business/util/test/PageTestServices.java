package com.onlineMarket.business.util.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineMarket.business.util.page.Page;
import com.onlineMarket.business.util.page.impl.PageManager;
@Service("testpageService")
public class PageTestServices {
	private static Logger log = Logger.getLogger(PageTestServices.class);
	@Autowired
	PageTestDao PageTestDao;
	@Autowired 
	PageManager<PageTest> pagemannger;
	public List<PageTest> list(Page page) {
		PageTest pa=new PageTest();
		log.info("00000000000000000000");
		return this.pagemannger.selectPage(pa,page,PageTestDao.class.getName()+".list");
	}
	
	public List<PageTest> listNoPage() {
		return this.PageTestDao.list();
	}
}
