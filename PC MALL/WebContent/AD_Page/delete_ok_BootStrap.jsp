<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
    
<% 
	String  uid = session.getAttribute("uid").toString();
	String sql = "delete from member where m_uid = ?" ;
	
	try {
		Connection conn = null;
		PreparedStatement pstmt = null; 
    
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)
		envCtx.lookup("jdbc/mySql");
		conn = ds.getConnection();
	
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,uid);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
%>  
	<%-- 기존mms 코드 	
    <h3>회원 탈퇴 성공</h3>
	<img src="img/delete.gif"><p>
	<%= uid %> 님은 탈퇴 처리 되었습니다.<p> 
	--%>
	
	<script language="Javascript">
			alert('<%= uid %>' + '님은 탈퇴 처리 되었습니다.');
			location.href="index_BootStrap.jsp";
	</script>
	
	
<%
    
	session.invalidate(); // 세션제거
}  catch (Exception e) {
%>
	<%-- 기존mms 소스코드 	
	<h3>회원 탈퇴 실패</h3>
	<img src="img/warning.gif"><p>
	<%= uid %> 님은 아직 회원에서 탈퇴되지 않았습니다.<p> 
	--%>
	<script language="Javascript">
			alert('<%= uid %>' + '님은 아직 회원에서 탈퇴되지 않았습니다.<p>');
			location.href="index_BootStrap.jsp";
	</script>	
<% 
} 
%>