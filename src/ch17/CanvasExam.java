package ch17;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// ComponentListener : 컴포넌트의 위치 변경, 사이즈 변경
//					    등의 이벤트 처리
class BallCanvas extends Canvas implements Runnable, ComponentListener {
	private int x,y;
	private int moveX=2, moveY=2;
	private int red,green,blue;
	private Random random;
	private int width, height;
	//생성자
	public BallCanvas() {
		//이벤트소스.이벤트리스너(이벤트핸들러)
		this.addComponentListener(this);
		random = new Random();
		//백그라운드 스레드 생성
		Thread th = new Thread(this);
		//백그라운드 스레드 작업 시작 요청
		th.start();
	}
	//그래픽 처리 method
	@Override
	public void paint(Graphics g) {
		//색상 설정
		g.setColor(new Color(red,green,blue));
		//타원 그리기(x,y,width,height)
		g.fillOval(x, y, 20, 20);
	}
	
	void setColor(){
		//랜덤.nextInt(num) 0~num-1 사이의 난수 발생
		red = random.nextInt(256); // 0~255
		green = random.nextInt(256);
		blue = random.nextInt(256);
	}
	
	@Override
	public void run() {
		while(true){
			if(x > (width-20) || x < 0){ //좌우 벽처리
				setColor();
				moveX = -moveX;
			}
			if(y > (height-20) || y < 0){ //상하 벽처리
				setColor();
				moveY = -moveY;
			}
			x += moveX;
			y += moveY;
			repaint(); //그래픽 갱신 요청 => paint()가 호출됨
			try {
				Thread.sleep(30); //cpu 멈춤
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//컴포넌트의 사이즈가 변경될 때
	@Override
	public void componentResized(ComponentEvent e) {
		//가로,세로 사이즈 저장
		width = getWidth();
		height = getHeight();
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

public class CanvasExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasExam frame = new CanvasExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CanvasExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//프레임에 캔버스를 붙임
		BallCanvas canvas = new BallCanvas();
		canvas.setBackground(Color.YELLOW);//배경색상
		contentPane.add(canvas);
	}

}
