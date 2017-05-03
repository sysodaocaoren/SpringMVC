package com.onlineMarket.business.util.page;



import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class PageTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5449553949004047645L;
	
	protected Object page;
	
	protected String path;
	
	protected String form;

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public Object getPage() {
		return this.page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	public int doStartTag() throws JspException {
		try {
			//声明引擎
			VelocityEngine ve = new VelocityEngine();
			//给引擎加参数  路径，传入传出字符集
			Properties properties = new Properties();
			properties.put("file.resource.loader.path", this.pageContext.getRequest().getRealPath("") + "/WEB-INF/tld/");
			properties.put("input.encoding", "UTF-8");
			properties.put("output.encoding", "UTF-8");
			//初始化引擎
			ve.init(properties);
			//传递参数
			VelocityContext vContext = new VelocityContext();
			vContext.put("page", this.page);
			vContext.put("form", this.form);
			HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
			vContext.put("path", request.getContextPath());
			Template template = ve.getTemplate("page.vm", "UTF-8");

			StringWriter writer = new StringWriter();

			template.merge(vContext, writer);

			this.pageContext.getOut().print(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int doEndTag() throws JspException {
		return 6;
	}
}

/*
 * Location: D:\EcodeSVN\webLand_jd\src_class\com.jar Qualified Name:
 * com.ecode.land.util.PageTag JD-Core Version: 0.6.2
 */