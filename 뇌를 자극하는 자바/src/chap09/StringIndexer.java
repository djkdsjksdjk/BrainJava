package chap09;



public class StringIndexer {

	public static void main(String[] args) {
		
		String str1 = "Java Programing";
		int index = str1.indexOf("a", 4);
		
		if(index < 0 )
			System.out.println("검색 결과가 없습니다.");
		else
		System.out.println(index + "인덱스에 위치하고 있습니다.");
		

	}

}
