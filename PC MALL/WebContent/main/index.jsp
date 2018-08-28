<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("index.jsp"); 
%>
<% logger.info("index.jsp start ~~~."); %>
<HTML>
	<HEAD>
		<TITLE>컴퓨터전문쇼핑몰</TITLE>
	<link href="../common/u3.css" type=text/css rel=stylesheet>
	</HEAD>

<BODY leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
		<jsp:include page="../common/basic_screen.jsp"    flush="true"/>
		<jsp:include page="../common/main_right.jsp"      flush="true"/>
		<jsp:include page="../common/basic_copyright.jsp" flush="true"/>
</BODY>
</HTML>

<% logger.info("index.jsp end ~~~."); %>