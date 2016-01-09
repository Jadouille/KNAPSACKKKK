
public class Container {
	
	private Coordinate a;
	private Coordinate b;
	private Coordinate c;
	private Coordinate d;
	private Coordinate e;
	private Coordinate f;
	private Coordinate g;
	private Coordinate h;
	private double weight;
	private double width;
	private double length;
	private double height;
	

	/** Creates a container in which parcel will be stored
	 */
	public Container( double weight, double width, double length, double height) {
		this.a = new Coordinate(0, 0, 0);
		this.b = new Coordinate(a.getX(), a.getY() + height, a.getZ());
		this.c = new Coordinate(a.getX() + length, a.getY() + height, a.getZ());
		this.d = new Coordinate(a.getX() + length, a.getY(), a.getZ());
		this.e = new Coordinate(a.getX(), a.getY() + height, a.getZ() + width);
		this.f = new Coordinate(a.getX() + length, a.getY() + height, a.getZ() + width);
		this.g = new Coordinate(a.getX(), a.getY(), a.getZ() + width);
		this.h = new Coordinate(a.getX() + length, a.getY(), a.getZ() + width);
		
		this.weight = weight;
				
		this.height = height;
		this.width = width;
		this.length = length;
		
			
	}
	
	/** Check whether a parcel is in the container or not by checking if all the corners lie in the container
	 * @param p parcel that is checked
	 * @return return true if p lies into the container, false otherwise
	 */
	public boolean liesInto(Parcel p){
		boolean a = false;
		boolean b = false;
		boolean d = false;
		boolean g = false;
		
		a = this.cornerIntoContainer(p.getA());
		b = this.cornerIntoContainer(p.getB());
		d = this.cornerIntoContainer(p.getD());
		g = this.cornerIntoContainer(p.getG());
		
		if (a == true && b == true && d == true && g == true)
			return true;
		
		return false;
		
	
		
	}
	
	/** Is the corner of a parcel in the container
	 * 
	 * @param c the corner of a parcel
	 * @return true if it lies into the container
	 */
	public boolean cornerIntoContainer(Coordinate c){
		boolean x = true;
		boolean y = true;
		boolean z = true;
		if (c.getX() < 0 || c.getX() > this.length)
			x = false;
			
		if (c.getY() < 0 || c.getY() > this.height)
			y = false;
		
		if (c.getZ() < 0 || c.getZ() > this.width)
			z = false;
		
		if (x == false && y == false && z == false)
			return false;
		
		return true;
		
		
		
	}
	
	
	
}
