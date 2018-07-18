package ch11;

import java.awt.Graphics;

public class DrawLine extends Point implements Draw {
	private int x,y;
	public DrawLine(int a, int b, int x, int y){
		super(a,b);
		this.x = x;
		this.y = y;
	}
	@Override
	public void paint(Graphics g) {
		// drawLine(x1,y1,x2,y2) 선 그리기
		// 10,20,150,100
		g.drawLine(a, b, x, y);
	}

}
