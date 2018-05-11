package geometry;

public class circle {
	
	int radius;
	
	circle(int radius){
		this.radius = radius;
	}
	
	double getArea() {
		return radius *  radius * 3.14;
		
	}

}
