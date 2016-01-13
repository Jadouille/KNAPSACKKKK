

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
	private static double movingUnit = 0.5;
	

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

	public Parcel() {}


	public Coordinate getA() {
		return a;
	}

	public Coordinate getB() {
		return b;
	}

	public Coordinate getC() {
		return c;
	}

	public Coordinate getD() {
		return d;
	}

	public Coordinate getE() {
		return e;
	}

	public Coordinate getF() {
		return f;
	}

	public Coordinate getG() {
		return g;
	}

	public Coordinate getH() {
		return h;
	}

	public Coordinate[] getCoords(){
		return coords;
	}

	public double getValue() {return value;}

	public double getWeight() {return weight;}


	public double getParcelLength(){
		return this.length;
	}

	public double getParcelWidth(){
		return this.width;
	}

	public double getParcelHeight(){
		return this.height;
	}

	public void setA(double x, double y, double z){
		this.a.setX(x);
		this.a.setY(y);
		this.a.setZ(z);
	}

	public void setA(Coordinate a){
		this.a = a;
	}

	public void setB(double x, double y, double z){
		this.b.setX(x);
		this.b.setY(y);
		this.b.setZ(z);
	}

	public void setB(Coordinate b){
		this.b = b;
	}

	public void setC(double x, double y, double z){
		this.c.setX(x);
		this.c.setY(y);
		this.c.setZ(z);
	}

	public void setC(Coordinate c){
		this.c = c;
	}

	public void setD(double x, double y, double z){
		this.d.setX(x);
		this.d.setY(y);
		this.d.setZ(z);
	}

	public void setD(Coordinate d){
		this.d = d;
	}

	public void setE(double x, double y, double z){
		this.e.setX(x);
		this.e.setY(y);
		this.e.setZ(z);
	}

	public void setE(Coordinate e){
		this.e = e;
	}

	public void setF(double x, double y, double z){
		this.f.setX(x);
		this.f.setY(y);
		this.f.setZ(z);
	}

	public void setF(Coordinate f){
		this.f = f;
	}

	public void setG(double x, double y, double z){
		this.g.setX(x);
		this.g.setY(y);
		this.g.setZ(z);
	}

	public void setG(Coordinate g){
		this.g = g;
	}

	public void setH(double x, double y, double z){
		this.h.setX(x);
		this.h.setY(y);
		this.h.setZ(z);
	}

	public void setH(Coordinate h){
		this.h = h;
	}

	public void setHeight(double height){
		this.height = height;
	}

	public void setLength(double length){
		this.length = length;
	}

	public void setWidth(double width){
		this.width = width;
	}


	public void moveToCoordinate(Coordinate coord) {
		this.setA(coord);
	}

	public Parcel moveDown(){
		return new Parcel(new Coordinate(this.a.getX(), this.getA().getY()-movingUnit, this.getA().getZ()),this.value,this.weight,this.width,this.length,this.height);
	}
	public Parcel moveUp(){
		return new Parcel(new Coordinate(this.a.getX(), this.getA().getY() + movingUnit, this.getA().getZ()),this.value,this.weight,this.width,this.length,this.height);
	}
	public Parcel moveRight(){
		return new Parcel(new Coordinate(this.a.getX() + movingUnit, this.getA().getY(), this.getA().getZ()),this.value,this.weight,this.width,this.length,this.height);
	}
	public Parcel moveLeft(){
		return new Parcel(new Coordinate(this.a.getX() - movingUnit, this.getA().getY(), this.getA().getZ()),this.value,this.weight,this.width,this.length,this.height);

	}
	public Parcel moveForward(){
		return new Parcel(new Coordinate(this.a.getX(), this.getA().getY(), this.getA().getZ() - movingUnit),this.value,this.weight,this.width,this.length,this.height);

	}
	public Parcel moveBackward(){
		return new Parcel(new Coordinate(this.a.getX(), this.getA().getY(), this.getA().getZ() + movingUnit),this.value,this.weight,this.width,this.length,this.height);
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
		
		if (two.a.getZ() > one.a.getZ() && two.a.getZ() < one.g.getZ())
			return true;
		
		else if(two.g.getZ() > one.a.getZ() && two.g.getZ() < one.g.getZ())
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
		
		if (two.a.getX() > one.a.getX() && two.a.getX() < one.d.getX())
			return true;
		
		else if(two.d.getX() > one.a.getX() && two.d.getX() < one.d.getX())
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
	
	
	


