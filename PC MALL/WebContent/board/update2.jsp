<%@ page  import="java.sql.*,oracle.dbpool.*" contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("show2.jsp"); 
%>

<%   
try {

    //DB풀 메니저 객체 생성 사용
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	PreparedStatement pstmt = null;
	
	request.setCharacterEncoding("UTF-8");

	int b_id = Integer.parseInt(request.getParameter("b_id"));
	String name = request.getParameter("name");
    int category  = Integer.parseInt(request.getParameter("category"));
    int price  = Integer.parseInt(request.getParameter("price"));
    String company_id  = request.getParameter("company_id");
    String expression  = request.getParameter("expression");
	     
  	//Statement stmt= con.createStatement();
  	String sql = "update product set category=?, name=?, price=?, company_id=?, cdate=sysdate, expression=? where id=?";
  	pstmt = con.prepareStatement(sql);
  	
  	pstmt.setInt(1, category);
  	pstmt.setString(2, name);
  	pstmt.setInt(3, price);
  	pstmt.setString(4, company_id);
  	pstmt.setString(5, expression);
  	pstmt.setInt(6, b_id);
  	
  	pstmt.executeUpdate();
  	pstmt.close();
  	pool.freeConnection("ora8", con);
%>
    <script type="text/javascript">
    	alert("상품정보를 수정 하였습니다.");
    	location.href="board_list2.jsp";
     </script>
<%
} catch (Exception e) {
        out.println(e);
} 
%>