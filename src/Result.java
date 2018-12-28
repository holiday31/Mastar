import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Result extends JFrame {

   private Panel panel = new Panel();
   String rank1;
   String rank2;
   String rank3;
   String s[] = { "감격의순간", "황운골", "피케이파티", "가을의전설", "싱그러운검", "와일드선더", "상감마마", "수성챔프" };
   String s2[] = { "단승", "연승", "복승", "쌍승", "복연승", "삼복승" };
   String s3[] = { "말1.png", "말3.png", "말5.png", "말7.png", "말2.png", "말4.png", "말6.png", "말8.png" };
   double rate[][]= {{ 8.24, 1.83, 13.14, 32.96, 4.12, 27.46 },{ 6.60, 1.22, 8.22, 26.4, 3.3, 22 },{ 4.28, 1, 7.5, 17.12, 2.14, 14.26 },
         { 10, 2.5, 19.98, 40, 5, 33.33 },{ 8.49, 1.54, 10.2, 33.96, 4.23, 28.3 },{ 10, 1.42, 15, 17.04, 5, 33.33 },{ 9.74, 2.36, 17.34, 38.96, 4.87, 32.46 },
          { 4.20, 1.16, 8.4, 16.8, 2.1, 14 } };
   String url = "jdbc:mysql://Mastar.c1uzyvfb0tlv.us-east-2.rds.amazonaws.com:3306/Mastar?autoReconnect=true&useSSL=false&user=Mastar&password=06231019";
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   int cash;
   int balance;
   int game;
   int no1, no2,no3;
   int r1, r2,r3;
   int bet=0;
   String id;
   public Result(String id,int r1, int r2, int r3, int cash, int balance, int game, int no1, int no2, int no3) {
	   setTitle("경기 결과");
	   this.cash = cash;
      this.balance = balance;
      this.game = game;
      this.no1 = no1;
      this.no2 = no2;
      this.no3 = no3;
      this.r1 = r1;
      this.r2 = r2;
      this.r3 = r3;
      this.id=id;
      for (int i = 0; i < 8; i++) {
         if (r1 == i)
            rank1 = s[i];
         if (r2 == i)
            rank2 = s[i];
         if (r3 == i)
            rank3 = s[i];
      }
      if(game==1) {
          if(r1==(no1-1)) {
             bet=(int)(cash*rate[no1-1][0]);
             balance+=bet;
          }
       }
          
       else if(game==2) {
          if(((no1-1)==r1)||((no1-1)==r2)||((no1-1)==r3) ) {
             bet=(int)(cash*rate[no1-1][1]);
              balance+=bet;
          }
       }
       else if(game==3) {
          if((((no1-1)==r1)&&((no2-1)==r2))||((no1-1)==r2&&((no2-1)==r1))) {
             bet=(int)(cash*rate[no1-1][2]);
              balance+=bet;
          }
       }
       else if(game==4)
       {
          if((((no1-1)==r1)&&((no2-1)==r2))) {
             bet=(int)(cash*((rate[no1-1][3]+rate[no2-1][3])/2));
              balance+=bet;
          }
       }
          
       else if(game==5)
       {
          if((((no1-1)==r1)||((no1-1)==r2)||((no1-1)==r3))&&(((no2-1)==r1)||((no2-1)==r2)||((no2-1)==r3))) {
             bet=(int)(cash*((rate[no1-1][4]+rate[no2-1][4])/2));
              balance+=bet;
          }
       }
       else if(game==6) {
          if((((no1-1)==r1)||((no1-1)==r2)||((no1-1)==r3))&&
           (((no2-1)==r1)||((no2-1)==r2)||((no2-1)==r3))&&
           (((no3-1)==r1)||((no3-1)==r2)||((no3-1)==r3)))
          {
             bet=(int)(cash*((rate[no1-1][5]+rate[no2-1][5]+rate[no3-1][5])/3));
              balance+=bet;
          }
       }
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url);

         stmt = conn.createStatement();
         String usemastar = "use mastar";
         stmt.executeUpdate(usemastar);
         String sql = "UPDATE info SET balance = "+balance+ " WHERE id ='"+id+"'"; 
         stmt.executeUpdate(sql);
            
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
      
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(panel);
      panel.setLayout(null);
      setSize(1200, 880);
      panel.setBackground(Color.white);
      
      
      JButton Back = new JButton(new ImageIcon("return.png")); //돌아가기 버튼
         Back.setBounds(930, 10, 180, 80);
      //   Back.setFont(new Font("KoreanAMERIB", Font.PLAIN, 25));
         Back.setBorderPainted(false);
         Back.setContentAreaFilled(false);
         Back.setFocusPainted(false);
         Back.setOpaque(false);
         
         panel.add(Back);
         Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Game(id);
               dispose();
            }
      });
       
        
      setVisible(true);
      

   }

   class Panel extends JPanel {
      private ImageIcon Rback2 = new ImageIcon("Rback2.jpg");
      private Image rback2 = Rback2.getImage(); // 이미지 객체
      private ImageIcon line = new ImageIcon("line.png");
      private Image Line = line.getImage(); // 이미지 객체
      private ImageIcon st1 = new ImageIcon("1st.png");
      private Image St1 = st1.getImage(); // 이미지 객체
      private ImageIcon st2 = new ImageIcon("2st.png");
      private Image St2 = st2.getImage(); // 이미지 객체
      private ImageIcon st3 = new ImageIcon("3st.png");
      private Image St3 = st3.getImage(); // 이미지 객체

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(rback2, 0, 100, 850, 770, this);
         g.drawImage(Line, 850, 100, 333, 240, this);
         g.drawImage(Line, 850, 340, 333, 240, this);
         g.drawImage(Line, 850, 580, 333, 253, this);

         g.drawImage(St1, 5, 2, 90, 95, this);
         g.drawImage(St2, 280, 2, 90, 95, this);
         g.drawImage(St3, 580, 2, 90, 95, this);

         g.drawImage(new ImageIcon(s3[r1]).getImage(), 270, 300, 500, 500, this);

         g.setFont(new Font("맑은고딕", Font.ITALIC, 30));
         g.drawString((r1+1)+" "+rank1, 95, 60);
         g.drawString((r2+1)+" "+rank2, 380, 60);
         g.drawString((r3+1)+" "+rank3, 680, 60);

         g.drawString("선택한 마번", 930, 140);
         g.drawString("경기종류", 950, 390);
         g.drawString("배팅금액", 950, 615);
         g.drawString("결과금액", 950, 730);
         g.drawString("1번말:  " + no1, 930, 180);
         if(no2!=0)
         g.drawString("2번말:  " + no2, 930, 230);
         if(no3!=0)
         g.drawString("3번말:  " + no3, 930, 280);
         g.drawString(s2[game - 1], 970, 470);
         g.drawString("" + cash, 970, 670);
         g.drawString(bet+"", 970, 780);
         g.setColor(new Color(0, 0, 170));
         // g.drawLine(850, 100, 850, 880); // 선그리기
         // g.drawLine(0, 100, 1200, 100);
         // g.drawLine(850, 340, 1200, 340);
         // g.drawLine(850, 580, 1200, 580);
         g.drawLine(857, 700, 1175, 700);

      }
   }

  

}