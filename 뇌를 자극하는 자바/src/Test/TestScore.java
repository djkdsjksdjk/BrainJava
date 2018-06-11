package Test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public  class  TestScore {
	public  static  void  main ( String [] args , Container  contentPane, Container panel ) {
	
	JFrame frame =  new  JFrame ( "성적계산기" );
	frame.setLocation (500, 400);
	
	
	Container contentpane = frame.getContentPane();
	String colName[] = {"과목", "학점", "평점"};
	Integer[] scoreCuts = new Integer[]
			{95, 90, 85, 80, 75, 70, 65, 60, 0};
	String[] grades = new String[] {"A+", "A0", 
			"B+", "B0", "C+", "C0", "D+", "D0", "F"};
	String score[] = {"선택", "A+", "A0", "B+", "B0",
			          "C+", "C0", "D+","D0","F"};
	
	FlowLayout layout =  new  FlowLayout ();
	contentPane.setLayout (layout);
	
	JTextField text1 =  new  JTextField(20);
	JTextField text2 =  new  JTextField(10);
	JComboBox<String>scoreCombox = new JComboBox<String>(score);
	
	JButton adBtn = new JButton("칸추가");
	
	
	
	contentpane.add (text1);
    contentpane.add (text2);
    contentpane.add (adBtn);
    
    panel.add(new JLabel("과목"));
    panel.add(text1);
    panel.add(new JLabel("학점"));
    panel.add(text2);
    panel.add(new JLabel("평점"));
    panel.add(scoreCombox);
    
    contentPane.add(panel, BorderLayout.NORTH);
    
    JButton okBtn      =  new  JButton ("계산");
	okBtn.addActionListener( new TestScore_Listener ( text1 , text2 ));
    
    
	contentpane.add (okBtn);
	
	String[] labels = new String[] {"학점", "총 평점"};
	
	Object[][] tables = new Object[][] {scoreCuts, grades};
	
	System.out.println("학점 평가를 시작합니다.");
	
	
	
	contentPane.add(panel, BorderLayout.SOUTH);
    
	}
}
