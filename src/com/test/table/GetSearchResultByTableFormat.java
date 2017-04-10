package com.test.table;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 1������һ�����԰�ִ�н�����سɱ�����ʽ���࣬��JSPҳ��ֻ��Ҫһ����ӡ���Ϳ��԰ѽ����ѯ���
 * ��ӡ������2�����Ҹ��ݲ�ͬ�ı����ɲ�ͬ�Ĳ�ѯ������3�����Ը��ݵĶ���ʾ��������ÿһ�ж�����
 * ͨ���ԱȽ�ǿ�����������ܲ�������Ҫ���ǵ�@����@
 * ����һ���򵥵�ʾ����������Ҫ����JSPҳ������ʹ�ã�
 * GetSearchResultByTableFormat get=new GetSearchResultByTableFormat();
 * get.setTableTitle("ʡ �� �� �� �� �� Ϣ");
 * get.setEditUrl("purchaseInformation_edit.do");
 * get.setVerify(true);//����Ҫͨ����֤��־��Ϊtrue,false�Ͳ��������֤��
 * get.setVerifyURL("PassVerify_PurchaseInformation.do");
 * //ע������Ҫ��̬�����ܣ�����Ͳ��ܹ�����order������
 * String sql="select ID,serialNumber,cname,ename,specification from components";
 * //ȡ�õ�ǰ��ҳ��
 * int currentPage;
 * try{
 *      currentPage=Integer.parseInt(request.getParameter("page"));
 * }catch(NumberFormatException e)
 * {
 *     currentPage=1;
 *     try{
 *         currentPage=(Integer)(request.getAttribute("page"));
 *             //out.println("��ǰҳ��"+currentPage);
 *     }catch(Exception e1)
 *     {
 *         currentPage=1;            
 *     }
 * }
 * //ȡ�õ�ǰ��ҳ��OK
 * get.setDelUrl("purchaseInformation_del.do?page="+currentPage+"&");
 * int pageSize=20;
 * get.setViewUrl("purchaseInformation_View.do");
 * //request.getRequestURI()ȡ�õ��ǵ�ǰ���ʵ�url��ַ������û�в���
 * String pageUrl=request.getRequestURI();
 * ****************************���ò��ң�����Ҫ����ɾ����*************************
 * get.setSearch(true);
 * String searchType=null;
 * searchType=request.getParameter("searchType");
 * if(searchType!=null && !searchType.equals("null"))
 * {   
 *     get.setSearchType(searchType);
 *     String searchCondition=request.getParameter("searchCondition");
 *     get.setSearchCondition(searchCondition);
 *     pageUrl+="?searchCondition="+searchCondition+"&searchType="+searchType;
 *     sql+=" where "+searchType+" like '%"+searchCondition+"%'";
 * }    
 * ***************************���ò���OK������Ҫ����ɾ����************************
 * *****************���������������Ҫ�ֶ����򣬿���ȥ���������****************
 * get.setSort(true);//true��ʾҪ�����ܣ�false��ʾ����Ҫ�����ܣ��������Ϊtrue����
 *                   //�����SQL�����һ�����ܹ���order�ؼ��ֵĳ���
 * String sortType=null;
 * String sortColumn=null;
 * sortColumn=request.getParameter("columnName");//ȡ��Ҫ�������
 * if(sortColumn!=null)
 * {        
 *     sortType=request.getParameter("sortType");//ȡ���������
 *     sql+=" order by "+sortColumn+" "+sortType;
 * }
 * if(sortColumn!=null)
 * {
 *     get.setSortColumn(sortColumn);
 *     if(sortType.equals("desc"))
 *     {
 *         get.setSortType(1);
 *     }
 *     if(sortType.equals("asc"))
 *     {
 *         get.setSortType(2);
 *     }
 *     if(pageUrl.indexOf("?")>0)
 *         pageUrl+="&columnName="+sortColumn+"&sortType="+sortType;
 *     else
 *         pageUrl+="?columnName="+sortColumn+"&sortType="+sortType;
 * }
 * *****************���������������Ҫ�ֶ����򣬿���ȥ���������****************
 * get.setCurrentPageUrl(pageUrl);
 * StringBuffer s=get.getResult_withTableFormat(sql,currentPage,pageSize,true);
 * out.println(s);//��ȡ�õĲ�ѯ�����ӡ������OK��
 * ����Ĳ����������е㷳��Ҫ���õĶ�����Ҳ�Ƚ϶࣬���������Ǵ�ͨ�����Ͽ��ǵģ����Ҷ࿼����
 * һЩ���ܣ���ѱ༭��ɾ������˵ȵ����Ӷ������ˣ������ֻ��һ���򵥵���ʾ�ģ���������Ը�
 * ��һЩ���ͳ�Ϊ����Ҫ���ˡ�����Ҳ�ܼ򵥣����������getExecuteResult_withTableFormat
 * ����һ�¾Ϳ����ˡ�
 * ���ߣ�http://blog.csdn.net/fenglibing,2007��9��3����10��������
 */
public class GetSearchResultByTableFormat {
    public GetSearchResultByTableFormat() {
        conn_init();
    }
    Connection conn;
    Statement st;
    int currentPage; //��ǰҳ��
    int pageSize; //ÿҳ��ʾ��¼����
    int totalPage; //�ܹ�ҳ��
    int previousPage; //ǰһҳҳ��
    int nextPage; //��һҳҳ��
    int columnCount; //�ܹ�����
    int totalRecord; //�ܼ�¼��
    String tableTitle; //����⣬��������������ʾ������
    String editUrl; //�༭ҳ���URL
    String delUrl; //ɾ��ҳ���URL
    String viewUrl; //�鿴ָ����¼URL
    String currentPageUrl;//��ǰҳ���url��ַ
    boolean verify = false; //�Ƿ�ǰ��¼��֤
    String verifyURL; //��¼����֤��ַ
    boolean sort;//�Ƿ���Ҫ��̬����
    int sortType;//�������ͣ�һΪ����2Ϊ����
    String desc="��";
    String asc="��";
    String sortColumn;//������ֶ�
    boolean search;//�Ƿ���ʾ��ѯ����
    String searchType;
    String searchCondition;
    /******************************��ʹ�����ݿ�����******************************/
    private void conn_init() {
        setConnection();
        setStatement();
    }

    private void setConnection() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String strurl;
            strurl = 
                    "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\Palfinger\\palfinger.mdb";
            conn = DriverManager.getConnection(strurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStatement() {
        try {
            st = 
 conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*****************************��ʹ�����ݿ�����OK*****************************/

    /**
     * 
     * @param sql ִ�е�SQL���
     * @param CurrentPage ��ǰҳ
     * @param PageSize ÿҳ��ʾ�ļ�¼��
     * @return ִ�еĽ����StringBuffer��
     */
    public StringBuffer getResult_withTableFormat(String sql, int CurrentPage, 
                                                  int PageSize, 
                                                  boolean withEdit) {
        int rowNum = 0; //������
        int TotalPage = 0; //��ҳ��
        int beginRow = 0; //��ʼ��¼
        int endRow = 0; //������¼
        StringBuffer resultRows = new StringBuffer(""); //�����
        this.pageSize = PageSize; //ÿҳ��С
        try {            
            rowNum = getTotalResultSetNum(sql); //ȡ���ܼ�¼��
            this.totalRecord = rowNum; //�ܼ�¼��
            //ȷ����ǰҳ
            if (rowNum % PageSize == 0) {
                TotalPage = rowNum / PageSize;
            } else
                TotalPage = rowNum / PageSize + 1;
            if (CurrentPage >= TotalPage) {
                CurrentPage = TotalPage;
                nextPage = CurrentPage;
                nextPage = CurrentPage + 1; //�õ���һҳҳ��
            } else {
                nextPage = CurrentPage + 1; //�õ���һҳҳ��
            }

            if (CurrentPage <= 1) {
                CurrentPage = 1;
                previousPage = CurrentPage; //�õ�ǰһҳҳ��
            } else {
                previousPage = CurrentPage - 1; //�õ�ǰһҳҳ��
            }
            this.currentPage = CurrentPage; //���õ�ǰҳ
            this.totalPage = TotalPage; //������ҳ��
            beginRow = (CurrentPage - 1) * PageSize + 1; //��ʼ��¼
            endRow = beginRow + PageSize; //������¼
            resultRows = 
                    getExecuteResult_withTableFormat(sql, beginRow, endRow, 
                                                     withEdit);
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return resultRows;
    }

    /**
     * 
     * @param sql Ҫִ�е�SQL���
     * @param startPos ��¼�Ŀ�ʼ�㣬���ӵõ�����ĵڼ�����¼��ʼ����
     * @param endPos ���ؼ�¼�Ľ����㣬�����һ����¼
     * @param withEdit �Ƿ���ϱ༭����
     * @return ����SQL������ɵķ���BufferString��������
     */
    private StringBuffer getExecuteResult_withTableFormat(String sql, 
                                                         int startPos, 
                                                         int endPos, 
                                                         boolean withEdit) {
        ResultSet rs;
        ResultSetMetaData rsmd; //ȡ��Ԫ����
        int ColumnCount; //���ؽ���ж�����
        StringBuffer resultStr = new StringBuffer("");
        if(isSearch()) {
            resultStr.append(generateSearchForm(sql));
        }
        resultStr.append("<table border=1>");
        try {
            rs = st.executeQuery(sql);
            rsmd = rs.getMetaData();
            ColumnCount = rsmd.getColumnCount();
            this.columnCount = ColumnCount;
            resultStr.append("<tr>");
            resultStr.append("<td colspan=" + (columnCount + 2) + " align=center>");
            resultStr.append("<font size=6>" + getTableTitle() + "</font>");
            resultStr.append("</td>");
            resultStr.append("</tr>");
            //System.out.println("ColumnCount:" + ColumnCount);
            //System.exit(0);
            //ȡ��������������˳���±��Ǵ�1��ʼ��
            resultStr.append("<tr bgcolor=AF723C>");
            for (int j = 1; j <= ColumnCount; j++) {
                String columnName=rsmd.getColumnName(j);
                String currentPageUrlWithoutParameteor=getCurrentPageURLWithoutParameteor(getCurrentPageUrl());                
                if(isSort()) {//Ҫ������
                    if(getSortType()==1) {//��ε�����������
                        if(columnName.equals(getSortColumn()))
                            resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=asc')>");
                        else
                            resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=desc')>");
                     }
                    if(getSortType()==2 || getSortType()==0) {//��ε������ǽ���
                        resultStr.append("<td align=left onclick=SortByThis('"+currentPageUrlWithoutParameteor+"?columnName="+columnName+"&sortType=desc')>");
                    }                    
                }
                else {
                    resultStr.append("<td align=left>");
                }                
                resultStr.append("&nbsp;<font color=white><b>");
                //������������Խ�Ӣ���ֶ��滻Ϊ���ģ������������ȥ�����
                resultStr.append(replaceEnglishHeadWithChinese(rsmd.getColumnName(j)));
                //�����������ģ������ǵ�ǰ�����ֶΣ���ô������ͼ��
                if(getSortType()!=0 && columnName.equals(getSortColumn()))
                {
                    if(getSortType()==1) {//����
                        resultStr.append("/"+desc);
                    }
                    if(getSortType()==2) {//����
                        resultStr.append("/"+asc);
                    }
                }
                resultStr.append("</b></font></td>");
            }
            resultStr.append("<td>");
            resultStr.append("</td>");
            if (withEdit == true) {
                resultStr.append("<td>");
                resultStr.append("<font color=white><b>��  ��</b></font>");
                resultStr.append("</td>");
            }
            resultStr.append("</tr>");
            int currentRecordNum = (currentPage - 1) * 20 + 1;
            if (rs.next()) {
                rs.absolute(startPos); //��¼���Զ�λ
                for (int i = 0; i < (endPos - startPos); i++) {
                    resultStr.append("<tr>");
                    int componentID = 0; //�����ָ���еı��е�ID�ֶ�
                    for (int j = 1; j <= ColumnCount; j++) {
                        if (j == 1) {
                            {
                                resultStr.append("<td align=left>&nbsp;");
                                //resultStr.append(rs.getInt(j));
                                resultStr.append(currentRecordNum++); //�������ݿ��ID�����Ѿ�����ID
                                resultStr.append("</td>");
                                componentID = rs.getInt(j);
                            }
                        } else {
                            resultStr.append("<td align=left>&nbsp;");
                            resultStr.append(rs.getString(j));
                            resultStr.append("</td>");
                        }
                    }
                    resultStr.append("<td>");
                    resultStr.append("<a href=" + getViewUrl() + "?id=" + 
                                     componentID + 
                                     " target=_blank><font color=green><nobr>�鿴</nobr></font></a>");
                    resultStr.append("</td>");
                    if (withEdit == true) {
                        resultStr.append("<td>");
                        resultStr.append("<nobr>");

                        resultStr.append("<a href=" + getEditUrl() + "?id=" + 
                                         componentID + 
                                         "><font color=blue>�༭</font></a>");
                        resultStr.append("&nbsp;&nbsp;");

                        resultStr.append("<a href=# onclick=delSure('" + 
                                         getDelUrl() + "id=" + componentID + 
                                         "')><font color=red>ɾ��</font></a>");
                        if (isVerify() == true) {
                            resultStr.append("&nbsp;&nbsp;");
                            resultStr.append("<a href=# onclick=passSure('" + 
                                             getVerifyURL() + "?id=" + 
                                             componentID + 
                                             "')><font color=red>���</font></a>");
                        }
                        resultStr.append("</nobr>");
                        resultStr.append("</td>");
                    }
                    resultStr.append("</tr>");
                    rs.next();
                    if (rs.isAfterLast()) {
                        break;
                    }
                }
            }
            resultStr.append("<tr>");
            resultStr.append("<td colspan=" + (ColumnCount + 2) + 
                             " align=center>");
            resultStr.append(setTurnPageString(getCurrentPageUrl()));
            resultStr.append("</td>");
            resultStr.append("</tr>");
            resultStr.append("</table>");
            resultStr.append(getJSFunction());                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
    /**
     * ���������Ҫ�Լ���ɣ���Ϊ�����ͬ
     * @param eColumnName Ӣ������
     * @return �滻�����������
     */
    private String replaceEnglishHeadWithChinese(String eColumnName) {
        String cColumnName;
        cColumnName=eColumnName;
        return cColumnName;
    }
    /**
     * 
     * @param sql sql���
     * @return ����sql������ɵĲ�ѯform
     */
    private StringBuffer generateSearchForm(String sql) {
        StringBuffer str=new StringBuffer("");
        String searchType=getSearchType();
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int ColumnCount = rsmd.getColumnCount();
            String searchCondition=getSearchCondition();
            if(searchCondition==null)
                searchCondition="";
            str.append("<form method=get action="+getCurrentPageURLWithoutParameteor(getCurrentPageUrl())+">");
            str.append("����������<input type=text name=searchCondition size=10 value="+searchCondition+"> ");
            str.append("ѡ�����ͣ�<select name=searchType>");
            str.append("<option value=null>��ѡ������</option>");
            for(int i=1;i<=ColumnCount;i++) {                
                String cName=replaceEnglishHeadWithChinese(rsmd.getColumnName(i));
                if(searchType!=null && searchType.equals(cName))
                    str.append("<option value="+cName+" selected>"+cName+"</option>");
                else
                    str.append("<option value="+cName+">"+cName+"</option>");
            }
            str.append("</select>");
            str.append("<input type=submit value=��ѯ>");
            str.append("</form>");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    //��JavaScript������̬���:����SortByThis(url)
    private StringBuffer getJSFunction() {
        StringBuffer str=new StringBuffer("");        
        str.append("<script language=JavaScript1.2 type=text/javascript>");
        str.append("function SortByThis(url){window.location=url;}");
        str.append("</script>");
        return str;
    }
    /**
     * 
     * @param httpUrl URL��ַ�������Ǵ�������
     * @return ���ɵ���ҳ����ҳ����ҳ��ĩҳ���ַ���
     */
    private String setTurnPageString(String httpUrl) {
        String turnPageStrng = "";
        String divideS = "&nbsp;&nbsp;&nbsp;&nbsp;";
        turnPageStrng = "�ܼ�¼����" + totalRecord;
        turnPageStrng = turnPageStrng + divideS + "��ҳ����" + totalPage;
        turnPageStrng = turnPageStrng + divideS + "ÿҳ��¼����" + pageSize;
        if (httpUrl.indexOf("?") > 0) //��������ַ���������ģ��ͼ�&��������������
            httpUrl += "&page=";
        else
            httpUrl += "?page=";
        String hS = "<a href=" + httpUrl + "1>��ҳ</a>" + divideS;
        String pS = "<a href=" + httpUrl + previousPage + ">ǰҳ</a>" + divideS;
        String cS = "��ǰ��" + currentPage + "ҳ" + divideS;
        String tS = "ת����<input type=text size=2 id=goToPage";
        tS += " onKeyDown=\"if(window.event.keyCode==13) goToPage('";
        tS += httpUrl + "');\" value=" + nextPage + ">ҳ";
        tS += "<input type=button name=g value=Go ";
        tS += "onclick=\"goToPage('" + httpUrl + "');\">" + divideS;
        String nS = "<a href=" + httpUrl + nextPage + ">��ҳ</a>" + divideS;
        String lS = "<a href=" + httpUrl + totalPage + ">ĩҳ</a>";
        turnPageStrng = turnPageStrng + divideS + hS + pS + cS + tS + nS + lS;
        return turnPageStrng;
    }

    /**
     * ȡ���ܼ�¼��
     * @return
     */
    private int getTotalResultSetNum(String sql) {
        int num = 0;
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                rs.last(); //�Ƶ����һ��
                num = rs.getRow(); //ȡ���ܼ�¼��
                rs.first(); //���Ƶ���һ����¼
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    /**
     * 
     * @param url �����������ǲ��������ĵ�ǰҳ���url
     * @return ȥ�������ĵ�ǰҳ���url
     */
    private String getCurrentPageURLWithoutParameteor(String url) {
        if(url.indexOf("?")>0)
            return url.split("\\?")[0];
        else
            return url;
    }
    /**************************��Ա�����set��get����**************************/
    public
    //���ñ�ͷ
    void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }
    //ȡ�ñ�ͷ

    private String getTableTitle() {
        return tableTitle;
    }
    //���ò鿴��Ӧ��¼��URL

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
    //ȡ�ò鿴��Ӧ��¼��URL

    private String getViewUrl() {
        return viewUrl;
    }
    //���ñ༭ָ����¼��URL

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }
    //ȡ�ñ༭ָ����¼��URL

    private String getEditUrl() {
        return editUrl;
    }
    //����ɾ��ָ����¼��URL

    public void setDelUrl(String delUrl) {
        this.delUrl = delUrl;
    }
    //ȡ��ɾ��ָ����¼��URL

    private String getDelUrl() {
        return delUrl;
    }
    //�����Ƿ�ͨ����֤

    public void setVerify(boolean verify) {
        this.verify = verify;
    }
    //����Ƿ�ͨ����֤

    private boolean isVerify() {
        return verify;
    }
    //����ͨ����ָ֤����¼��URL

    public void setVerifyURL(String verifyURL) {
        this.verifyURL = verifyURL;
    }
    //ȡ����ָ֤����¼��URL

    private String getVerifyURL() {
        return verifyURL;
    }
    //���õ�ǰҳ��URL

    public void setCurrentPageUrl(String currentPageUrl) {
        this.currentPageUrl = currentPageUrl;
    }
    //ȡ�õ�ǰҳ��URL

    private String getCurrentPageUrl() {
        return currentPageUrl;
    }    

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    private boolean isSort() {
        return sort;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    private int getSortType() {
        return sortType;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    private String getSortColumn() {
        return sortColumn;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    private boolean isSearch() {
        return search;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    private String getSearchType() {
        return searchType;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    private String getSearchCondition() {
        return searchCondition;
    }
    /**************************��Ա�����set��get����OK**************************/
}