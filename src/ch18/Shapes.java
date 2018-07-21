package ch18;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

public class Shapes extends JApplet {
	@Override
	public void init() {
		setSize(300,300);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//선굵기 조절
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		g.drawLine(10, 10, 200, 10); //선그리기
//drawRect(x,y,width,height)
		g.setColor(Color.YELLOW);
		g2.setStroke(new BasicStroke(1));
		g.drawRect(120, 40, 90, 55); //사각형
		g.setColor(Color.cyan);
		g.fillRect(120, 140, 90, 55);
//모서리가 둥근 사각형
//fillRoundRect(x,y,width,height,가로라운드길이,세로라운드길이)
		g.setColor(Color.red);
		g.fillRoundRect(120, 240, 90, 55, 100, 100);
		g.setColor(Color.blue);
		g.drawOval(0, 40, 90, 55);//타원 그리기
		g.setColor(Color.pink);
		g.fillOval(0, 140, 90, 55);
		int[] x={10,30,50,40,20};
		int[] y={257,240,257,280,280};
		//fillPolygon(x배열,y배열,꼭지점의 수)
		g.fillPolygon(x,y,x.length);//다각형 그리기
	}
}


 



