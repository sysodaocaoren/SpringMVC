package com.Log.bean;

import java.io.Serializable;
import java.util.Date;

public class Log  implements Serializable{
	 private static final long serialVersionUID = 1024792477652984770L;  
	  
    private Long userid;//����Աid  
    private Date createdate;//����  
    private String content;//��־����  
    private String operation;//����(��Ҫ��"���"��"�޸�"��"ɾ��")
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
