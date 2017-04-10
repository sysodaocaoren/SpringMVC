<%@tag body-content="empty" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ attribute name="x" required="false" rtexprvalue="true" %>
<%@ attribute name="y" required="false" rtexprvalue="true" %>
<div>
<h4>The result of x+y is</h4>
result=${x+y}
</div>