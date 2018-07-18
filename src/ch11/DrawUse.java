package ch11;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
// Applet : 웹브라우저에서 실행되는 자바 클래스
public class DrawUse extends Applet{
	Draw shape1;
	Draw shape2;
	public DrawUse(){
		shape1 = new DrawCircle(30,30,60,80);
		shape2 = new DrawLine(10,20,150,100);
		setBackground(Color.ORANGE); //배경색상 설정
	}
	@Override //자동으로 실행됨
	public void paint(Graphics g) {
		g.drawString("자바 그래픽", 100, 60);//문자열,x,y좌표
		shape1.paint(g);
		shape2.paint(g);
	}
}
