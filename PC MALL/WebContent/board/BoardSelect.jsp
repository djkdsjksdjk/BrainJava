<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*,oracle.dbpool.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<HTML>
<HEAD>
<TITLE>컴퓨터 전문쇼핑몰</TITLE>
<link href="../common/u3.css" type=text/css rel=stylesheet>
</HEAD>

<BODY leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
	<jsp:include page="../board/Boarde_list.jsp" flush="true" />
	
	
			<!-- 검색 시작 -->
			<%
				DBConnectionManager pool = DBConnectionManager.getInstance();
				Connection con = pool.getConnection("ora8");

				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
				String s_word = new String(request.getParameter("srch_word").getBytes("8859_1"), "UTF-8");

				try {
					String b_name, b_email, b_title, b_content, b_date;
					int b_id, b_hit, count;

					ResultSet rs = stmt.executeQuery(
							"select b_name, b_title, b_content from re_board where b_name like UPPER('%"+s_word+"%')");
					ResultSet rs1 = stmt1
							.executeQuery("select count(*) from re_board where b_name like UPPER('%"+s_word+"%')");

					while (rs1.next()) {
						count = rs1.getInt(1);
			%>
			         <font color=red><%= s_word %></font> 에 대한
			          <font color=red><%= count %></font> 개의 검색결과 입니다!<br>
			
			<%
				}
			%>
			
			<table border=0 width=550 height=30 bordercolor=black>
		<tr>
			<td align=center bgcolor=0063ce><font size=3 color=#FFFFFF><b>자 유 게 시 판</b></td>
		</tr>
	</table>
	<br>
	<table width=550 border=0 cellspacing=0 cellpadding=0  bordercolor="#C0C0C0">
		<tr bgcolor="#7eaee9" align="center">
			
			<td height=30 bgcolor=#7aaad5>&nbsp;번호</td>
			<td height=30 width=230 bgcolor=#7aaad5>&nbsp;제목</td>
			<td height=30 bgcolor=#7aaad5>&nbsp;날짜</td>
			<td height=30 bgcolor=#7aaad5>&nbsp;글쓴이</td>
			<td height=30 bgcolor=#7aaad5>&nbsp;조회수</td>
		</tr>

			<%

					while(rs.next()){ 
						b_id=rs.getInt(1);			//글번호
						b_name=rs.getString(2);		// 글쓴이
						b_email=rs.getString(3);	//작성자 메일
						b_title=rs.getString(4);	// 글제목
						b_content=rs.getString(5);	//글내용
						b_date=rs.getString(6);		//작성날짜
						b_hit=rs.getInt(7);			// 조회수
						%>
						<tr bgcolor="edf5fe"> 
				<td  height=30>&nbsp;&nbsp;&nbsp;&nbsp;<a href=
				                "../board/Boarde_list.jsp?i=<%=b_title%> <%=b_content%> <%=b_name%>"></a></td>
				
			</tr>
						<%
			
				}
					rs.close();
					rs1.close();
					stmt.close();
					stmt1.close();
				} catch (Exception e) {
					out.println(e);
				} finally {
					pool.freeConnection("ora8", con);
				}
			%>
		</table>


		<!--  검색 끝 -->
		<jsp:include page="../common/basic_copyright.jsp" flush="true" />
</BODY>
</HTML>