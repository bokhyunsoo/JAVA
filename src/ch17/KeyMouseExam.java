package ch17;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
// MouseListener : 마우스이벤트 처리를 위한 인터페이스
// MouserEvent
// MouseMotionListener
public class KeyMouseExam extends JApplet implements MouseListener, MouseMotionListener, KeyListener{
	private int x,y;
	private int width, height;
	private Image img;
	private boolean flag = false;
	//애플릿을 초기화하는 코드
	@Override
	public void init() {
		setSize(1000,1000); //화면 사이즈 설정
		//이미지를 불러오는 코드(같은 패키지에 이미지 준비)
		System.out.println(getClass());//클래스의 정보
		img = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("kiwi.jpg"));
		//현재 클래스에 마우스 이벤트 기능을 추가
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//현재 클래스에 키이벤트 기능을 추가
		this.addKeyListener(this);
		//키입력을 받을 수 있도록 설정
		setFocusable(true);
		//현재 화면에 키 입력을 요청함
		requestFocus();
	}
	//화면 출력 method
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//이미지의 가로,세로 길이 계산
		width = img.getWidth(null);
		width = img.getHeight(null);
		//drawImage(이미지,x,y,이미지관찰자)
		if(flag){
		g.drawImage(img, x, y, this);
		}
	}
	//press+release
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e);
		flag = true;
		//마우스 클릭한 좌표 저장
		x = e.getX();
		y = e.getY();
		//그래픽 갱신 요청 => paint()가 호출됨
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouse drag:x"+x+",y:"+y);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		System.out.println("mouse move:x:"+x+",y:"+y);
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyCode());//키 코드값
//		System.out.println(e.getKeyChar());//문자
		switch(e.getKeyCode()){ //키코드값에 따라 분기
		case KeyEvent.VK_UP:
			y=Math.max(0, y-5); break;
		case KeyEvent.VK_DOWN:
			y=Math.min(300-height, y+5); break;
		case KeyEvent.VK_LEFT:
			x=Math.max(0, x-5); break;
		case KeyEvent.VK_RIGHT:
			x=Math.min(300-width, x+5); break;
		}
		repaint(); //그래픽 갱신 요청
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
