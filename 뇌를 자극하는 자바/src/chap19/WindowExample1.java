/**
 * 2018. 5. 23. Dev By Lee.M.H
   뇌를 자극하는 자바
   WindowExample1.java
 */
package chap19;

import java.awt.Container;
import java.awt.Dimension;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

/**
 * @author kosea102
 *
 */
public class WindowExample1 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Hello Java Program");
		//frame.setLocation(500, 400);
		
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setLocation((dim.width/2)-(frame.getWidth()/2), (dim.height/2)-(frame.getHeight()/2));
		
		frame.setPreferredSize(new Dimension(300, 200));
		Container contentPane = frame.getContentPane();
		
		JLabel lable = new JLabel("Hello, Java", SwingConstants.CENTER);
		contentPane.add(lable);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//화면 전중앙 배치
	}

}
