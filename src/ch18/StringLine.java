package ch18;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class StringLine extends JApplet {
	@Override
	public void init() {
		getContentPane().setBackground(
				new Color(255,255,255)); //배경색상 설정
		setSize(300,300); //애플릿의 화면 사이즈
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue); //색상 설정
// 선그리기 drawLine(x1,y1,x2,y2)		
		g.drawLine(250, 50, 30, 160);
		g.setColor(Color.red);
		g.drawString("Red string", 10, 50);
		g.setColor(Color.green);
		g.drawString("Green string", 10, 80);
		g.setColor(Color.blue);
		g.drawString("Blue string", 10, 110);
	}
}



