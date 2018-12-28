import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;



public class Race extends JFrame {
	JLabel[] j = new JLabel[8];
	Container c = getContentPane();
	Thread th;
	int meter[] = { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000 };
	String s[] = { "1.gif", "2.gif", "3.gif", "4.gif" };
	String s2;
	static int rank[] = { 0, 0, 0 };
	int a;
	Boolean bool[] = new Boolean[8];
	int p[] = { 46, 55, 60, 40, 45, 40, 40, 61 };
	OneByThousent o[] = new OneByThousent[8];
	int flag = 1;
	int count = 0;
	int cash;
	int balance;
	int game;
	int no1;
	int no2;
	int no3;
	String id;
	private ImageIcon icon;

	public Race(String id, final int cash, final int balance, int game, int no1, int no2, int no3) {
		this.cash = cash;
		this.balance = balance;
		this.game = game;
		this.no1 = no1;
		this.no2 = no2;
		this.no3 = no3;
		this.id = id;
		setTitle("race");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("brabo.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
		}

		JLabel imgLabel = new JLabel(new ImageIcon("RaceBack.jpg"));
		imgLabel.setBounds(0, 0, 1200, 800);
		c.setLayout(null);

		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 2)
				s2 = s[2];
			else if (i == 1)
				s2 = s[0];
			else if (i == 3 || i == 4 || i == 6)
				s2 = s[3];
			else if (i == 5 || i == 7)
				s2 = s[1];
			j[i] = new JLabel("" + (i + 1), new ImageIcon(s2), SwingConstants.CENTER);
			add(j[i]);
			j[i].setBounds(0, 10 + 90 * i, 200, 100);
			o[i] = new OneByThousent(p[i]);

		}
		RaceRunnable runnable = new RaceRunnable();
		th = new Thread(runnable);
		th.start();

		c.add(imgLabel);
		setSize(1200, 800);
		setVisible(true);

	}

	class RaceRunnable implements Runnable {
		public void run() {
			int data = 0;

			while (true) {

				for (int i = 0; i < 8; i++) {
					if ((bool[i] = o[i].Get(p[i])) == true)
						a = 40;
					else
						a = 25;

					Point point = j[i].getLocation();
					if (meter[i] > 0) {
						j[i].setLocation((point.x + a), (point.y));
						meter[i] -= a;
						c.repaint();
						if (meter[i] <= 0) {
							if (count == 0)
								rank[0] = i;
							if ((count == 1) && (rank[0] != i))
								rank[1] = i;
							if ((count == 2) && (rank[0] != i) && (rank[1] != i))
								rank[2] = i;
							count++;
						}
					} else {
						flag = 0;
						System.out.println("" + (rank[0] + 1) + (rank[1] + 1) + (rank[2] + 1));
					}
					try {
						Thread.sleep(15);
						if ((flag == 0) && count == 8) {
							try {
								try {
			                           AudioInputStream ais = AudioSystem.getAudioInputStream(new File("drum.wav"));
			                           Clip clip = AudioSystem.getClip();
			                           clip.stop();
			                           clip.open(ais);
			                           clip.start();
			                        } catch (Exception ex) {
			                        }

								Thread.sleep(1000);
								new Result(id, rank[0], rank[1], rank[2], cash, balance, game, no1, no2, no3);
								dispose();
								return;
							} catch (InterruptedException e) {
								return;
							}
						}
					} catch (InterruptedException e) {
						return;
					}
				}

			}

		}
	}

	public static void main(String[] args) {

		OneByThousent o = new OneByThousent(70);
		o.print();
		

	}

}

class OneByThousent {
	Boolean array[] = new Boolean[100];
	int point = 0;

	public OneByThousent(int p) {
		for (int k = 0; k < 100; ++k)
			array[k] = false;
		for (int j = 0; j < p; j++)
			array[j] = true;
		Shuffle(p);
	}

	void Shuffle(int p) {
		for (int from = 0; from < 100; ++from) {
			int to = (int) (Math.random() * 100);
			boolean tmp = array[from];
			array[from] = array[to];
			array[to] = tmp;
		}
		point = 0;
	}

	boolean Get(int p) {
		boolean rtn = array[point];
		++point;
		if (point > 100)
			Shuffle(p);
		return rtn;
	}

	void print() {
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println((i + 1) + "번째 :" + array[i]);
			if (array[i] == true)
				count1++;
			if (array[i] == false)
				count2++;
		}
		System.out.println("true:" + count1 + ", false:" + count2);
	}

}