package com.Log.service;

import com.Log.bean.Log;


public interface LogService {

	Long loginUserId();

	void log(Log log);
	
}
