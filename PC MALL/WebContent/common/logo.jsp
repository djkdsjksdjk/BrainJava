<%@ page contentType="text/html;charset=utf-8" %>

<% 
	String pid =(String)session.getAttribute("pid");
	String pname=(String)session.getAttribute("pname"); 
%>

<body link="#000000" vlink="#000000" alink="#666666">
<table width=1200 border=0 cellspacing=0 cellpadding=0 height=60 align=left name="top_table">
	<tbody valign=top align=left>
		<tr valign=top align=left> 
			<td border=0 width=50 height=50 rowspan=2><a href="../main/index.jsp"><img name="Image5"  align=left  border=0 src="../img/electronic-logo.png" width=400 height=80></a></td>
			
			<td width=100 colspan=2>
			<div align=right><marquee behavior=left scrollamount=1><font color="#0000AA">
<%
				if( session.getAttribute("pid") != null) {
 %>
					([<%=pname%>]
<%
				}
 %>			님 어서오세요!</font></marquee></div>
			</td>
		
			</tr>
		<tr valign=top  align=center> 
<%
			if( session.getAttribute("pid") != null) {
%>
			<td><a href="../member/logout.jsp" class=line>[ 로그아웃 ]</td>
<%
			}  else {
%>
			<td><a href="../member/login.jsp" class=line>[ 로그인 ]</a></td>
<%
			}
%>
           
<td align="center" style="width= 50px;width: 100px;"><a href="../service/index_site.jsp" class="line">[ 사이트맵 ]</a></td>			
			
		</tr>
		
		  <td width=500 height=15 valign=middle style=" padding-bottom:4px;" bgcolor=#ffffff >
		<tr align=center>
		<form name="search_form" action="../common/search_view.jsp" method=post>
	         <td height="39" width="600" align="center" style="padding-bottom: 12px ;  padding-left: 300px;">  
                  <input type="text" name="srch_word" size="20" style="width:400px;height: 30px;">
                   <input type="image" border=0 width="49" height="35"align="center" style="padding-bottom: 9px;" src="../img/s.gif"></td>
             </form>
             </td>
		</tr>
	</tbody>
</table>