import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Person{
	String Jumincd = null;
	String Pname = null;
	String Gender = null;
	int age = 0;
	
	public Person() //기본생성자
	{
		this.Jumincd = "주민번호 입력 누락";
		this.Pname = "이름 입력 누락";
		this.Gender = "성별 입력 누락";
		this.age = 0;
	}
	
	public String getJumincd() {
		return Jumincd;
	}
	public void setJumincd(String jumincd) {
		this.Jumincd = jumincd;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		this.Pname = pname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}


class JDBC_Person_ArrayList {
	
public static void main(String args[]) {
	
	ArrayList<Person> ListPerson = new ArrayList<Person>();
	
	
	/// JDBC 연결 시작 ///
		
		//1단계 : DB 연결을 위한 커넥션  인터페이스
		 Connection conn = null;
		 //Statement 인터페이스 - SQL 실행.
		 Statement stmt = null;
		 //ResultSet 인터페이스 - SQL 결과를 저장
		 ResultSet rs = null;
		 
		 //try ~ catch문에서 DB연결중에 예외가 발생하는지를 검사
	        try {
//	        	String Jumincd = null;
//	        	String Pname = null;
//	        	String Gender = null;
             	int age = 0;
	        	
	        	//2단계 : JDBC드라이버를 로드한다.
	            Class.forName("com.mysql.jdbc.Driver");
	            //3단계 : 드라이버 매니져 클래스는 getConnection 메소드로 DB를 연결한다.
	            conn = DriverManager.getConnection(
	               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
	            System.out.println("데이터베이스에 접속했습니다.");
	            
	            //커넥션 객체가 Statement 객체를 생성
	            stmt = conn.createStatement();
	            
	            //DML SQL 쿼리 실행 후 결과를 저장
	            rs = stmt.executeQuery("select Jumincd, Pname, Gender, age from Person");
	            
	            System.out.println("     주민번호           이름   성별  나이");
	            
	           while(rs.next()) {
//	        	   Person person;
//	        	   person = new Person();
	        	   Person Person = new Person();
	        	   
	        	   Person.setJumincd(rs.getString(1));
	        	   Person.setPname(rs.getString(2));
	        	   Person.setGender(rs.getString(3)); //person.setGender(rs.getString("Gender));
	        	   Person.setAge(rs.getInt(4));
	        	   
	        	   ListPerson.add(Person);
	       
	           }
	            //4단계 : DB연결을 종료한다.
	            conn.close();
	            System.out.println("=================================");
	            
	            for(int i = 0; i < ListPerson.size(); i++) {
	            	System.out.print(ListPerson.get(i).getJumincd()+ "    ");
	            	System.out.print(ListPerson.get(i).getPname()+ "    ");
	            	System.out.print(ListPerson.get(i).getGender()+ "    ");
	            	System.out.print(ListPerson.get(i).getAge()+ "    ");
	            	System.out.println();
	            }
	            
	            
	        }
	        catch (ClassNotFoundException cnfe) {
	            System.out.println("해당 클래스를 찾을 수 없습니다." + 
	                               cnfe.getMessage());
	        }
	        catch (SQLException se) {
	            System.out.println(se.getMessage());
	            
	            ////JDBC 연결 종료 ////
           }
}
}