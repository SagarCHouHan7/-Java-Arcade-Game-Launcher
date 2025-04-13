package APP.GamePages;
import APP.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Ldemo extends JFrame
{
	JLdemo jp;
	Ldemo()
	{
		super.setTitle("Snake & Ladder");
		jp = new JLdemo();
		add(jp);
	}
}
class JLdemo extends JPanel implements ActionListener
{ 
	ImageIcon img1,img2,img3,img4,img5,img6;
	ImageIcon img7,img8,img9,img10,img11,imgback;
	
	Image swt,board,s1,start;
	Image  player1,player2,player11,player12;
	Image dice,dice1;
	
	JButton b1,b2,b3,b4,back;
	JTextField tx1,tx2,tx3;
	
	int px1 = 40;
	int py1 = 620;
	
	boolean start_game = false;
	JLdemo()
	{
		Font f = new Font("Bauhaus 93",Font.ITALIC,20);
		setBackground(Color.black);
		
		img1 = new ImageIcon("APP/images/swt.jpg");
		img2 = new ImageIcon("APP/images/board.jpg");
		img3 = new ImageIcon("APP/images/s1.png");
		img4 = new ImageIcon("APP/images/start.jpg");
		img5 = new ImageIcon("APP/images/about.gif");
		img6 = new ImageIcon("APP/images/reset.png");
		img7 = new ImageIcon("APP/images/start.gif");
		img8 = new ImageIcon("APP/images/player1.png");
		img9 = new ImageIcon("APP/images/player2.png");
		img10 = new ImageIcon("APP/images/dice.gif");
		img11 = new ImageIcon("APP/images/dice1.png");
		
		imgback = new ImageIcon("APP/images/back.png");
		back = new JButton(imgback);
		back.setBounds(50,160,50,50);
		back.setBackground(new Color(153,32,86));
		add(back);
		back.addActionListener(this);
		
		
		swt = img1.getImage();
		board = img2.getImage();
		s1 = img3.getImage();	
		start = img4.getImage();		
		
		player1 = img8.getImage();		
		player2 = img9.getImage();			
		player11 = img8.getImage();		
		player12 = img9.getImage();		
		
		dice = img10.getImage();
		dice1 = img11.getImage();
		
		setLayout(null);
		
	
		
		b2 = new JButton(img6);
		b2.setBounds(50,120,100,30);
		b2.setBackground(new Color(4,129,255));
		add(b2);
		
		tx1 = new JTextField("start game");
		tx1.setBounds(50,230,150,35);
		tx1.setBackground(Color.black);
		tx1.setForeground(Color.green);
		tx1.setFont(f);
		add(tx1);		
		
		tx2 = new JTextField("Player 1 Name");
		tx2.setBounds(50,290,150,35);
		tx2.setBackground(Color.black);
		tx2.setForeground(Color.green);
		tx2.setFont(f);
		add(tx2);	
		
		tx3 = new JTextField("Player 2 Name");
		tx3.setBounds(50,375,150,35);
		tx3.setBackground(Color.black);
		tx3.setForeground(Color.green);
		tx3.setFont(f);
		add(tx3);
		
		b3 = new JButton("Roll");
		b3.setBounds(50,500,100,30);
		b3.setForeground(Color.red);
		b3.setFont(f);
		add(b3);
		b3.addActionListener(this);
		
		b4 = new JButton(img7);
		b4.setBounds(20,560,150,60);
		b4.setForeground(Color.red);
		b4.setFont(f);
		add(b4);
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(4,129,255));
		g.fillRect(0,0,200,735);
		g.drawImage(swt,0,0,this);
		g.drawImage(board,200,0,this);
		g.drawImage(s1,920,0,this);
		g.drawImage(start,20,550,this);
		
		g.drawImage(player1,px1,py1,this);
		g.drawImage(player2,120,620,this);
		
		g.drawImage(player11,10,280,this);
		g.drawImage(player12,10,360,this);
		
		g.drawImage(dice,10,420,this);
		g.drawImage(dice1,110,430,this);
		}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b3)
		{
			start_game = true;
			int random = (int)Math.round(Math.random()*5+1);
			px1 = 140;
		   py1 = 645;
			switch(random)
			{
				case 1:
						img11 = new ImageIcon("dice1.png");
						px1+=70;
						break;
				case 2:
						img11 = new ImageIcon("dice2.png");
						px1 += 140;
						break;
				case 3:
						img11 = new ImageIcon("dice3.png");
						px1+=210;
						break;
				case 4:
						img11 = new ImageIcon("dice4.png");
						px1+=280;
						break;
				case 5:
						img11 = new ImageIcon("dice5.png");
						px1+=350;
						break;
				case 6:
						img11 = new ImageIcon("dice6.png");
						px1+=420;
						break;
			}
			dice1 = img11.getImage();
			
			repaint();
		}
		
		if(e.getSource() == back)
		{
		Window win = SwingUtilities.windowForComponent(this);
            if (win != null) {
                win.dispose();
            }
            App.main(null);  
			
		}
	}
}
public class SnakeLadder
{
	public static void main(String ar[])
	{
		Ldemo l = new Ldemo();
		l.setVisible(true);
		l.setBounds(200,0,990,735);
		 
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
