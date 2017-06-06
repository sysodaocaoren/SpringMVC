package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		
		JSONObject jsr=JSONObject.fromObject(str);
		System.out.println(str);
		System.out.println(jsr.get("number"));
		
		String stre="{'people':[{'number':0,'id':1111,'username':'234343','password':2222'},"
				+ "{'number':1,'id':1111,'username':'234343','password':2222'}]}";
		
		JSONObject jres2=JSONObject.fromObject(stre);
		System.out.println(jres2.get("people"));
	}
	
}
