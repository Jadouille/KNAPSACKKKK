
/** create a system of coordinates in 3D */
public class Coordinate {
	private int x;
	private int y;
	private int z;

	public Coordinate (int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setCoord(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getZ(){
		return this.z;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;		
	}
	
	public void setZ(int z){
		this.z = z;
	}

	public int hashCode() {
		return x * 10000000 + y * 100000 + z * 100000;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		// object must be Test at this point
		Coordinate coord = (Coordinate) obj;
		return x == coord.x && y == coord.y && z == coord.z;
	}


	public void printCoord(){
		System.out.println(this.x + " " + this.y + " " + this.z);
	}

	/** compute the coordinate x in 2D using Thales
	 * 
	 * @param viewer is the coordinate in 3D from where we see the shape that's being projected
	 */
	public double computeProjectedX(Coordinate viewer){
		return (((((viewer.z * this.x)-(viewer.x * this.z))/(viewer.z - this.z)))/viewer.z);
	}

	/** compute the coordinate y in 2D using Thales
	 * 
	 * @param viewer is the coordinate in 3D from where we see the shape that's being projected
	 */
	public double computeProjectedY(Coordinate viewer){
		return (((((viewer.z * this.y)-(viewer.y * this.z))/(viewer.z - this.z)))/viewer.z);
	}

}
