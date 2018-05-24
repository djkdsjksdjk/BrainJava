package chap19;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WindowExample4 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fruit Basket Program");
		frame.setLocation(500,  400);
		Color color = new Color(0, 0, 0);
		frame.getContentPane().setBackground(color);
		
		
		Container contentPane = frame.getContentPane();
		FlowLayout layout = new FlowLayout()
;
		contentPane.setLayout(layout);
		contentPane.add(new JButton("사과"));
		contentPane.add(new JButton("파인애플"));
		contentPane.add(new JButton("오렌지"));
		contentPane.add(new JButton("포도"));
		contentPane.add(new JButton("레몬"));
		contentPane.add(new JButton("복숭아"));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//화면 전중앙 배치

	}

}
