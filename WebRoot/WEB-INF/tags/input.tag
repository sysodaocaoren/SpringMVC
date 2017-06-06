<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ attribute name="name" type="java.lang.String" required="true"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="showRequired" type="java.lang.Boolean" required="false" %>
<%@ attribute name="classes" type="java.lang.String" required="false"%>
<%@ attribute name="placeholder" type="java.lang.String" required="false"%>
<%@ attribute name="onfocus" type="java.lang.String" required="false"%>
<%@ attribute name="value" type="java.lang.String" required="false"%>
<%@ attribute name="required" type="java.lang.String" required="false"%>
<%@ attribute name="style" type="java.lang.String" required="false"%>
<%@ attribute name="readonly" type="java.lang.String" required="false"%>
<%--设置class start --%>
<c:set var="strClass" value=""></c:set>
<c:if test="${not empty classes}">
  <c:set var="strClass" value="class=\'${classes}\'"></c:set>
</c:if>
<%--设置class end --%>

<%--设置placeholder start --%>
<c:set var="strPlaceholder" value=""></c:set>
<c:if test="${not empty placeholder}">
  <c:set var="strPlaceholder" value="placeholder=\'${placeholder}\'"></c:set>
</c:if>
<%--设置placeholder end --%>

<%--设置onfocus start --%>
<c:set var="strFocus" value=""></c:set>
<c:if test="${not empty onfocus}">
  <c:set var="strFocus" value='onfocus=\"${onfocus}\"'></c:set>
</c:if>
<%--设置onfocus end --%>

<%--设置value start --%>
<c:set var="strValue" value=""></c:set>
<c:if test="${not empty value}">
  <c:set var="strValue" value='value=\"${value}\"'></c:set>
</c:if>
<%--设置value end --%>

<%--设置required start --%>
<c:set var="strRequired" value=""></c:set>
<c:if test="${not empty required}">
  <c:set var="strRequired" value='required=\"${required}\"'></c:set>
</c:if>
<%--设置required end --%>

<%--设置style start --%>
<c:set var="strStyle" value=""></c:set>
<c:if test="${not empty style}">
  <c:set var="strStyle" value='style=\"${style}\"'></c:set>
</c:if>
<%--设置style end --%>

<%--设置readonly start --%>
<c:set var="strReadonly" value=""></c:set>
<c:if test="${not empty readonly}">
  <c:set var="strReadonly" value='readonly=\"${readonly}\"'></c:set>
</c:if>
<%--设置readonly end --%>

<%--设置是否显示必须项的符号（*）及控件基本属性 id及name start --%>
 <input id="${id}" name="${name}" ${strClass} ${strPlaceholder } ${strFocus} ${strValue} ${strRequired}  ${strStyle} ${strReadonly}/>
<c:choose>
  <c:when test="${empty showRequired or !showRequired}">
  </c:when>
  <c:otherwise>
      <span>*</span>
  </c:otherwise>
</c:choose>
<%--设置是否显示必须项的符号（*）及控件基本属性 id及name end --%>