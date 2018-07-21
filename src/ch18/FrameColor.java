package ch18;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class FrameColor extends JFrame {
	public FrameColor() throws InterruptedException {
		setVisible(true); //프레임을 화면에 표시
		//프레임의 컨텐츠 영역
		Container c=getContentPane(); 
		for(int i=0; i<=255; i++){
			setSize(i*2, i); //프레임의 사이즈
			setLocation(i*2, i); //프레임의 좌표
			c.setBackground(new Color(i,0,0)); //배경색상 설정
			Thread.sleep(10); //잠시 멈춤
		}
		for(int i=0; i<=255; i++){
			setSize(i*2, i); //프레임의 사이즈
			setLocation(i*2, i); //프레임의 좌표
//new Color(red,green,blue) 0~255			
			c.setBackground(new Color(255,i,0)); //배경색상 설정
			Thread.sleep(10); //잠시 멈춤
		}
		//윈도우 닫기 동작
//숨김처리(기본값)		
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
//현재창만 닫음		
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//모든창을 닫음		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
			throws InterruptedException {
		new FrameColor(); //인스턴스 생성, 생성자 호출
	}

}







