import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Exp extends JFrame {

	
	
	private JTextField textField;
	String s1[] = new String[] { "단승", "연승", "복승", "쌍승", "복연승", "삼복승" };
	String s2[] = new String[] { "1등으로 들어올 말이 무엇인지 맞추는 것", "3등안에 들어 오는 말을 한마리 맞추는것", "2등 안에 들어올 두마리의 말을 순위에 상관없이 맞추는것",
			"1,2등을 순서대로 맞추는것", "3등안으로 들어올 2마리의 말을 순위에 상관없이 맞추는것", "3등안으로 들어올 3마리 말을 모두 순위에 상관없이 맞추는것" };
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	public Exp() {
		
		JPanel Main = new JPanel();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		Main.setBackground(Color.WHITE);
		Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main);
		Main.setLayout(null);
		

		JLabel label = new JLabel("마스타 사용법");
		label.setBounds(490, 6, 289, 180);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Main.add(label);

		JLabel lblNewLabel = new JLabel("경기 종류");
		lblNewLabel.setBounds(577, 145, 100, 60);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Main.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					if (comboBox.getSelectedItem().equals(s1[i]))
						textField.setText(s2[i]);
				}
			}
		});

		comboBox.setBounds(478, 200, 289, 25);
		comboBox.setModel(new DefaultComboBoxModel(s1));
		comboBox.setToolTipText("");
		Main.add(comboBox);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(415, 236, 417, 80);
		Main.add(textField);
		textField.setColumns(10);

		

		JLabel label_1 = new JLabel("경기 방법");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(577, 418, 100, 31);
		Main.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("마스타는 실제 경마장인 레츠런파크 를 본따 만든 경마게임으로 실제 경마 게임과 흡사한 방식으로 게임이 진행 됩니다.\n");
		textField_1.setBounds(250, 461, 700, 31);
		Main.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("자기 자신이 가지고 있는 금액을 이용하여 마권을 살 수 있고, 종류와 배팅 금액을 고를 수 있습니다. ");
		textField_2.setBounds(250, 504, 700, 22);
		Main.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("게임 종류에 따라 배당은 높아지거나 낮아지고 각각 말에 지정된 배팅율로된 결과 금액을 얻을 수 있습니다.");
		textField_3.setBounds(250, 534, 700, 31);
		Main.add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("종료");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(558, 645, 117, 29);
		Main.add(button);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	
}
/**
 * Create the frame.
 */