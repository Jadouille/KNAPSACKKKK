import java.math.BigDecimal;

/**
 * Created by Jade on 16-01-16.
 */
public class Coordinate3D {
    private double x;
    private double y;
    private double z;
    private static Config config = new Config();
    private double zoom = config.zoom;

    public Coordinate3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Coordinate2D computeProjectedCoordinate(BigDecimal initialPosition) {
        BigDecimal x = BigDecimal.valueOf(this.getX()).stripTrailingZeros();
        BigDecimal y = BigDecimal.valueOf(this.getY()).stripTrailingZeros();
        BigDecimal z = BigDecimal.valueOf(this.getZ()).stripTrailingZeros();


        BigDecimal value1 = x.multiply(new BigDecimal(zoom));
        BigDecimal value2 = z.multiply(new BigDecimal(config.zmultiply1));
        BigDecimal value3 = y.multiply(new BigDecimal(zoom));
        BigDecimal value4 = z.multiply(new BigDecimal(config.zmultiply2));


        BigDecimal coordinate1 = value1.add(value2);
        coordinate1 = coordinate1.add(initialPosition);
        coordinate1 = coordinate1.add(new BigDecimal(4));

        BigDecimal coordinate2 = value3.add(value4);
        coordinate2 = coordinate2.add(initialPosition);

        return new Coordinate2D( coordinate1, coordinate2);
    }
}
