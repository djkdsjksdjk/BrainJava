<%@ page contentType="text/html;charset=UTF-8" 
         import="java.sql.*,oracle.dbpool.*"  %>
<%@ page import="org.apache.log4j.*" %>
<%@ page import="myutil.Multipart, java.util.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%! 
	static Logger logger = Logger.getLogger("write_form2.jsp"); 
%>

<%
	String member = (String)session.getAttribute("pid"); 
    
    try{
    	ArrayList<HashMap<String, String>> listOfMap =
    			new ArrayList<HashMap<String, String>>();
    			HashMap<String, String>map;
    			
    			String sql = "SELECT id, name FROM category ORDER BY ID ASC";
    			String keyId, valueCategory;
    			
    			DBConnectionManager pool = DBConnectionManager.getInstance();
    			Connection con = pool.getConnection("ora8");
    			Statement stmt = con.createStatement();
    			ResultSet rs = stmt.executeQuery(sql);
    			
    			while(rs.next()){
    				keyId = String.valueOf(rs.getInt("ID"));
    				valueCategory = rs.getString("NAME");
    				logger.info(keyId + "-" + valueCategory);
    				
    				map = new HashMap<String, String>();
    				map.put(keyId, valueCategory);
    				
    				listOfMap.add(map);
    				
    			}
    			request.setAttribute("listOfMap", listOfMap);
    }catch(Exception e){
    	out.println(e);
    }
    

%>


	<html>
	<head><title>컴퓨터전문쇼핑몰</title>
		<LINK href="../common/u3.css" type=text/css rel=STYLESHEET>
	
	<script>
	function writeCheck() {
		
		if(!document.bbs_form.price.value){
			alert("가격을 입력하세요.");
			document.bbs_form.price.focus();
			return ;
		}
		
		document.bbs_form.submit();
	}
	</script>
	</head>

<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>
    <jsp:include page="../common/basic_screen.jsp" flush="true"/>

<br>
<form name=bbs_form method="post" action="write2.jsp" enctype="multipart/form-data">
	  <table border=1 width=550 height=30 bordercolor=black>
		<tr>
			<td align=center bgcolor=#E68D8D><font size=3 color=#FFFFFF><b>상품 등록</b></td>
		</tr>
	  </table>
	  <br>
<table width=550 border=1>
	<tr>
	   <td width=100 align=center bgcolor="#E68D8D">카테고리</td>
	   <td width=170>&nbsp;
	   			<select name="category">
						<c:forEach items="${listOfMap}" var="maps">
						<c:forEach items="${maps}" var="mapItem">
			       <option value="${mapItem.key}">${mapItem.value}</option>
		       </c:forEach>
		       </c:forEach>
  				</select> </td> 
  				
  
   			
	   <td width=100 align=center bgcolor="#E68D8D">판매가격</td>
	   <td width=170>&nbsp;<input type="text" name="price" size=15 value=""></td>
	</tr>	
	<tr>
	   <td width=100 align=center bgcolor="#E68D8D">판매자ID</td>
	   <td width=170>&nbsp;<input type="text" name="code" size=20 value="<%=member%>" readonly="readonly"></td>
	   <td width=100 align=center bgcolor="#E68D8D">비밀번호</td>
	   <td width=170>&nbsp;<input type="password" name="pwd" size=15 value=""></td>
	</tr>	
	<tr>
	   <td width=100 align=center bgcolor="#E68D8D">연락처</td>
	   <td width=170>&nbsp;<input type="text" name="" size=20></td>
	   <td width=100 align=center bgcolor="#E68D8D">제조사</td>
	   <td width=170>&nbsp;<input type="text" name="company_id" size=15 value=""></td>
	</tr>
	<tr>
		<td width=100 align=center bgcolor="#E68D8D">파일첨부</td>
		<td  colspan=3>&nbsp;<input type="file" name="upload_file"></td>
	</tr>	
	<tr>
	   <td align=center bgcolor="#E68D8D">상품명</td>
	   <td colspan=3>&nbsp;<input type="text" name="name" size=40></td>
	</tr>	
	   <td align=center bgcolor="#E68D8D">상품정보</td>
	   <td colspan=3>
   <table>
      <tr>
         <td><textarea cols=60 rows=15 name="expression"></textarea></td>
      </tr>
   </table>
	  <tr>
	   	<td colspan=4 align=right height=25>
		  <a href="javascript:writeCheck()"><img src="img/b_save.gif" border=0></a>
		  <a href="javascript:history.go(-1)"><img src="img/b_cancel.gif" border=0></a>
	   	</td>
	  </TR>

</TABLE>
</form>

			<jsp:include page="../common/basic_copyright.jsp" flush="true"/>
	</body>
	</html>
