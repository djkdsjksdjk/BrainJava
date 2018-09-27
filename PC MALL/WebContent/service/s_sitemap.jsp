<%@ page contentType="text/html;charset=euc_kr"  %>

<% String user_id= (String) session.getAttribute("pid");%>

<LINK href="../common/u3.css" type=text/css rel=STYLESHEET>

<body link="#000000" vlink="#000000" alink="#FF6633">

<br><br>
<table  width=560 height=40  cellspacing=0 cellpadding=0 topmargin=0>
	<tr valign=middle bgcolor=>
		<td align=left bgcolor=><font color="#E6E6E6" size=10><b>사이트 맵</b></font></td>
	</tr>
</table>

<table width=664 height=20 style="padding-bottom: 9px" >
     <tr  bgcolor="#E6E6E6">
     	<td align=left bgcolor= "#E6E6E6"></td>
	</tr>

</table>

  
<table width=666 border=0 cellspacing="1" cellpadding="0">
	<tr align="center" valign="top"> 
		<td width=292 height="330" style="padding-right:30px ">
			<table width=220 border=0 cellspacing="0" cellpadding="0">
				<tr> 
					<td height=55><b><font color="#0000FF" size=5>쇼핑몰</font></b><br>&nbsp;
						<img src="img/middle_line_01.gif" border=0 width=200></td>
				</tr>                           
				<tr >
					<td  ><font size=4><a href="../shoppingmall/gongi.jsp" id="dami"> &nbsp;●공지사항</a></td>
					
				</tr>
				<tr height=10>
						<td></td>
						</tr>
				 <tr>
					<td><font size=4><a href="../shoppingmall/newproduct.jsp"> &nbsp;●신상품 코너</a></td>
				</tr>
				<tr height=10>
						<td></td>
						</tr>
				<tr>
					<td><font size=4><a href="../shoppingmall/pc_calculation.jsp"> &nbsp;●조립PC견적</a></td>
				</tr>
			
			</table>
			
		<td width=88 height="330" style="padding-right:50px ">
			<table width=9 border=0 cellspacing="0" cellpadding="0">
			
			</table>
     
		</td>
		
		<td width=352 align="left" style="padding-right:14px ">
			<table width="287" border=0 cellspacing="0" cellpadding="0" bgcolor="#ffffff">
				<tr> 
					<td height=60><b><font color="#0000FF" size=5>내페이지</font></b><br>&nbsp;
						<img src="img/middle_line_01.gif" border=0 width=200></td>
				</tr>
				
				<tr>
					<td><font size=4><a href="../member/user.jsp"> &nbsp;●회원가입</a></td>
				</tr>
				<tr height=10>
						<td></td>
						</tr>
				<tr>

					<td><font size=4><a href="../board/Mywrite.jsp"> &nbsp;●내가 쓴 게시물</a></td>

				</tr>
				<tr height=10>
						<td></td>
						</tr>
				<tr>
					<td><font size=4><a href="../member/modify.jsp?user_id=<%=user_id%>"> &nbsp;●회원정보수정</a></td>
				</tr>
				<tr height=10>
						<td></td>
						</tr>
				<tr>
					<td><font size=4><font size=4><a href="../member/delete.jsp?user_id=<%=user_id%>"> &nbsp;●회원탈퇴</a></td>
				</tr>
				<tr height=10>
						<td></td>
						</tr>
				<tr>
					<td><font size=4><a href="../product/basket_view.jsp"> &nbsp;●장바구니</a></td>
				</tr>
			</table>
		</td>

	<table width="666" border=0 cellspacing="0" cellpadding="0">
			<tr align="center" height=210 valign="top"> 
				<td width=292 height=330  style="padding-right:30px ">
					<table width="224" border=0 cellspacing="0" cellpadding="0" bgcolor="#ffffff">
						<tr> 
							<td height=50><b><font color="#0000FF" size=5>묻고답하기</font></b><br>&nbsp;
								<img src="img/middle_line_01.gif" border=0 width=200></td>
						</tr>
						<tr height=10>
						<td></td>
						</tr>                           
						<tr>
							<td><font size=4><a href="../board/reply_list.jsp"> &nbsp;●자유게시판</a></td>
						</tr>
						<tr height=10>
						<td></td>
						</tr>
						<tr>
							<td><font size=4><a href="../service/inform_01.jsp"> &nbsp;●FAQ</a></td>
						</tr>
					</table> 
				</td>
				
			<td width=88 height="330" style="padding-right:50px ">
			     <table width=9 border=0 cellspacing="0" cellpadding="0">
			
			  </table>
     
		</td>
     				
				<td width=352 valign="top" align="left" >
					<table width= 245 style="padding-right:12px " border=0 cellspacing="0" cellpadding="0" bgcolor="#ffffff">
						<tr> 
							<td height=50><font size=4><b><font color="#0000FF" size=5>기 타</font></b><br>&nbsp;
							
							<img src="img/middle_line_01.gif" border=0 width=200></td>
							
						</tr>
						
						
						
						<tr>
							<td><font size=4><a href="../member/login_form.jsp"> &nbsp;●로그인</a></td>
						</tr>
						<tr height=10>
						<td></td>
						</tr>
						<tr>
							<td><font size=4><a href="../service/company_intro.jsp"> &nbsp;●회사소개</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</tr>
</table>

</BODY>
</HTML>