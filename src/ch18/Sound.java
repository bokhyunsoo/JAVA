package ch18;

import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;

public class Sound extends JApplet 
		implements ActionListener	 {
	private AudioClip audio;
	private JButton play,stop,loop;
	@Override
	public void init() {
		//레이아웃 변경
		setLayout(new FlowLayout());
		//버튼을 애플릿에 추가
		play = new JButton("play");
		stop = new JButton("stop");
		loop = new JButton("loop");
		add(play); add(stop); add(loop);
		//사운드 객체
//getClass() 현재 클래스의 정보
//getClass().getResource() 현재 클래스가 속한 패키지에서
//		리소스 파일을 로딩함		
		System.out.println(getClass());
		audio = getAudioClip(getClass().getResource(
				"dingdong.wav"));
		play.addActionListener(this);
		stop.addActionListener(this);
		loop.addActionListener(this);
		//버튼 클릭 이벤트
//		play.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("play...");
//				audio.play();
//			}
//		});
//		stop.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				audio.stop();
//			}
//		});
//		loop.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				audio.loop();
//			}
//		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e);
//클릭한 버튼의 label 		
		System.out.println(e.getActionCommand());
//클릭한 버튼의 주소		
		JButton btn=(JButton)e.getSource();
		System.out.println(e.getSource());
		if(btn == play){
			audio.play();
		}else if(btn == stop){
			audio.stop();
		}else if(btn == loop){
			audio.loop();
		}
	}
}













