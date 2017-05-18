//package cn.com.sure.file;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.UnsupportedEncodingException;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Vector;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.log4j.Logger;
//import org.apache.tools.ant.taskdefs.Copy;
//
//import cn.com.sure.bean.CaCertInfo;
//import cn.com.sure.constant.Global;
//import cn.com.sure.dao.DB_CaCert;
//import cn.com.sure.exception.ErrorCode;
//import cn.com.sure.service.CertBc;
//import cn.com.sure.sureLicense.SureLic;
//
//
//
//
//public class UploadFile 
//{
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//	private static final String FILE_TYPE_LIC = "license";
//	private static final String FILE_TYPE_CERT = "certificate";
//	private static final Logger logger = Logger.getLogger(UploadFile.class);
//
//	private String upTempPath;
//	private String realPath;
//	private HashMap<String, Vector<String>> allowedExt;
//	private HashMap<String, String> upPath;
//	HttpServletRequest request;
//	HttpServletResponse response;
//
//	/**
//	 * Constructor of the object.
//	 */
//	public UploadFile(HttpServletRequest request, HttpServletResponse response) {
//		this.request = request;
//		this.response = response;
//		this.allowedExt = new HashMap<String, Vector<String>>();
//		
//		Vector<String> licExt = new Vector<String>();
//		licExt.add("lic");
//		this.allowedExt.put(FILE_TYPE_LIC, licExt);
//		
//		Vector<String> certExt = new Vector<String>();
//		certExt.add("cer");
//		certExt.add("der");
//		certExt.add("crt");
//		certExt.add("pem");
//		this.allowedExt.put(FILE_TYPE_CERT, certExt);
//
//		this.upPath = new HashMap<String, String>();
//		this.upPath.put(FILE_TYPE_LIC, "/upLicense");
//		this.upPath.put(FILE_TYPE_CERT, "/upCertificate");
//		
//		
//		
//	}
//
//	public String doUpload() 
//	{
//		HashMap<String, String> params = new HashMap<String, String>();
//		HttpSession session = request.getSession();
//		this.realPath = session.getServletContext().getRealPath("/");
//		this.upTempPath = this.realPath + "/upTempPath";
//		
//		DiskFileItemFactory dfif = new DiskFileItemFactory();
//		dfif.setSizeThreshold(256 * 1024);
//		dfif.setRepository(new File(upTempPath));
//
//		ServletFileUpload sfu = new ServletFileUpload(dfif);
//		sfu.setSizeMax(256 * 1024);
//		sfu.setHeaderEncoding("gb2312");
//
//		List<?> fileList = null;
//		try {
//			fileList = sfu.parseRequest(request);
//		} catch (FileUploadException e) {
//			logger.warn("上传文件异常 - " + e.toString());
//			// e.printStackTrace();
//			if (e instanceof SizeLimitExceededException) {
//				logger.warn("Upload sys file size is too big.");
//				return ErrorCode.RET_FILE_TOO_BIG;
//			}
//		}
//		if (fileList == null || fileList.size() == 0) {
//			logger.error("Servlet file upload - parse request is null");
//			return ErrorCode.RET_NULL;
//			//return ErrorCode.RET_SUCCESS;
//		}
//		Iterator<?> fileItr = fileList.iterator();
//		while (fileItr.hasNext()) {
//			FileItem fileItem = (FileItem) fileItr.next();
//			if (fileItem == null) {
//				continue;
//			}
//
//			if (fileItem.isFormField()) {
//				try {
//					params.put(fileItem.getFieldName(), fileItem.getString("gb2312"));
//				} catch (UnsupportedEncodingException e) {
//					logger.warn("Servlet file upload - request field has unsupported encoding.");
//					//e.printStackTrace();
//				}
//			}
//		}
//		
//		String fileType = params.get("fileType").toLowerCase();
//		String upPathName = realPath + upPath.get(params.get("fileType")) + "/";
//		File dir = new File(upPathName);
//		if (!dir.isDirectory()) {
//			dir.delete();
//			dir.mkdirs();
//		}
//		
//		int iCertCount = 0;
//		HashMap<String, X509Certificate> certMap = new HashMap<String, X509Certificate>();
//		String licRealPath = "";
//
//		fileItr = fileList.iterator();
//		while (fileItr.hasNext()) {
//			FileItem fileItem = (FileItem) fileItr.next();
//			if (fileItem == null) {
//				continue;
//			}
//			if (fileItem.isFormField()) {
//				continue;
//			}
//			String _filePath = fileItem.getName();
//			String fileFieldName = fileItem.getFieldName();
//			logger.debug(_filePath + " : -- : " + fileItem.getSize());
//			if (_filePath.equals("") || fileItem.getSize() == 0) {
//				//logger.warn("Servlet file upload - file filed has null value.");
//				// return TsaConst.RET_FILE_PATH_OR_SIZE;
//				continue;
//			}
//			int index = _filePath.indexOf("/");
//			if (index > -1) {
//				_filePath = _filePath.substring(_filePath.lastIndexOf("/") + 1);
//			} else {
//				_filePath = _filePath.substring(_filePath.lastIndexOf("\\") + 1);
//			}
//
//			String upFullFileName = "";
//			String _ext = (_filePath.substring(_filePath.lastIndexOf(".") + 1)).toLowerCase();
//			if (!this.allowedExt.get(fileType).contains(_ext)) {
//				logger.warn("Servlet file upload - file extension is NOT allowed.");
//				return ErrorCode.RET_FILE_NOT_ALLOWED_TYPE;	
//			}
//
//			if (fileType.equals(FILE_TYPE_CERT)) {
//				upFullFileName = upPathName + fileFieldName + iCertCount + ".cer";
//				X509Certificate cert = CertBc.Bytes2X509(fileItem.get());
//				if (cert == null) {
//					logger.warn("Servlet file upload - parse file to X.509 Certificate - null");
//					return ErrorCode.RET_FILE_CERT_FORMAT;
//				}
//
//				if (fileFieldName.indexOf("root") > -1) {
//					iCertCount++;
//				}
//				certMap.put(fileFieldName, cert);
//				
//			} else if (fileType.equals(FILE_TYPE_LIC)) {
//				upFullFileName = upPathName + fileFieldName + ".lic";
//				licRealPath = upPathName;
//			}
//			
//			try {
//				fileItem.write(new File(upFullFileName));
//				fileItem.delete();
//				//把上传的root.cer文件解析并保存到CA_INFO表
//				X509Certificate x509Certificate = getX509CerCate(_ext);
//				DB_CaCert caCert = new DB_CaCert();
//				CaCertInfo caCertInfo=new CaCertInfo();
//				caCertInfo.setDN(x509Certificate.getSubjectDN().toString());
//				caCertInfo.setCert(x509Certificate.getEncoded().toString());
//				caCertInfo.setPubKey(x509Certificate.getPublicKey().toString());
//				caCertInfo.setCertValidBegin(x509Certificate.getNotBefore().toString());
//				caCertInfo.setCertValidEnd(x509Certificate.getNotAfter().toString());
//				caCert.add(caCertInfo);
//				
//			} catch (Exception e) {
//				logger.error("Servlet file upload - 保存文件异常" + e.toString());
//				// e.printStackTrace();
//				return ErrorCode.RET_FILE_SAVE_ERROR;
//			}
//		}
//
//		
//		if (fileType.equals(FILE_TYPE_LIC)) 
//		{
//			//20110905 dream modify code 授权文件复制，拷贝CA授权到RA目录
//			String BasePath_sys = "";
//			int findNum = this.realPath.lastIndexOf("CM");
//			if(findNum > 1)
//				BasePath_sys = this.realPath.substring(0, findNum);
//			else
//				BasePath_sys = this.realPath;
//			String RaPath_sys = BasePath_sys+"RA\\WEB-INF\\";
//			String CaPath_sys = BasePath_sys+"CA\\WEB-INF\\";
//			String KmPath_sys = BasePath_sys+"KM\\WEB-INF\\";
//			String CMPath_sys=  BasePath_sys+"CM\\WEB-INF\\";
//			
//			
//			SureLic lic = new SureLic(licRealPath);
//			
//			int ret = lic.verifyLicFile(Global.hardWareCode);
//			licRealPath = licRealPath + "/SureLic.lic";
//			if (ret == 0) {
//				logger.debug("Upload Sys File - Verify license OK.");
//				String dirPath = Global.sysConfigPath.substring(0,  Global.sysConfigPath.lastIndexOf('\\') + 1);
//				Copy cp = new Copy();
//				cp.setFile(new File(licRealPath));
//				cp.setTodir(new File(dirPath));
//				//System.out.print(dirPath);
//				cp.execute();
//				//将授权文件拷贝到CM目录
//				cp.setTodir(new File(CMPath_sys));
//				cp.execute();
//				//将授权文件拷贝到CA目录
//				cp.setTodir(new File(CaPath_sys));
//				//System.out.print(CaPath_sys);
//				cp.execute();
//				//将授权文件拷贝到KM目录
//				cp.setTodir(new File(KmPath_sys));
//				//System.out.print(KmPath_sys);
//				cp.execute();
//				//将授权文件拷贝到RA目录
//				cp.setTodir(new File(RaPath_sys));
//				//System.out.print(RaPath_sys);
//				cp.execute();
//				
///*
//				TsaConst.props.setProperty("licenseEnable", "true");
//				if (!TsaUtils.saveConf()) {
//					logger.error("保存授权启停标志位异常");
//					return TsaConst.RET_FILE_SAVE_LICENSE_ENABLED_ERROR;
//				}
//
//				InitStatus.stopCheckLicenseStatus();
//				InitStatus.startCheckLicenseStatus();*/
//			} else {
//				File licFile = new File(licRealPath);
//				if (licFile.isFile()) {
//					// licFile.delete();
//				}
//				logger.warn("Upload Sys File - Verify license Failed.");
//				return ErrorCode.RET_FILE_LICENSE_VERIFY_ERROR;
//			}
//
//			logger.debug("Upload Sys File - Verify license end.");
//		}
//
//		logger.debug("Upload Sys File - doUpload end.");
//		return ErrorCode.RET_SUCCESS;
//	}
//	
//
//	public static X509Certificate getX509CerCate(String cerPath) throws Exception {  
//        X509Certificate x509Certificate = null;  
//        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");  
//        FileInputStream fileInputStream = new FileInputStream(cerPath);  
//        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);  
//        fileInputStream.close();  
//       /* x509Certificate.getIssuerDN();//dn
//        x509Certificate.();//cert
//        x509Certificate.getPublicKey();//公钥
//        x509Certificate.getNotAfter();
//        x509Certificate.getNotBefore();
//        x509Certificate.getSerialNumber();*/
//        return x509Certificate; 
//        
//    }  
//
//	
//}
