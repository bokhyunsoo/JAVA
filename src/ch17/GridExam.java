package ch17;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridExam extends JFrame {
	public GridExam() {
		// JFrame의 기본레이아웃은 BorderLayout
		// 기본레이아웃을 쓰지 않고 GridLayout으로 변경
		// new GridLayout(rows,cols)
		//setLayout(new GridLayout(2,3)); //2행 3열
		setLayout(new FlowLayout());
		for(int i=1; i<=6; i++){
			JButton button = new JButton("button"+i);
			add(button); //프레임에 버튼 추가
		}
		setSize(300,300); //화면 사이즈 설정
		setVisible(true); //프레임을 화면에 표시
		//윈도우 닫기 버튼 동작 정의
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//인스턴스가 만들어지면서 생성자가 자동으로 호출됨
		new GridExam();
	}
}
