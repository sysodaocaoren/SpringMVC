package com.test.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * tld��ʽ�ı�ǩ��
 * 1.ҳ��������tld�ļ�<%@taglid uri="" prefix=""%>
 * 2.�༭tld�ļ����������֣���ֵ֮��ģ�����ָ��class��
 * 3.дclass��̳�TagSupport
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
			jw.print("���ղ�������һ�����֣���������ǣ�"+nameTest+"</br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.EVAL_PAGE;
	}
}
