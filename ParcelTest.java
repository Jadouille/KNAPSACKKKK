import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by Użytkownik on 08.01.2016.
 */
public class ParcelTest extends Applet {

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Projector viewer = new Projector(new Coordinate(15,4,10));
        LParcel l = new LParcel(new Coordinate(10,10,1),0,0,2,2,2);
        viewer.draw(g2,l.getParcel1());
        viewer.draw(g2,l.getParcel2());
        viewer.draw(g2,l.getParcel3());
        viewer.draw(g2,l.getParcel4());
        viewer.draw(g2,l.getParcel5());

       Projector viewer2 = new Projector(new Coordinate(10,10,10));
        viewer2.draw(g2,l.getParcel1());
        viewer2.draw(g2,l.getParcel2());
        viewer2.draw(g2,l.getParcel3());
        viewer2.draw(g2,l.getParcel4());
        viewer2.draw(g2,l.getParcel5());
    }



}
