import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class H_1 extends JFrame {

	public H_1() {

		JPanel contentPane;
		
		setBounds(100, 100, 510, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 60, 500, 1);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 280, 500, 1);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 200, 500, 1);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(250, 60, 1, 141);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("말 이름");
		lblNewLabel.setFont(new Font("KoreanAMERIB", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 6, 304, 42);
		contentPane.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(166, 202, 1, 80);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(332, 200, 1, 80);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(83, 280, 1, 48);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(166, 280, 1, 48);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(250, 280, 1, 48);
		contentPane.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(332, 280, 1, 48);
		contentPane.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(415, 280, 1, 48);
		contentPane.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("마 번");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 89, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("국 적");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(166, 89, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("레이팅");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(387, 89, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("연 령");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(272, 89, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("승 률");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(55, 213, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("복승률");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(223, 213, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("연승률");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(387, 213, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("단승");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 280, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("연승");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(93, 280, 61, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("복승");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(177, 280, 61, 16);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("쌍승");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(259, 280, 61, 16);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("복연승");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(342, 280, 61, 16);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("삼복승");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(428, 280, 61, 16);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(55, 149, 61, 16);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(166, 149, 61, 16);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(272, 149, 61, 16);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setBounds(387, 149, 61, 16);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setBounds(55, 241, 61, 16);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setBounds(223, 241, 61, 16);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setBounds(387, 241, 61, 16);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setBounds(10, 300, 61, 16);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("New label");
		lblNewLabel_22.setBounds(93, 300, 61, 16);
		contentPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("New label");
		lblNewLabel_23.setBounds(179, 300, 61, 16);
		contentPane.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("New label");
		lblNewLabel_24.setBounds(263, 300, 61, 16);
		contentPane.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("New label");
		lblNewLabel_25.setBounds(345, 300, 61, 16);
		contentPane.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("New label");
		lblNewLabel_26.setBounds(428, 300, 61, 16);
		contentPane.add(lblNewLabel_26);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new H_1();
	}

}