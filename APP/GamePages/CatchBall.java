package APP.GamePages;
import APP.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Cdemo extends JFrame
{
	CPdemo cp;
	Cdemo()
	{
		cp = new CPdemo();
		add(cp);
	}
}
class CPdemo extends JPanel implements KeyListener, ActionListener
{
	
	//setLayout(null);
	int width = 80;
	int hight = 30;
	int posx = 300;
	int randomx = 340;
	int fixy = 55;
	
	int score = 0;
	int lifes = 3;
	ImageIcon img1 , img2;
	Image heart;
	JButton back;
	Timer t;
	CPdemo()
	{
		//setColor(Color.black);
		setBackground(new Color(54,184,100));
		addKeyListener(this);
		 setFocusable(true);
		 setLayout(null);
        setFocusTraversalKeysEnabled(false);
		
		img1 = new ImageIcon("APP/images/heart.png");
		 heart = img1.getImage();
		img2 = new ImageIcon("APP/images/back.png");
		
		 back = new JButton(img2);
		back.setBounds(0,0,50,50);
		back.setBackground(new Color(153,32,86));
		add(back);
		back.addActionListener(this);
		
		t = new Timer(50,this);

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(0,0,700,50);
		
		g.setColor(Color.white);
		g.setFont(new Font("SAN_SERIF" , Font.BOLD,20));
		g.drawString("Score : " +score, 550, 30);
		int x = 60;
		for(int i = 0; i<lifes ; i++)
		{
			g.drawImage(heart,x,10,this);
			x += 35;
		}
		
		g.setColor(Color.red);
		g.fillOval(randomx, fixy , 20,20);
		//Random();
		
		g.setColor(Color.yellow);
		g.fillRect(posx,570,width,hight);
		
		
		
		if(lifes == 0){
			g.setColor(Color.red);
			g.setFont(new Font("SAN_SERIF" , Font.BOLD,45));
			g.drawString("GAME OVER " ,200, 300);
			g.setColor(Color.black);
			g.setFont(new Font("SAN_SERIF" , Font.BOLD,25));
			g.drawString("Score :  " +score, 260, 350);
			g.setFont(new Font("SAN_SERIF" , Font.BOLD,20));
			g.drawString("press Enter to restart" ,240, 380);
			t.stop();
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		t.start();
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(posx > 0 )
			{
				posx-=15;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(posx <600 )
			{
				posx+=15;
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			lifes = 3;
			 randomx = 340;
			fixy = 55;
			score = 0;
	      t.start();
	      requestFocusInWindow();
	      setFocusable(true);
			
		}
		
		
		
		repaint();
	}
	public void keyTyped(KeyEvent e){}
	
	public void actionPerformed(ActionEvent e)
	{
		fixy += 15;
		
		if(new Rectangle(posx,570,width,hight).intersects(new Rectangle(randomx, fixy , 20,20)))
		{
			Random();
			fixy = 55;
			score += 10;
		}
		
		if(fixy >= 690){
			Random();
			fixy = 55;
			lifes--;
		}
		
		if(e.getSource() == back)
		{
			Window win = SwingUtilities.windowForComponent(this);
            if (win != null) {
                win.dispose();
            }
			App.main(null);
		}
		repaint();
	}
	
	public void Random(){
		randomx = (int)Math.round(Math.random()*600+10);
	}
}
public class CatchBall

{
	public static void main(String ar[])
	{
		Cdemo c = new Cdemo();
		c.setVisible(true);
		c.setBounds(300,35,700,690);
	   c.getContentPane().setBackground(new Color(67,30,87));
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}