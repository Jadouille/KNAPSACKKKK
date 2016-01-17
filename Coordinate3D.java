/**
 * Created by Jade on 16-01-16.
 */
public class Coordinate3D {
    private double x;
    private double y;
    private double z;

    public Coordinate3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){ return x;}
    public double getY(){ return y;}
    public double getZ(){ return z;}

    public void setX(double x){ this.x = x;}
    public void setY(double y){ this.y = y;}
    public void setZ(double z){ this.z = z;}

    public Coordinate2D computeProjectedCoordinate(double initialPosition){
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();

        return new Coordinate2D(((x * 0.3) + (z * 0.2) + initialPosition),((y * 0.3) + (z * 0.1) + initialPosition) );
    }
}
