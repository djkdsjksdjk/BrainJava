<%@ page  import="java.sql.*,oracle.dbpool.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ page import="myutil.Multipart" %>
<%@ page import="java.net.URLEncoder" %>


<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("write2.jsp"); 
%>


<% logger.info("write2 start ~~~."); %>


<%
try {
	
    //DB풀 메니저 객체 생성 사용
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	
	request.setCharacterEncoding("UTF-8");
	
	///////////////////// 파일 업로드 시작 ////////////////
 	Multipart multiPart = new Multipart(request);
	String fileName = multiPart.getFileName("upload_file");
	String newPath = application.getRealPath("/product/image/" + fileName);	
	multiPart.saveFile("upload_file", newPath); 
	logger.info("index.jsp start ~~~.");
	int product_id    = 1;                                  // id
	String category   = multiPart.getParameter("category");
	String code       = multiPart.getParameter("code");
    String name       = multiPart.getParameter("name");
    logger.info("name: "+name);
	String price      = multiPart.getParameter("price");
	String company_id = multiPart.getParameter("company_id");
	String expression = multiPart.getParameter("expression");
	String pass       = multiPart.getParameter("pwd");
    String photo      = fileName;
	    
    String sql = "SELECT COUNT(*) FROM PRODUCT";
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	
	if(rs.next()) {
		product_id = rs.getInt(1); 
		product_id++;    
		rs.close();
	}


    // 상품등록		 
    sql = "INSERT INTO PRODUCT (ID,CATEGORY,CODE,NAME,PRICE,COMPANY_ID,CDATE,EXPRESSION,PHOTO,PASS) VALUES ( ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
		    
    PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1   , product_id);         
    pstmt.setString(2, category);      
    pstmt.setInt(3   , product_id);  //pstmt.setString(3, code);
	pstmt.setString(4, name);   
	pstmt.setInt(5   , Integer.parseInt(price));   
	pstmt.setString(6, company_id); 
    pstmt.setString(7, expression);
    pstmt.setString(8, photo);
    pstmt.setString(9, pass);
	pstmt.executeUpdate();
	pstmt.close();
	pool.freeConnection("ora8", con); 
%>
	 <script type="text/javascript">
    	location.href="board_list2.jsp";
     </script> 
<%

	} catch (Exception e) {
		out.println(e);
	}
%>

<%!

	
String makeKOR(String str)throws java.io.UnsupportedEncodingException
{
   String kor="";
   if (str==null) 
   		kor=null;
   else
    	kor=new String(str.getBytes("ISO-8859-1"),"UTF-8");
   
   return kor;
}
	
	   // 개행 처리를 위한 메소드 

public static String Replace(String original, String oldString, String newString) 
{
	for(int index = 0; (index = original.indexOf(oldString, index)) >= 0; index += newString.length())
		original = original.substring(0, index) + newString + original.substring(index + oldString.length());
	return original;
}	

%>