package ch17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ClockExam extends JFrame implements Runnable {

	private JPanel contentPane;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockExam frame = new ClockExam();
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
	public ClockExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblTime = new JLabel("New label");
		lblTime.setForeground(Color.RED);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("굴림", Font.PLAIN, 20));
		contentPane.add(lblTime, BorderLayout.CENTER);
		
		JButton btnClose = new JButton("종료");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnClose, BorderLayout.SOUTH);
		
		//백그라운드 스레드 생성
		Thread th = new Thread(this);
		//백그라운드 스레드 시작 요청 => run() method가 호출됨
		th.start();
	}

	@Override
	public void run() {
		while(true){
		//캘린더 인스턴스 생성(현재 시각을 얻음)
		Calendar cal = Calendar.getInstance();
//		String str = cal.get(Calendar.YEAR)+"-"
//				+(cal.get(Calendar.MONTH)+1)+"-"
//				+cal.get(Calendar.DATE)+" "
//				+cal.get(Calendar.HOUR_OF_DAY)+":"
//				+cal.get(Calendar.MINUTE)+":"
//				+cal.get(Calendar.SECOND);
		//String.format(출력형식, 출력할값...)
		String str = String.format("%d-%02d-%02d %02d:%02d:%02d",
				cal.get(Calendar.YEAR)
				,(cal.get(Calendar.MONTH)+1)
				,cal.get(Calendar.DATE)
				,cal.get(Calendar.HOUR)
				,cal.get(Calendar.MINUTE)
				,cal.get(Calendar.SECOND));
		//label에 텍스트 입력
		//lable.getText()
		lblTime.setText(str);
		}
	}

}
