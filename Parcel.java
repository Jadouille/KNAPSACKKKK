

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
	private Coordinate[] coords = new Coordinate[8];
	

	/** creates a parcel
	 * 
	 * @param a is the coordinate of the downer left corner, the others letters are the other corners
	
	 */
	public Parcel(Coordinate a, double value, double weight, double width, double length, double height) {
		this.a = a;
		this.b = new Coordinate(a.getX(), a.getY() + height, a.getZ());
		this.c = new Coordinate(a.getX() + length, a.getY() + height, a.getZ());
		this.d = new Coordinate(a.getX() + length, a.getY(), a.getZ());
		this.e = new Coordinate(a.getX(), a.getY() + height, a.getZ() + width);
		this.f = new Coordinate(a.getX() + length, a.getY() + height, a.getZ() + width);
		this.g = new Coordinate(a.getX(), a.getY(), a.getZ() + width);
		this.h = new Coordinate(a.getX() + length, a.getY(), a.getZ() + width);

		coords[0] = a;
		coords[1] = b;
		coords[2] = c;
		coords[3] = d;
		coords[4] = e;
		coords[5] = f;
		coords[6] = g;
		coords[7] = h;
		
		this.weight = weight;
		this.value = value;
		
		this.height = height;
		this.width = width;
		this.length = length;
		
			
	}

	public Coordinate getA() {
		return a;
	}

	public Coordinate getB() {
		return b;
	}

	public Coordinate getD() {
		return d;
	}

	public Coordinate getG() {
		return g;
	}

	public Coordinate[] getCoords(){
		return coords;
	}

	public void moveToCoordinate(Coordinate coord){
		if (this.coords[0].getX() > coord.getX()) {
			int i = 0;
			while (this.coords[0].getX() > coord.getX()) {
				moveLeft();
			}
		}

		if (this.coords[0].getX() < coord.getX()) {
			int i = 0;
			while (this.coords[0].getX() > coord.getX()) {
				moveRight();
			}
		}

		if (this.coords[0].getY() > coord.getY()) {
			int i = 0;
			while (this.coords[0].getY() > coord.getY()) {
				moveDown();
			}
		}

		if (this.coords[0].getY() < coord.getY()) {
			int i = 0;
			while (this.coords[0].getY() > coord.getY()) {
				moveUp();
			}
		}

		if (this.coords[0].getZ() > coord.getZ()) {
			int i = 0;
			while (this.coords[0].getZ() > coord.getZ()) {
				moveBackward();
			}
		}

		if (this.coords[0].getZ() < coord.getZ()) {
			int i = 0;
			while (this.coords[0].getZ() > coord.getZ()) {
				moveForward();
			}
		}
	}

	public void moveDown(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setY((this.coords[i].getY()-1));
		}
	}
	public void moveUp(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setY((this.coords[i].getY()+1));
		}
	}
	public void moveRight(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setX((this.coords[i].getX()+1));
		}
	}
	public void moveLeft(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setX((this.coords[i].getX()-1));
		}
	}
	public void moveForward(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setZ((this.coords[i].getZ()-1));
		}
	}
	public void moveBackward(){
		for (int i = 0;i<this.getCoords().length;i++){
			this.coords[i].setZ((this.coords[i].getZ()+1));
		}
	}
	
	/** rotation method when the width stays the same
	  */
	public Parcel rotateWidth(){
		return new Parcel(this.a, this.value, this.weight, this.width, this.height, this.length);
	}
	
	/** rotation method when the length stays the same
	 */
	public Parcel rotateLength(){
		return new Parcel(this.a, this.value, this.weight, this.height, this.length, this.width);
	}
	
	/** Check whether the heights overlap or not
	  * @return true there is an overlap
	 */
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
	
	/** Check whether there's a width overlap 
	 * @return true if there is an overlap
	 */
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
	
	/** Check whether there's a length overlap
	 * @return true if overlap
	 */
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

	
	/** Check whether two parcels are colliding or not
	 * @return true if there is a collision
	 */
	public boolean checkCollision(Parcel p){
		boolean length = this.lengthOverlap(p);
		boolean width = this.widthtOverlap(p);
		boolean height = this.heightOverlap(p);
		
		if (length == true && width == true && height == true)
			return true;
		
		return false;
		
		
		
		
	}

	
	public static void main(String[] args){
		Parcel dawid = new Parcel(new Coordinate(0, 0, 0), 0, 0, 4, 2, 3);
		dawid.a.printCoord();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();
		System.out.println("  ");

		Projector p = new Projector(new Coordinate(5,10,5));





		//dawid = dawid.rotateLength();
		/**dawid.a.printCoord();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();*/
		
		/**dawid = dawid.rotateWidth();
		dawid.b.printCoord();
		dawid.c.printCoord();
		dawid.d.printCoord();
		dawid.e.printCoord();
		dawid.f.printCoord();
		dawid.g.printCoord();
		dawid.h.printCoord();*/
				
	}


}
	
	
	


