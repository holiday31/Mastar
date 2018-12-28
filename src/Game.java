import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class Game extends JFrame {
	//게임 로비 화면
   JScrollPane scrollPane;
   ImageIcon back;
   JLabel imageLabel;
   JButton st, ifo, ex;
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   String name;
   int balance;
   public Game(final String id) {
      String url = "jdbc:mysql://Mastar.c1uzyvfb0tlv.us-east-2.rds.amazonaws.com:3306/Mastar?autoReconnect=true&useSSL=false&user=Mastar&password=06231019";
      setTitle("Mastar");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(null);
      c.setBackground(new Color(250, 240, 230));// 250 240 230faf0e6
      back = new ImageIcon("GameBack.jpg");

      JPanel background = new JPanel() {
         public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(back.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };
      
      scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        background.setLayout(null);
      

      Panel panel1 = new Panel();
      panel1.setBounds(0, 100, 1200, 5);
      panel1.setBackground(Color.BLACK);

      Panel panel2 = new Panel();
      panel2.setBounds(815, 0, 5, 100);
      panel2.setBackground(Color.BLACK);

      Panel panel3 = new Panel();
      panel3.setBounds(1010, 0, 5, 100);
      panel3.setBackground(Color.BLACK);

      background.add(panel1);
      background.add(panel2);
      background.add(panel3);
      try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url);
            //추가
            stmt=conn.createStatement();
            String usemastar="use mastar";
            stmt.executeUpdate(usemastar);
            String find="SELECT nickname,balance FROM info where id='" + id + "'";
            rs=stmt.executeQuery(find);
            if (rs.next()) {
               
              name = rs.getString("nickname");
              balance = rs.getInt("balance");
            }
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
      JPanel j2 = new JPanel(); // 돈 넣을 공간
      JLabel textLabel1 = new JLabel("잔액: "+balance);
      textLabel1.setFont(new Font("굴림", Font.BOLD, 20));
      JPanel j3 = new JPanel(); // 이름 넣을 공간
      JLabel textLabel2 = new JLabel("이름:"+name);
      textLabel2.setFont(new Font("굴림", Font.BOLD, 20));

      j2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
      j3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
      j2.setBackground(new Color(250, 240, 230));
      j3.setBackground(new Color(250, 240, 230));

      j2.add(textLabel1);
      j3.add(textLabel2);
      j2.setBounds(830, 23, 170, 50);
      j3.setBounds(1020, 23, 165, 50);

      background.add(j2);
      background.add(j3);

      // 버튼
      
      JButton st = new JButton(new ImageIcon("st.png")); //게임시작 버튼
      background.add(st);
      st.setBounds(830, 600, 300, 150);
    //st.setFont(new Font("굴림", Font.BOLD, 20));
      st.setBorderPainted(false);
     st.setContentAreaFilled(false);
     st.setFocusPainted(false);
     st.setOpaque(false);
    
      st.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Ticket(id,balance);
               setVisible(false);
            }
      });

      JButton ifo = new JButton(new ImageIcon("rule.png")); //게임방법 버튼
      background.add(ifo);
      ifo.setBounds(830, 300, 300, 150);
     // ifo.setFont(new Font("굴림", Font.BOLD, 20));
      ifo.setBorderPainted(false);
      ifo.setContentAreaFilled(false);
      ifo.setFocusPainted(false);
      ifo.setOpaque(false);
      
      ifo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Exp();
            }
      });
      JButton mainfo = new JButton(new ImageIcon("inf.png")); //경주마정보 버튼
      background.add(mainfo);
      mainfo.setBounds(830, 450, 300, 150);
      //mainfo.setFont(new Font("굴림", Font.BOLD, 20)); 
      mainfo.setBorderPainted(false);
      mainfo.setContentAreaFilled(false);
      mainfo.setFocusPainted(false);
      mainfo.setOpaque(false);
      
      mainfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new HorseInfo();
            }
      });
      
      JButton ex = new JButton(new ImageIcon("end.png")); //게임종료 버튼
      ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
      });
      background.add(ex);
      ex.setBounds(40, 25, 170, 50);
      //ex.setFont(new Font("굴림", Font.BOLD, 20));
      ex.setBorderPainted(false);
      ex.setContentAreaFilled(false);
      ex.setFocusPainted(false);
      ex.setOpaque(false);
      
      
      JButton charge = new JButton(new ImageIcon("ch.png")); //충전하기 버튼
      charge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, " 관리자에게 문의하세요", "Message", JOptionPane.PLAIN_MESSAGE);
            }
      });
      background.add(charge);
      charge.setBounds(220, 25, 170, 50);
      //charge.setFont(new Font("굴림", Font.BOLD, 20));
      charge.setBorderPainted(false);
      charge.setContentAreaFilled(false);
      charge.setFocusPainted(false);
      charge.setOpaque(false);
      
      
      setSize(1220, 840);
      setVisible(true);
      
      
      
         }
   
   
}