package ch18;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

class MyCanvas extends Canvas{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("hello java", 0, 10);
		g.fillRect(0, 0, 50, 50);
	}
}

public class PaintExam extends JFrame {
	public PaintExam() {
		setLayout(new FlowLayout());
		MyCanvas c=new MyCanvas();
		c.setSize(200,200);
		c.setBackground(Color.yellow);
		add(c);
		//윈도우 닫기 동작
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300); //프레임의 사이즈
		setVisible(true); //프레임을 화면에 표시
	}
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		//문자열 출력 drawString("문자열", x, y )
//		//g.drawString("hello java", 0, 0);
//		g.setColor(Color.YELLOW);  //색상 설정
//		//사각형 그리기(x,y,width,height)
//		//g.fillRect(100, 100, 50, 50);
//		g.drawRect(0, 0, 50, 50);
//	}
	public static void main(String[] args) {
		new PaintExam();
	}
}




