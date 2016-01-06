import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import java.awt.Shape;

public class Trucks extends JComponent{
	
	private double x;
	private double y;
	private Rectangle2D.Double cabine;
	private Rectangle2D.Double remorque;
	private Ellipse2D.Double frontWheel;
	private Ellipse2D.Double firstBackWheel;
	private Ellipse2D.Double secondBackWheel;
	private Ellipse2D.Double backBackWheel;
	private Point2D.Double A;
	private Point2D.Double B;
	private Point2D.Double C;
	private Point2D.Double D;
	private Point2D.Double E;
	private Point2D.Double F;
	private Point2D.Double G;
	private Point2D.Double H;
	private Point2D.Double I;
	private Line2D.Double one;
	private Line2D.Double two;
	private Line2D.Double three;
	private Line2D.Double four;
	private Line2D.Double five;
	private Line2D.Double six;
	private Line2D.Double seven;
	private Polygon whiteSquare;
	private Shape white;
	
	
	
	
	
	
	public Trucks(double x, double y){
		this.x = x;
		this.y = y;
		cabine = new Rectangle2D.Double(this.x, this.y + 500, 200, 300);
		remorque = new Rectangle2D.Double(x + 200, y + 400, 1650, 400);
		frontWheel = new Ellipse2D.Double(x + 100, y + 800, 100, 100);
		firstBackWheel = new Ellipse2D.Double(x + 1650 , y + 800, 100, 100);
		secondBackWheel = new Ellipse2D.Double(x + 1750 , y + 800, 100, 100);
		backBackWheel = new Ellipse2D.Double(x + 1925, y + 625, 100, 100);
		A = new Point2D.Double(this.x, this.y + 500);
		B = new Point2D.Double(this.x + 75, this.y + 425);
		C = new Point2D.Double(this.x + 200, this.y + 425);
		one = new Line2D.Double(A, B);
		two = new Line2D.Double(B, C);
		D = new Point2D.Double(this.x + 200, this.y + 400);
		E = new Point2D.Double(this.x + 375, this.y +225);
		G = new Point2D.Double(this.x + 2025, this.y + 225);
		F = new Point2D.Double(this.x + 1850, this.y + 400);
		three = new Line2D.Double(D	, E);
		four = new Line2D.Double(E, G);
		five = new Line2D.Double(G, F);
		I = new Point2D.Double(this.x + 2025, this.y + 625);
		H = new Point2D.Double(this.x + 1850, this.y + 800);
		six = new Line2D.Double(G, I);
		seven = new Line2D.Double(I, H);
		whiteSquare = new Polygon();
		whiteSquare.addPoint((int) this.x + 1850, (int) this.y + 400);
		whiteSquare.addPoint((int) this.x + 2025, (int) this.y + 625);
		whiteSquare.addPoint((int) this.x + 1850, (int) this.y + 100);
		whiteSquare.addPoint((int) this.x + 2025, (int) this.y + 325);
		white = (Shape) whiteSquare;
		
		
				
		
		
		
	}
		
		
	
	public void setTruckLocation(double xCoord, double yCoord){
		this.x = xCoord;
		this.y = yCoord;
		
	}
	
	
	
	public  void draw(Graphics2D g2){
		Color darkOrange = new Color(241, 238, 244);
		Color newColor = new Color(114, 50, 114);
		
		g2.setColor(newColor);
		//g2.fill(backBackWheel);
		g2.setColor(Color.white);
		g2.fill(white);
		g2.setColor(Color.BLACK);    
		g2.draw(remorque);
		g2.draw(three);
		g2.draw(four);
		g2.draw(five);
		g2.draw(six);
		g2.draw(seven);		
		g2.setColor(darkOrange);
		g2.fill(cabine);
		
		g2.setColor(newColor);
		g2.draw(cabine);
		g2.draw(one);
		g2.draw(two);
		//g2.fill(frontWheel);
		//g2.fill(firstBackWheel);
		//g2.fill(secondBackWheel);
	}
	

	
}


