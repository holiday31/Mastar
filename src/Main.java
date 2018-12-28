import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Main extends JFrame {
	//메인화면 
   String url="jdbc:mysql://Mastar.c1uzyvfb0tlv.us-east-2.rds.amazonaws.com:3306/Mastar?autoReconnect=true&useSSL=false&user=Mastar&password=06231019";
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   JScrollPane scrollPane;
   ImageIcon icon,i;
   JLabel imageLabel;
   JButton b1,b2;
   static JTextField tf1;
   JPasswordField tf2;
   String s=null;
   public void findOne(String i,String p) throws Exception { //로그인을 위한 메소드: 데이터베이스에 연결하여 로그인
      try {
         Class.forName("com.mysql.jdbc.Driver"); 
         
         conn=DriverManager.getConnection(url);
         
         
         //추가
         stmt=conn.createStatement();
         String usemastar="use mastar";
         stmt.executeUpdate(usemastar);
         
         String findmastar="SELECT id,password,nickname,balance FROM info where id='" + i + "'";
        
         rs=stmt.executeQuery(findmastar);
         if (rs.next()) {
            
            String name = rs.getString("nickname");
            int balance = rs.getInt("balance");

            if (p.equals(rs.getString("password"))) {
               System.out.println("로그인 성공");
               new Game(tf1.getText()); //로그인 성공시 게임로비창 띄움
               setVisible(false);
          }
            else
               s="비밀번호가 올바르지 않습니다.";
          }
         else
            s="아이디,비밀번호를 다시 입력하세요.";
         if(s!=null)
         JOptionPane.showMessageDialog(null, s, "Message", JOptionPane.ERROR_MESSAGE);
      }
      
      catch(ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }
      catch(SQLException se) {
         se.printStackTrace();
      }
      finally {
         if(conn!=null) try { conn.close();} catch(SQLException se) {}
         if(stmt!=null) try { stmt.close();} catch(SQLException se) {}
         if(rs!=null) try { rs.close();} catch(SQLException se) {}
         
      }
      }

   
   public Main() {
      icon = new ImageIcon("back.jpg");
      JPanel background = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
            g.setColor(new Color(102,51,0));
            g.setFont(new Font("Arial", Font.ITALIC, 80));
            g.drawString("MASTAR", 450,100);
         }
      };
      scrollPane=new JScrollPane(background);
      setContentPane(scrollPane);
      background.setLayout(null);
      
      tf1=new JTextField("아이디",15);
      tf2=new JPasswordField("비밀번호",15);
      background.add(tf1);
      background.add(tf2);
      tf1.setBounds(450,650,180,40);
      tf2.setBounds(450,700,180,40);
      b1 = new JButton(new ImageIcon("login.png")); //로그인버튼
      b1.setBorderPainted(false);
      b1.setContentAreaFilled(false);
      b1.setFocusPainted(false);
      b1.setOpaque(false);
      
      b1.addActionListener(new ActionListener() {  //로그인버튼을 클릭시 findOne메소드를 불러와 로그인 시도
         public void actionPerformed(ActionEvent e) {

            try {
               findOne(tf1.getText(), new String(tf2.getPassword()));
            } catch (Exception e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }

         }
      });
      background.add(b1);
      b1.setBounds(640, 650, 100, 40);
      
      b2 = new JButton(new ImageIcon("join2.png")); //회원가입 버튼
      b2.setBorderPainted(false);
      b2.setContentAreaFilled(false);
      b2.setFocusPainted(false);
      b2.setOpaque(false);
      
      b2.addActionListener(new MyActionListener());// 버튼에 내부클래스 리스너로 등록

      background.add(b2);
      b2.setBounds(640, 700, 100, 40);

   }

   private class MyActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
            new Join();

      }
   }

   public static void main(String[] args) {
      
      Main main = new Main();
      main.setTitle("Mastar");
      main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      main.setSize(1200, 880);
      main.setVisible(true);
      
   }
}