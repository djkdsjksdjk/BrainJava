package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestScore_Listener implements ActionListener {

	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, 
	           text10, text11, text12, text13, text14, text15, text16;
  /*  JComboBox<String> scoreCombox,scoreCombox2,scoreCombox3,
                      scoreCombox4,scoreCombox5, scoreCombox6, scoreCombox7;*/
	
    
	public TestScore_Listener(JTextField text2, JTextField text4, JTextField text6, JTextField text8, JTextField text10,
			JTextField text12, JTextField text14, JTextField text15
			/*JComboBox<String> scoreCombox, JComboBox<String> scoreCombox2, JComboBox<String> scoreCombox3,
			JComboBox<String> scoreCombox4, JComboBox<String> scoreCombox5, JComboBox<String> scoreCombox6, JComboBox<String> scoreCombox7*/) {
		super();
		this.text2 = text2;
		this.text4 = text4;
		this.text6 = text6;
		this.text8 = text8;
		this.text10 = text10;
		this.text12 = text12;
		this.text14 = text14;
		this.text15 = text15;
		
		/*this.scoreCombox = scoreCombox;
		this.scoreCombox2 = scoreCombox2;
		this.scoreCombox3 = scoreCombox3;
		this.scoreCombox4 = scoreCombox4;
		this.scoreCombox5 = scoreCombox5;
		this.scoreCombox6 = scoreCombox6;
		this.scoreCombox7 = scoreCombox7;*/
		
		
	}

	public TestScore_Listener() {
		System.out.println("TestScore_Listener() 기본 생성자 호출");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed 호출");
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("계산")) {

			// 과목 학점 합산

			String strNum1 = text2.getText();
			String strNum2 = text4.getText();
			String strNum3 = text6.getText();
			String strNum4 = text8.getText();
			String strNum5 = text10.getText();
			String strNum6 = text12.getText();
			String strNum7 = text14.getText();

			if (strNum1.equals("")) {
				JOptionPane.showMessageDialog(null, "학점을 입력해 주세요.", "경고 메세지", JOptionPane.WARNING_MESSAGE);
			}
			
			if (strNum7.equals("")) {
				JOptionPane.showMessageDialog(null, "학점을 입력해 주세요.", "경고 메세지", JOptionPane.WARNING_MESSAGE);
			}

			System.out.println(strNum1);
			System.out.println(strNum2);
			System.out.println(strNum3);
			System.out.println(strNum4);
			System.out.println(strNum5);
			System.out.println(strNum6);
			System.out.println(strNum7);
			

			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int num3 = Integer.parseInt(strNum3);
			int num4 = Integer.parseInt(strNum4);
			int num5 = Integer.parseInt(strNum5);
			int num6 = Integer.parseInt(strNum6);
			int num7 = Integer.parseInt(strNum7);
			

			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num4);
			System.out.println(num5);
			System.out.println(num6);
			System.out.println(num7);

			int total = num1 + num2 + num3 + num4 + num5 + num6 + num7;
			
			
			
			/*String strNum8 = scoreCombox.getActionCommand();
			String strNum9 = scoreCombox2.getActionCommand();
			String strNum10 = scoreCombox3.getActionCommand();
			String strNum11 = scoreCombox4.getActionCommand();
			String strNum12 = scoreCombox5.getActionCommand();*/
			
			
			

			System.out.println(total);


			 text15.setText(String.valueOf(total));
			 //text16.setText(String.valueOf(total));

			

		}

	}
}
