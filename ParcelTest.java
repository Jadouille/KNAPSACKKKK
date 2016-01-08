import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by Użytkownik on 08.01.2016.
 */
public class ParcelTest extends Applet {

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Projector viewer = new Projector(new Coordinate(3,10,10));
        Parcel p = new Parcel(new Coordinate(10,10,1),0,0,3,4,5);
        Parcel e = new Parcel(new Coordinate(15,16,4),0,0,2,2,2);
        viewer.draw(g2,p);
        viewer.draw(g2,e);
    }

}
