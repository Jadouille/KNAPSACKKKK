import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Jade on 16-01-16.
 */
public class Coordinate3D {
    private double x;
    private double y;
    private double z;

    public Coordinate3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Coordinate2D computeProjectedCoordinate(BigDecimal initialPosition) {
        BigDecimal x = BigDecimal.valueOf(this.getX()).stripTrailingZeros();
        BigDecimal y = BigDecimal.valueOf(this.getY()).stripTrailingZeros();
        BigDecimal z = BigDecimal.valueOf(this.getZ()).stripTrailingZeros();


        BigDecimal value1 = x.multiply(new BigDecimal(0.3));
        BigDecimal value2 = z.multiply(new BigDecimal(0.2));
        BigDecimal value3 = y.multiply(new BigDecimal(0.3));
        BigDecimal value4 = z.multiply(new BigDecimal(0.1));


        BigDecimal coordinate1 = value1.add(value2);
        coordinate1 = coordinate1.add(initialPosition);
        coordinate1 = coordinate1.add(new BigDecimal(10));

        BigDecimal coordinate2 = value3.add(value4);
        coordinate2 = coordinate2.add(initialPosition);

        return new Coordinate2D( coordinate1, coordinate2);
    }
}
