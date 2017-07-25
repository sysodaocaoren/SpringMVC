//���ܣ�ʵ��sure�ӿڹ��̵ļ��ļ���־�����
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
	
	//��־�ļ����
	private static final String LOG_FILE_NAME = "SureLraClint";	//��־�ļ�����
	private static final String LOG_PATH_WIN = "c:\\SureLog\\";	//winϵͳ��־�ļ�·��
	private static final String LOG_PATH_LINUX = "/SureLog/";	//Linux��־�ļ�·��


	//������־�������
	public static final int LOG_LEVEL_NONE = 0;				//����־��Ϣ���--������Ϣ�����
	public static final int LOG_LEVEL_NORMAL = 1;			//ϵͳ������Ϣ���
	public static final int LOG_LEVEL_ERR = 2;				//������Ϣ���
	public static final int LOG_LEVEL_WARN = 3;				//���漶��Ϣ���
	public static final int LOG_LEVEL_DUBUG = 4;			//���Լ���Ϣ���
	
	//������־�������
	public static final int LOG_TYPE_INFO = 0;				//��־���ͣ���Ϣ���
	public static final int LOG_TYPE_ERR = 1;				//��־���ͣ�������Ϣ
	
	//������־�������
	public static final int LOG_OUT_S = 0;				//��־�������Ļ
	public static final int LOG_OUT_F = 1;				//��־������ļ�
	public static final int LOG_OUT_ALL = 2;			//��־������ļ�����Ļ
	
	//��־�������
	private static int logOutputLevel = 1;						//��־�������
	private static int logOutputTarget = 2;						//��־�������
	
	//���ܣ��û���־�����������
	//���룺logLevel��־����
	//�����
	public static void setLogOutLevel(int logLevel)
	{
		logOutputLevel = logLevel;
	}
	//���ܣ���ȡ��ǰ�û���־�������
	//���룺
	//�����logLevel��־����
	public static int getLogOutLevel()
	{
		return logOutputLevel;
	}
	
	//���ܣ��û���־�����¼,���Ϊ������־����һ���������Ļ������ļ�Ŀ¼������������ļ�
	//���룺functionName��־�����ĺ�����msg������Ϣ��errCode�����룬logType��־�����Ϣ�������־����logLevel��־����
	//�����0�ɹ�������ʧ��
	public static void sureLog(String functionName, String errMsg, int errCode, int logType, int logLevel)
	{
		String logFilePath = "";
		String logMsg = "";
		
		if(logOutputLevel == LOG_LEVEL_NONE || logLevel < LOG_LEVEL_NORMAL)//����־���
			return;
		else if((logOutputLevel == LOG_LEVEL_NORMAL) && (logLevel != LOG_LEVEL_NORMAL && logLevel != LOG_LEVEL_ERR))//������־ ���������Ϣ�ʹ�����Ϣ
			return;
		else if((logOutputLevel == LOG_LEVEL_ERR) && (logLevel > LOG_LEVEL_ERR))//������Ϣ��־     ���������Ϣ�ʹ�����Ϣ
			return;
		else if((logOutputLevel == LOG_LEVEL_WARN) && (logLevel > LOG_LEVEL_WARN))//������Ϣ��־     ���������Ϣ��������Ϣ�ʹ�����Ϣ
			return;
		else if((logOutputLevel == LOG_LEVEL_DUBUG) && (logLevel > LOG_LEVEL_DUBUG))//������Ϣ��־      ���������Ϣ��������Ϣ��������Ϣ�͵�����Ϣ
			return;

		//��ʽ��������Ϣ����Ӵ�����룻
		logMsg = String.format("[%1$#010x]", errCode)+ errMsg;
		
		//��ʽ��ʱ��
   	 	String nowTime = getTimeStringAll();
		
		//��ȡϵͳ���ƣ�������־Ŀ¼
		String osName = System.getProperty("os.name");
		if(osName!=null && osName.toUpperCase().startsWith("WIN"))//.substring(0, 3).equals("WIN"))//���Ϊtrue����windowsϵͳ
			logFilePath = LOG_PATH_WIN;
		else
			logFilePath = LOG_PATH_LINUX;
		
		//��־���
		if(logOutputTarget ==  LOG_OUT_S)				//��־�������Ļ
		{
			outPutScreen(functionName, logMsg, nowTime, logType);
		}
		else
		{
			boolean filepthFlag = isFilePathExist(logFilePath);
			//�ж���־Ŀ¼�Ƿ����
			if(!filepthFlag || logOutputTarget ==  LOG_OUT_ALL)//��־���Ŀ¼�����ڣ���־�������Ļ
			{
				outPutScreen(functionName, logMsg, nowTime, logType);
			}
			if(filepthFlag)//��־���Ŀ¼���ڣ���־������ļ�
			{
				outPutFile(functionName, logMsg, nowTime, logType);
			}
		}
	}
	
	//���ܣ��û���־�������Ļ
	//���룺functionName��־�����ĺ�����msg������Ϣ��nowTime��־����ʱ�䣬 logType��־���
	//�����0�ɹ�������ʧ��
	public static void outPutScreen(String functionName, String errMsg, String nowTime, int logType)
	{
		String logMark = "";
		
		if(logType == LOG_TYPE_INFO)
			logMark = "------->|<------- ";
		else
			logMark = "......->|<-...... ";
		   	 	
   	 	//�������ʾ��
		System.out.println(logMark + nowTime + "[" + functionName + "]" + errMsg);
		
		return;
	}
	
	//���ܣ��û���־������ļ�
	//���룺functionName��־�����ĺ�����msg������Ϣ��nowTime��־����ʱ�䣬logType��־���
	//�����0�ɹ�������ʧ��
	public static void outPutFile(String functionName, String errMsg, String nowTime, int logType)
	{
		String logMark = "";
		String logFilePath = "";
		String logMsg = "";

		if(logType == LOG_TYPE_INFO)
			logMark = "------>>>";
		else
			logMark = "******>>>";
		
		//��ȡϵͳ���ƣ�������־Ŀ¼
		String osName = System.getProperty("os.name");
		if(osName!=null && osName.toUpperCase().startsWith("WIN"))//.substring(0, 3).equals("WIN"))//���Ϊtrue����windowsϵͳ
			logFilePath = LOG_PATH_WIN;
		else
			logFilePath = LOG_PATH_LINUX;
		
		//�����־ȫ·��
		logFilePath += LOG_FILE_NAME+nowTime.substring(0, 8)+".log";
		
		//�����־��Ϣ
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
	
	//���ܣ��ж��ļ���·���Ƿ����
	//���룺path �ļ���·��
	//�����true���ڣ����򲻴���
	 public static boolean isFilePathExist(String path) 
	 {
		 try
		 {
			 File file = new File(path);
			  //�ж��ļ����Ƿ����
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
	
	//���ܣ���ȡϵͳ��ǰ��ʽ�����ʱ�䣬yyyyMMddHHmmss
	//���룺
	//�����ϵͳ��ǰʱ�䣬����Ϊ��
	public static String getTimeStringAll()
    {
        Date date = new Date();
        SimpleDateFormat _time = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = _time.format(date);
        return time;
    }
	
}
