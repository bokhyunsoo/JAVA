package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalSliderUI;

public class SliderExam extends JFrame {
	//local => field
	private JPanel contentPane;
	private JSlider sliderR;
	private JSlider sliderG;
	private JSlider sliderB;
	private JPanel panel;
	//추가
	private int red,green,blue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderExam frame = new SliderExam();
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
	public SliderExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//절대좌표 레이아웃(null layout)
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 182, 410, 70);
		contentPane.add(panel);
		
		sliderR = new JSlider();
		
		 sliderR.setMajorTickSpacing(40); //큰 눈금
		 sliderR.setMinorTickSpacing(10); //작은 눈금
		 sliderR.setPaintTicks(true); //눈금 표시
		 sliderR.setPaintLabels(true); // 숫자 표시
		//슬라이더의 값이 바뀔 때 호출
		sliderR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//슬라이더의 설정값
				red = sliderR.getValue();
				//패널의 배경색상 변경
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderR.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int dir){
				red = sliderR.getValue();
				//마우스 좌표값을 슬라이더의 value로 환산
				red = valueForXPosition(sliderR.getMousePosition().x);
				//슬라이더 value 변경
				sliderR.setValue(red);
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderR.setValue(0);
		sliderR.setMaximum(255);
		// setBounds(x,y,width,height)
		sliderR.setBounds(12, 22, 410, 40);
		contentPane.add(sliderR);
		
		sliderG = new JSlider();
		sliderG.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//슬라이더의 설정값
				green = sliderG.getValue();
				//패널의 배경색상 변경
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderG.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int dir){
				green = sliderG.getValue();
				//마우스 좌표값을 슬라이더의 value로 환산
				green = valueForXPosition(sliderG.getMousePosition().x);
				//슬라이더 value 변경
				sliderG.setValue(green);
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderG.setValue(0);
		sliderG.setMaximum(255);
		sliderG.setBounds(12, 84, 410, 23);
		contentPane.add(sliderG);
		
		sliderB = new JSlider();
		sliderB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//슬라이더의 설정값
				blue = sliderB.getValue();
				//패널의 배경색상 변경
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderB.setUI(new MetalSliderUI(){
			protected void scrollDueToClickInTrack(int dir){
				blue = sliderB.getValue();
				//마우스 좌표값을 슬라이더의 value로 환산
				blue = valueForXPosition(sliderB.getMousePosition().x);
				//슬라이더 value 변경
				sliderB.setValue(blue);
				panel.setBackground(new Color(red,green,blue));
			}
		});
		sliderB.setValue(0);
		sliderB.setMaximum(255);
		sliderB.setBounds(12, 149, 410, 23);
		contentPane.add(sliderB);
		
		JLabel lblNewLabel = new JLabel("Red");
		lblNewLabel.setBounds(24, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Green");
		lblNewLabel_1.setBounds(22, 70, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blue");
		lblNewLabel_2.setBounds(22, 124, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
