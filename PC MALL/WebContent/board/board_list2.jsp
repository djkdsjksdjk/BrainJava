<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,oracle.dbpool.*"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="org.apache.log4j.*" %>
<%@ page import="myutil.Category, java.util.*" %>

<%! 
	static Logger logger = Logger.getLogger("board_list2.jsp"); 
%>

<%
  
	// 로그인이 아닌경우 
	if(session.getAttribute("pid") == null) {
%>		
        <script type="text/javascript">
			alert("회원전용 게시판 입니다.");
			history.go(-1); 
		</script>
<% 
    } else {  
%>

<HTML>
	<HEAD><TITLE>컴퓨터전문쇼핑몰</TITLE>
	</HEAD>
	<link href="../common/u3.css" type=text/css rel=stylesheet>

<BODY leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
    <jsp:include page="../common/basic_screen.jsp" flush="true"/>

<form name=board_search method=post>
<br>
	<table border=1 width=550 height=30 bordercolor=black>
		<tr>
			<td align=center bgcolor=#E68D8D><font size=3 color=#FFFFFF><b>상 품 게 시 판</b></td>
		</tr>
	</table>
	<br>
	<table width=550 border=1 cellspacing=0 cellpadding=0  bordercolor="#C0C0C0">
		<tr bgcolor="#E68D8D" height=21>
			<td width=50 align="center" bgcolor="#E68D8D"><font size="2" >번호</font></td>
			<td width=100  align="center">상품이미지</td>
			<td width=230 align="center">상품명</td>
			<td width=100 align="center">가격</td>
			<td width=60 align="center">제조사</td>
		</tr>
<%!   
	int pagesize = 10;  // 한페이지당 10개 출력물
	int pageNUM=1;    // 페이지 번호
	int pagecount=1 ; // 페이지 갯수 지정 변수
	int absolutepage=1;  // 절대 위치 페이지 번호
	int dbcount=0 ;   //  DB 안에 글 갯수 저장 변수
%>
<%


	try{ 
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
 
		String b_name, b_email, b_title, b_content, b_date, mailto;
		
		// ID,NAME,PRICE,COMPANY_ID,EXPRESSION,PHOTO,CATEGORY,CNAME,CODE,CDATE
		String id, name, company_id, expression, photo,  cname,  cdate, pass; 
		int  b_id =0 , b_hit = 0, level=0, color=1, price, category, code;
		
		String selectCategory = "SELECT id, name FROM CATEGORY ORDER BY ID ASC";
				

		// DB 행의 수 계산
		Statement stmt = con.createStatement();  
		Statement stmt2 = con.createStatement();
		//Statement stmt3 = con.createStatement();
		
		ResultSet pageset = stmt.executeQuery("SELECT count(ID) FROM PRODUCT_VIEW");
		//ResultSet categoryRS = stmt3.executeQuery(selectCategory);
		
		//ResultSet pageset = stmt.executeQuery("select count(b_id) from re_board");
		if( pageset.next()){
			dbcount = pageset.getInt(1); 
			pageset.close();
		}

        int ii = dbcount + 1;

		if(dbcount%pagesize == 0)   
			pagecount = dbcount/(pagesize); // 총 페이지수 구하기
		else
			pagecount = dbcount/(pagesize)+1; // 총 페이지수 구하기

		if(request.getParameter("pageNUM") != null) {
			pageNUM=Integer.parseInt(request.getParameter("pageNUM"));	 //지정된 페이지 보여주기
			absolutepage=(pageNUM-1)*pagesize+1;
			ii = ii - (pageNUM-1)*pagesize;
		}
		
		/* 
		String sql = "select b_id, b_name, b_email, b_title, b_content, ";
		sql = sql + " to_char(b_date,'yy-mm-dd'), b_hit, ref, step, anslevel "; 
		sql = sql + " from re_board order by ref desc, step ";
		sql = sql.toUpperCase().trim();
		*/
		
		String sql = "SELECT ID,NAME,PRICE,COMPANY_ID,EXPRESSION,PHOTO,CATEGORY,CNAME,CODE,CDATE,PASS FROM PRODUCT_VIEW ORDER BY ID DESC ";
		ResultSet rs = stmt2.executeQuery(sql);

		for(int k=1; k<absolutepage; k++)rs.next();
		int k=1;

		// id, name, price, company_id, expression, photo, category, cname, code, cdate;
		while(rs.next() && k<=pagesize){ 
			
			b_id       = rs.getInt(1);		
			name       = rs.getString(2);	// NAME
			price      = rs.getInt(3);	    // PRICE
			company_id = rs.getString(4);	// COMPANY_ID
			expression = rs.getString(5);	// EXPRESSION
			photo      = rs.getString(6);   // PHOTO
			category   = rs.getInt(7);		// CATEGORY
			cname      = rs.getString(8);	// CNAME
			code       = rs.getInt(9);		// CODE
			cdate      = rs.getString(10);  // CDATE
			pass       = rs.getString(11);  // PASS
	
			/* 			
			if(!b_email.equals("")) {
				mailto="<a href=mailto:"+b_email+">"+b_name+"</a>";
			} 
			else {
				mailto=b_name; 
			}
	 		*/
	 		
            ii--;
 %>
		<tr height=22 bgcolor=ffffff onMouseOver=this.style.backgroundColor='#FFF8DE'  onMouseOut=this.style.backgroundColor='#FFFFFF'>
			<td width=50 align=center><%= ii %></td>
			<td width=100 align=center><a href='show2.jsp?b_id=<%= b_id %>'>
<%			
				if(level>0) { 
					for(int i = 0; i< level; i++){
 %>				&nbsp;
 <%
		        }
 %>
				<img src="img/reply.gif" width="16" height="16"border=0>  	
<% 
                } 
 %> 
             <img border=0 name=PicMedium height=30 width=30 src="../product/image/<%=photo%>"></a></td>
             
             
             
			 <td width=230 align=center><%=name%></td>
			 
			 <td width=100 align=center>
			 <c:set var="fmtPrice" value="<%=price%>"/>
			 &nbsp;<fmt:formatNumber value="${fmtPrice }" pattern="#,###" />원
			 </td>
			 <td width=60 align=center><%=company_id%></td>
		  </tr>
<%
		k++;
		} 

		rs.close();
		stmt.close(); 
		con.close(); 
		pool.freeConnection("ora8", con); 
	} catch (Exception e) {
	out.println(e);
	}
%>
   <c:set var="categoryList" value="${categoryList}" scope="session" /> 
	</table>
	<table width=550 bgcolor=000000 border=0 cellpadding=0 cellspacing=0>
		<tr bgcolor=ffffff>
			<td width=10>&nbsp;</td>
			<td width=350  align=center valign=middle height=30>
  
<%		// 페이지 구현부
			 int limit = 15 ;                  // 하단 페이지번호 리스트 개수셋팅 
			 int temp =(pageNUM-1) % limit ;  
			 int startPage = pageNUM - temp;  // 시작 페이지 구하기
			 
			 // [이전] 링크 추가하기
			 if ((startPage-limit)>0){ %>     
				<a href='board_list2.jsp?pageNUM=<%=startPage-1%>'>[이전]<a>
<% 
			 }
			 //페이지 번호 나열하기
			 for(int i=startPage ; i<(startPage+limit);i++){
				if( i == pageNUM){%>
					<font color="red" ><b>[<%=i%>]</b></font>
<% 
				} else { 
%>
					<a href='board_list2.jsp?pageNUM=<%=i%>'><%=i%><a>
<%
					}
				 if(i >= pagecount) break;
			 }
			 //[다음] 링크 추가
			if ((startPage+limit)<=pagecount) { %>
  				<a href='board_list2.jsp?pageNUM=<%=startPage+limit%>'>[다음] <a>
<%
			}
%>
			</td>
			<td width=180 height=30 valign=middle align=right>
			<a href="write_form2.jsp"><img src="img/m_bt10.gif" border=0 align=absmiddle></a>
			<a href="board_list2.jsp"><img src="img/m_bt06.gif" border=0 align=absmiddle></a>
			</td>
			<td width=10>&nbsp;</td>
		</tr>
	</table>	
</form>
	<jsp:include page="../common/basic_copyright.jsp" flush="true"/>
</body>
</html>

<%
 } 
%>