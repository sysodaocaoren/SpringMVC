<!-- 
  body-content:
	tagdependent：标签体内容直接被写入BodyContent，由自定义标签类来进行处理，而不被JSP容器解释，
	如下：
	<test:myList>
	select name,age from users
	</test:myList>
	 
	JSP：接受所有JSP语法，如定制的或内部的tag、scripts、静态HTML、脚本元素、JSP指令和动作。如：
	<my:test>
	    <%=request.getProtocol()%>      // ②
	</my:test>
	具体可参考后面附源码。
	 
	empty：空标记，即起始标记和结束标记之间没有内容。
	下面几种写法都是有效的，
	<test:mytag />
	<test:mytag uname="Tom" />
	<test:mytag></test:mytag>
	 
	scriptless：接受文本、EL和JSP动作。如上述②使用<body-content> scriptless </body-content>则报错，具体可参考后面附源码。
 -->


<%@tag body-content="empty" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ attribute name="name" required="false" rtexprvalue="true" %>
<div>
<h4>您刚才传过来一个值</h4>
${name}
</div>