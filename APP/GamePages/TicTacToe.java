package APP.GamePages;
import APP.App;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Tdemo extends JFrame implements ActionListener
{
	JButton b1[] = new JButton[9];
	JButton back;
	ImageIcon imgback;
	JLabel u1,u2,u3,u4,u5;
	int c = 1;
	Tdemo()
	{
		setLayout(null);
		setTitle("   TIC TAC TOE");
		Font f = new Font("Elephant" , Font.BOLD,29);
		
		
		

		u1 = new JLabel("  TIC   TAC   TOE");
		u1.setBounds(220,100,255,45);
		u1.setBackground(new Color(85,0,86));
		u1.setFont(new Font("Elephant" , Font.BOLD,23));
		add(u1);	
		u1.setForeground(Color.black);
		
		
		
		u2 = new JLabel("  O IS WINNER!!!  ");
		u2.setBounds(460,600,255,45);
		u2.setBackground(new Color(36,49,64));
		u2.setForeground(Color.GREEN);
		
		u3 = new JLabel("  X IS WINNER!!!  ");
		u3.setBounds(460,600,255,45);
		u3.setBackground(new Color(36,49,64));
		u3.setForeground(Color.GREEN);
		
		u4 = new JLabel("  Board Full!!!  ");
			u4.setBounds(460,600,255,45);
		u4.setBackground(new Color(36,49,64));
		u4.setForeground(Color.GREEN);
		
		imgback = new ImageIcon("APP/images/back.png");
		back = new JButton(imgback);
		back.setBounds(30,20,50,50);
		back.setBackground(new Color(153,32,86));
		add(back);
		back.addActionListener(this);
		
		int x = 180,y=180;
		int i,j,k=0;
		for(i=1;i<=3;i++){
			for(j=1;j<=3;j++){
				b1[k] = new JButton(" ");
				b1[k].setSize(100,100);
				b1[k].setLocation(x,y);
				b1[k].setBackground(new Color(148,148,148));
				b1[k].setFont(f);
				add(b1[k]);
				b1[k].addActionListener(this);
				k++;
				x+=110;    
					}
					y+=110;
					x = 180;
		}
		
  }
		
		public void actionPerformed(ActionEvent e)
		{
			JButton b =  (JButton)e.getSource();
			b.setForeground(Color.white);
			if(c%2==1){
				
				b.setText("O");
			}
			else{
				b.setText("X");
			}
			c++;
			b.removeActionListener(this);
			
			if(c>=5)
			{
				if(c%2==1 && win() ){
					add(u2);
						for(int i=0;i<8;i++){
							b.removeActionListener(this);
					}
				}
				
				if(c%2==0 && win()){
					add(u3);
					System.out.println("00000000");
						for(int i=0;i<8;i++){
							b.removeActionListener(this);
					}
				}
				
			}
			
			if(c==8)
			{
				add(u4);
				for(int i=0;i<8;i++){
							b.removeActionListener(this);
					}
			}
			
			if(e.getSource() == back)
			{
				Window won = SwingUtilities.windowForComponent(this);
             if (won != null) {
                won.dispose();
            }
            App.main(null);  
				
			}
		}
			
			public boolean win()
			{
				for(int i=0;i<3;i++)
				{
					if(b1[i*3].getText().equals(b1[i*3+1].getText()) && b1[i*3+1].getText().equals(b1[i*3+2].getText()) && !b1[i*3].getText().equals(""))
					{
						System.out.println("7854536845315");
						return true;
					}
					
					if(b1[i].getText().equals(b1[i+3].getText() )&& b1[i+3].getText().equals(b1[i+6].getText())&& !b1[i].getText().equals("")){
						System.out.println("7854536845315");
						return true;
					}
					}
					
					if(b1[0].getText().equals(b1[4].getText()) && b1[4].getText().equals(b1[8].getText())&& !b1[0].getText().equals(""))			return true;
					if(b1[2].getText().equals(b1[4].getText()) && b1[4].getText().equals(b1[6].getText())&& !b1[2].getText().equals(""))		return true;
					
					return false;
			}
}
public class TicTacToe{
	public static void main(String ar[])
	{
		Tdemo t = new Tdemo();
		t.setVisible(true);
		t.setVisible(true);
		 t.setBounds(300,35,700,690);
		 t.getContentPane().setBackground(new Color(36,49,64));
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
  }
