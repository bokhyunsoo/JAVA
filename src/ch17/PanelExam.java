package ch17;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelExam extends JFrame{
	public PanelExam() {
		// 패널에는 2개 이상의 컴포넌트를 배치할 수 있음
		// 패널에 여러개의 컴포넌트를 배치한 후
		// 프레임에 패널을 붙이면 1개를 붙인 효과가 됨
		JPanel p = new JPanel(); // 패널 추가
		
		//버튼 생성
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");
		JButton button5 = new JButton("버튼5");
		JButton button6 = new JButton("버튼6");
//		setLayout(new FlowLayout());
		//프레임에 버튼을 붙임
		// target.add(component)
//		this.add(button1);
//		add(button2);
//		add(button3);
//		add(컴포넌트, 위치)
		p.add(button1);
		p.add(button6);
		// 프레임의 North 영역에 패널을 추가
//		add(p, "North");
		add(p, BorderLayout.NORTH);
		//add(button2, "Center");
		add(button2); //위치를 생략하면 Center로 배치
		add(button3, "South");
		add(button4, "West");
		add(button5, "East");
		//한 영역에 한개의 컴포넌트만 배치됨
		setSize(300,300); //화면 사이즈 설정
		setVisible(true); //프레임을 화면에 표시
		//윈도우 닫기 버튼을 눌렀을 때의 동작
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new PanelExam();
	}
}
