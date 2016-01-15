import java.applet.Applet;
import java.awt.*;

/**
 * Created by Jade on 15-01-16.
 */
public class pParcelTest extends Applet{

        public void paint(Graphics g) {


            pProjector viewer = new pProjector(new Coordinate(50, 50, 50));
            pParcel parcel = new pParcel(5, 5);
            viewer.draw(g, parcel);

        }
}
