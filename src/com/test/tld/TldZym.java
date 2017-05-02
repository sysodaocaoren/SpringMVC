package com.test.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * tld形式的标签：
 * 1.页面上引入tld文件<%@taglid uri="" prefix=""%>
 * 2.编辑tld文件，设置名字，传值之类的，并且指向class类
 * 3.写class类继承TagSupport
 * @author zhuyumeng
 *
 */
public class TldZym extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String nameTest;
	
	public String getNameTest() {
		return nameTest;
	}

	public void setNameTest(String nameTest) {
		this.nameTest = nameTest;
	}

	public int doStartTag() throws JspException {
		JspWriter jw=pageContext.getOut();
		try {
			jw.print("您刚才输入了一个名字，这个名字是："+nameTest+"</br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.EVAL_PAGE;
	}
}
