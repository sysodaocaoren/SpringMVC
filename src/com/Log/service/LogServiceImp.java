package com.Log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Log.bean.Log;
import com.Log.dao.LogDao;

@Service("logService")
public class LogServiceImp implements LogService{
	@Autowired LogDao logdao;

	public Long loginUserId() {
		// TODO Auto-generated method stub
		return 21313l;
	}

	public void log(Log log) {
		logdao.log(log);
	}
	

}
