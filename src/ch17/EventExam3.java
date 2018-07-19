package ch17;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventExam3 extends JFrame {
	private JButton button1,button2,button3,button4,button5,button6;
	
	public EventExam3() {
		
		//레이아웃 변경
		setLayout(new FlowLayout());
		
		button1 = new JButton("Red"); //버튼 생성
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		button4 = new JButton("White");
		button5 = new JButton("Yellow");
		button6 = new JButton("Cyan");
		//프레임에 버튼을 붙임
		//target.add(component)
		this.add(button1);add(button2);add(button3);
		add(button4);add(button5);add(button6);
		//버튼 클릭 이벤트 기능 추가
		//버튼을 누르면 MyColorAction 클래스에서 구현한 actionPerformed()가 호출됨
		button1.addActionListener(new MyColorAction(this, Color.red));
		button2.addActionListener(new MyColorAction(this, Color.green));
		button3.addActionListener(new MyColorAction(this, Color.blue));
		button4.addActionListener(new MyColorAction(this, Color.white));
		button5.addActionListener(new MyColorAction(this, Color.yellow));
		button6.addActionListener(new MyColorAction(this, Color.cyan));
		setSize(450, 300); //화면 사이즈 설정
		setVisible(true); //프레임을 화면에 표시
		//윈도우 창닫기 설정
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//hidden 처리, 프로그램이 종료되지 않음
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		//현재 창만 닫음
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//인스턴스 생성, 생성자 호출
		new EventExam3();
	}
}
