package com.onlineMarket.business.util.page;

import java.util.List;

public abstract interface PageMapper<E>
{
  public abstract List<E> selectPage(Object paramObject, Page paramPage, String paramString);

  public abstract List<E> selectPage(Object paramObject, Page paramPage, String paramString, Integer paramInteger);
}

/* Location:           D:\EcodeSVN\webLand_jd\src_class\com.jar
 * Qualified Name:     com.ecode.land.persistence.page.PageMapper
 * JD-Core Version:    0.6.2
 */