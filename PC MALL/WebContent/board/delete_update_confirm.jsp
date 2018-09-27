<%@ page  import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("delete_confirm2.jsp"); 
%>

<%
	String b_id  = request.getParameter("b_id");
	String param_gubun = request.getParameter("gubun");
	String strGubun = param_gubun.equals("delete")?"삭제":"수정";
	String strUrl = param_gubun.equals("delete")?"delete2.jsp":"update_form2.jsp";
	
	String pass = (String)session.getAttribute("PASS");
	
	logger.info("b_id :" + b_id);
	logger.info("pass :" + pass);
	logger.info("strGubun :" + strGubun);
%>
                                          
<HTML>
	<HEAD>
		<TITLE>컴퓨터전문쇼핑몰</TITLE>
		
		
		
		
<script type="text/javascript">



	function go_process()
	{
		
	 	if(document.confirm_password.pwd.value == "") {
			alert("비밀번호를 입력하세요.");
			document.confirm_password.pwd.focus();
			return;
		}
	 	
	 	// alert(document.confirm_password.pwd.value);
	 	// alert('<%=pass%>');
	 	
	 	if(document.confirm_password.pwd.value != <%=pass%>) {
			alert("비밀번호가 틀렸습니다.");
			document.confirm_password.pwd.focus();
			return;
	 	}
	 		
	 	document.confirm_password.submit();
	}

</script>		
		
		
	</HEAD>
	<link href="../common/u3.css" type=text/css rel=stylesheet>

<BODY leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
	<jsp:include page="../common/basic_screen.jsp" flush="true"/>

	<br>
	<table cellpadding=0 cellspacing=0 border=0 width=330>
		<tr bgcolor=#7eaee9>
			<td align=center><font color="#ffffff"><b>[<%= strGubun %>]상품 게시물의 비밀번호를 입력하세요.</b></font></td>
		</tr>
	</table>
	<form name="confirm_password" method="post" action="<%= strUrl %>">
	<table cellpadding=0 cellspacing=0 border=0 width=330>
		<tr bgcolor=#948dcf>
			<td>
				<table cellpadding=4 cellspacing=1 border=0 width=330>
  					<tr bgcolor="#ffffff">
						<td align="center">
							<input type="password" name="pwd" size=20 >
							<input type="button" value="확인" onclick="javascript:go_process()">
						</td>
					</tr>
				</table>
				
				</tr>
		<input type="hidden" name="b_id" value="<%=b_id%>">
		<% 
			logger.info("hidden b_id값:" + b_id);
		%>
		
	</table>		  
	</form>                              
	
	<table cellpadding=0 cellspacing=0 border=0 width=330>
		<tr bgcolor=#0000FF>
		   <td></td>
		</tr>
	</table>

	<jsp:include page="../common/basic_copyright.jsp" flush="true"/>
</body>
</html>