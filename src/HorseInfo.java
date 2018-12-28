import java.util.*;
import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HorseInfo extends JFrame {

   JScrollPane scrollPane;
   ImageIcon a = new ImageIcon("말1.png");
   ImageIcon b = new ImageIcon("말2.png");
   ImageIcon c = new ImageIcon("말3.png");
   ImageIcon d = new ImageIcon("말4.png");
   ImageIcon e = new ImageIcon("말5.png");
   ImageIcon f = new ImageIcon("말6.png");
   ImageIcon i = new ImageIcon("말7.png");
   ImageIcon h = new ImageIcon("말8.png");

   ImageIcon n1 = new ImageIcon("1.png");
   ImageIcon n2 = new ImageIcon("2.png");
   ImageIcon n3 = new ImageIcon("3.png");
   ImageIcon n4 = new ImageIcon("4.png");
   ImageIcon n5 = new ImageIcon("5.png");
   ImageIcon n6 = new ImageIcon("6.png");
   ImageIcon n7 = new ImageIcon("7.png");
   ImageIcon n8 = new ImageIcon("8.png");

   Image a1 = a.getImage();
   Image b1 = b.getImage();
   Image c1 = c.getImage();
   Image d1 = d.getImage();
   Image e1 = e.getImage();
   Image f1 = f.getImage();
   Image i1 = i.getImage();
   Image h1 = h.getImage();

   Image N1 = n1.getImage();
   Image N2 = n2.getImage();
   Image N3 = n3.getImage();
   Image N4 = n4.getImage();
   Image N5 = n5.getImage();
   Image N6 = n6.getImage();
   Image N7 = n7.getImage();
   Image N8 = n8.getImage();

   public HorseInfo() {

      setContentPane(new MyPaner());

      Container c = getContentPane();
      c.setLayout(null);
      c.setBackground(new Color(247, 247, 247));
      setTitle("경주마 정보");
      setSize(1200, 850);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      // 버튼

      JButton b1 = new JButton(new ImageIcon("감격의순간.png"));
      b1.setBounds(80, 280, 185, 40);
      b1.setBorderPainted(false);
      b1.setContentAreaFilled(false);
      b1.setFocusPainted(false);
      b1.setOpaque(false);
      add(b1);

      JButton b2 = new JButton(new ImageIcon("황운골.png"));
      b2.setBounds(365, 280, 185, 40);
      b2.setBorderPainted(false);
      b2.setContentAreaFilled(false);
      b2.setFocusPainted(false);
      b2.setOpaque(false);
      add(b2);

      JButton b3 = new JButton(new ImageIcon("피케이파티.png"));
      b3.setBounds(650, 280, 185, 40);
      b3.setBorderPainted(false);
      b3.setContentAreaFilled(false);
      b3.setFocusPainted(false);
      b3.setOpaque(false);
      add(b3);

      JButton b4 = new JButton(new ImageIcon("가을의전설.png"));
      b4.setBounds(920, 280, 185, 40);
      b4.setBorderPainted(false);
      b4.setContentAreaFilled(false);
      b4.setFocusPainted(false);
      b4.setOpaque(false);
      add(b4);

      JButton b5 = new JButton(new ImageIcon("싱그러운검.png"));
      b5.setBounds(80, 690, 185, 40);
      b5.setBorderPainted(false);
      b5.setContentAreaFilled(false);
      b5.setFocusPainted(false);
      b5.setOpaque(false);
      add(b5);

      JButton b6 = new JButton(new ImageIcon("와일드선더.png"));
      b6.setBounds(365, 690, 185, 40);
      b6.setBorderPainted(false);
      b6.setContentAreaFilled(false);
      b6.setFocusPainted(false);
      b6.setOpaque(false);
      add(b6);

      JButton b7 = new JButton(new ImageIcon("상감마마.png"));
      b7.setBounds(650, 690, 185, 40);
      b7.setBorderPainted(false);
      b7.setContentAreaFilled(false);
      b7.setFocusPainted(false);
      b7.setOpaque(false);
      add(b7);

      JButton b8 = new JButton(new ImageIcon("수성챔프.png"));
      b8.setBounds(920, 690, 185, 40);
      b8.setBorderPainted(false);
      b8.setContentAreaFilled(false);
      b8.setFocusPainted(false);
      b8.setOpaque(false);
      add(b8);

      JButton button = new JButton("종료");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      button.setBounds(550, 760, 117, 29);
      add(button);

      ////////////////////////////////// 버튼클릭 이벤트/////////////////////////////////

      ActionListener eventHandler = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
               System.out.printf("버튼1");
               new horse1();
            } else if (e.getSource() == b2) {
               System.out.printf("버튼2");
               new horse2();
            } else if (e.getSource() == b3) {
               System.out.printf("버튼3");
               new horse3();
            } else if (e.getSource() == b4) {
               System.out.printf("버튼4");
               new horse4();

            } else if (e.getSource() == b5) {
               System.out.printf("버튼5");
               new horse5();
            } else if (e.getSource() == b6) {
               System.out.printf("버튼6");
               new horse6();
            } else if (e.getSource() == b7) {
               System.out.printf("버튼7");
               new horse7();
            } else if (e.getSource() == b8) {
               System.out.printf("버튼8");
               new horse8();

            }

         }
      };

      b1.addActionListener(eventHandler);
      b2.addActionListener(eventHandler);
      b3.addActionListener(eventHandler);
      b4.addActionListener(eventHandler);
      b5.addActionListener(eventHandler);
      b6.addActionListener(eventHandler);
      b7.addActionListener(eventHandler);
      b8.addActionListener(eventHandler);

      setSize(1200, 880);// 창크기
      setVisible(true);

   }

   class MyPaner extends JPanel {

      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         g.drawImage(a1, 50, 50, 280, 220, this);
         g.drawImage(b1, 50, 450, 280, 220, this);
         g.drawImage(c1, 330, 50, 280, 220, this);
         g.drawImage(d1, 330, 450, 280, 220, this);
         g.drawImage(e1, 610, 50, 280, 220, this);
         g.drawImage(f1, 610, 450, 280, 220, this);
         g.drawImage(i1, 893, 50, 230, 220, this);
         g.drawImage(h1, 893, 450, 230, 220, this);

         g.drawImage(N1, 10, 5, 30, 40, this);
         g.drawImage(N2, 330, 5, 30, 40, this);
         g.drawImage(N3, 610, 5, 30, 40, this);
         g.drawImage(N4, 893, 5, 30, 40, this);
         g.drawImage(N5, 10, 430, 30, 40, this);
         g.drawImage(N6, 330, 430, 30, 40, this);
         g.drawImage(N7, 610, 430, 30, 40, this);
         g.drawImage(N8, 893, 430, 30, 40, this);

      }
   }

   public static void main(String[] args) {

      new HorseInfo();

   }

}