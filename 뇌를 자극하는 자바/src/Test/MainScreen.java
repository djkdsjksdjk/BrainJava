package Test;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import chap19.ContentPaneEx;

import java.awt.*;

public class MainScreen extends JFrame {
	public MainScreen(Container panel) {
		
		
		setTitle("코세아 학생 시스템");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.BLUE);
		contentPane.setLayout(new FlowLayout());

		JButton button1 = new JButton("일정표");
		JButton button2 = new JButton("성적계산");
		
		panel.add(button1);
		panel.add(button2);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		

		setSize(500, 250);
		setVisible(true);
}
		
	public static void main(String[] args) {
		new MainScreen();


		
}
}


