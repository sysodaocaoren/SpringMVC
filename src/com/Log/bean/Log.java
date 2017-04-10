package com.Log.bean;

import java.io.Serializable;
import java.util.Date;

public class Log  implements Serializable{
	 private static final long serialVersionUID = 1024792477652984770L;  
	  
    private Long userid;//管理员id  
    private Date createdate;//日期  
    private String content;//日志内容  
    private String operation;//操作(主要是"添加"、"修改"、"删除")
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
