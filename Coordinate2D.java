import java.math.BigDecimal;

/**
 * Created by Jade on 14-01-16.
 */
public class Coordinate2D {

    private BigDecimal x;
    private BigDecimal y;

    public Coordinate2D(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public void setCoords(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

     public void printCoords(){
        System.out.println(this.getX() + " " + this.getY());
    }
}
