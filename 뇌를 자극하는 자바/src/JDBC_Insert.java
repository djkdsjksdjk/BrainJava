//패키지
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {

	public static void main(String[] args) {
		//1단계 : DB 연결을 위한 커넥션  인터페이스
		 Connection conn = null;
		 Statement stmt = null;
		 
		 //try ~ catch문에서 DB연결중에 예외가 발생하는지를 검사
	        try {
	        	//2단계 : JDBC드라이버를 로드한다.
	            Class.forName("com.mysql.jdbc.Driver");
	            //3단계 : 드라이버 매니져 클래스는 getConnection 메소드로 DB를 연결한다.
	            conn = DriverManager.getConnection(
	            		//URL주소
	               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
	            System.out.println("데이터베이스에 접속했습니다.");
	            
	            //DB SQL 작업
	            stmt = conn.createStatement();
	            String sql = "INSERT INTO Person (Jumincd, Pname, Gender, age)" + 
	            "values('7706301869653', '을지문덕3' , 'm', 42) ";
	            		int chageRecord = stmt.executeUpdate(sql);
	            
	            
	            
	            
	            //4단계 : DB연결을 종료한다.
	            conn.close();
	            System.out.println(chageRecord + "건이 수정되었습니다.");
	        }
	        catch (ClassNotFoundException cnfe) {
	            System.out.println("해당 클래스를 찾을 수 없습니다." + 
	                               cnfe.getMessage());
	        }
	        catch (SQLException se) {
	            System.out.println(se.getMessage());
	        }
	    }
	
		

	}


