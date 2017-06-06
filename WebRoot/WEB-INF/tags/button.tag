<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ attribute name="value" type="java.lang.String" required="true"  description="显示文字必须项"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="ID必须项"%>
<%@ attribute name="id" type="java.lang.String" required="true" description="name必须项"%>
<%@ attribute name="onclick" type="java.lang.String" required="true" description="点击事件必须项"%>
<%@ attribute name="smallPadding" type="java.lang.Boolean" required="false" description="是否靠左间距变窄"%>
<c:choose>
  <c:when test="${empty smallPadding or !smallPadding}">
    <span class="btn_yj_normal">
      <input id="${id}" name="${name}" onclick="${onclick}" 
      value="${value}" onfocus="this.blur()" onmouseout="this.parentNode.className='btn_yj_normal'"
      onmouseover="this.parentNode.className='btn_yj_normal_over'" type="button"/>
    </span>
  </c:when>
  <c:otherwise>
    <span class="btn_yj_padding">
      <input id="${id}" name="${name}" onclick="${onclick}" 
      value="${value}" onfocus="this.blur()" onmouseout="this.parentNode.className='btn_yj_padding'"
      onmouseover="this.parentNode.className='btn_yj_padding_over'" type="button"/>
    </span>
  </c:otherwise>
</c:choose>