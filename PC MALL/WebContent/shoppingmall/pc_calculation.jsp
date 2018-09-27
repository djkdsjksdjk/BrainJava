<%@ page contentType="text/html; charset=euc-kr" 
                 import="java.sql.*,oracle.dbpool.*,java.util.*, java.text.*" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<HTML>
	<HEAD>
		<TITLE>조립 PC 견적</TITLE>
		<SCRIPT language=JavaScript src="../common/u3.js"></script>
		<link href="../common/u3.css" type=text/css rel=stylesheet>
	</HEAD>

<BODY leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
    <jsp:include page="../common/basic_screen.jsp" flush="true"/>
	
<!--  화면 설계   -->
<center><br>
  <table  width=685 height=30  bgcolor=ffffff>
	<tr>
		<td align="left" height="25" style=" padding-top: 25px;  padding-bottom: 20px;"><font color="#E6E6E6" size="25"><b>--조립 PC 견적--</b></td>
	</tr>
  </table><br>

<form name="buy" action="../product/basket_insert.jsp" method="post">
<table align=center  border=0  cellpadding=0 cellspacing=3  width=725 >
	<tr>
		<td bgcolor=black align="center" style="height: 36px"><b><font color="#ffffff">구분</font></b></td>
		<td bgcolor=black align="center" style="height: 36px"><b><font color="#ffffff">상품명</font></b></td>
	</tr>
<%
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	int i=1;
	int j=101;
	try {
		Statement stmt = con.createStatement();
		ResultSet rs =stmt.executeQuery("select * from category where id between 1 and 18");
		while(rs.next()){
			int id=rs.getInt("id");
			String name=rs.getString("name");
%>
	<tr bgcolor=cde6ff>
		<td width=100 height="26"><font color=black>&nbsp;<%= name %></font>
		</td>
		<td>
			<select name=productnum>
			<option value='0'>------------  원하시는 부품을 목록에서 선택 하세요  ------------</option>
<% 
        Statement stmt1 = con.createStatement();
		ResultSet rs1=stmt1.executeQuery("select * from product where category="+id);
		while(rs1.next()){
			int id1 = rs1.getInt("id");
			String name1=rs1.getString("name");
			int price1=rs1.getInt("price");
%>
			<option value=<%= id1 %>>&nbsp;<%=name1%> &nbsp;가격:<%= price1 %></option>
<%
		}
		rs1.close();
		stmt1.close();
%>
		</select>
		</td>
	</tr>
<%
	} //end of while
	rs.close();
	stmt.close();
	pool.freeConnection("ora8", con); 
  } catch (SQLException e) {
		out.print(e);
  } 
%>
	<tr>
		<td align=right padding-right:5 colspan=3><br><input type="submit" value="장바구니에 담기"></td>
	</tr>
</table>
</form>
  
</center>
<!--  화면 끝   -->
</BODY>
</HTML>