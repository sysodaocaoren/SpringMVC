package com.Log;
import java.lang.reflect.Method;  
import java.util.Date;  
  




import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Pointcut;  
import org.springframework.beans.factory.annotation.Autowired;

import com.Log.bean.Log;
import com.Log.service.LogService;


@Aspect
public class LogAspect {
	@Autowired  
    private LogService logService;//��־��¼Service  
      
   /* @Autowired  
    private FilmService filmService;//ӰƬService  
*/      
    /** 
     * ���ҵ���߼���������� 
     */  
    @Pointcut("execution(* com.wg.service.*.*.save*(..))")  
    public void insertServiceCall() { }  
      
    /** 
     * �޸�ҵ���߼����������  /SpringMVC/src/com/wg/service/impl/UserServiceImpl.java
     */  
    @Pointcut("execution(* com.wg.service.*.update*(..))")  
    public void updateServiceCall() { }  
      
    /** 
     * ɾ��ӰƬҵ���߼���������� 
     */  
    @Pointcut("execution(* com.wg.service.*.delete*(..))")  
    public void deleteFilmCall() { }  
      
    /** 
     * ����Ա��Ӳ�����־(����֪ͨ) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")  
    public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //��ȡ��¼����Աid  
        Long adminUserId = logService.loginUserId();  
          
        if(adminUserId == null){//û�й���Ա��¼  
            return;  
        }  
          
        //�жϲ���  
        if(joinPoint.getArgs() == null){//û�в���  
            return;  
        }  
          
        //��ȡ������  
        String methodName = joinPoint.getSignature().getName();  
          
        //��ȡ��������  
        String opContent = adminOptionContent(joinPoint.getArgs(), methodName);  
          
        //������־����  
        Log log = new Log();  
        log.setUserid(logService.loginUserId());//���ù���Աid  
        log.setCreatedate(new Date());//����ʱ��  
        log.setContent(opContent);//��������  
        log.setOperation("���");//����  
          
        logService.log(log);//�����־  
    }  
      
     /** 
     * ����Ա�޸Ĳ�����־(����֪ͨ) 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @AfterReturning(value="updateServiceCall()", argNames="rtv", returning="rtv")  
    public void updateServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{  
          
        //��ȡ��¼����Աid  
        Long adminUserId = logService.loginUserId();  
          
        if(adminUserId == null){//û�й���Ա��¼  
            return;  
        }  
          
        //�жϲ���  
        if(joinPoint.getArgs() == null){//û�в���  
            return;  
        }  
          
        //��ȡ������  
        String methodName = joinPoint.getSignature().getName();  
          
        //��ȡ��������  
        String opContent = adminOptionContent(joinPoint.getArgs(), methodName);  
          
        //������־����  
        Log log = new Log();  
        log.setUserid(logService.loginUserId());//���ù���Աid  
        log.setCreatedate(new Date());//����ʱ��  
        log.setContent(opContent);//��������  
        log.setOperation("�޸�");//����  
          
        logService.log(log);//�����־  
    }  
      
    /** 
     * ����Աɾ��ӰƬ����(����֪ͨ)��ʹ�û���֪ͨ��Ŀ���� 
     * ��ӰƬ��ɾ��ǰ�����Ȳ�ѯ��ӰƬ��Ϣ������־��¼ 
     * @param joinPoint 
     * @param rtv 
     * @throws Throwable 
     */  
    @Around(value="deleteFilmCall()", argNames="rtv")  
    public Object deleteFilmCallCalls(ProceedingJoinPoint pjp) throws Throwable {  
          
        Object result = null;  
         //����֪ͨ������  
         try {  
              
           /* //��ȡ��������(��ɾ����ӰƬid)  
            Integer id = (Integer)pjp.getArgs()[0];  
            Film obj = null;//ӰƬ����  
            if(id != null){  
                //ɾ��ǰ�Ȳ�ѯ��ӰƬ����  
                obj = filmService.getFilmById(id);  
            }  */
              
            //ִ��ɾ��ӰƬ����  
            result = pjp.proceed();  
              
                  
                //������־����  
                Log log = new Log();  
                log.setUserid(logService.loginUserId());//�û����  
                log.setCreatedate(new Date());//����ʱ��  
                  
                StringBuffer msg = new StringBuffer("ӰƬ�� : ");  
                //msg.append(obj.getFname());  
                log.setContent(msg.toString());//��������  
                  
                log.setOperation("ɾ��");//����  
                  
                logService.log(log);//�����־  
              
         }  
         catch(Exception ex) {  
            ex.printStackTrace();  
         }  
           
         return result;  
    }  
      
    /** 
     * ʹ��Java��������ȡ�����ط���(insert��update)�Ĳ���ֵ�� 
     * ������ֵƴ��Ϊ�������� 
     */  
    public String adminOptionContent(Object[] args, String mName) throws Exception{  
  
        if (args == null) {  
            return null;  
        }  
          
        StringBuffer rs = new StringBuffer();  
        rs.append(mName);  
        String className = null;  
        int index = 1;  
        // ������������  
        for (Object info : args) {  
              
            //��ȡ��������  
            className = info.getClass().getName();  
            className = className.substring(className.lastIndexOf(".") + 1);  
            rs.append("[����" + index + "�����ͣ�" + className + "��ֵ��");  
              
            // ��ȡ��������з���  
            Method[] methods = info.getClass().getDeclaredMethods();  
              
            // �����������ж�get����  
            for (Method method : methods) {  
                  
                String methodName = method.getName();  
                // �ж��ǲ���get����  
                if (methodName.indexOf("get") == -1) {// ����get����  
                    continue;// ������  
                }  
                  
                Object rsValue = null;  
                try {  
                      
                    // ����get��������ȡ����ֵ  
                    rsValue = method.invoke(info);  
                      
                    if (rsValue == null) {//û�з���ֵ  
                        continue;  
                    }  
                      
                } catch (Exception e) {  
                    continue;  
                }  
                  
                //��ֵ����������  
                rs.append("(" + methodName + " : " + rsValue + ")");  
            }  
              
            rs.append("]");  
              
            index++;  
        }  
          
        return rs.toString();  
    }  
}
