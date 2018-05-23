package chap11;

public class ObjectExample2 {

	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		System.out.println(obj);//obj.toString();
		String str = "재고정보 = " + obj.toString();
		System.out.println(str);

	}

}
