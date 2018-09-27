<%@ page  import="java.sql.*,oracle.dbpool.*" contentType="text/html;charset=utf-8" %>
<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("write.jsp"); 
%>
<% logger.info("update start ~~~."); %>

<%
try {

   //DB풀 메니저 객체 생성 사용
DBConnectionManager pool = DBConnectionManager.getInstance();
Connection con = pool.getConnection("ora8");
PreparedStatement pstmt = null;

request.setCharacterEncoding("utf-8");

int b_id = Integer.parseInt(request.getParameter("b_id"));
String b_name = request.getParameter("b_name");
String pwd = request.getParameter("pwd");
String b_email = request.getParameter("b_email");
String b_title = request.getParameter("b_title");
String b_content = request.getParameter("b_content");
String ip = request.getRemoteAddr(); // IP 알아내기

logger.info("update3.jsp  ~~~.");


int maxref=0;  //DB 안에 들어 있는 가장 큰 글 그룹번호
int ref=0;
int step=0;
int level=0;

	Statement stmt=con.createStatement();
	
	logger.info("update3.jsp step1 ~~~.");
  String sql = "update re_board2 set b_name=?, b_email=?, b_title=?, b_content=?, b_date=sysdate where b_id=?";
  pstmt = con.prepareStatement(sql);

  pstmt.setString(1,b_name);
  pstmt.setString(2,b_email);
  pstmt.setString(3,b_title);
  pstmt.setString(4,b_content);
  pstmt.setInt(5, b_id);
  
  
  logger.info("update3.jsp step2 ~~~.");
  pstmt.executeUpdate();
	pstmt.close();
  pool.freeConnection("ora8", con);
  %>
  <html>
<head><title>컴퓨터전문쇼핑몰</title>
    <script tlanguage="Javascript">
    function alrim(){
    	alert("게시물을 수정 하였습니다.");
    	location.href="Boarde_list.jsp";
    }
    </script>
    </head>
    <body onload="alrim();">
    </body>
    </html>
<%
} catch (Exception e) {
        out.println(e);
} 
%>
<% logger.info("update end ~~~."); %>