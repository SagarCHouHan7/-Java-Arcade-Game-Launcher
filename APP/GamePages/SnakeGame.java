package APP.GamePages;
import javax.swing.*;

import APP.App;

import java.awt.*;
import java.awt.event.*;
class Fdemo extends JFrame
{
	JPdemo jp;
	Fdemo()
	{
		jp = new JPdemo();    
		add(jp);
	}
} 
class JPdemo extends JPanel  implements ActionListener, KeyListener
{
	
	ImageIcon img1,img2,img3,img4,img5;
	Image dot,head,food;
	JButton b1,back;
	int x[] = new int[100];
	int y[] = new int[100];
	int dots = 5;
	int r1=0,r2=0;
	boolean flag = false;
	Timer t;
	boolean start_game = false;
	boolean left = false, right =  true, up = false, down = false;
	JLabel out;
	int score = 0;
	Color c1 = new Color(136,136,136);
	JPdemo()
	{
				setLayout(null);
		Font f = new  Font("Elephant", Font.BOLD,30);
		
		x[0] = 200;
		y[0] = 160;
		x[1] = 180;
		y[1] = 160;
		x[2] = 160;
		y[2] = 160;
		x[3] = 140;
		y[3] = 160;
		x[4] = 120;
		y[4] = 160;
		
		b1 = new JButton("Restart");
		b1.setBounds(230,30,200,30);
		b1.setBackground(Color.YELLOW);
		b1.setFont(f);
		add(b1);
		b1.addActionListener(this);
	
		setForeground(Color.YELLOW);
		setBackground(new Color(74,74,74));
		
		img1 = new ImageIcon("APP/images/dott2.png");
		dot = img1.getImage();	
		img2 = new ImageIcon("APP/images/headd5.png");
		head = img2.getImage();
		img3 = new ImageIcon("APP/images/dott2.png");
		food = img3.getImage();		
		img4 = new ImageIcon("APP/images/back.png");
		
		back = new JButton(img4);
		back.setBounds(30,20,50,50);
		back.setBackground(new Color(153,32,86));
		add(back);
		back.addActionListener(this);
		
		t = new Timer(100,this);
		t.start();
		
		addKeyListener(this);
		
		setFocusable(true);
		
		randomdemo();

	}
	void randomdemo()
	{
		r1 = (int)Math.round(Math.random()*20+5);
		r1 = r1*20;
		r2 = (int)Math.round(Math.random()*20+5);
		r2 = r2*20;  
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

			int x1=100,y1=100;
		for(int i=1;i<26;i++){

					g.drawLine(100,x1,600,y1);
					g.drawLine(x1,100,y1,600);
					x1=x1+20;
					y1=y1+20;
		}
		
		g.drawImage(food,r1,r2,this);
		setForeground(c1);
		
		g.drawRect(100,100,500,500);
		g.drawRect(80,80,540,540);
		for(int i =0;i<dots;i++){
		
		if(i==0)			g.drawImage(head,x[i],y[i],this);
		else					g.drawImage(dot,x[i],y[i],this);
		}
		
		
		if(x[0]==80||y[0]==80||x[0]==600||y[0]==600){
			g.setFont(new Font("SAN_SERIF" , Font.BOLD,45));
			g.setColor(Color.green);
			g.drawString("GAME OVER",225,340);
			
			t.stop();
			
		}
		for(int i=3;i<dots;i++)
		{
			if(x[0]==x[i]&&y[0]==y[i])
			{
			g.setFont(new Font("SAN_SERIF" , Font.BOLD,45));
			g.setColor(Color.green);
			g.drawString("GAME OVER",225,340);
			
			t.stop();
			}
		}
				g.setFont(new Font("SAN_SERIF" , Font.ITALIC,15));
				g.setColor(Color.white);
		    	g.drawString("Score : " + score ,500,50);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1){

			restart();
		}
		if(x[0]==r1&&y[0]==r2)
		{
			dots++;
			score += 10;
			randomdemo();
		}
		if(start_game)
		{
		for(int i = dots;i>0;i--)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		if(right)			x[0] = x[0]+20;
		if(left)			    x[0] = x[0]-20;
		if(up)		     	y[0] = y[0]-20;
		if(down)			y[0] = y[0]+20;
		
		}
		
		if(e.getSource()==back)
		{
			Window win = SwingUtilities.windowForComponent(this);
            if (win != null) {
                win.dispose();
            }
            App.main(null);  
			
		}
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		start_game = true;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(right==false){
			left = true;
			right = false;
			up = false;
			down = false;
			}
		}		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(left==false){
			left = false;
			right = true;
			up = false;
			down = false;
			}
		}		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			if(down == false){
			left = false;
			right = false;
			up = true;
			down = false;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(up==false){
			left = false;
			right = false;
			up = false;
			down = true;
			}
		}
	}
	public void keyTyped(KeyEvent e){}
	public void restart()
	{
		x[0] = 200;
		y[0] = 160;
		x[1] = 180;
		y[1] = 160;
		x[2] = 160;
		y[2] = 160;
		x[3] = 140;
		y[3] = 160;
		x[4] = 120;
		y[4] = 160;
		start_game = false;
		 dots = 5;
            left = false;
			right = true;
			up = false;
			down = false;
		//	remove(out);
			randomdemo();
		score = 0;
		  	setFocusable(true);
		requestFocusInWindow();
			t.stop();
		   t.start();
		    repaint();
	}
}
public class SnakeGame
{
	public static void main(String ar[])
	{
		Fdemo f = new Fdemo();
		f.setVisible(true);
		 f.setBounds(300,35,700,690);
		
		 f.getContentPane().setBackground(new Color(153,32,86));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}