package com.onlineMarket.business.util.page;

import java.util.List;

public class Page
{
  private int nowPage;//��ǰҳ
  private int pageSize;//ÿһҳ�Ĵ�С
  private int count;//���ݵ�������
  private String queryKey;//��ѯ����
  private String sql;//��ѯ���
  private String pagReamrk = "T";//��ʾ
  private List<String> idList;
  public Page()
  {
    this.nowPage = 1;
    this.pageSize = 10;
  }

  public int getOffset()//��ȡ��ҳ֮ǰ��ҳ��ҳ��
  {
    int tempOffest = (this.nowPage - 1) * this.pageSize;
    if (tempOffest < this.count) {
      return tempOffest;
    }
    return this.count / this.pageSize;
  }

  public int getLimit()
  {
    if (this.count - getOffset() > this.pageSize) {
      return this.pageSize;
    }
    return this.count - getOffset();
  }

  public int getPageCount()
  {
    if (this.count <= this.pageSize)
      return 1;
    if (this.count % this.pageSize == 0) {
      return this.count / this.pageSize;
    }

    return this.count / this.pageSize + 1;
  }

  public void setCount(int Count)
  {
    this.count = Count;
  }
  public int getCount() {
    return this.count;
  }

  public int getNowPage() {
    return this.nowPage;
  }

  public void setNowPage(int nowPage) {
    this.nowPage = nowPage;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public String getQueryKey()
  {
    return this.queryKey;
  }

  public void setQueryKey(String queryKey)
  {
    this.queryKey = queryKey;
  }

  public String getSql() {
    return this.sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public String getPagReamrk() {
    return this.pagReamrk;
  }

  public void setPagReamrk(String pagReamrk) {
    this.pagReamrk = pagReamrk;
  }

public List<String> getIdList() {
	return idList;
}

public void setIdList(List<String> idList) {
	this.idList = idList;
}
  
}

/* Location:           D:\EcodeSVN\webLand_jd\src_class\com.jar
 * Qualified Name:     com.ecode.land.util.Page
 * JD-Core Version:    0.6.2
 */