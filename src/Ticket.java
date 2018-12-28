import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

public class Ticket extends JFrame {

	String[] num = { "1", "2", "3", "4", "5", "6", "7", "8" };
	String[] money = { "1천", "2천", "3천", "4천", "5천", "1만", "2만", "3만", "5만", "10만" };
	int[] money2 = { 1000, 2000, 3000, 4000, 5000, 10000, 20000, 30000, 50000, 100000 };
	int game;
	int horseNo[] = { 0, 0, 0 };
	int cash;
	int balance;

	Ticket(final String id, int b) {
		balance = b;
		setTitle("구매표");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);

		JLabel textLabel = new JLabel("구매표 작성");
		JLabel cashlabel = new JLabel("현재 잔액: " + balance);
		JLabel label1 = new JLabel("첫번째말");
		JLabel label2 = new JLabel("두번째말");
		JLabel label3 = new JLabel("세번째말");

		JButton info = new JButton("경주마 정보");
		JButton Output = new JButton("마토 출력");
		JButton ex = new JButton("구매 방법");
		JPanel panel = new JPanel(); // 첫번째 메인판넬
		JPanel panel1 = new JPanel(); // 아래쪽 판넬
		JPanel panel2 = new JPanel(); // 왼쪽 게임선택
		JPanel panel3 = new JPanel(); // 오른쪽 마번선택
		JPanel panel4 = new JPanel(); // 가운데 텍스트판넬

		// 판넬 색상
		panel.setBackground(Color.WHITE);
		panel1.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		panel4.setBackground(Color.WHITE);

		// 패널 테두리
		panel1.setBorder(new LineBorder(Color.black));
		panel2.setBorder(new LineBorder(Color.black));
		panel3.setBorder(new LineBorder(Color.black));
		panel4.setBorder(new LineBorder(Color.black));

		// 판넬 레이아웃타입
		panel.setLayout(null);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 17, 10));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 19, 30));
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 19, 35));

		panel.setBounds(50, 100, 700, 200); // 판넬 위치
		panel1.setBounds(60, 310, 690, 50);
		panel2.setBounds(10, 10, 110, 180);
		panel3.setBounds(250, 10, 450, 180);
		panel4.setBounds(150, 10, 90, 180);

		textLabel.setBounds(50, 20, 150, 30);
		cashlabel.setBounds(220, 20, 250, 30);
		Font f = new Font("Serif", Font.BOLD, 20);
		textLabel.setFont(f);
		ex.setBounds(410, 20, 120, 30);
		ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Exp();
			}
		});
		info.setBounds(530, 20, 120, 30);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HorseInfo();
			}
		});
		Output.setBounds(650, 20, 100, 30);

		ButtonGroup g = new ButtonGroup(); // 게임방법 그룹
		ButtonGroup g1 = new ButtonGroup(); // 마번그룹1
		ButtonGroup g2 = new ButtonGroup(); // 마번그룹2
		ButtonGroup g3 = new ButtonGroup(); // 마번그룹3
		ButtonGroup g4 = new ButtonGroup(); // 배팅금액 그룹

		// 라디오버튼
		final JRadioButton b1 = new JRadioButton("단 승 (1)"); // Panel2
		final JRadioButton b2 = new JRadioButton("연 승 (1/3)");
		final JRadioButton b3 = new JRadioButton("복 승 (2/2)");
		final JRadioButton b4 = new JRadioButton("쌍 승 (1->2)");
		final JRadioButton b5 = new JRadioButton("복연승 (2/3)");
		final JRadioButton b6 = new JRadioButton("삼복승 (3/3)");

		// 버튼 테두리 없애는것
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setContentAreaFilled(false);
		b5.setBorderPainted(false);
		b5.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		b6.setContentAreaFilled(false);

		final JRadioButton[] v = new JRadioButton[8]; // 첫번째버튼들

		for (int i = 0; i < v.length; i++) {
			v[i] = new JRadioButton(num[i]);
			v[i].setBorderPainted(false);
			v[i].setContentAreaFilled(false);
		}

		final JRadioButton[] m = new JRadioButton[8]; // 두번째버튼

		for (int i = 0; i < m.length; i++) {
			m[i] = new JRadioButton(num[i]);
			m[i].setBorderPainted(false);
			m[i].setContentAreaFilled(false);
		}

		final JRadioButton[] z = new JRadioButton[8]; // 세번째버튼

		for (int i = 0; i < z.length; i++) {
			z[i] = new JRadioButton(num[i]);
			z[i].setBorderPainted(false);
			z[i].setContentAreaFilled(false);

		}

		final JRadioButton[] k = new JRadioButton[10]; // 금액 버튼

		for (int i = 0; i < k.length; i++) {
			k[i] = new JRadioButton(money[i]);
			k[i].setBorderPainted(false);
			k[i].setContentAreaFilled(false);
		}

		// 그룹화
		g.add(b1);
		g.add(b2);
		g.add(b3);
		g.add(b4);
		g.add(b5);
		g.add(b6);

		for (int i = 0; i < v.length; i++) {
			g1.add(v[i]);
			;

		}

		for (int i = 0; i < m.length; i++) {
			g2.add(m[i]);

		}

		for (int i = 0; i < z.length; i++) {
			g3.add(z[i]);

		}

		for (int i = 0; i < k.length; i++) {
			g4.add(k[i]);

		}

		// 버튼위치
		b1.setBounds(60, 100, 100, 30);
		b2.setBounds(90, 100, 100, 30);
		b3.setBounds(80, 100, 100, 30);
		b4.setBounds(90, 100, 100, 30);
		b5.setBounds(100, 100, 100, 30);
		b6.setBounds(110, 100, 100, 30);

		// 적용
		c.add(textLabel);
		c.add(cashlabel);
		c.add(ex);
		c.add(info);
		c.add(Output);
		c.add(panel);
		c.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);

		for (int i = 0; i < k.length; i++) {
			panel1.add(k[i]);

		}

		panel4.add(label1);
		panel4.add(label2);
		panel4.add(label3);

		panel2.add(b1);
		b1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					for (int i = 0; i < 8; i++) {
						m[i].setEnabled(false);
						z[i].setEnabled(false);
					}
				else
					for (int i = 0; i < 8; i++) {
						m[i].setEnabled(true);
						z[i].setEnabled(true);
					}
			}
		});
		panel2.add(b2);
		b2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					for (int i = 0; i < 8; i++) {
						m[i].setEnabled(false);
						z[i].setEnabled(false);
					}
				else
					for (int i = 0; i < 8; i++) {
						m[i].setEnabled(true);
						z[i].setEnabled(true);
					}
			}
		});
		panel2.add(b3);
		b3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(false);
					}
				else
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(true);
					}
			}
		});
		panel2.add(b4);
		b4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(false);
					}
				else
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(true);
					}
			}
		});
		panel2.add(b5);
		b5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(false);
					}
				else
					for (int i = 0; i < 8; i++) {
						z[i].setEnabled(true);
					}
			}
		});
		panel2.add(b6);

		for (int i = 0; i < v.length; i++) {
			panel3.add(v[i]);
		}

		for (int i = 0; i < m.length; i++) {
			panel3.add(m[i]);

		}

		for (int i = 0; i < z.length; i++) {
			panel3.add(z[i]);

		}

		setSize(800, 450);
		setVisible(true);
		Output.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int error1 = 0;
				int error2 = 1;
				int error3 = 1;

				for (int i = 0; i < 8; i++) {
					if (v[i].isSelected()) {
						horseNo[0] = Integer.parseInt(v[i].getText());
						error2 = 0;
					}

					if (m[i].isSelected()) {
						horseNo[1] = Integer.parseInt(m[i].getText());
						error2 = 0;
					}

					if (z[i].isSelected()) {
						horseNo[2] = Integer.parseInt(z[i].getText());
						error2 = 0;
					}

				}

				for (int i = 0; i < 10; i++) {
					if (k[i].isSelected()) {
						cash = money2[i];
						error3 = 0;
					}

				}
				if (cash > balance)
					error3 = 2;

				if (b1.isSelected()) {
					game = 1;// 단승
					horseNo[1] = 0;
					horseNo[2] = 0;
					if (horseNo[0] == 0)
						error2 = 1;
				} else if (b2.isSelected()) {
					game = 2;// 연승
					horseNo[1] = 0;
					horseNo[2] = 0;
					if (horseNo[0] == 0)
						error2 = 1;
				} else if (b3.isSelected()) {
					game = 3;// 복승
					horseNo[2] = 0;
					if (horseNo[0] == 0 || horseNo[1] == 0)
						error2 = 1;
				} else if (b4.isSelected()) {
					game = 4;// 쌍승
					horseNo[2] = 0;
					if (horseNo[0] == 0 || horseNo[1] == 0)
						error2 = 1;
				} else if (b6.isSelected()) {
					game = 6;// 삼복승
					if (horseNo[0] == 0 || horseNo[1] == 0 || horseNo[2] == 0)
						error2 = 1;
				} else if (b5.isSelected()) {
					game = 5;// 복연승
					horseNo[2] = 0;
					if (horseNo[0] == 0 || horseNo[1] == 0)
						error2 = 1;
				} else {
					error1 = 1;
				}
				if (error1 == 1 || error2 == 1 || error3 == 1 || error3 == 2) {
					String err = "";
					if (error1 == 1)
						err = "배팅방식을 선택해주세요.";
					else if (error2 == 1)
						err = "마번을 선택해주세요.";
					else if (error3 == 1)
						err = "금액을 선택해주세요.";
					else if (error3 == 2)
						err = "잔액이 부족합니다. 금액을 다시 선택해주세요.";
					JOptionPane.showMessageDialog(null, err, "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					balance -= cash;
					new Mato(id, cash, balance, game, horseNo[0], horseNo[1], horseNo[2]);
					setVisible(false);
				}

			}
		});

	}

	

}