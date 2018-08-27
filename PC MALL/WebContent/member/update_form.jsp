<%@ page contentType="text/html;charset=utf-8" 
         import="java.sql.*,oracle.dbpool.*"
         errorPage="error.jsp" %>
<%          
	String m_uid = session.getAttribute("pid").toString();
  
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");

	String m_name, m_ssn, m_pwd, m_zip, m_address;
	String m_phone, m_email, m_job;

	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select m_name, m_ssn, m_pwd, m_zip, m_address, m_phone, m_email, NVL(m_job,0) from mber where m_uid='"+ m_uid +"'");

		if(rs.next()) {
			m_name    = rs.getString(1);
			m_ssn     = rs.getString(2);	
			m_pwd     = rs.getString(3);	
			m_zip     = rs.getString(4);
			m_address = rs.getString(5);	
			m_phone   = rs.getString(6);	
			m_email   = rs.getString(7);	
			m_job     = rs.getString(8);
%>

<HTML>
	<HEAD>
		<TITLE>회원정보수정화면</TITLE>
   
	<script language="JavaScript">
		function checkInput() {
		 	if(document.mform.pwd.value == "") {
				alert("비밀번호를 입력하세요");
				return;
			}
		
		 	document.mform.submit();
		}   
	</script>
		</HEAD>

<BODY bgcolor="#E0EEE0">
<center><br>
<form name=mform method=post action="update.jsp" >
	<table cellpadding=3 cellspacing=0 border=1 width=550 align=center>       
		<tr bgcolor=#7aaad5 height=30>
			<td align=center bgcolor="#0000FF" colspan=2><font color="#ffffff"><b>회원정보 수정&nbsp;</b></font></td>
		</tr>
		<tr>
			<td  bgcolor=#eff4f8>&nbsp;회원 성명</td>
			<td bgcolor=white><input type=text name="name" size=20 maxlength=20 value="<%=m_name%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;주민등록번호</td>
			<td bgcolor=white><input type=text name=ssn size=13 maxlength=13 value="<%=m_ssn%>"readonly></td>
			</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;회원 id</td>
			<td bgcolor=white><input type=text name=uid size=12 maxlength=16 value="<%=m_uid%>" readonly style="width:120"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
				<td bgcolor=white><input type=password name=pwd size=8 maxlength=12 style="width:80" value="<%=m_pwd%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
			<td bgcolor=white><input type=password name=repwd size=8 maxlength=12 value="<%=m_pwd%>" style="width:80">&nbsp;비밀번호를 한번 더 입력해 주세요. </td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;우편번호<font color=red>&nbsp;*</font></td>
			<td bgcolor=white colspan=2><input type=text name=zip size=7 maxlength=7 value="<%=m_zip==null?"":m_zip%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;주소<font color=red>&nbsp;*</font></td>
			<td bgcolor=white><input type=text name=addr size=50 maxlength=100 value="<%=m_address==null?"":m_address%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
			<td bgcolor=white><input type=text name=tel size=12 maxlength=12 value="<%=m_phone%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;e-mail<font color=red>&nbsp;*</font></td>
			<td bgcolor=white valign=middle><input type=text name=email size=30 maxlength=30 value="<%=m_email%>"></td>
		</tr>
		<tr>
			<td bgcolor="#eff4f8">&nbsp;직업<font color=red>&nbsp;*</font></td>
			<td bgcolor=white>
			  <select name=job class="formbox">
				<option value="0"       <% if(m_job.equals("0"))    { %> selected <%}%>> 선택하세요 ---
				<option value="학생"    <% if(m_job.equals("학생"))  { %>selected<%}%>>학생
				<option value="교원"    <% if(m_job.equals("교원"))  { %>selected<%}%>>교원
				<option value="회사원"  <% if(m_job.equals("회사원")){ %>selected<%}%>>회사원
				<option value="공무원"  <% if(m_job.equals("공무원")){ %>selected<%}%>>공무원
				<option value="의료인"  <% if(m_job.equals("의료인")){ %>selected<%}%>>의료인
 				<option value="법조인"  <% if(m_job.equals("법조인")){ %>selected<%}%>>법조인
				<option value="주부"    <% if(m_job.equals("주부"))  { %>selected<%}%>>주부
				<option value="기타"    <% if(m_job.equals("기타"))  { %>selected<%}%>>기타
	 		  </select>
			</td>
		</tr>
		<tr bgcolor=#ffffff>
			<td colspan=4>&nbsp;<font color=red>*</font> 표시만 수정할 수 있습니다&nbsp;&nbsp;
				<input type="button" name="modify" value="수 정" OnClick="checkInput()"></td>
		</tr>
	</table> 
</form>

<% 
	} 
	rs.close();
	stmt.close();
	pool.freeConnection("ora8", con); 
	} catch (Exception e)	{
		pool.freeConnection("ora8", con); 
	}
%>	
</BODY>
</HTML>    