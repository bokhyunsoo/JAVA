package ch17;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardExam extends JFrame {
	CardLayout card;
	Container con;
	public CardExam() {
		con = getContentPane(); //프레임의 컨텐츠 영억
		card = new CardLayout();
		//기본 레이아웃을 BorderLayout에서 카드레이아웃으로 변경
		setLayout(card);
		//패널 참조변수 5개
		JPanel[] pan = new JPanel[5];
		//색상 배열
		Color[] color = {Color.red, Color.yellow,
				Color.green, Color.blue, Color.cyan};
		for(int i=0; i<pan.length; i++){
			pan[i] = new JPanel(); //패널 생성
			//패널의 배경색상 설정
			pan[i].setBackground(color[i]);
			// add( "이름", 컴포넌트 )
			add("card"+i,pan[i]);
			//패널에 마우스 이벤트 추가
			//MouseAdapter : MouseListener를 구현한 클래스
			pan[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					card.next(con); //다음 화면으로 이동
					card.previous(con); //이전 화면으로 이동
				}
			});
			setSize(300,300); //프레임의 사이즈 설정
			setVisible(true); //프레임을 화면에 표시
			//닫기 버튼 동작 설정
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	public static void main(String[] args) {
		new CardExam();
	}
}
