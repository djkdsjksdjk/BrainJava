package GPA_Calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.event.*;

public class GPA_Calculator {
	JFrame frame;
	ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPA_Calculator window = new GPA_Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String route = "C:/temp/file.txt";									// 파일 입출력 경로
	PanelTemplate template[] = new PanelTemplate[4];					// 주형
	JRadioButton grade[] = new JRadioButton[4];							// 라디오버튼
	JPanel panel1_1;													// 1학년 패널
	JPanel panel1_2;													// 2학년 패널
	JPanel panel1_3;													// 3학년 패널
	JPanel panel1_4;													// 4학년 패널
	JTextField finalComplete;											// 총 이수학점
	JTextField finalAverage;											// 평량평균

	GPA_Calculator() {
		frame = new JFrame();
		frame.setResizable(false);										// 사이즈 변경 불가
		frame.setBounds(100, 100, 707, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel1_1 = new JPanel();										// 1학년 패널
		panel1_2 = new JPanel();										// 2학년 패널
		panel1_3 = new JPanel();										// 3학년 패널
		panel1_4 = new JPanel();										// 4학년 패널
		
		for(int i = 0;i < 4; i++) {
			template[i] = new PanelTemplate(i);							// 주형
		}
		
		panel1_1.add(template[0].panel);
		frame.getContentPane().add(panel1_1);
		panel1_1.setBounds(12, 10, 471, 312);
		panel1_1.setLayout(null);
		
		panel1_2.add(template[1].panel);
		frame.getContentPane().add(panel1_2);
		panel1_2.setBounds(12, 10, 471, 312);
		panel1_2.setLayout(null);
		
		panel1_3.add(template[2].panel);
		frame.getContentPane().add(panel1_3);
		panel1_3.setBounds(12, 10, 471, 312);
		panel1_3.setLayout(null);
		
		panel1_4.add(template[3].panel);
		frame.getContentPane().add(panel1_4);
		panel1_4.setBounds(12, 10, 471, 312);
		panel1_4.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(495, 10, 184, 312);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel selectGrade = new JLabel("학년 선택");
		selectGrade.setBounds(12, 10, 160, 22);
		panel2.add(selectGrade);
		
		JPanel panel2_1 = new JPanel();
		panel2_1.setBounds(12, 42, 160, 138);
		panel2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(int i = 0; i < 4; i++) {									// 학년별 라디오버튼
			grade[i] = new JRadioButton(i+1 + "학년");
			buttonGroup.add(grade[i]);
			panel2_1.add(grade[i]);
		}
		
		grade[0].setSelected(true);										// 1학년 자동 선택
		panel2.add(panel2_1);
		
		JPanel panel2_2 = new JPanel();
		panel2_2.setBounds(12, 190, 160, 51);
		panel2.add(panel2_2);
		panel2_2.setLayout(new GridLayout(2, 2, 10, 10));
		
		panel2_2.add(new JLabel("총 이수학점"));							// 총 이수학점
		finalComplete = new JTextField("0");
		finalComplete.setEditable(false);								// 임의 수정 불가
		panel2_2.add(finalComplete);
		finalComplete.setColumns(10);
		
		panel2_2.add(new JLabel("평량평균"));								// 평량학점
		finalAverage = new JTextField("0.00");
		finalAverage.setEditable(false);								// 임의 수정 불가
		panel2_2.add(finalAverage);
		finalAverage.setColumns(10);
		
		JPanel panel2_3 = new JPanel();
		panel2_3.setBounds(45, 251, 98, 51);
		panel2.add(panel2_3);
		panel2_3.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton saveButton = new JButton("Save");						// 저장 버튼
		panel2_3.add(saveButton);
		
		JButton exitButton = new JButton("Exit");						// 종료 버튼
		panel2_3.add(exitButton);
		
		JMenuBar menuBar = new JMenuBar();								// 메뉴바
		frame.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");								// 파일 메뉴
		menuBar.add(menuFile);
		
		JMenuItem menuNew = new JMenuItem("New");						// 초기화
		menuFile.add(menuNew);
		
		JMenuItem menuOpen = new JMenuItem("Open");						// 불러오기
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");						// 저장
		menuFile.add(menuSave);
		
		JMenuItem menuExit = new JMenuItem("Exit");						// 종료
		menuFile.add(menuExit);
		
		SelectGrade selLis = new SelectGrade();							// 라디오버튼 리스너
		for(int i = 0; i < 4; i++) {
			grade[i].addActionListener(selLis);
		}
		
		ButtonFunction butLis = new ButtonFunction();					// 버튼 리스너
		saveButton.addActionListener(butLis);
		exitButton.addActionListener(butLis);
		
		MenuFunction menLis = new MenuFunction();						// 메뉴 리스너
		menuNew.addActionListener(menLis);
		menuOpen.addActionListener(menLis);
		menuSave.addActionListener(menLis);
		menuExit.addActionListener(menLis);
	}
	
	class SelectGrade implements ActionListener {						// 학년별 패널 전환
		@Override
		public void actionPerformed(ActionEvent e) {
			panel1_1.setVisible(false);
			panel1_2.setVisible(false);
			panel1_3.setVisible(false);
			panel1_4.setVisible(false);
			
			if(grade[0].isSelected() == true) {							// 1학년 표시
				panel1_1.setVisible(true);
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				panel1_4.setVisible(false);
			}
			else if(grade[1].isSelected() == true) {					// 2학년 표시
				panel1_1.setVisible(false);
				panel1_2.setVisible(true);
				panel1_3.setVisible(false);
				panel1_4.setVisible(false);
			}
			else if(grade[2].isSelected() == true) {					// 3학년 표시
				panel1_1.setVisible(false);
				panel1_2.setVisible(false);
				panel1_3.setVisible(true);
				panel1_4.setVisible(false);
			}
			else {														// 4학년 표시
				panel1_1.setVisible(false);
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				panel1_4.setVisible(true);
			}
		}
	}
	
	class PanelTemplate {
		JPanel panel = new JPanel();
		
		JTextField className1[] = new JTextField[8];					// 1학기 강의명
		JTextField className2[] = new JTextField[8];					// 2학기 강의명
		JTextField classScore1[] = new JTextField[8];					// 1학기 학점수
		JTextField classScore2[] = new JTextField[8];					// 2학기 학점수
		
		JTextField complete1 = new JTextField("0");						// 1학기 이수학점
		JTextField complete2 = new JTextField("0");						// 2학기 이수학점
		JTextField average1 = new JTextField("0.00");					// 1학기 평균
		JTextField average2 = new JTextField("0.00");					// 2학기 평균
		
		String[] contents = {"선택", "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
		
		@SuppressWarnings("unchecked")
		JComboBox<String[]> classGrade1[] = new JComboBox[8];			// 1학기 학점
		@SuppressWarnings("unchecked")
		JComboBox<String[]> classGrade2[] = new JComboBox[8];			// 2학기 학점
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		PanelTemplate(int i) {											// 학년 입력
			panel.setBounds(0, 0, 471, 312);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();								// 1학기 학년 표시
			JPanel panel_4 = new JPanel();								// 2학기 학년 표시
			
			if(i == 0) {												// 학년 입력
				panel_1.add(new JLabel("1학년 1학기"));
				panel_4.add(new JLabel("1학년 2학기"));
			}
			else if(i == 1) {
				panel_1.add(new JLabel("2학년 1학기"));
				panel_4.add(new JLabel("2학년 2학기"));
			}
			else if(i == 2) {
				panel_1.add(new JLabel("3학년 1학기"));
				panel_4.add(new JLabel("3학년 2학기"));
			}
			else if(i == 3) {
				panel_1.add(new JLabel("4학년 1학기"));
				panel_4.add(new JLabel("4학년 2학기"));
			}
			
			panel_1.setBounds(12, 10, 220, 25);
			panel_4.setBounds(239, 10, 220, 25);
			panel.add(panel_1);
			panel.add(panel_4);
			
			JPanel panel_2 = new JPanel();								// 1학기 입력창
			panel_2.setBounds(12, 45, 220, 224);
			panel.add(panel_2);
			panel_2.setLayout(new GridLayout(9, 1, 0, 0));
			
			JPanel panel_2_1[] = new JPanel[9];
			
			for(int j = 0; j < 9; j++) {
				panel_2_1[j] = new JPanel();
				panel_2_1[j].setLayout(new GridLayout(1, 3, 0, 0));
				
				if(j == 0) {											// 분류
					panel_2_1[j].add(new JLabel("과목명"));
					panel_2_1[j].add(new JLabel("학점수"));
					panel_2_1[j].add(new JLabel("학점"));
				}
				
				panel_2.add(panel_2_1[j]);
			}
			
			for(int j = 0; j < 8; j++) {
				className1[j] = new JTextField();						// 1학기 강의명
				classScore1[j] = new JTextField();						// 1학기 학점수
				classGrade1[j] = new JComboBox(contents);				// 1학기 학점
				
				panel_2_1[j+1].add(className1[j]);
				panel_2_1[j+1].add(classScore1[j]);
				panel_2_1[j+1].add(classGrade1[j]);
				
				classGrade1[j].setEnabled(false);						// 임의 수정 불가
			}
			
			JPanel panel_5 = new JPanel();								// 2학기 입력창
			panel_5.setBounds(239, 45, 220, 224);
			panel.add(panel_5);
			panel_5.setLayout(new GridLayout(9, 1, 0, 0));
			
			JPanel panel_5_1[] = new JPanel[9];
			
			for(int j = 0; j < 9; j++) {
				panel_5_1[j] = new JPanel();
				panel_5_1[j].setLayout(new GridLayout(1, 3, 0, 0));
				
				if(j == 0) {											// 분류
					panel_5_1[j].add(new JLabel("과목명"));
					panel_5_1[j].add(new JLabel("학점수"));
					panel_5_1[j].add(new JLabel("학점"));
				}
				
				panel_5.add(panel_5_1[j]);
			}
			
			for(int j = 0; j < 8; j++) {
				className2[j] = new JTextField();						// 2학기 강의명
				classScore2[j] = new JTextField();						// 2학기 학점수
				classGrade2[j] = new JComboBox(contents);				// 2학기 학점
				
				panel_5_1[j+1].add(className2[j]);
				panel_5_1[j+1].add(classScore2[j]);
				panel_5_1[j+1].add(classGrade2[j]);
				
				classGrade2[j].setEnabled(false);						// 임의 수정 불가
			}
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(12, 277, 220, 25);
			panel.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 4, 0, 0));
			
			panel_3.add(new JLabel("이수학점"));
			panel_3.add(complete1);										// 1학기 이수학점
			complete1.setEditable(false);								// 임의 수정 불가
			
			panel_3.add(new JLabel("평균학점"));
			panel_3.add(average1);										// 1학기 평균학점
			average1.setEditable(false);								// 임의 수정 불가
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(239, 277, 220, 25);
			panel.add(panel_6);
			panel_6.setLayout(new GridLayout(0, 4, 0, 0));
			
			panel_6.add(new JLabel("이수학점"));
			panel_6.add(complete2);										// 2학기 이수학점
			complete2.setEditable(false);								// 임의 수정 불가
			
			panel_6.add(new JLabel("평균학점"));
			panel_6.add(average2);										// 2학기 평균학점
			average2.setEditable(false);								// 임의 수정 불가
			
			Calcultate calLis = new Calcultate();
			
			for(int j = 0; j < 8; j++) {
				classScore1[j].getDocument().addDocumentListener(calLis);
				classScore2[j].getDocument().addDocumentListener(calLis);
				
				classScore1[j].getDocument().addDocumentListener(calLis);
				classScore2[j].getDocument().addDocumentListener(calLis);
				
				classGrade1[j].addItemListener(calLis);
				classGrade2[j].addItemListener(calLis);
			}
		}
		
		class Calcultate implements DocumentListener, ItemListener {
			public void calculateComplete() {
				double sum1 = 0;										// 1학기
				double sum2 = 0;										// 2학기
				
				for(int i = 0; i < 8; i++) {
					if(classScore1[i].getText().length() > 0) {			// 학점수 입력시 학점 활성화
						classGrade1[i].setEnabled(true);
					}
					
					if(classScore2[i].getText().length() > 0) {			// 학점수 입력시 학점 활성화
						classGrade2[i].setEnabled(true);
					}
				}
				
				for(JTextField file1 : classScore1) {
					String str = file1.getText();
					
					try {
						sum1 += Double.parseDouble(str);				// 학점수에 입력된 값을 모두 sum1에 더함
					} catch (NumberFormatException e) {}				// 입력 값이 없으면 무시
					
					complete1.setText(String.format("%.0f", sum1));		// 소수점 아래 0번째 자리까지 sum1을 1학기 이수학점에 출력
				}
				
				for(JTextField file2 : classScore2) {
					String str = file2.getText();
					
					try {
						sum2 += Double.parseDouble(str);				// 학점수에 입력된 값을 모두 sum2에 더함
					} catch (NumberFormatException e) {}				// 입력 값이 없으면 무시
					
					complete2.setText(String.format("%.0f", sum2));		// 소수점 아래 0번째 자리까지 sum2을 2학기 이수학점에 출력
				}
				
				@SuppressWarnings("unused")
				FinalCalculate fc = new FinalCalculate();				// 총 이수학점, 평량평균 계산
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				calculateComplete();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				calculateComplete();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				calculateComplete();
				
				for(int i = 0; i < 8; i++) {
					if(classScore1[i].getText().length() == 0) {		// 학점수 미입력시 학점 활성화
						classGrade1[i].setSelectedIndex(0);
						classGrade1[i].setEnabled(false);
					}
					
					if(classScore2[i].getText().length() == 0) {		// 학점수 미입력시 학점 활성화
						classGrade2[i].setSelectedIndex(0);
						classGrade2[i].setEnabled(false);
					}
				}
				
				int count = check();
				
				if(count == 192) {										// 평량평균 NaN
					finalAverage.setText("0.00");
				}
			}
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				double num1 = 0;										// 1학기 학점수 * 학점의 총합
				double num2 = 0;										// 2학기 학점수 * 학점의 총합
				double dividend1 = 0;									// 1학기 이수학점
				double dividend2 = 0;									// 2학기 이수학점
				
				for(int i = 0; i < 8; i++) {
					if(classGrade1[i].getSelectedIndex() == 0) {}
					else {
						dividend1 += Double.parseDouble(classScore1[i].getText());
					}
					
					if(classGrade2[i].getSelectedIndex() == 0) {}
					else {
						dividend2 += Double.parseDouble(classScore2[i].getText());
					}
				}
				
				for(int i = 0; i < 8; i++) {
					if(classScore1[i].getText().equals("")) {}
					else {
						if(classGrade1[i].getSelectedIndex() == 0) {		// 선택
							num1 += 0;
						}
						else if(classGrade1[i].getSelectedIndex() == 1) {	// A+
							num1 += Double.parseDouble(classScore1[i].getText()) * 4.5;
						}
						else if(classGrade1[i].getSelectedIndex() == 2) {	// A
							num1 += Double.parseDouble(classScore1[i].getText()) * 4;
						}
						else if(classGrade1[i].getSelectedIndex() == 3) {	// B+
							num1 += Double.parseDouble(classScore1[i].getText()) * 3.5;
						}
						else if(classGrade1[i].getSelectedIndex() == 4) {	// B
							num1 += Double.parseDouble(classScore1[i].getText()) * 3;
						}
						else if(classGrade1[i].getSelectedIndex() == 5) {	// C+
							num1 += Double.parseDouble(classScore1[i].getText()) * 2.5;
						}
						else if(classGrade1[i].getSelectedIndex() == 6) {	// C
							num1 += Double.parseDouble(classScore1[i].getText()) * 2;
						}
						else if(classGrade1[i].getSelectedIndex() == 7) {	// D+
							num1 += Double.parseDouble(classScore1[i].getText()) * 1.5;
						}
						else if(classGrade1[i].getSelectedIndex() == 8) {	// D
							num1 += Double.parseDouble(classScore1[i].getText()) * 1;
						}
						else if(classGrade1[i].getSelectedIndex() == 9) {	// F
							num1 += 0;
						}
					}
					
					if(classScore2[i].getText().equals("")) {}
					else {
						if(classGrade2[i].getSelectedIndex() == 0) {		// 선택
							num2 += 0;
						}
						else if(classGrade2[i].getSelectedIndex() == 1) {	// A+
							num2 += Double.parseDouble(classScore2[i].getText()) * 4.5;
						}
						else if(classGrade2[i].getSelectedIndex() == 2) {	// A
							num2 += Double.parseDouble(classScore2[i].getText()) * 4;
						}
						else if(classGrade2[i].getSelectedIndex() == 3) {	// B+
							num2 += Double.parseDouble(classScore2[i].getText()) * 3.5;
						}
						else if(classGrade2[i].getSelectedIndex() == 4) {	// B
							num2 += Double.parseDouble(classScore2[i].getText()) * 3;
						}
						else if(classGrade2[i].getSelectedIndex() == 5) {	// C+
							num2 += Double.parseDouble(classScore2[i].getText()) * 2.5;
						}
						else if(classGrade2[i].getSelectedIndex() == 6) {	// C
							num2 += Double.parseDouble(classScore2[i].getText()) * 2;
						}
						else if(classGrade2[i].getSelectedIndex() == 7) {	// D+
							num2 += Double.parseDouble(classScore2[i].getText()) * 1.5;
						}
						else if(classGrade2[i].getSelectedIndex() == 8) {	// D
							num2 += Double.parseDouble(classScore2[i].getText()) * 1;
						}
						else if(classGrade2[i].getSelectedIndex() == 9) {	// F
							num2 += 0;
						}
					}
				}
				
				if(dividend1 == 0) {
					average1.setText("0.00");							// 1학기 학점수 없음
				}
				else {													// 1학기 평균
					average1.setText(String.format("%.2f", num1 / dividend1));
				}
				
				if(dividend2 == 0) {
					average2.setText("0.00");							// 1학기 학점수 없음
				}
				else {													// 2학기 평균
					average2.setText(String.format("%.2f", num2 / dividend2));
				}
				
				@SuppressWarnings("unused")
				FinalCalculate fc = new FinalCalculate();				// 총 이수학점, 평량평균 계산
			}
		}
	}
	
	class FinalCalculate {
		FinalCalculate() {												// 총 이수학점, 평량평균 계산
			Double tempCompleteArray[] = new Double[4];
			double tempComplete = 0;
			
			for(int i = 0; i < 4; i++) {								// 총 이수학점 계산 
				tempCompleteArray[i] = Double.parseDouble(template[i].complete1.getText()) + Double.parseDouble(template[i].complete2.getText());
				tempComplete += tempCompleteArray[i];
			}
			
			finalComplete.setText(String.format("%.0f", tempComplete));
			
			Double tempArray1[] = new Double[4];
			Double tempArray2[] = new Double[4];
			double tempAverage = 0;
			
			for(int i = 0; i < 4; i++) {								// 평량평균 계산
				tempArray1[i] = new Double(0);
				tempArray2[i] = new Double(0);
				
				if(template[i].average1.getText().equals("0.00")) {}
				else {tempArray1[i] = Double.parseDouble(template[i].average1.getText()) * Double.parseDouble(template[i].complete1.getText());}
				
				if(template[i].average2.getText().equals("0.00")) {}
				else {tempArray2[i] = Double.parseDouble(template[i].average2.getText()) * Double.parseDouble(template[i].complete2.getText());}
				
				tempAverage += tempArray1[i] + tempArray2[i];
			}
			
			finalAverage.setText(String.format("%.2f", tempAverage / tempComplete));
		}
	}
	
	class ButtonFunction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			String str = button.getText();
			
			@SuppressWarnings("unused")
			SaveExitFuntion sef = new SaveExitFuntion(str);
		}
	}
	
	class MenuFunction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			
			String str = item.getText();
			
			if(str.equals("New")) {										// 초기화
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 8; j++) {
						template[i].className1[j].setText("");
						template[i].className2[j].setText("");
						template[i].classScore1[j].setText("");
						template[i].classScore2[j].setText("");
						template[i].classGrade1[j].setSelectedIndex(0);
						template[i].classGrade2[j].setSelectedIndex(0);
					}
				}
				
				finalAverage.setText("0.00");							// 평량평균 NaN
			}
			
			if(str.equals("Open")) {									// 불러오기
				grade[0].setSelected(true);								// 1학년 라디오버튼 선택
				
				panel1_1.setVisible(true);								// 1학년 패널 표시
				panel1_2.setVisible(false);
				panel1_3.setVisible(false);
				panel1_4.setVisible(false);
				
				try {
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader(route));
					
					String line;
					String token;
					
					line = br.readLine();
					
					StringTokenizer st = new StringTokenizer(line, "&");
					
					for(int i = 0; i < 4; i++) {
						for(int j = 0; j < 8; j++) {					// 1학기
							token = st.nextToken();
							
							if(token.equals("null")) {					// 강의명
								template[i].className1[j].setText("");
							}
							else {
								template[i].className1[j].setText(token);
							}
							
							token = st.nextToken();
							
							if(token.equals("null")) {					// 학점수
								template[i].classScore1[j].setText("");
							}
							else {
								template[i].classScore1[j].setText(token);
							}
							
							token = st.nextToken();
							
							template[i].classGrade1[j].setSelectedIndex(Integer.parseInt(token));
						}
						
						for(int j = 0; j < 8; j++) {					// 2학기
							token = st.nextToken();
							
							if(token.equals("null")) {					// 강의명
								template[i].className2[j].setText("");
							}
							else {
								template[i].className2[j].setText(token);
							}
							
							token = st.nextToken();
							
							if(token.equals("null")) {					// 학점수
								template[i].classScore2[j].setText("");
							}
							else {
								template[i].classScore2[j].setText(token);
							}
							
							token = st.nextToken();
							template[i].classGrade2[j].setSelectedIndex(Integer.parseInt(token));
						}
					}
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
			@SuppressWarnings("unused")
			SaveExitFuntion sef = new SaveExitFuntion(str);
		}
	}
	
	class SaveExitFuntion {
		SaveExitFuntion(String str) {
			if(str.equals("Save")) {									// 저장
				try {
					FileWriter fw = new FileWriter(route);
					
					for(int i = 0; i < 4; i++) {
						for(int j = 0; j < 8; j++) {
							if(template[i].className1[j].getText().equals("")) {
								fw.write("null&");
							}
							else {
								fw.write(template[i].className1[j].getText() + "&");
							}
							
							if(template[i].classScore1[j].getText().equals("")) {
								fw.write("null&");
							}
							else {
								fw.write(template[i].classScore1[j].getText() + "&");
							}
							fw.write(template[i].classGrade1[j].getSelectedIndex() + "&");
						}
						
						for(int j = 0; j < 8; j++) {
							if(template[i].className2[j].getText().equals("")) {
								fw.write("null&");
							}
							else {
								fw.write(template[i].className2[j].getText() + "&");
							}
							
							if(template[i].classScore2[j].getText().equals("")) {
								fw.write("null&");
							}
							else {
								fw.write(template[i].classScore2[j].getText() + "&");
							}
							fw.write(template[i].classGrade2[j].getSelectedIndex() + "&");
						}
					}
					
					fw.write("\r\n");
					
					fw.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(str.equals("Exit")) {								// 종료
				if(check() != 192) {
					int dialog;
																		// JOptionPane 사용하여 dialog 구현
					dialog = JOptionPane.showConfirmDialog(null, "저장 후 종료하시겠습니까?", "", 1, 2);
					
					if(dialog == 0) {									// 예
						try {
							FileWriter fw = new FileWriter(route);
							
							for(int i = 0; i < 4; i++) {
								for(int j = 0; j < 8; j++) {
									if(template[i].className1[j].getText().equals("")) {
										fw.write("null&");
									}
									else {
										fw.write(template[i].className1[j].getText() + "&");
									}
									
									if(template[i].classScore1[j].getText().equals("")) {
										fw.write("null&");
									}
									else {
										fw.write(template[i].classScore1[j].getText() + "&");
									}
									fw.write(template[i].classGrade1[j].getSelectedIndex() + "&");
								}
								
								for(int j = 0; j < 8; j++) {
									if(template[i].className2[j].getText().equals("")) {
										fw.write("null&");
									}
									else {
										fw.write(template[i].className2[j].getText() + "&");
									}
									
									if(template[i].classScore2[j].getText().equals("")) {
										fw.write("null&");
									}
									else {
										fw.write(template[i].classScore2[j].getText() + "&");
									}
									fw.write(template[i].classGrade2[j].getSelectedIndex() + "&");
								}
							}
							
							fw.write("\r\n");
							
							fw.close();
							
							System.exit(0);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else if(dialog == 1) {								// 아니오
						System.exit(0);
					}
					else {												// 취소
						
					}
				}
				else {
					System.exit(0);										// 기재 내용 없으면 종료
				}
			}
		}
	}
	
	public int check() {												// 입력 확인
		int count = 0;													// count != 192 일 경우 저장해야함
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				if(template[i].className1[j].getText().equals("")) {
					count++;
				}
				if(template[i].classScore1[j].getText().equals("")) {
					count++;
				}
				if(template[i].classGrade1[j].getSelectedIndex() == 0) {
					count++;
				}
				if(template[i].className2[j].getText().equals("")) {
					count++;
				}
				if(template[i].classScore2[j].getText().equals("")) {
					count++;
				}
				if(template[i].classGrade2[j].getSelectedIndex() == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
}
