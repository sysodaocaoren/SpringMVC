package com.common.config.commonClass;

import java.util.Date;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
	@InitBinder
	public void initBinder(ServletRequestDataBinder bind){
		bind.registerCustomEditor(Date.class, new DateEditor());
	}
}
