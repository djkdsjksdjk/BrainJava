<%@ page  import="java.sql.*,oracle.dbpool.*" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("delete2.jsp"); 
%>

<%
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
   
	try {
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		
		logger.info("delete2.jsp -> b_id: " + b_id);
		
		String pwd = null ;   //DB에서 현재 글쓴사람과 세션이같으면 삭제
 
		Statement stmt  = con.createStatement();
		Statement stmt2 = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select pass from product where id="+b_id);
		
		if(rs.next()) {
			pwd=rs.getString(1);
		}
		
		if(pwd.equals(request.getParameter("pwd"))){ 
			logger.info("delete2.jsp -> request.getParameter(\"pwd\") :" + request.getParameter("pwd"));
			stmt2.executeUpdate("delete from product where id="+b_id);
%>
			<script language=javascript>
				document.location.href='board_list2.jsp';
			</script>
<%
		} else {
%>
			<script language=javascript>
				alert("글을 삭제할 수 없습니다.");
				history.back();
			</script>
<%
		}
		rs.close();
		stmt.close(); 

	} catch (Exception e) {
		out.println(e);
	}  finally{
		pool.freeConnection("ora8", con); 
	}
%>