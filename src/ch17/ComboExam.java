package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ComboExam extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboExam frame = new ComboExam();
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
	public ComboExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					ta.setText("");
					int dan = cboDan.getSelectedIndex()+2;
					for(int i=1; i<=9; i++){
						ta.append(String.format("%2d x %2d = %2d\n", dan,i,dan*i));
					}
				}
//				//선택한 아이템의 값
//				System.out.println(cboDan.getSelectedItem());
//				//선택한 아이템의 인덱스(0부터)
//				System.out.println(cboDan.getSelectedIndex());
				
			}
		});
		cboDan.setModel(new DefaultComboBoxModel(new String[] {"2단", "3단", "4단", "5단", "6단", "7단", "8단", "9단"}));
		contentPane.add(cboDan, BorderLayout.NORTH);
		
		ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.PLAIN, 15));
		contentPane.add(ta, BorderLayout.CENTER);
	}

}
