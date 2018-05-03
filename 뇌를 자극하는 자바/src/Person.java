
public class Person {

	String name;
	int age;
	
	//매개변수 없는 생성자
	
	public Person() {
		

	}
	//매개변수 1개있는 생성자
	public Person(String name) {
		this.name = name;
	}
   //매개변수 2개있는 생성자
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		System.out.println("person(int age, String name)매개변수 2개있는 생성자 호출");
	}
	
	public void showPerson() {
		System.out.println("이름:" + name + "나이:" + age);
	}
	public void showPerson(Person obj) {
		System.out.println("showPerson(Person obj)메소드 호출");
		System.out.println("이름은 : " + obj.name);
		System.out.println("나이는 : " + obj.age + "입니다.");
		
		obj.name = "김철수 ";
		obj.age = 10;
	}
}
