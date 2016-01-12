import java.util.ArrayList;



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
	private ArrayList<Parcel> parcels = new ArrayList<Parcel>(2);
	private static Coordinate lastEmptyCell;
	private static Coordinate previousEmptyCell;
	private int indexInTheArray = 0;

	public enum CoordinateName {
		x, y, z
	}
	

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

	public Parcel getParcel(int index){
		return parcels.get(index);
	}

	public ArrayList<Parcel> getParcels(){
		return parcels;
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

	/**public boolean addParcel(Parcel p){
		 return this.parcels.add(p);
		//this.indexInTheArray++;
	}*/
	
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

		if (!x && !y && !z)
			return false;

		return true;
	}

	public boolean putParcel(Parcel p, Coordinate coord) {
		boolean result = true;
		p.moveToCoordinate(coord);
		parcels.add(p);
		return result;
	}

	public boolean removeParcel(Parcel p) {
		boolean result = true;
		parcels.remove(p);
		return result;
	}

	public boolean checkCollision(Parcel p) {
		for (Parcel curParcel : parcels) {
			if (curParcel.checkCollision(p)) {
				return true;
			}
		}
		if (!liesInto(p)) {
			return true;
		}

		return false;
	}

	/*
	public Coordinate getFirstEmptyCoord() {
		double max = 0;
		for (Parcel parcel : parcels) {
			if (parcel.getG().getY() == 0 && parcel.getG().getZ() == 0) {}
		}
	}
	*/

	public Coordinate getFirstEmptyCell(Coordinate lastEmptyCell){
		Parcel unitCube = new Parcel(lastEmptyCell, 0, 0, 0.5, 0.5, 0.5);
		boolean collision = false;
		Coordinate returnCoord = new Coordinate(100,100,100);

		for (Parcel parcel : parcels ){
			collision = parcel.checkCollision(unitCube);
			if (collision)
				break;
		}
		if(!collision) {
			previousEmptyCell = lastEmptyCell;
			lastEmptyCell = unitCube.getA();
			return unitCube.getA();
		}
		else if(unitCube.getA().getX()<(this.length-0.5)){
			unitCube = unitCube.moveRight();
			returnCoord = getFirstEmptyCell(unitCube.getA());
			System.out.println("XMOOOVE");
		}
		else if(unitCube.getA().getZ()<(this.width-0.5)){
			unitCube = unitCube.moveBackward();
			unitCube.getA().setX(0);
			System.out.println("ZSLIDE");
			returnCoord = getFirstEmptyCell(unitCube.getA());
		}
		else if (unitCube.getA().getY()<(this.height-0.5)){
			unitCube = unitCube.moveUp();
			unitCube.getA().setX(0);
			unitCube.getA().setZ(0);
			System.out.println("YFLIED");
			returnCoord = getFirstEmptyCell(unitCube.getA());
		}
		else System.out.println("no empty cells left");
		return returnCoord;
	}


	
	
	
}
