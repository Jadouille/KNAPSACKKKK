import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class TruckTest extends Applet {
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Trucks one = new Trucks(50, 50);
		one.draw(g2);
		
		
	}
	
	

}