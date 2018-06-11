package Test;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestScore2 {

	public static void main(String[] args, Container panel) {
		JFrame frame = new JFrame("학점 평균 계산 프로그램");
		frame.setLocation(500, 400);
		
		Container contentpane = frame.getContentPane();
		String colName[] = {"과목", "학점", "평점"};
		String score[] = {"선택", "A+", "A0", "B+", "B0",
		          "C+", "C0", "D+","D0","F"};
		
		FlowLayout layout = new FlowLayout();
		contentpane.setLayout(layout);
		
		JTextField text1 =  new  JTextField(20);
		JTextField text2 =  new  JTextField(10);
		JComboBox<String>scoreCombox = new JComboBox<String>(score);
		
		JTextField text3 =  new  JTextField(20);
		JTextField text4 =  new  JTextField(10);
		JComboBox<String>scoreCombox2 = new JComboBox<String>(score);
		
		JTextField text5 =  new  JTextField(20);
		JTextField text6 =  new  JTextField(10);
		JComboBox<String>scoreCombox3 = new JComboBox<String>(score);
		
		JTextField text7 =  new  JTextField(20);
		JTextField text8 =  new  JTextField(10);
		JComboBox<String>scoreCombox4 = new JComboBox<String>(score);
		
		JTextField text9 =  new  JTextField(20);
		JTextField text10 =  new  JTextField(10);
		JComboBox<String>scoreCombox5 = new JComboBox<String>(score);
		
		panel.add(new JLabel("과목"));
		contentpane.add (text1);
		panel.add(new JLabel("학점"));
		contentpane.add (text2);
		panel.add(new JLabel("과목"));
		contentpane.add (text3);
		panel.add(new JLabel("학점"));
		contentpane.add (text4);
		panel.add(new JLabel("과목"));
		contentpane.add (text5);
		panel.add(new JLabel("학점"));
		contentpane.add (text6);
		panel.add(new JLabel("과목"));
		contentpane.add (text7);
		panel.add(new JLabel("학점"));
		contentpane.add (text8);
		panel.add(new JLabel("과목"));
		contentpane.add (text9);
		panel.add(new JLabel("학점"));
		contentpane.add (text10);
		
	}

}
