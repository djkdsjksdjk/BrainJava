package chap19;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowExample2 {

	public static void main(String[] args) {
		
		JFrame jframe = new JFrame("Hello Program");
		jframe.setPreferredSize(new Dimension(200, 90));
		//frame.setPreferredSize(new Dimension(1000, 600));
		//frame.setLocation(500, 400);
		
		//ImageIcon image = new ImageIcon("images/label.jpg");
		//JLabel imageLabel = new JLabel(image);
		
		Container container = jframe.getContentPane();
		
		JTextField text = new JTextField("이름을 입력하세요");
		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello!");
		
		container.add(text, BorderLayout.CENTER);
		container.add(button, BorderLayout.EAST);
		container.add(label, BorderLayout.SOUTH);
		
		//ActionListener listener = new ConfirButtonActionListener(text, label);
		//button.addActionListener(listener);
		
		button.addActionListener(new ConfirButtonActionListener(text, label));
		text.addActionListener(new ConfirButtonActionListener(text, label));
		
		container.setFocusable(true);                //컨테이너에 포커스를 설정
		
		text.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {  //텍스트 필드가 포커스를 얻을때
				text.setText("");                    //이름을 입력하세요 문자열을 삭제
				
			}
			
			public void focusLost(FocusEvent e) { }
		});
		
		text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
		
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keypressed");
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("VK_ENTER");
			}
			}
		});
			
	
		
		//contentPane.add(imageLabel, BorderLayout.NORTH);
		
		//button.requestFocusInWindow();
		//text.setFocusable(false);//포커스 해제
		
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);//화면 전중앙 배치
		
		

	}
}