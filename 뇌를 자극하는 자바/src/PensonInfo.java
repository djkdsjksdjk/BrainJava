/**
 * 2018. 5. 3. Dev By Lee.M.H
   뇌를 자극하는 자바
   PensonInfo.java
 */

/**
 * @author kosea102
 *
 */
public class PensonInfo {

	
	public static void main(String[] args) {
		
		
        //클래스 변수
		Person obj;
		//매개변수 없는 디폴트 생성자 호출하여 객체생성
         //person = new Person();
		
		//String 매개변수 1개있는 디폴트 생성자 호출하여 객체생성
		//person = new Person("홍길동", 20);
         
		//String 매개변수 int 매개변수 1개있는 생성자 호출하여 객체생성
       //person = new Person("홍길동", 20);
         
         //int 매개변수 있고 
		obj = new Person(20, "홍길동 ");
        
		//메소드 호출
		obj.showPerson(obj);
		obj.showPerson();
		
		//System.out.println(obj);

	}

}
