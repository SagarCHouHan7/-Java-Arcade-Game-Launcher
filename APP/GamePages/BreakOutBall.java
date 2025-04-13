package APP.GamePages;
import APP.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class gameplay extends JPanel implements KeyListener, ActionListener
{
ImageIcon img4;
JButton back;
	boolean play = false;
	int score = 0;
	
	int totalBricks = 21;
	
	Timer timer;
	int delay = 2;
	int playerX = 310;
	
	int ballposX = 120;
	int ballposY = 350;
	int ballXdir = -1;
	int ballYdir = -2;
	mapegenerator map;
	gameplay()
	{
		map = new mapegenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		img4 = new ImageIcon("APP/images/back.png");
		
		back = new JButton(img4);
		back.setBounds(30,640,50,50);
		back.setBackground(new Color(153,32,86));
		add(back);
		
		back.addActionListener(this);
		
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		//background
		setBackground(Color.black);
		g.fillRect(1,1,692,592);
		
		//drawing map
		map.draw((Graphics2D)g);
		//boaders
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
		// score
		g.setColor(Color.white);
		g.setFont(new Font("serif" , Font.BOLD , 25));
		g.drawString(""+score, 590, 30);
		
		//paddel
		g.setColor(Color.green);
		g.fillRect(playerX,550,100,8);
		
		//ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20,20);
		
		if(totalBricks <=0)
		{
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif" , Font.BOLD , 30));
			g.drawString("YOU WON  , Score : " +score , 190,300);
			
				g.setFont(new Font("serif" , Font.BOLD , 20));
			g.drawString("Press up to Return main menu  ", 230,350);
		}
		if(ballposY > 570)
		{
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif" , Font.BOLD , 30));
			g.drawString("GAME OVER  , Score : " +score , 190,300);
			
				g.setFont(new Font("serif" , Font.BOLD , 20));
			g.drawString("Press enter to Restart ", 230,350);
			g.drawString("Press up to Return main menu ", 230,390);
			
			add(back);
		}
		g.dispose();
			
	}
	
	public void actionPerformed(ActionEvent e)
	{
		timer.start();
		
		if(play)
		{
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
			{
				ballYdir = -ballYdir;
			}
			
		A :
		for(int i =0;i<map.map.length;i++){
				for(int j = 0 ; j<map.map[0].length;j++){
					if(map.map[i][j] > 0)
					{
							int brickX = j* map.brickWitdth + 80;
							int brickY = i* map.brickHeight + 50;
							int brickWitdth = map.brickWitdth;
							int brickHeight = map.brickHeight;
							
							Rectangle rect = new Rectangle(brickX, brickY, brickWitdth , brickHeight);
							Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
							Rectangle brickRect = rect;
							
							if(ballRect.intersects(brickRect))
							{
							 map.setBrickValue(0, i , j);
	
								totalBricks--;
								score += 5;
								
								if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
									ballXdir = -ballXdir;
								}
								else {
									ballYdir = - ballYdir;
								}
								break A;
							}
					}
				}
			}
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX<0)				ballXdir = -ballXdir;
			if(ballposY<0)				ballYdir = -ballYdir;
			if(ballposX>670)				ballXdir = -ballXdir;
		}
		
		if(e.getSource()==back)
		{
			System.out.println("10000000000001");
			App.main(null);
		}
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			
			if(playerX >= 600){		
						playerX = 600;
			}
			else {
				moveRight();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			
			if(playerX <= 10)
			{				
							playerX = 10;
			}
			else {
				moveLeft();
			}
		}
		
				if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			
		
		Window win = SwingUtilities.windowForComponent(this);
            if (win != null) {
                win.dispose();
            }
            App.main(null);  
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			
			if(!play)
			{
				play = true;
				 ballposX = 120;
				ballposY = 350;
				ballXdir = -1;
				ballYdir = -2;
				
				playerX = 310;
				score = 0;
				totalBricks = 21;
				map = new mapegenerator(3,7);
				repaint();
			}
		}
	}
	public void keyTyped(KeyEvent e){}
	
	public void moveRight()
	{
		play = true;
		playerX += 20;
	}
	public void moveLeft()
	{
		play = true;
		playerX -= 20;
	}
}

class mapegenerator
{
	int map[][];
	int brickWitdth;
	int brickHeight;
	mapegenerator(int row,int col)
	{
		map = new int[row][col];
		for(int i = 0; i<map.length;i++){
			for(int j = 0; j<map[i].length;j++){
				map[i][j] = 1;
			}
		}
		brickWitdth = 540/col;
		brickHeight = 150/row;
	}
	public void draw(Graphics2D g)
	{
		for(int i = 0; i<map.length;i++){
			for(int j = 0; j<map[i].length;j++){
				if(map[i][j] > 0){
					g.setColor(Color.white);
					g.fillRect(j*brickWitdth+80 , i*brickHeight+50 , brickWitdth , brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWitdth+80 , i*brickHeight+50 , brickWitdth , brickHeight);
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row , int col)
	{
		map[row][col] = value;
	}
	
}
public class BreakOutBall{
	public static void main(String ar[])     
	{
		  JFrame obj = new JFrame();
		  gameplay gamePlay = new gameplay();
		  obj.setBounds(300,35,710,690);
		  obj.setTitle("Breakout Ball");
		  obj.setVisible(true);
		  obj.setResizable(false);
		  obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  obj.add(gamePlay);
		  obj.addKeyListener(gamePlay);
	}
}
