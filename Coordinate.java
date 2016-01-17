
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
     */


    public Coordinate2D computeProjectedCoordinate(double initialPosition){
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        return new Coordinate2D(((x * 0.3) + (z * 0.2) + initialPosition),((y * 0.3) + (z * 0.1) + initialPosition) );
    }

}
