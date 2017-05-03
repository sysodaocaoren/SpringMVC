package com.test.velocity;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


public class Test001 extends TagSupport{
	
	private static final long serialVersionUID = 7524954518342215007L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int doStartTag()throws JspException{
		try {
			VelocityEngine ve=new VelocityEngine();
			
			Properties properties = new Properties();
			properties.put("file.resource.loader.path", this.pageContext.getRequest().getRealPath("") + "/WEB-INF/tld/");
			properties.put("input.encoding", "UTF-8");
			properties.put("output.encoding", "UTF-8");
			ve.init(properties);
			
			VelocityContext vc=new VelocityContext();
			vc.put("nameV", this.name);
			
			Template tl=ve.getTemplate("test001.vm","UTF-8");
			
			StringWriter writer=new StringWriter();
			
			tl.merge(vc, writer);
			
			JspWriter jw=pageContext.getOut();
		
			jw.write(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return 123;
	}
}
