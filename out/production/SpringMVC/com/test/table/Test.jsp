<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="palfinger.bean.GetSearchResultByTableFormat"%>
<html>
  <head>
    <script language="JavaScript1.2" type="text/javascript" src="../function.js">
    </script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
    <title>Test</title>
  </head>
  <body>
  <%
    GetSearchResultByTableFormat get=new GetSearchResultByTableFormat();
    get.setTableTitle("ʡ �� �� �� �� �� Ϣ");
    get.setEditUrl("purchaseInformation_edit.do");
    get.setVerify(true);//����Ҫͨ����֤��־��Ϊtrue,false�Ͳ��������֤��
    get.setVerifyURL("PassVerify_PurchaseInformation.do");
    //ע������Ҫ��̬�����ܣ�����Ͳ��ܹ�����order������
    String sql="select ID,serialNumber,cname,ename,specification from components";
    //ȡ�õ�ǰ��ҳ��
    int currentPage;
    try{
         currentPage=Integer.parseInt(request.getParameter("page"));
    }catch(NumberFormatException e)
    {
        currentPage=1;
        try{
            currentPage=(Integer)(request.getAttribute("page"));
                //out.println("��ǰҳ��"+currentPage);
        }catch(Exception e1)
        {
            currentPage=1;            
        }
    }
    //ȡ�õ�ǰ��ҳ��OK
    get.setDelUrl("purchaseInformation_del.do?page="+currentPage+"&");
    int pageSize=20;
    get.setViewUrl("purchaseInformation_View.do");
    //request.getRequestURI()ȡ�õ��ǵ�ǰ���ʵ�url��ַ������û�в���
    String pageUrl=request.getRequestURI();
    /****************************���ò��ң�����Ҫ����ɾ����*************************/
    get.setSearch(true);
    String searchType=null;
    searchType=request.getParameter("searchType");
    if(searchType!=null && !searchType.equals("null"))
    {   
        get.setSearchType(searchType);
        String searchCondition=request.getParameter("searchCondition");
        get.setSearchCondition(searchCondition);
        pageUrl+="?searchCondition="+searchCondition+"&searchType="+searchType;
        sql+=" where "+searchType+" like '%"+searchCondition+"%'";
    }    
    /***************************���ò���OK������Ҫ����ɾ����************************/
    /*****************���������������Ҫ�ֶ����򣬿���ȥ���������****************/
    get.setSort(true);//true��ʾҪ�����ܣ�false��ʾ����Ҫ�����ܣ��������Ϊtrue����
                      //�����SQL�����һ�����ܹ���order�ؼ��ֵĳ���
    String sortType=null;
    String sortColumn=null;
    sortColumn=request.getParameter("columnName");//ȡ��Ҫ�������
    if(sortColumn!=null)
    {        
        sortType=request.getParameter("sortType");//ȡ���������
        sql+=" order by "+sortColumn+" "+sortType;
    }
    if(sortColumn!=null)
    {
        get.setSortColumn(sortColumn);
        if(sortType.equals("desc"))
        {
            get.setSortType(1);
        }
        if(sortType.equals("asc"))
        {
            get.setSortType(2);
        }
        if(pageUrl.indexOf("?")>0)
            pageUrl+="&columnName="+sortColumn+"&sortType="+sortType;
        else
            pageUrl+="?columnName="+sortColumn+"&sortType="+sortType;
    }
    /*****************���������������Ҫ�ֶ����򣬿���ȥ���������****************/
    get.setCurrentPageUrl(pageUrl);
    StringBuffer s=get.getResult_withTableFormat(sql,currentPage,pageSize,true);
    out.println(s);//��ȡ�õĲ�ѯ�����ӡ������OK��
  %>
  <table>
  <tr>
  </tr>
  </table>
  </body>
</html>