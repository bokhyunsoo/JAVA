package ch12;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//이벤트 처리
//사용자의 요청(request)에 시스템이 응답(response)
//이벤트 소스 : 이벤트의 대상
//이벤트 리스너 : 이벤트 관찰자, 감시자
//이벤트 핸들러 : 이벤트 처리기
//이벤트소스.이벤트리스너(이벤트핸들러)
// Frame : 인도우 창을 띄워주는 클래스
public class InnerExam extends Frame {
	public InnerExam(){
		super("내부 클래스 테스트"); // Frame 클래스의 생성자
		setSize(300,400); // 가로, 세로 사이즈 설정
		setVisible(true); // 프로엠을 화면에 표시
	}
	public static void main(String[] args) {
		InnerExam e = new InnerExam();
		e.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			//윈도우창이 닫힐 때 호출(x 버튼을 누를 때)
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); //프로그램 강제 종료
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
	}
}
