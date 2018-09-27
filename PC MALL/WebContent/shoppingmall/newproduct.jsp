<%@ page  contentType="text/html;charset=euc-kr" import="java.sql.*,oracle.dbpool.*" %> 

<HTML>
	<HEAD>
		<TITLE>컴퓨터전문쇼핑몰</TITLE>
		<script language=JavaScript src="../common/u3.js"></script>
		<link href="../common/u3.css" type=text/css rel=stylesheet>
	</HEAD>

<BODY leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>
    <jsp:include page="../common/basic_screen.jsp" flush="true"/>
	
<!--  신상품 화면    -->
	<br>
	<table  width=685  height=30>
		<tr>
			<td align="left" height="25" style=" padding-top: 25px;  padding-bottom: 20px;"><font color="#E6E6E6" size="25"><b>--신 상 품--</b></td>
		</tr>
	</table><br>
	<table width="725" border=0 cellpadding=1 cellspacing=1>
<%
	try {
		String name,company_id,expression,photo;
		int id,price;
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select id,name,price,company_id,expression,photo from product order by cdate desc, id desc");
		
		int flag=0;
        int stop = 1;		
		while(rs.next())  {
			id=rs.getInt(1);
			name=rs.getString(2);
			price=rs.getInt(3);
			company_id=rs.getString(4);
			expression=rs.getString(5);
			photo=rs.getString(6);
		if(flag==0){
%>
		<tr>
			<td>
				<!-- ========= 왼쪽 테이블 ========== -->
				<table width="362" border=3 cellpadding=1 cellspacing=2 align=center bordercolor="#E6E6E6" >
				<tr>
					<td colspan=2 align="center"><a href="../product/product.jsp?i=<%= id%>">
					<img src="../product/image/<%=photo%>" width=200 height=200 border=0></a></td>
				</tr>
				<tr>
					<td width=100 align=center bgcolor=#7eaee9><font color="white">상품명</font></td>
					<td bgcolor=cde6ff>&nbsp;&nbsp;<%=name%></td>
				</tr>
				<tr>
					<td width=100 align=center bgcolor=#7eaee9><font color="white">가격</font></td>
					<td bgcolor=cde6ff>&nbsp;&nbsp;<%=price%>&nbsp;원</td>
				</tr>
				<tr>
					<td width=100 align=center bgcolor=#7eaee9><font color="white">제조회사</font></td>
					<td bgcolor=cde6ff>&nbsp;&nbsp;<%=company_id%></td>
				</tr>
				<tr>
					<td width=100  height=35 align=center><font  color=blue>제품설명</font></td>
					<td>&nbsp;&nbsp;<%=expression%></td>
				</tr>
				</table>
			    <!-- 끝 -->
<%      
		flag=1;            
		} else {
%>
		</td>
		<td>
			<!-- 오른쪽  테이블 -->
			<table width="362" border=3 cellpadding=1 cellspacing=2 align=center bordercolor="#E6E6E6" >
			<tr>
				<td colspan=2 align="center"><a href="../product/product.jsp?i=<%= id%>">
				<img src="../productimg/image/<%=photo%>" width=200 height=200 border=0></a></td>
			</tr>
			<tr>
				<td width=100 align=center bgcolor=#7eaee9><font color="white">상품명</font></td>
				<td bgcolor=cde6ff>&nbsp;&nbsp;<%=name%></td>
			</tr>
			<tr>
				<td width=100 align=center bgcolor=#7eaee9><font color="white">가격</font></td>
				<td bgcolor=cde6ff>&nbsp;&nbsp;<%=price%>&nbsp;원</td>
			</tr>
			<tr>
				<td width=100 align=center bgcolor=#7eaee9><font color="white">제조회사</font></td>
				<td bgcolor=cde6ff>&nbsp;&nbsp;<%=company_id%></td>
			</tr>
			<tr>
				<td width=100  height=35 align=center><font color=blue>제품설명</font></td>
				<td>&nbsp;&nbsp;<%=expression%></td>
			</tr>
			</table>
			<!--끝 -->	
		</td>
	</tr>
<%
	flag=0;
     stop = stop + 1;
	 if( stop > 2) break;
	} //while
	} //try
        rs.close(); 
        stmt.close();
	 pool.freeConnection("ora8", con);
} catch (Exception e) {
	out.println(e);
}
%>
	</table>


<!--  화면 끝   -->

</BODY>
</HTML>