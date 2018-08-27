<%@ page contentType="text/html;charset=utf-8" 
    import="java.sql.*,java.util.*,oracle.dbpool.*"
    errorPage="error.jsp" %>
<% request.setCharacterEncoding("euc-kr"); %>

<% 
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");

	try {
		String m_uid   = request.getParameter("uid");
		String m_pwd   = request.getParameter("pwd");
		String m_email = request.getParameter("email");
		String m_addr  = request.getParameter("addr");
		String m_zip   = request.getParameter("zip");
		String m_phone = request.getParameter("tel");
		String m_job   = request.getParameter("job");
		String m_name  = request.getParameter("name");  /////////

        String sql = "update mber set m_pwd=?,";
		sql = sql +  "m_email=?,m_job=?,m_phone=?,";
		sql = sql +  "m_zip=?,m_address=?, m_name=? ";  ///////////
		sql = sql +  "where m_uid ='" + m_uid + "'";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, m_pwd);
		pstmt.setString(2, m_email);
		pstmt.setString(3, m_job);
		pstmt.setString(4, m_phone);
        pstmt.setString(5, m_zip);
		pstmt.setString(6, m_addr);
		pstmt.setString(7, m_name);      ///////////////

		pstmt.executeUpdate();
		pstmt.close();
        pool.freeConnection("ora8", con);
        
       	 
    	session.setAttribute("pname",m_name);	 //회원 이름
        
%>
        <script language=javascript>
                alert("회원정보를 수정했습니다.");
                document.location.href='../main/index.jsp';
        </script>
<%     
	} catch (Exception e) {
		out.println(e);
		pool.freeConnection("ora8", con); 
	}
%>