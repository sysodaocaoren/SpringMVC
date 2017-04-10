/*package Servlet;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import cn.com.sure.init.dao.DB_Manager;
import cn.com.sure.service.Cert;
import cn.com.sure.service.CodeToString;

public class AdminLoginServlet extends HttpServlet{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	private static final Logger logger2Flie = Logger.getLogger(LoginServlet.class);
	*//**
	 * Constructor of the object.
	 *//*
	public AdminLoginServlet() {
		super();
	}

	*//**
	 * Destruction of the servlet. <br>
	 *//*
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	*//**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 *//*
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DB_Manager db_mgr = new DB_Manager();
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		HttpSession hs = request.getSession();
		response.setContentType("text/html;charset=GB2312");
		
    	
    	//1.从request中获取证书
		X509Certificate[] certChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		
		//2.无证书
		if ((certChain == null) || (certChain.length == 0)) {
			//写管理日志
			logger2Flie.error("您没有有效的管理员证书，不能登录本系统。");
			model.addAttribute("Error_Message","您没有有效的管理员证书，不能登录本系统。");
			return "loginErrors";
		}
		
		X509Certificate cert = (X509Certificate) certChain[0];
		//X509Certificate certDb=db_mgr.findCertById();
		//校验登录
		// 获取提交的用户名
		CodeToString cts = new CodeToString();	
		String dn = "";
		String mgrdn = cert.getSubjectDN().toString();
		//String mgrdn="C=CN,S=123,L=jinan,O=32,OU=22,CN=das";  C=CN,S=SD,L=jinan,O=sure,OU=jishu,CN=测试
		String basecert = "";
		try {
			basecert = new BASE64Encoder().encode(cert.getEncoded());
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		}
		String mgrcert = basecert;
		//如果是C中获取的DN项，包含的Email项格式为E=，修正为Email=的java方式
		int fdEmail = mgrdn.indexOf("E=");
		if(fdEmail>=0)
			mgrdn = mgrdn.replaceAll("E=", "Email=");
	
		if(mgrdn!=null)
		{
			if (mgrdn.indexOf(", ") >= 0) {
				   dn = mgrdn.replaceAll(", ", ",");
			}
			else
				dn = mgrdn;
			hs.setAttribute("CMMgrDn", dn);
		}
		Cert mgCert = new Cert();
		dn = mgCert.dnFormat(mgrdn);
		dn=formatDn(dn);
		hs.setAttribute("CMMgrDn", dn);

		
		//证书根式规范
		mgrcert = mgrcert.replace("\r\n", "");
		
		boolean exist = db_mgr.isExistbyDN(dn);
		//exist=true;
		if(!exist)
		{
			//写管理日志
			logger2Flie.error("CM权限验证-该操作员不存在！["+mgrdn+"]");

			hs.setAttribute("LoginError", "该操作员不存在！");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		//验证管理员证书信息
		String mgrDBCert = db_mgr.getMgrCert(dn);
		if(mgrDBCert==null || mgrDBCert.length()<10)
		{
			//写管理日志
			logger2Flie.error("CM权限验证-获取操作员证书失败！["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "获取操作员证书失败！");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		mgrDBCert = mgrDBCert.replace("\r\n", "");
		if(!mgrcert.equals(mgrDBCert))
		{
			//写管理日志
			logger2Flie.error("CM权限验证-操作员证书验证失败！["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "操作员证书验证失败！");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		int auth = db_mgr.getMgrAuth(dn);
		if(auth == -1||auth == -2)
		{
			//写管理日志
			logger2Flie.error("CM权限验证-获取操作员管理权限失败！["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "获取操作员管理权限失败！");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		//根据用户名称判断用户类型
		if(auth==1)
		{
			hs.setAttribute("CMMgrAuth", "1");
		}
		if(auth==2)
		{
			//写管理日志
			logger2Flie.error("CM权限验证-操作员权限不能登录错误！["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "操作员权限不能登录错误！");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		//添加管理日志
		logger2Flie.warn("CM权限验证-管理员登录成功！["+mgrdn+"]");
    	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		response.sendRedirect("MainIndex/index.jsp");
	}
	*//**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 *//*
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		HttpSession hs = request.getSession();
		response.setContentType("text/html;charset=GB2312");
		
    	
    	//1.从request中获取证书
		X509Certificate[] certChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		
		//2.无证书
		if ((certChain == null) || (certChain.length == 0)) {
			//写管理日志
			logger2Flie.error("您没有有效的管理员证书，不能登录本系统。");
			model.addAttribute("Error_Message","您没有有效的管理员证书，不能登录本系统。");
			return "loginErrors";
		}
		
		X509Certificate cert = (X509Certificate) certChain[0];
		response.sendRedirect("MainIndex/index.jsp");
	}
	*//**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 *//*
	public void init() throws ServletException {
		// Put your code here
	}
	
	public  String formatDn(String dn){
		String result="";
		if(dn!=null&&!"".equals(dn)){
			String [] splitString=dn.split(",");
			String[] resultString=new String[splitString.length];
			if(splitString.length>0){
				for(int i=0;i<splitString.length;i++){
					String codeString=splitString[i].trim();
					String [] splitCode=codeString.split("=");
					if("C".equals(splitCode[0])){
						resultString[0]=codeString;
					}
					if("ST".equals(splitCode[0])){
						resultString[1]="S="+splitCode[1];
					}
					if("L".equals(splitCode[0])){
						resultString[2]=codeString;
					}
					if("O".equals(splitCode[0])){
						resultString[3]=codeString;
					}
					if("OU".equals(splitCode[0])){
						resultString[4]=codeString;
					}
					if("CN".equals(splitCode[0])){
						resultString[5]=codeString;
					}
				}
			}
			for(int j=0;j<resultString.length;j++){
				if(j==0){
					result+=resultString[j];
				}else{
					result+=","+resultString[j];
				}
			}
		}else{
		}
		return result;
	}
}
*/