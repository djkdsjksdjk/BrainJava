package chap06;

public interface Colorable {
	void setForeground(String color);
	void setBackground(String color);

}

interface Changeable extends Resizable, Colorable{
	void setFont(String font);
}
