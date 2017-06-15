package com.test.designPatterns.briage;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlUtil {
	public static Object getBean(String args){
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dFactory.newDocumentBuilder();
			Document doc=builder.parse(new File("src\\com\\test\\designPatterns\\briage\\config.xml"));
			
			NodeList nl=null;
			Node node=null;
			String cname="";
			
			if("dataSource".equals(args)){
				nl=doc.getElementsByTagName("className");
				node=nl.item(0).getFirstChild();
			}else{
				nl=doc.getElementsByTagName("className");
				node=nl.item(1).getFirstChild();
			}
			cname=node.getNodeValue();
			
			Class<?> c=Class.forName(cname);
			Object obj=c.newInstance();
			return obj;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 
	}
}
