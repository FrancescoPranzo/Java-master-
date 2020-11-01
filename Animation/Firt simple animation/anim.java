import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//outer class
public class anim { 
	int x = 70;
	int y = 70;
	public static void main(String[] args) { 
		anim gi = new anim();
		gi.go();
	}
	
	JFrame jf = new JFrame();
	//JButton bt1 = new JButton();
	//JButton bt2 = new JButton();
	
	//graphics object
	MyDrawPanel mp = new MyDrawPanel();
	public void go() { 
		
		jf.setVisible(true);
		jf.setSize(300,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().add(mp);	
		for (int i=71;i<=130;i++) { 
			x ++;
			y ++;
			
			mp.repaint();
			try {
				Thread.sleep(50);
			}
			catch (Exception ex) { }
	
		}
		
		
			
	}
  	//inner class
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) { 
			g.setColor(Color.red);
			g.fillOval(x,y,40,40);
		}
		
	}//end of the inner class
}//end of the outer class
