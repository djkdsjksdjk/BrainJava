<%@ page  import="java.sql.*,oracle.dbpool.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="org.apache.log4j.*" %>

<%! 
	static Logger logger = Logger.getLogger("show2.jsp"); 
%>


<html>
<head>
  <title>컴퓨터전문쇼핑몰</title>
  <link href="../common/u3.css" type=text/css rel=stylesheet>

<script type="javascript" src="../common/u3.js"></script>

<script type="text/javascript">

	function go_update()
	{
	 	if(document.mform.b_name.value == "") {
			alert("이름을 입력하세요");
			document.mform.b_name.focus();
			return;
		}
	 	
	 	
	 	if(document.mform.b_email.value == "") {
			alert("이메일 주소 입력하세요");
			document.mform.b_email.focus();
			return;
		}
	 	
	 	if(document.mform.b_title.value == "") {
			alert("제목을 입력하세요");
			document.mform.b_title.focus();
			return;
		}
	 	
	 	if(document.mform.b_content.value == "") {
			alert("내용을 입력하세요");
			document.mform.b_content.focus();
			return;
		}
	 		
	 	document.mform.submit();
	}

</script>


</head>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<jsp:include page="../common/basic_screen.jsp" flush="true"/>

<!-- 상세정보 표시 -->
<%
String  b_name, b_email, b_title, b_content, b_date, b_ip, photo, mailto;
int  b_id =0 , b_hit =0, level=0, color=1, ref=0;

	Statement stmt = null;
	//Statement stmt2 = null;
	ResultSet rs = null;

	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
    
	try {
		 
		 b_id = Integer.parseInt(request.getParameter("b_id"));
		 String sql1 ="select b_id, b_name, b_email, b_title, b_content, to_char(b_date,'yy-mm-dd'),b_hit, b_ip, photo, ref, step, anslevel, pwd  from re_board2 where b_id= "+b_id; 
		 stmt = con.createStatement();
		 rs = stmt.executeQuery(sql1);
		 
		 while(rs.next()) {
			b_id=rs.getInt(1);
     b_name=rs.getString(2);
     b_email=rs.getString(3);
     b_title=rs.getString(4);
     b_content=rs.getString(5);
     b_date=rs.getString(6);
     b_hit=rs.getInt(7)+1;
     b_ip=rs.getString(8);
     photo=rs.getString(9);
     ref = rs.getInt(10);  // 글 그룹
			
			logger.info("update b_id값:" + b_id);
%>


<form name=mform method=post action="update3.jsp" >
<br><br>
<table border=0 cellpadding=0 cellspacing=0 width=605 align=center>
   <tr bgcolor=#7aaad5 height=30>
       <td  colspan=3 align=center bgcolor="#0000ff"><font color="#ffffff"><b> [수정]<%= b_name %>상품 문의 정보</b></font></td>
  </tr>
</table><br>
	
<table border=1 align=center cellpadding=0 cellspacing=0 width=600>
 <tbody> 
    <tr> 
      <td valign=top> 
        <table border=0 cellpadding=0 cellspacing=0 width=200>
          <tr> 
            <td valign=top><img border=0 name=picmedium height=200 width=200 src="../product/image/<%=photo%>"></td>
          </tr>
         </table>
      </td>

      <td> 
        <table border=1 cellpadding=0 cellspacing=0 width=400>
          <tr> 
              <td width=90>&nbsp; 이름</td>
              <td width=280>&nbsp;<input type="text" name="b_name" value="<%=b_name%>"/></td>
		 </tr>
          
          <tr>
                  <td width=90>&nbsp; 이메일 주소</td>
                  <td width=280>
                  	&nbsp;<input type="text" name="b_email" value="<%=b_email%>"/>
					
                  </td>
          </tr>
           <tr> 
                  <td>&nbsp; 제목</td>
                  <td>&nbsp;<input type="text" name="b_title" value="<%= b_title %>"></td>
          </tr>
          <tr> 
                  <td>&nbsp; 내용</td>
                  <td>&nbsp;<input type="text" name="b_content" value="<%= b_content %>" size="40"></td>
           </tr>
          <tr> 
	   		<td colspan=2 valign="bottom" align=right height=40 >
	
		     <a href="javascript:go_update()"><img src="img/b_edit.gif" border=0></a>
		     <a href="javascript:history.go(-2)"><img src="img/b_cancel.gif" border=0></a>


	   		</td>
	  	</tr>
        </table>
      </td>
    </tr>
    </tbody> 
</table>
    
	<input type="hidden" name="b_id" value="<%=b_id%>">

</form>
<%
	}
		rs.close();
	} catch (Exception e){
		System.out.println(e);
	} finally{
		if (stmt != null) 
			stmt.close();
	
		if (con != null) {
		 	pool.freeConnection("ora8", con);
		}
	}
%>
<!-- 상품상세정보 표시 끝 -->
<jsp:include page="../common/basic_copyright.jsp" flush="true"/>
</body>
</html>