package com.test;

import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.wg.bean.User;

public class JSON {
	
	public static void main(String[] args){
		JSONArray jsonArray=new JSONArray();
		Gson gson=new Gson();
		
		User user=new User();
		user.setId(1111l);
		user.setPassword("2222");
		user.setUsername("234343");
		
		String str=gson.toJson(user);
		System.out.println(str);
	}
	
}
