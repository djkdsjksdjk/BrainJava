package com.kosea.kmove30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	//Insert
	//query - "INSERT INTO Person(PName, Gender, age)values('이민희', 'f', 21)";
	public void insertTable(String[] arr) throws Exception {
		String name = arr[0];
		String age = arr[1];
		String Gender = arr[2];
		
		String query = "INSERT INTO Person(PName, age, Gender)values"
				+ "('" + name + "'," + age + ",'" + Gender + "'"+")";
		System.out.println("query - " + query);
		stmt = conn.createStatement();
		int insertCount = stmt.executeUpdate(query);
		
		if (insertCount > 0)
			System.out.println(insertCount + "건이 삽입 되었습니다.");
	}
	
	//query -"UPDATE person set age = 42 WHERE '이순신'";
	public void updateTable(String name, String age) throws Exception {
		String query = "UPDATE person set age = " + age + 
				" WHERE PName = '" + name + "'";
		System.out.println("query - " + query);
		stmt = conn.createStatement();
		int updateCount  = stmt.executeUpdate(query);
		
		if(updateCount > 0)
			System.out.println(updateCount + "건이 수정 되었습니다.");
		
	}
	
	
	
	
	
	
	
	//query - "delete from person where nName = '홍길동'";
	public void deleteTable(String deleteName)throws Exception {
		
		String query = "delete from person where Pname = '" + deleteName + "'";
		stmt = conn.createStatement();
		int deleteCount  = stmt.executeUpdate(query);
		
		if(deleteCount > 0)
		System.out.println(deleteCount + "건이 삭제 되었습니다.");
		
		
		
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