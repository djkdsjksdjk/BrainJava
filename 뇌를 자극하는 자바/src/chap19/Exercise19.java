package chap19;


import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Exercise19 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("덧셈 프로그램");
		frame.setLocation(250,  120);
		
		Container contentPane = frame.getContentPane();
		FlowLayout layout = new FlowLayout();
		contentPane.setLayout(layout);
		
		JTextField text1  = new JTextField(5);
		JTextField text2  = new JTextField(5);
		JTextField text3  = new JTextField(5);
		
		JButton okBtn     = new JButton("확인");
		JButton cancelBtn = new JButton("취소");
		
		okBtn.addActionListener(new Excercise19_Listener(text1, text2, text3));
		cancelBtn.addActionListener(new Excercise19_Listener(text1, text2, text3));
		
		contentPane.add(text1);
		contentPane.add(new JLabel("+"));
		contentPane.add(text2);
		contentPane.add(new JLabel("="));
		contentPane.add(text3);
		contentPane.add(okBtn);
		contentPane.add(cancelBtn);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);//화면 전중앙 배치

	}
	

}
