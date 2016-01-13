
/** create a system of coordinates in 3D */
public class Coordinate {
	private double x;
	private double y;
	private double z;
	
	public Coordinate (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setCoord(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;		
	}
	
	public void setZ(double z){
		this.z = z;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}
	
	public void printCoord(){
		System.out.println(this.x + " " + this.y + " " + this.z);
	}

	public Coordinate addCoordinates(Coordinate plus){
		this.x = this.x + plus.x;
		this.y = this.y + plus.y;
		this.z = this.z + plus.z;
		return this;
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
