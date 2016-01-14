import java.applet.Applet;
import java.awt.*;
public class ParcelTest extends Applet {

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Projector viewer = new Projector(new Coordinate(13, 13, 10));
        Parcel l = new Parcel(10, 10, 15, 5, 4);
        viewer.draw(g2,l);

    }



}
