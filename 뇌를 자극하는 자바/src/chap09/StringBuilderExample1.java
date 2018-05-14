package chap09;

public class StringBuilderExample1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("역사를 하노라고 맨땅을 파다가 ");
		//StringBuilder sb = new StringBuilder("역사를");
		
		sb.ensureCapacity(50);
		
		System.out.println(sb.capacity());
		
		
		System.out.println(sb);
		System.out.println(sb.append("커다란 고인돌을 끄집어 내어놓고 보니"));
		
		System.out.println(sb.capacity());
		
		System.out.println(sb.insert(26, "하나 "));
		System.out.println(sb.delete(21, 23));//21번째 인덱스부터 23번째 인덱스 -1까지
		System.out.println(sb.deleteCharAt(9));
		
		System.out.println(sb.capacity());
		
		sb.replace(20, 21, "고인돌");
		System.out.println(sb);
		
		sb.trimToSize();
		System.out.println(sb.capacity());
	}

}
