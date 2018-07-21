package ch18;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

// 키이벤트 : KeyListener
// 멀티스레드 : Runnable
public class Game extends JApplet 
		implements KeyListener, Runnable {
	private Image imgBackground; // 배경이미지
	private Image imgGunship; // 비행기
	private Image imgMissile; // 총알
	private Image imgEnemy; // 적비행기
	private Image imgHit; // 폭발이미지
	private AudioClip audioFire; // 총알 사운드
	private AudioClip audioHit; // 폭발 사운드
	private int x, y = 270; // 비행기의 좌표
	private int mx = x + 10; // 총알 좌표
	private int my = y - 10;
	private int ex, ey = 50; // 적비행기의 좌표
	private int moveEx = 2; // 적비행기의 좌표이동값
	private int hitX, hitY; // 폭발지점의 좌표
	private int point = 1000; // 점수
	// private boolean fire; // 발사상태(true-발사, false-대기)
	private boolean hit; // 폭발상태(true - 폭발, false-폭발안된 상태)
	// 총알리스트 변수
	ArrayList<Missile> mlist = new ArrayList<Missile>();
	// 더블버퍼링을 위한 변수
	private Image offImage;
	private Graphics bg;

	public void init() {
		this.setSize(300, 300); // 화면 사이즈 설정
		// 버블 버퍼링을 위한 백그라운드 이미지 영역 생성
		offImage = createImage(
				this.getWidth(), this.getHeight());
		bg = offImage.getGraphics();
		// 이미지 객체 생성
		imgBackground = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("space.png")); // 배경이미지
		imgGunship = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("gunship.png")); // 비행기
		imgMissile = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("missile.png")); // 총알
		imgEnemy = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("enemy.png")); // 적비행기
		imgHit = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("hit.png")); // 폭발이미지
		// 사운드 객체 생성
		audioFire = getAudioClip(getClass()
				.getResource("fire.wav"));// 발사음
		audioHit = getAudioClip(getClass()
				.getResource("hit.wav"));// 폭발음
		// 애플릿에 키이벤트 기능 추가
		this.addKeyListener(this);
		// 클릭하지 않더라도 포커스를 설정하는 코드
		this.setFocusable(true);
		// 현재 화면에 입력포커스를 설정함
		this.requestFocus();
		// 스레드 객체 생성
		Thread t = new Thread(this);
		t.start(); //run()
	}

	@Override
	public void start() {
		// 비행기의 초기 좌표
		x = getWidth() / 2 - 15;
		// 총알의 초기 좌표
		mx = getWidth() / 2 - 2;
		// 적비행기의 초기 좌표
		ex = getWidth() - 25;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		super.paint(g);
		bg.clearRect(0, 0, getWidth(), getHeight()); // 이미지 클리어
		bg.drawImage(imgBackground, 0, 0, this); // 배경 이미지 그리기
		bg.drawImage(imgGunship, x, y, this); // 비행기 그리기
		// 총알 리스트를 화면에 출력
		for (int i = 0; i < mlist.size(); i++) {
			Missile m = mlist.get(i);
			bg.drawImage(imgMissile, m.getMx(), m.getMy(), this); // 총알 그리기
		}
		if (hit) {
			bg.drawImage(imgHit, hitX, hitY, this); // 폭발 이미지 그리기
			hit = false;
		} else {
			bg.drawImage(imgEnemy, ex, ey, this); // 적비행기 그리기
		}
		bg.setColor(Color.white);
		bg.drawString("점수:" + point, 20, 20);
		g.drawImage(offImage, 0, 0, this); // 그래픽 화면에 출력
	}

	@Override
	public void run() {
		while (true) {
			//System.out.println(mlist);
			// 리스트객체.size() ==> 요소의 갯수
			// if (fire) {
			for (int i = 0; i < mlist.size(); i++) {
				Missile m = mlist.get(i); // i번째 총알 객체를 꺼냄
				// my = my - 5; // 총알의 y좌표를 감소시킴
				m.setMy(m.getMy() - 5);
				// if ( my == 0) { // 총알의 y좌표가 0가 되면 발사대기상태로 전환
				if (m.getMy() == 0) {
					mlist.remove(i); // 총알리스트에서 제거
				}
				// 충돌 체크
				// new Rectangle( x좌표, y좌표, 가로길이, 세로길이 ) ==> 사각영역을 계산
				// rect객체1.intersects( rect객체2 ) ==> 겹치는 부분이 있으면 true
				Rectangle rect1 = 
new Rectangle(ex, ey, imgEnemy.getWidth(null), imgEnemy.getHeight(null));
				Rectangle rect2 = new Rectangle(m.getMx(), m.getMy(), imgMissile.getWidth(null), imgMissile.getHeight(null));
				// 두 사각영역이 교집합이 있으면
				if (rect1.intersects(rect2)) {
					System.out.println("충돌");
					audioHit.play(); // 폭발음 플레이
					// 폭발상태로 전환
					hit = true;
					// 폭발지점의 좌표 저장
					hitX = m.getMx() - 30;
					hitY = m.getMy() - 30;
					// 점수 처리
					point = point + 100;
					// 총알, 적비행기 좌표를 초기화
					setMissilePos();
					ex = getWidth() - 25;
					ey = 0;
					// 총알 제거
					mlist.remove(i);
				}
				// }
			}
			// 적비행기 좌표 변경
			ex = ex - moveEx;
			if (ex < 0 || ex > getWidth() - 25) {
				moveEx = -moveEx;
				ey = ey + 10;
			}
			if (ey == (getHeight() - imgGunship.getHeight(this))) {
				// messagedialog로 하고 system.exit로 할 것
				int result = JOptionPane.showConfirmDialog(this, "game over, restart?");
				if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.YES_OPTION) {
					ex = getWidth() - 25;
					ey = 0;
					point = 1000;
				}
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void setMissilePos() {
		// if (fire == false) {
		mx = x + 13;
		// }
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) { // 키코드(숫자)
		case KeyEvent.VK_LEFT:
			x = Math.max(0, x - 5);
			setMissilePos();
			break;
		case KeyEvent.VK_RIGHT:
			// 이미지객체.getWidth() ==> 이미지의 가로길이
			x = Math.min(300 - imgGunship.getWidth(null), x + 5);
			setMissilePos();
			break;
		case KeyEvent.VK_F: // F키를 누르면 총알 발사
			// fire = true; // 발사상태로 변경
			// 총알 객체 생성 ==> 리스트에 추가
			Missile m = new Missile(); // 총알 객체 생성
			m.setMx(x + imgGunship.getWidth(null) / 2); // 총알의 x좌표
			m.setMy(y); // 총알의 y좌표
			mlist.add(m); // 리스트에 총알객체 추가
			audioFire.play(); // 사운드 플레이
			break;
		}
		repaint(); // 그래픽을 새로고침
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
