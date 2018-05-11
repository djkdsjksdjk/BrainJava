/**
 * 2018. 5. 11. Dev By Lee.M.H
   뇌를 자극하는 자바
   PackageExample2.java
 */
package math;

//import geometry.polygon.Rectangle;
//import geometry.polygon.*;

/**
 * @author kosea102
 *
 */
public class PackageExample2 {

	
	public static void main(String[] args) {
		
		geometry.polygon.Rectangle rectangle = new geometry.polygon.Rectangle(2, 3);
		System.out.println("넓이:" + rectangle.width);
		System.out.println("높이:" + rectangle.height);
		System.out.println("면적:" + rectangle.getArea());
		

	}

}
