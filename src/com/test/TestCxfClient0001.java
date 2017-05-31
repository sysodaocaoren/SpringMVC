package com.test;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.testCxf0001.SayHi;
import com.test.testCxf0001.SayHiImplServiceLocator;
/**
 * 接口方法的调用test
 * @author zhuyumeng
 *
 */
@Controller
@RequestMapping("testService")
public class TestCxfClient0001 {
	
	@Autowired SayHi sayHiImplService;
	
	@RequestMapping("test1")
	@ResponseBody
	public String test1(){
		String str = null;
		try {
			str = sayHiImplService.sayHello("657");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 直接调用生成的文件
	 * @param args
	 */
	public static void main1(String[] args){
		SayHiImplServiceLocator sy=new SayHiImplServiceLocator();
		try {
			SayHi si=sy.getSayHiImplPort();
			System.out.println(si.sayHello("3242343"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * http://localhost:8090/testCxf0001/services/sayHi?wsdl
	 */
	public static void main2(String[] args){
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8090/testCxf0001/services/sayHi?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://testCxf0001.testCxf.com.cn/", "sayHello");
        // namespace是命名空间，methodName是方法名
        String xmlStr = "aaaaaaaa";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, xmlStr);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public static void main(String[] args){
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();  
        bean.setServiceClass(SayHi.class);  
        bean.setAddress("http://localhost:8090/testCxf0001/services");  
        SayHi helloWorldService = (SayHi)bean.create();  
        String result = null;
		try {
			result = helloWorldService.sayHello("Kevin");
		} catch (RemoteException e) {
			e.printStackTrace();
		}  
        System.out.println(result);
		
	}
}
