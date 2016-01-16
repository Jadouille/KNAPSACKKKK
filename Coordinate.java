
/**
 * create a system of coordinates in 3D
 */
public class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setCoord(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
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


    public void printCoord() {
        System.out.println(this.x + " " + this.y + " " + this.z);
    }

    /**
     * compute the coordinate x in 2D using Thales
     *
     * @param viewer is the coordinate in 3D from where we see the shape that's being projected
     */
    public double computeProjectedX(Coordinate viewer) {
        double vx = viewer.getX();
		double vz = viewer.getZ();
		double px = this.x;
		double py = this.y;
		double pz = this.z;

		return ((((((vz * px) - (vx * pz)) / (vz - pz))) / vz) + 5);
    }

    /**
     * compute the coordinate y in 2D using Thales
     *
     * @param viewer is the coordinate in 3D from where we see the shape that's being projected
     */
    public double computeProjectedY(Coordinate viewer) {
		double vy = viewer.getY();
		double vz = viewer.getZ();
		double px = this.x;
		double py = this.y;
		double pz = this.z;

        return ((((((vz * py) - (vy * pz)) / (vz - pz))) / vz)+ 2);
    }

}
