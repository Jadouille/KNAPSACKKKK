import java.math.BigDecimal;

/**
 * create a system of coordinates in 3D
 */
public class Coordinate {
    private int x;
    private int y;
    private int z;
    public double zoom = Config.zoom;
    public double zmultiply1 = Config.zmultiply1;
    public double zmultiply2 = Config.zmultiply2;

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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
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

    public Coordinate addCoords(Coordinate toAdd){
        int x = this.getX() + toAdd.getX();
        int y = this.getY() + toAdd.getY();
        int z = this.getZ() + toAdd.getZ();
        return new Coordinate(x,y,z);
    }

    public Coordinate multiplyByInt(int i){
        int x = this.getX() * i;
        int y = this.getY() * i;
        int z = this.getZ() * i;
        return new Coordinate(x,y,z);
    }


    public void printCoord() {
        System.out.println(this.x + " " + this.y + " " + this.z);
    }

    /**
     * compute the coordinate x in 2D using Thales
     */
    public Coordinate2D computeProjectedCoordinate(BigDecimal initialPosition) {
        BigDecimal x = BigDecimal.valueOf(this.getX()).stripTrailingZeros();
        BigDecimal y = BigDecimal.valueOf(this.getY()).stripTrailingZeros();
        BigDecimal z = BigDecimal.valueOf(this.getZ()).stripTrailingZeros();


        BigDecimal value1 = x.multiply(new BigDecimal(zoom));
        BigDecimal value2 = z.multiply(new BigDecimal(zmultiply1));
        BigDecimal value3 = y.multiply(new BigDecimal(zoom));
        BigDecimal value4 = z.multiply(new BigDecimal(zmultiply2));


        BigDecimal coordinate1 = value1.add(value2);
        coordinate1 = coordinate1.add(initialPosition);
        coordinate1 = coordinate1.add(new BigDecimal(4));

        BigDecimal coordinate2 = value3.add(value4);
        coordinate2 = coordinate2.add(initialPosition);

        return new Coordinate2D(coordinate1, coordinate2);
    }

}
