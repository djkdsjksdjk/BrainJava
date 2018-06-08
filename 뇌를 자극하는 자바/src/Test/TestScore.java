package Test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TestScore {
	public static void main(String[] args, Container contentPane) {
	
	JFrame frame = new JFrame("성적 계산기");
	frame.setLocation(500, 400);
	
	
	Container contentpane = frame.getContentPane();
	String colName[] = {"과목", "학점", "평점"};
	
	FlowLayout layout = new FlowLayout();
	contentPane.setLayout(layout);
	
	JTextField text1 = new JTextField(20);
	JTextField text2 = new JTextField(10);
	
	JButton okBtn     = new JButton("계산");
	okBtn.addActionListener(new TestScore_Listener(Text1, Text2));
	
	contentpane.add(text1);
    contentpane.add(Text2);
    contentpane.add(okBtn);
    
	
	
	
}
	

}
