

public class Parcel {
	
	private Coordinate a;
	private Coordinate b;
	private Coordinate c;
	private Coordinate d;
	private Coordinate e;
	private Coordinate f;
	private Coordinate g;
	private Coordinate h;
	private double value;
	private double weight;
	private double width;
	private double length;
	private double height;
	

	public Parcel(Coordinate a, double value, double weight, double width, double length, double height) {
		this.a = a;
		this.b = new Coordinate(a.getX(), a.getY() + height, a.getZ());
		this.c = new Coordinate(a.getX() + length, a.getY() + height, a.getZ());
		this.d = new Coordinate(a.getX() + length, a.getY(), a.getZ());
		this.e = new Coordinate(a.getX(), a.getY() + height, a.getZ() + width);
		this.f = new Coordinate(a.getX() + length, a.getY() + height, a.getZ() + width);
		this.g = new Coordinate(a.getX(), a.getY(), a.getZ() + width);
		this.h = new Coordinate(a.getX() + length, a.getY(), a.getZ() + width);
		
		this.weight = weight;
		this.value = value;
		
		this.height = height;
		this.width = width;
		this.length = length;
		
			
	}
	
	public Parcel rotateWidth(){
		return new Parcel(this.a, this.value, this.weight, this.width, this.height, this.length);
	}
	
	public Parcel rotateLength(){
		return new Parcel(this.a, this.value, this.weight, this.height, this.length, this.width);
	}
	
	public boolean checkCollision(Parcel p){
		boolean length = this.lengthOverlap(p);
		boolean width = this.widthtOverlap(p);
		boolean height = this.heightOverlap(p);
		
		if (length == true && width == true && height == true)
			return true;
		
		return false;
		
		
		
		
	}
	
	public boolean heightOverlap(Parcel p){
		Parcel one = this;
		Parcel two = p;
		if (p.height > this.height){
			Parcel temp = two;
			two = one;
			one = temp;
		}
		
		if (two.a.getY() > one.a.getY() && two.a.getY() < one.b.getY())
			return true;
		
		else if(two.b.getY() > one.a.getY() && two.b.getY() < one.b.getY())
			return true;
		
		return false;		
		
	}
	
	public boolean widthtOverlap(Parcel p){
		Parcel one = this;
		Parcel two = p;
		if (p.width > this.width){
			Parcel temp = two;
			two = one;
			one = temp;
		}
		
		if (two.a.getZ() > one.a.getZ() && two.a.getZ() < one.b.getZ())
			return true;
		
		else if(two.b.getZ() > one.a.getZ() && two.b.getZ() < one.b.getZ())
			return true;
		
		return false;		
		
	}
	
	public boolean lengthOverlap(Parcel p){
		Parcel one = this;
		Parcel two = p;
		if (p.length > this.length){
			Parcel temp = two;
			two = one;
			one = temp;
		}
		
		if (two.a.getX() > one.a.getX() && two.a.getX() < one.b.getX())
			return true;
		
		else if(two.b.getX() > one.a.getX() && two.b.getX() < one.b.getX())
			return true;
		
		return false;		
		
	}
	
	public static void main(String[] args){
		Parcel dawid = new Parcel(new Coordinate(0, 0, 0), 0, 0, 4, 2, 3);
		/**dawid.a.printCoord();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();*/
		
		dawid = dawid.rotateLength();
		/**dawid.a.printCoord();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();*/
		
		dawid = dawid.rotateWidth();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();
				
	}
	
}
	
	
	


