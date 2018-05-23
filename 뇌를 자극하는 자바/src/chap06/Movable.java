package chap06;

public interface Movable {
 void moveTo(int x, int y); 
 void moveBy(int xOffset, int yOffset);
 
}
interface Transformable extends Movable{
	void resize (int width, int height);
}

	

