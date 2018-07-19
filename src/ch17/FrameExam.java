package ch17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//awt : java+c
//swing : awt를 향상시킨 버전, java로만 개발
public class FrameExam {
	public static void main(String[] args) {
		//Frame 생성(윈도우를 띄우는 클래스)
		Frame f = new Frame("프레임 테스트");
		//JFrame f = new JFrame("프레임 테스트");
		//프레임의 타이틀
//		f.setTitle("프레임 테스트");
		//프레임의 사이즈 설정
		f.setSize(200, 300);
		//프레임을 화면에 표시
		f.setVisible(true);
		//이벤트 소스.이벤트리스너(이벤트핸들러)
		// addOOOListener
		// addMouseListener, addKeyListener
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		f.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				//프로그램을 종료시킴
//				//정상종료 : 0, 비정상종료 : -1
//				System.exit(0);
//			}
//			
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//			
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});
	}
}
