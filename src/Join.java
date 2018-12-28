import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Join extends JFrame {
	//회원가입 화면 
	String url = "jdbc:mysql://Mastar.c1uzyvfb0tlv.us-east-2.rds.amazonaws.com:3306/Mastar?autoReconnect=true&useSSL=false&user=Mastar&password=06231019";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	JLabel[] j;
	JLabel[] j3;
	JTextField[] tf;
	JPasswordField[] tf2;
	String[] s = { "아이디", "닉네임" };
	String[] s2 = { "비밀번호", "비밀번호 확인" };
	JButton b1, b2, b3;
	JLabel j2;
	BevelBorder border;
	int price = 10000;
	int a=3;
	String s3;
	public Join() {
		setTitle("Join us");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		j = new JLabel[2];
		j3 = new JLabel[2];
		tf = new JTextField[2];
		tf2 = new JPasswordField[2];
		for (int i = 0; i < 2; i++) {
			
			j[i] = new JLabel(s[i]);
			tf[i] = new JTextField(15);
			c.add(j[i]);
			c.add(tf[i]);
			j[i].setBounds(80, 140 + 50 * i, 110, 30);
			tf[i].setBounds(190, 140 + 50 * i, 110, 30);

		}
		for (int i = 0; i < 2; i++) {

			j3[i] = new JLabel(s2[i]);
			tf2[i] = new JPasswordField(15);
			c.add(j3[i]);
			c.add(tf2[i]);
			j3[i].setBounds(80, 140 + 50 + 50 * (i + 1), 110, 30);
			tf2[i].setBounds(190, 140 + 50 + 50 * (i + 1), 110, 30);

		}

		b3 = new JButton(new ImageIcon("ok2.png"));
		b3.setBounds(330, 140, 100, 30);
		c.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url);
					String idcheck = "select id from mastar.info";
					PreparedStatement pstmt = conn.prepareStatement(idcheck);
					ResultSet rs = pstmt.executeQuery();
					int enabled = 1;
					while (rs.next()) {
						if (rs.getString("id").equals(tf[0].getText())) { //아이디 중복확인 
							enabled=0;
							
						}
						
							
				    }
					if(enabled==0) {
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다", "Message", JOptionPane.ERROR_MESSAGE);
						a=0;
					}
					else  {
						JOptionPane.showMessageDialog(null, " 사용 가능한 아이디입니다", "Message", JOptionPane.PLAIN_MESSAGE);
						a=1;
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon j = new ImageIcon("join.png");
		JLabel join=new JLabel(j);
		c.add(join);
		join.setBounds(145, 20, 200, 70);
		
		b1 = new JButton(new ImageIcon("ok.png"));
		b1.setBounds(130, 370, 95, 40);
		c.add(b1);
		b1.addActionListener(new ActionListener() {
			String s1 = tf2[0].getText();

			String s2 = tf2[1].getText();

			// System.out.println(s1);
			public void actionPerformed(ActionEvent e) { //사용자 등록 버튼 클릭 시 등록 정보 검사 
				s3=null;
				if ((tf[0].getText() == null) || (tf[0].getText().length() == 0))
					s3="아이디를 입력하세요";
				else if ((tf[1].getText() == null) || (tf[1].getText().length() == 0))
					s3="닉네임을 입력하세요";
				else if ((tf2[0].getText() == null) || (tf2[0].getPassword().length == 0))
					s3="비밀번호를 입력하세요";
				else if (!(tf2[1].getText().equals(tf2[0].getText())) || (tf2[1].getPassword().length == 0))
					s3="비밀번호가 일치하지 않습니다.";
				else if (a!=1) {
					s3="아이디 중복확인을 하세요.";
				}
				
				
				else { //등록 정보에 문제가 없을시 데이터베이스에 사용자 등록 성공

					try {
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(url);

						stmt = conn.createStatement();
						String usemastar = "use mastar";
						stmt.executeUpdate(usemastar);
						String sql = "insert into info(id,nickname,password,balance) values('" + tf[0].getText() + "','"
								+ tf[1].getText() + "','" + tf2[0].getText() + "'," + +price + ")";
						stmt.executeUpdate(sql);
						System.out.println("사용자 등록 완료");
						dispose();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
				

				if (s3 != null) {
					JOptionPane.showMessageDialog(null, s3, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		b2 = new JButton(new ImageIcon("cancel.png"));
		MyMouseListener listener = new MyMouseListener();
	    b2.addActionListener(listener);

		b2.setBounds(260, 370, 95, 40);
		c.add(b2);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		Join join = new Join();
	}
	
	class MyMouseListener implements ActionListener { 
	      public void actionPerformed(ActionEvent e) {
	         dispose();
	      }
	   }

}
