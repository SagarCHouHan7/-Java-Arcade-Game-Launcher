package APP;
import APP.GamePages.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class Ademo extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6;
	ImageIcon img1,img2,img3,img4,img5,img6;
	Image ticgame;
	Ademo()
	{
		setLayout(null);
		
	
		img1 = new ImageIcon("APP/images/snake.jpg");
		img2 = new ImageIcon("APP/images/wac1.png");
		img3 = new ImageIcon("APP/images/ball.png");
		img4 = new ImageIcon("APP/images/catch1.png");
		img5 = new ImageIcon("APP/images/tic1.png");
		img6 = new ImageIcon("APP/images/ladder1.png");
		
	    b1 = new JButton(img1);
		b1.setBounds(20,80,200,200);
		b1.setFont(new Font("SAN_SERIF" , Font.ITALIC, 20));
		b1.setBackground(new Color(32,200,144));
		add(b1);
		
		b1.addActionListener(this);
		
		b2 = new JButton(img2);
		b2.setBounds(240,80,200,200);
		b2.setFont(new Font("SAN_SERIF" , Font.ITALIC, 20));
		b2.setBackground(new Color(62,100,44));
		add(b2);
	
		b2.addActionListener(this);
		
		b3 = new JButton(img3);
		b3.setBounds(460,80,200,200);
		b3.setFont(new Font("SAN_SERIF" , Font.ITALIC, 20));
		b3.setBackground(new Color(32,200,144));
		add(b3);
		
		b3.addActionListener(this);
		
		b4 = new JButton(img4);
		b4.setBounds(20,360,200,200);
		b4.setFont(new Font("SAN_SERIF" , Font.BOLD, 17));
		b4.setBackground(new Color(32,200,144));
		add(b4);
		
		b4.addActionListener(this);
		
		b5 = new JButton(img5);
		b5.setBounds(240,360,200,200);
		b5.setFont(new Font("SAN_SERIF" , Font.ITALIC, 20));
		b5.setBackground(new Color(32,200,144));
		add(b5);
	
		b5.addActionListener(this);
		
		b6 = new JButton(img6);
		b6.setBounds(460,360,200,200);
		b6.setFont(new Font("SAN_SERIF" , Font.ITALIC, 20));
		b6.setBackground(new Color(32,200,144));
		add(b6);
		
		b6.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b1){
					
			SnakeGame.main(null);
			this.dispose();
		}
		if(e.getSource()==b2){
				
			HitNScore.main(null);
			this.dispose();
		}
		if(e.getSource()==b3){
				
			BreakOutBall.main(null);
			this.dispose();
		}
		if(e.getSource()==b4){
					
			CatchBall.main(null);
			this.dispose();
		}
		if(e.getSource()==b5){
				
			TicTacToe.main(null);
			this.dispose();
		}
		if(e.getSource()==b6){
				
			SnakeLadder.main(null);
			this.dispose();
		}
		
		
			
	}
} 
public class App
{
	public static void main(String ar[])
	{
		Ademo a = new Ademo();
		a.setVisible(true);
		 a.setBounds(300,35,700,690);
	   a.getContentPane().setBackground(new Color(28,43,35));
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}