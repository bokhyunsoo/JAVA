package ch16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
//main thread: 화면(UI, User Interface)을 변경
//background thread: 좌표값 변경
//애플릿 : 우베브라우저에서 실행되는 자바 프로그램
public class BufferedBall extends Applet implements Runnable, ComponentListener{
	private int x,y;
	private int mx=2, my=3;
	private int width=200, height=200;
	//더블 버퍼링(double buffering)
	//백그라운드 메모리 영역에 그래픽 처리를 할 객체
	private Graphics bg;
	//백그라운드 이미지 객체
	private Image offScreen;
	//화면의 가로, 세로 사이즈를 저장하는 객체
	private Dimension dim;
	
	//애플릿을 초기화시키는 method
	@Override
	public void init() {
		//애플릿의 가로,세로 길이 설정 setSize(가로,세로)
		setSize(300,300);
		//애플릿의 가로,세로 길이를 Dimension 객체에 저장
		dim = getSize();
		//화면 사이즈만큼의 백그라운드 그래픽 영역 생성
		offScreen = createImage(dim.width, dim.height);
		//백그라운드 영역에 그래픽 처리를 하기 위한 객체 생성
		bg = offScreen.getGraphics();
		
		//화면의 변화를 감지하는 이벤트 처리 기능 추가
		//이벤트소스.이벤트리스너(이벤트핸들러)
		this.addComponentListener(this);
		//새로운 스레드 생성 new Thread(스레드를 구현한 객체)
		Thread t = new Thread(this);
		//새로운 작업단위가 할당되고 run()이 실행됨
		t.start();
	}
	//그래픽 처리
	@Override
	public void paint(Graphics g) {
		//백그라운드 메모리에 그래픽 출력
		bg.setColor(Color.blue); //색상 설정
		//fillRect(x1,y1,width,height) 사각형을 그리는 method
		bg.fillRect(0, 0, getWidth(), getWidth()); //사각형
		bg.setColor(Color.GREEN);
		bg.fillOval(x, y, 30, 30);//원
		//백그라운드 메모리에 출력된 그림을 화면에 출력
		//drawImage(이미지,x,y,이미지관찰객체)
		g.drawImage(offScreen, 0, 0, this);
	}
	@Override
	public void run() {
		while(true){ //무한반복
			//x,y 좌표값 변경
			if(x > (width-30) || x < 0) {
				mx = -mx;
			}
			x = x + mx;
			if(y > (height-30) || y < 0) {
				my = -my;
			}
			y = y + my;
			repaint(); //화면을 새로 그림 => paint()가 호출됨
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	//화면 사이즈가 변경될 때 호출됨
	@Override
	public void componentResized(ComponentEvent e) {
		//화면의 가로, 세로 사이즈를 저장
		width = getWidth();
		height = getHeight();
		System.out.println("가로:"+width+"세로:"+height);
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}