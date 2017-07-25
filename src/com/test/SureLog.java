//功能：实现sure接口工程的简单文件日志输出；
//author: dream
//version: V1.0.0.0
//date: 2013-10-14

package sure.lra.client.Bean;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SureLog {
		
	public SureLog() 
	{

	}
	
	//日志文件相关
	private static final String LOG_FILE_NAME = "SureLraClint";	//日志文件名称
	private static final String LOG_PATH_WIN = "c:\\SureLog\\";	//win系统日志文件路径
	private static final String LOG_PATH_LINUX = "/SureLog/";	//Linux日志文件路径


	//定义日志输出级别
	public static final int LOG_LEVEL_NONE = 0;				//无日志信息输出--错误信息仍输出
	public static final int LOG_LEVEL_NORMAL = 1;			//系统正常信息输出
	public static final int LOG_LEVEL_ERR = 2;				//错误级信息输出
	public static final int LOG_LEVEL_WARN = 3;				//警告级信息输出
	public static final int LOG_LEVEL_DUBUG = 4;			//调试级信息输出
	
	//定义日志输出级别
	public static final int LOG_TYPE_INFO = 0;				//日志类型：信息输出
	public static final int LOG_TYPE_ERR = 1;				//日志类型：错误信息
	
	//定义日志输出方向
	public static final int LOG_OUT_S = 0;				//日志输出到屏幕
	public static final int LOG_OUT_F = 1;				//日志输出到文件
	public static final int LOG_OUT_ALL = 2;			//日志输出到文件和屏幕
	
	//日志输出级别
	private static int logOutputLevel = 1;						//日志输出级别
	private static int logOutputTarget = 2;						//日志输出方向
	
	//功能：用户日志输出级别设置
	//输入：logLevel日志级别
	//输出：
	public static void setLogOutLevel(int logLevel)
	{
		logOutputLevel = logLevel;
	}
	//功能：获取当前用户日志输出级别
	//输入：
	//输出：logLevel日志级别
	public static int getLogOutLevel()
	{
		return logOutputLevel;
	}
	
	//功能：用户日志输出记录,如果为错误日志，则一定输出到屏幕，如果文件目录存在则输出到文件
	//输入：functionName日志发生的函数，msg错误信息，errCode错误码，logType日志类别【信息或错误日志】，logLevel日志级别
	//输出：0成功，否则失败
	public static void sureLog(String functionName, String errMsg, int errCode, int logType, int logLevel)
	{
		String logFilePath = "";
		String logMsg = "";
		
		if(logOutputLevel == LOG_LEVEL_NONE || logLevel < LOG_LEVEL_NORMAL)//无日志输出
			return;
		else if((logOutputLevel == LOG_LEVEL_NORMAL) && (logLevel != LOG_LEVEL_NORMAL && logLevel != LOG_LEVEL_ERR))//正常日志 输出正常信息和错误信息
			return;
		else if((logOutputLevel == LOG_LEVEL_ERR) && (logLevel > LOG_LEVEL_ERR))//错误信息日志     输出正常信息和错误信息
			return;
		else if((logOutputLevel == LOG_LEVEL_WARN) && (logLevel > LOG_LEVEL_WARN))//警告信息日志     输出正常信息、警告信息和错误信息
			return;
		else if((logOutputLevel == LOG_LEVEL_DUBUG) && (logLevel > LOG_LEVEL_DUBUG))//调试信息日志      输出正常信息、警告信息、错误信息和调试信息
			return;

		//格式化错误信息，添加错误代码；
		logMsg = String.format("[%1$#010x]", errCode)+ errMsg;
		
		//格式化时间
   	 	String nowTime = getTimeStringAll();
		
		//获取系统名称，区分日志目录
		String osName = System.getProperty("os.name");
		if(osName!=null && osName.toUpperCase().startsWith("WIN"))//.substring(0, 3).equals("WIN"))//如果为true则是windows系统
			logFilePath = LOG_PATH_WIN;
		else
			logFilePath = LOG_PATH_LINUX;
		
		//日志输出
		if(logOutputTarget ==  LOG_OUT_S)				//日志输出到屏幕
		{
			outPutScreen(functionName, logMsg, nowTime, logType);
		}
		else
		{
			boolean filepthFlag = isFilePathExist(logFilePath);
			//判断日志目录是否存在
			if(!filepthFlag || logOutputTarget ==  LOG_OUT_ALL)//日志存放目录不存在，日志输出到屏幕
			{
				outPutScreen(functionName, logMsg, nowTime, logType);
			}
			if(filepthFlag)//日志存放目录存在，日志输出到文件
			{
				outPutFile(functionName, logMsg, nowTime, logType);
			}
		}
	}
	
	//功能：用户日志输出到屏幕
	//输入：functionName日志发生的函数，msg错误信息，nowTime日志发生时间， logType日志类别
	//输出：0成功，否则失败
	public static void outPutScreen(String functionName, String errMsg, String nowTime, int logType)
	{
		String logMark = "";
		
		if(logType == LOG_TYPE_INFO)
			logMark = "------->|<------- ";
		else
			logMark = "......->|<-...... ";
		   	 	
   	 	//输出到显示屏
		System.out.println(logMark + nowTime + "[" + functionName + "]" + errMsg);
		
		return;
	}
	
	//功能：用户日志输出到文件
	//输入：functionName日志发生的函数，msg错误信息，nowTime日志发生时间，logType日志类别
	//输出：0成功，否则失败
	public static void outPutFile(String functionName, String errMsg, String nowTime, int logType)
	{
		String logMark = "";
		String logFilePath = "";
		String logMsg = "";

		if(logType == LOG_TYPE_INFO)
			logMark = "------>>>";
		else
			logMark = "******>>>";
		
		//获取系统名称，区分日志目录
		String osName = System.getProperty("os.name");
		if(osName!=null && osName.toUpperCase().startsWith("WIN"))//.substring(0, 3).equals("WIN"))//如果为true则是windows系统
			logFilePath = LOG_PATH_WIN;
		else
			logFilePath = LOG_PATH_LINUX;
		
		//组合日志全路径
		logFilePath += LOG_FILE_NAME+nowTime.substring(0, 8)+".log";
		
		//组合日志信息
		logMsg = nowTime+ "[" + functionName+ "]" + logMark+errMsg + System.getProperty("line.separator");
		
		try{
		FileOutputStream logFileOut = new FileOutputStream(logFilePath, true);
		logFileOut.write(logMsg.getBytes());
		logFileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace( );
			return;
		}
		
		return;
	}
	
	//功能：判断文件夹路径是否存在
	//输入：path 文件夹路径
	//输出：true存在，否则不存在
	 public static boolean isFilePathExist(String path) 
	 {
		 try
		 {
			 File file = new File(path);
			  //判断文件夹是否存在
			  if (file.exists()) 
				  return true;
			  else
				  return false;
		 }
		 catch(Exception e)
		{
			e.printStackTrace( );
			return false;
		}
	 
	 }
	
	//功能：获取系统当前格式化后的时间，yyyyMMddHHmmss
	//输入：
	//输出：系统当前时间，否则为空
	public static String getTimeStringAll()
    {
        Date date = new Date();
        SimpleDateFormat _time = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = _time.format(date);
        return time;
    }
	
}
