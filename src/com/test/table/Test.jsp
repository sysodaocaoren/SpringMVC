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
    get.setTableTitle("省 核 所 有 的 信 息");
    get.setEditUrl("purchaseInformation_edit.do");
    get.setVerify(true);//把需要通过验证标志设为true,false就不会出现验证项
    get.setVerifyURL("PassVerify_PurchaseInformation.do");
    //注：如需要动态排序功能，这里就不能够出现order排序了
    String sql="select ID,serialNumber,cname,ename,specification from components";
    //取得当前的页号
    int currentPage;
    try{
         currentPage=Integer.parseInt(request.getParameter("page"));
    }catch(NumberFormatException e)
    {
        currentPage=1;
        try{
            currentPage=(Integer)(request.getAttribute("page"));
                //out.println("当前页："+currentPage);
        }catch(Exception e1)
        {
            currentPage=1;            
        }
    }
    //取得当前的页号OK
    get.setDelUrl("purchaseInformation_del.do?page="+currentPage+"&");
    int pageSize=20;
    get.setViewUrl("purchaseInformation_View.do");
    //request.getRequestURI()取得的是当前访问的url地址，但是没有参数
    String pageUrl=request.getRequestURI();
    /****************************设置查找，不需要可以删除掉*************************/
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
    /***************************设置查找OK，不需要可以删除掉************************/
    /*****************增加排序，如果不需要手动排序，可以去掉下面代码****************/
    get.setSort(true);//true表示要排序功能，false表示不需要排序功能，如果这里为true，那
                      //上面的SQL语句中一定不能够有order关键字的出现
    String sortType=null;
    String sortColumn=null;
    sortColumn=request.getParameter("columnName");//取得要排序的列
    if(sortColumn!=null)
    {        
        sortType=request.getParameter("sortType");//取得排序情况
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
    /*****************增加排序，如果不需要手动排序，可以去掉上面代码****************/
    get.setCurrentPageUrl(pageUrl);
    StringBuffer s=get.getResult_withTableFormat(sql,currentPage,pageSize,true);
    out.println(s);//把取得的查询结果打印出来就OK了
  %>
  <table>
  <tr>
  </tr>
  </table>
  </body>
</html>