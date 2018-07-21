package ch18;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

public class RandomLine extends JApplet {
	private Random random;
	@Override
	public void init() {
		setSize(300,300);
		random = new Random();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//clipRect(x,y,width,height) 그래픽 영역 제한
		g.clipRect(100, 100, 100, 100);
		for(int i=0; i<100; i++){
			int red=random.nextInt(256); //0~255
			int green=random.nextInt(256);
			int blue=random.nextInt(256);
// Color.상수			
			g.setColor(new Color(red,green,blue));
			int x1=random.nextInt(300); //0~299
			int y1=random.nextInt(300);
			int x2=random.nextInt(300);
			int y2=random.nextInt(300);
			g.drawLine(x1, y1, x2, y2);
		}
	}
}







