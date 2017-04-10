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
		
    	
    	//1.��request�л�ȡ֤��
		X509Certificate[] certChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		
		//2.��֤��
		if ((certChain == null) || (certChain.length == 0)) {
			//д������־
			logger2Flie.error("��û����Ч�Ĺ���Ա֤�飬���ܵ�¼��ϵͳ��");
			model.addAttribute("Error_Message","��û����Ч�Ĺ���Ա֤�飬���ܵ�¼��ϵͳ��");
			return "loginErrors";
		}
		
		X509Certificate cert = (X509Certificate) certChain[0];
		//X509Certificate certDb=db_mgr.findCertById();
		//У���¼
		// ��ȡ�ύ���û���
		CodeToString cts = new CodeToString();	
		String dn = "";
		String mgrdn = cert.getSubjectDN().toString();
		//String mgrdn="C=CN,S=123,L=jinan,O=32,OU=22,CN=das";  C=CN,S=SD,L=jinan,O=sure,OU=jishu,CN=����
		String basecert = "";
		try {
			basecert = new BASE64Encoder().encode(cert.getEncoded());
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		}
		String mgrcert = basecert;
		//�����C�л�ȡ��DN�������Email���ʽΪE=������ΪEmail=��java��ʽ
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

		
		//֤���ʽ�淶
		mgrcert = mgrcert.replace("\r\n", "");
		
		boolean exist = db_mgr.isExistbyDN(dn);
		//exist=true;
		if(!exist)
		{
			//д������־
			logger2Flie.error("CMȨ����֤-�ò���Ա�����ڣ�["+mgrdn+"]");

			hs.setAttribute("LoginError", "�ò���Ա�����ڣ�");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		//��֤����Ա֤����Ϣ
		String mgrDBCert = db_mgr.getMgrCert(dn);
		if(mgrDBCert==null || mgrDBCert.length()<10)
		{
			//д������־
			logger2Flie.error("CMȨ����֤-��ȡ����Ա֤��ʧ�ܣ�["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "��ȡ����Ա֤��ʧ�ܣ�");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		mgrDBCert = mgrDBCert.replace("\r\n", "");
		if(!mgrcert.equals(mgrDBCert))
		{
			//д������־
			logger2Flie.error("CMȨ����֤-����Ա֤����֤ʧ�ܣ�["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "����Ա֤����֤ʧ�ܣ�");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		int auth = db_mgr.getMgrAuth(dn);
		if(auth == -1||auth == -2)
		{
			//д������־
			logger2Flie.error("CMȨ����֤-��ȡ����Ա����Ȩ��ʧ�ܣ�["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "��ȡ����Ա����Ȩ��ʧ�ܣ�");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		//�����û������ж��û�����
		if(auth==1)
		{
			hs.setAttribute("CMMgrAuth", "1");
		}
		if(auth==2)
		{
			//д������־
			logger2Flie.error("CMȨ����֤-����ԱȨ�޲��ܵ�¼����["+mgrdn+"]");
	    	
			hs.setAttribute("LoginError", "����ԱȨ�޲��ܵ�¼����");
			response.sendRedirect("MainIndex/Login.jsp");
			return;
		}
		
		//��ӹ�����־
		logger2Flie.warn("CMȨ����֤-����Ա��¼�ɹ���["+mgrdn+"]");
    	
		
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
		
    	
    	//1.��request�л�ȡ֤��
		X509Certificate[] certChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		
		//2.��֤��
		if ((certChain == null) || (certChain.length == 0)) {
			//д������־
			logger2Flie.error("��û����Ч�Ĺ���Ա֤�飬���ܵ�¼��ϵͳ��");
			model.addAttribute("Error_Message","��û����Ч�Ĺ���Ա֤�飬���ܵ�¼��ϵͳ��");
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