import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		Jumincd = jumincd;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}


public class JDBC_Person {
	
public static void main(String[] args) {
	
	Person[] persons = new Person[3]; //배열 객체
	for(int i = 0; i < persons.length; i++) {
	   persons[i] =new Person(); //생성자 호출하여 배열 레퍼런스 대입
	}
	
	
	/*for(int i = 0; i < persons.length; i++) {
		System.out.println("주민번호: " + persons[i].getJumincd());
		System.out.println("이름: " +  persons[i].getPname());
		System.out.println("성별: " +  persons[i].getGender());
		System.out.println("나이: " +  persons[i].getAge());
		
	}*/
	
	
//	Person person; // 레퍼런스 변수 선언
//	person = new Person();      //객체생성 - new  연산자(생성자) 이용
	
	//person 객체에 멤버필드를 셋팅
	/*person.setJumincd("800511-1574310");
	person.setPname("홍길동");
	person.setGender("man");
	person.setAge(20);*/
	
	/*int age = person.getAge();
	System.out.println(age);

	System.out.println(person.getAge());*/
	
	/*System.out.println(person.Jumincd);
	System.out.println(person.Pname);
	System.out.println(person.Gender);
	System.out.println(person.age);*/
	
	// 한줄 Person person = new Person();
	
	
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
	            		//URL주소
	               "jdbc:mysql://localhost:3306/mysql", "root", "12345");
	            System.out.println("데이터베이스에 접속했습니다.");
	            
	            //커넥션 객체가 Statement 객체를 생성
	            stmt = conn.createStatement();
	            
	            //DML SQL 쿼리 실행 후 결과를 저장
	            rs = stmt.executeQuery("select Jumincd, Pname, Gender, age from Person");
	            
	            System.out.println("     주민번호           이름   성별  나이");
	            int i = 0;
	           while(rs.next()) {
	            
	        	  persons[i].setJumincd(rs.getString(1));
	        	  persons[i].setPname(rs.getString(2));
	        	  persons[i].setGender(rs.getString(3));
	        	  persons[i].setAge(rs.getInt(4));
	        	  
	        	  i++;
	        	   
	            /*Jumincd = rs.getString(1); //rs.getString("Jumincd");
	            Pname = rs.getString(2); //rs.getString("Pname"); 
	            Gender = rs.getString(3); //rs.getString("Gender");
	            age = rs.getInt(4);//rs.getInt("age");
*/	            
	            //System.out.println(Jumincd+ "---" + Pname + "---"+ Gender + "---" + age);
	           }
	            //4단계 : DB연결을 종료한다.
	            conn.close();
	            System.out.println("=================================");
	            for(i = 0; i < persons.length; i++) {
	            	System.out.println("주민번호: " + persons[i].getJumincd());
	        		System.out.println("이름: " +  persons[i].getPname());
	        		System.out.println("성별: " +  persons[i].getGender());
	        		System.out.println("나이: " +  persons[i].getAge());
	        		System.out.println("=================================");
	            	
	            	
	            }
	            
	           // System.out.println(Jumincd+ "---" + Pname + "---"+ Gender + "---" + age);
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



