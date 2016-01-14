/**
 * Created by Jade on 14-01-16.
 */
public class Coordinate2D {

    private double x;
    private double y;

    public Coordinate2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setCoord(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
