package ch18;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JApplet;

public class FontExam extends JApplet {
	private Font font;
	private FontMetrics fm;//글꼴관련 정보를 제공하는 클래스
	private int x,y;
	private String message;
	private Dimension dim;
	@Override
	public void init() {
		message = "그래픽 테스트";
		//new Font("폰트", 옵션, 사이즈)
		font = new Font("굴림",Font.ITALIC, 30);
		fm=getFontMetrics(font); 
		setSize(250,250); //애플릿의 화면 크기
		dim=getSize(); //화면 크기 계산
		System.out.println(dim.width);
		System.out.println(dim.height);
// 문자열의 가로 길이 계산		
		x=dim.width/2;
		y=dim.height/2;
//		x=(dim.width/2)-(fm.stringWidth(message)/2);
//// 문자열의 세로 길이 계산		
//		y=(dim.height/2)-(fm.getDescent()/2);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(font); //폰트 설정
		//문자열 출력 drawString(문자열, x, y)
		g.drawString(message, x, y); 
	}
}






	
	
	
	
	