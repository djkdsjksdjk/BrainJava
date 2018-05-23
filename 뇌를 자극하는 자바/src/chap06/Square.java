package chap06;

public class Square extends Rectangle2 {
	Square(int sideLength) {
		super (sideLength, sideLength);
		
	}
	int getsideLength() {
		return(getWidth() + getHeight());
	}
}
