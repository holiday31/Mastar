import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class Mato extends JFrame {

   public Mato(final String id, final int cash, final int balance, final int game, final int no1, final int no2,
         final int no3) {
      String s[] = { "단승", "연승", "복승", "쌍승", "복연승", "삼복승" };
      JPanel c;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 550, 400);
      c = new JPanel();
      c.setBackground(Color.WHITE);
      c.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(c);
      c.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBackground(Color.BLACK);
      panel.setForeground(new Color(0, 0, 0));
      panel.setBounds(0, 80, 550, 4);
      c.add(panel);

      JPanel panel_1 = new JPanel();
      panel_1.setBackground(Color.BLACK);
      panel_1.setBounds(0, 280, 550, 4);
      c.add(panel_1);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(Color.BLACK);
      panel_2.setBounds(0, 150, 550, 1);
      c.add(panel_2);
      
      JPanel panel_3 = new JPanel();
      panel_3.setBackground(Color.BLACK);
      panel_3.setBounds(150, 80, 1, 200);
      c.add(panel_3);
      
      JPanel panel_4 = new JPanel();
      panel_4.setBackground(Color.BLACK);
      panel_4.setBounds(265, 80, 1, 200);
      c.add(panel_4);
      
      JPanel panel_5 = new JPanel();
      panel_5.setBackground(Color.BLACK);
      panel_5.setBounds(400, 80, 1, 200);
      c.add(panel_5);

      JLabel lblNewLabel = new JLabel("MASTAR");
      lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
      lblNewLabel.setBounds(180, 20, 200, 50);
      c.add(lblNewLabel);

      JLabel label = new JLabel("경기 종류");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      label.setBounds(27, 100, 100, 26);
      c.add(label);

      JLabel label_1 = new JLabel("금액");
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      label_1.setBounds(183, 100, 51, 26);
      c.add(label_1);

      JLabel label_2 = new JLabel("마번");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      label_2.setBounds(297, 100, 74, 26);
      c.add(label_2);

      JLabel label_3 = new JLabel("계");
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
      label_3.setBounds(454, 100, 24, 26);
      c.add(label_3);

      JButton btnStart = new JButton(new ImageIcon("strt.png")); //게임시작 버튼
      //btnStart.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
      btnStart.setBorderPainted(false);
      btnStart.setContentAreaFilled(false);
      btnStart.setFocusPainted(false);
      btnStart.setOpaque(false);
         
      btnStart.setBounds(361, 295, 163, 55);
      c.add(btnStart);
      btnStart.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new Race(id, cash, balance, game, no1, no2, no3);
            dispose();
         }
      });
      JButton btnBack = new JButton(new ImageIcon("retn.png")); //돌아가기 버튼
      //btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
      btnBack.setBorderPainted(false);
      btnBack.setContentAreaFilled(false);
      btnBack.setFocusPainted(false);
      btnBack.setOpaque(false);
      
      btnBack.setBounds(30, 295, 163, 55);
      c.add(btnBack);
      btnBack.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new Ticket(id, balance + cash);
            dispose();
         }
      });

      JLabel lblNewLabel_1 = new JLabel("" + s[game - 1]);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(20, 201, 95, 25);
      c.add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("" + cash);
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setBounds(160, 200, 95, 25);
      c.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("1번 마:" + no1);
      JLabel lblNewLabel_3_2 = new JLabel("2번 마:" + no2);
      JLabel lblNewLabel_3_3 = new JLabel("3번 마:" + no3);
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_3.setBounds(280, 170, 95, 25);
      lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_3_2.setBounds(280, 196, 95, 25);
      lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_3_3.setBounds(280, 220, 95, 25);
      c.add(lblNewLabel_3);
      c.add(lblNewLabel_3_2);
      c.add(lblNewLabel_3_3);

      JLabel lblNewLabel_4 = new JLabel("" + cash);
      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_4.setBounds(420, 200, 95, 25);
      c.add(lblNewLabel_4);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   /**
    * Launch the application.
    */
  
 

}