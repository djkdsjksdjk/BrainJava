package com.kosea.kmove30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import javax.management.Query;

import com.mysql.jdbc.Driver;

public class JDBC_Manager {
	
	//////////속성(필드)
	//1단계 : DB 연결을 위한 커넥션  인터페이스
	 Connection conn = null;
	//Statement 인터페이스 - SQL 실행.
	 Statement stmt = null;
	//ResultSet 인터페이스 - SQL 결과를 저장
	 ResultSet rs = null;
	 
	 //생성자
	public JDBC_Manager(Connection conn, Statement stmt, ResultSet rs) {
		super();
		this.conn = conn;
		this.stmt = stmt;
		this.rs = rs;
	}
	 
	 public JDBC_Manager() {
		System.out.println("JDBC_Manager() 기본 생성자 호출");
	 }
	 
	///////////////기능(메소드)//////////////////
	//DB연결
	public Connection DBConnection(String driver, String url, String user, String pass) throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");//JDBC드라이버 로드
		Class.forName(driver);
        
		conn = DriverManager.getConnection(url,user,pass);
           
        return conn;
	}
	 
	//select
	//query - "select Pname, age, Gender from person
	public ResultSet selectTable(String query) throws Exception {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		return rs;
		
	}
	//query - "delete from person where nName = '홍길동'";
	public void deleteTable(String deleteName)throws Exception {
		
		String query = "delete from person where Pname = '" + deleteName + "'";
		stmt = conn.createStatement();
		int deleteCount  = stmt.executeUpdate(query);
		
		if(deleteCount > 0)
		System.out.println(deleteCount + "건이 삭제 되었습니다.");
		
		if(deleteCount > 0)
			System.out.println(deleteCount + "건이 추가 되었습니다.");
		
		
		/*//DB SQL 작업
        stmt = conn.createStatement();
        String sql = "delete from Person where Pname ='" +  args[0] + "'"; //이순신'
        //delete from Person where Pname ='이순신' ;
        		int chageRecord = stmt.executeUpdate(sql);*/
	}
	
	//DB연결해제

public void DBClose() throws Exception {
	conn.close();
}
}