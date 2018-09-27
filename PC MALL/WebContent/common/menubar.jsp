<%@ page contentType="text/html;charset=utf-8"  %>
<%  
	String pid = (String) session.getAttribute("pid"); 
%>

<script language="JavaScript">
<!--
function MM_showHideLayers() { //v3.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>

<BODY>



<div valign="top" align="left" >
<table width=780  align="center" border=0 cellspacing=0 cellpadding=0 height=10>

<tbody valign="top" align="center" >
  <tr valign="top" align="center" height="19">
 

 
    <td width=95 height=24><a href="../main/index.jsp" onMouseOver="document.images[1].src='../img/ｂａｒ１.jpg';" onMouseOut="document.images[1].src='../img/ｂａｒ１.jpg';"><img src="../img/ｂａｒ１.jpg" width=95 height=24></a></td>

	<td width=95 height=24><a href="../service/company_intro.jsp" onMouseOver="document.images[2].src='../img/ｂａｒ２.jpg';;MM_showHideLayers('shop','','hide','member','','hide','qna','','hide')" onMouseOut="document.images[2].src='../img/ｂａｒ２.jpg';">
   <img src="../img/ｂａｒ２.jpg" width=95 height=24></a></td>

    <td width=95 height=24 border=0><a src="../img/ｂａｒ３.jpg"   onMouseOver="document.images[3].src='../img/ｂａｒ３.jpg';MM_showHideLayers('shop','','show','member','','hide','qna','','hide')" onMouseOut="document.images[3].src='../img/ｂａｒ３.jpg';"><img name="Image1"  src="../img/ｂａｒ３.jpg" width=95 height=24></a></td>

   <td width=95 height=24><a href="../product/basket_view.jsp?user_id=<%=pid %>" onMouseOver="document.images[4].src='../img/ｂａｒ４.jpg';MM_showHideLayers('shop','','hide','member','','hide','qna','','hide')" onMouseOut="document.images[4].src='../img/ｂａｒ４.jpg';"><img src="../img/ｂａｒ４.jpg" width=95 height=24></a></td>
   
   <td width=95 height=24><a src="../img/ｂａｒ５.jpg" onMouseOver="document.images[5].src='../img/ｂａｒ５.jpg';MM_showHideLayers('shop','','hide','member','','show','qna','','hide')" onMouseOut="document.images[5].src='../img/ｂａｒ５.jpg';"><img name="Image2"  src="../img/ｂａｒ５.jpg" width=95 height=24></a></td>  
 
 	<td width=95 height=24><a href="../member/user.jsp" onMouseOver="document.images[6].src='../img/ｂａｒ６.jpg';MM_showHideLayers('shop','','hide','member','','hide','qna','','hide');" onMouseOut="document.images[6].src='../img/ｂａｒ６.jpg';">
   <img src="../img/ｂａｒ６.jpg" width=95 height=24></a></td>

	<td width=95 height=24> <a src="../img/ｂａｒ７.jpg"  onMouseOver="document.images[7].src='../img/ｂａｒ７.jpg';MM_showHideLayers('shop','','hide','member','','hide','qna','','show')" onMouseOut="document.images[7].src='../img/ｂａｒ７.jpg';"><img name="Image3"  src="../img/ｂａｒ７.jpg" width=114 height=24></a></td>

	<td width=30 height=24 border=0></td>




</tbody>
</table>
</div>

<div id="shop" align="center" style="position:absolute; left:390px;  width:100px; height:20px; z-index:100; visibility: hidden" class="layerstyle"> 
  <table width=230 border=0 cellspacing=0 cellpadding=0 height=20>    
	<tr bgcolor="#EAEAEA"> 
      <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center> &nbsp;<span class="layerstyle"><a href="../shoppingmall/gongi.jsp">공지사항</a></span> </div>
      </td>
      <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center><span class="layerstyle"><a href="../shoppingmall/newproduct.jsp">신상품 코너</a></span> </div>
      </td>
      <td width=140 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center><span class="layerstyle"><a href="../shoppingmall/pc_calculation.jsp">조립 PC 견적</a></span> </div>
      </td>
    </tr>
  </table>
</div>

<div id="member" align="center" style="position:absolute; left:650px; middle:200px; width:160px; height:20px; z-index:100; visibility: hidden"> 
  <table width=230 border=0 cellspacing=1 cellpadding=0 height=20>
    <tr bgcolor="#EAEAEA"> 
      <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center class="layerstyle"><a href="../member/modify.jsp?user_id=<%= pid %>">회원정보수정</a></div>
      </td>
      <td width=80 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center class="layerstyle"><a href="../member/user_delete.jsp?user_id=<%= pid %>">회원 탈퇴</a></div>
      </td>
    </tr>
  </table>
</div>

<div id="qna" align="center" style="position:absolute; left:910px; midle:200px; width:100px; height:20px; z-index:100; visibility: hidden"> 
  <table width=230 border=0 cellspacing=1 cellpadding=0 height=20>
    <tr bgcolor="#EAEAEA">        
      <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
	<div align=center><span class="layerstyle"><a href="../board/board_list.jsp">자유게시판</a></span> </div>
      </td>
        <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
	<div align=center><span class="layerstyle"><a href="../board/board_list2.jsp">상품등록</a></span> </div>
      </td>
         <td width=120 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
	<div align=center><span class="layerstyle"><a href="../board/Boarde_list.jsp">상품문의</a></span> </div>
      <td width=80 onMouseOver="this.style.backgroundColor='#cdcdcd'" onMouseOut="this.style.backgroundColor=''"> 
        <div align=center class="layerstyle"><a href="../service/inform_01.jsp">F A Q</a></div>
      </td>
    </tr>
   
  </table>
</div>


