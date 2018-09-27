
<%@ page contentType="text/html;charset=utf-8"  %>

<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("index.jsp"); 
%>


<% logger.info("index.jsp start ~~~."); %>

<HTML>
	<HEAD>
		<TITLE>전자제품쇼핑몰</TITLE>
	<link href="../common/u3.css" type=text/css rel=stylesheet>
	</HEAD>

<BODY onload="window.open('popup.html','pop','width=480px, height=400px, left=100px, top=50px, toolbar=0, status=yes, menubars=0, scrollbars=0, resizable=0, location=0, directories=0')">
		<jsp:include page="../common/basic_screen.jsp"    flush="true"/>
		<jsp:include page="../common/main_right.jsp"  flush="true"/>

</BODY>
</HTML>
<% logger.info("index.jsp end ~~~."); %>