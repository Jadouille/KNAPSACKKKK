/**
 * Created by Użytkownik on 08.01.2016.
 */
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.geom.Line2D;

public class Projector {
    private Coordinate viewer;


    public Projector(Coordinate viewer){
        this.viewer = viewer;
    }

    public Coordinate[] getProjection(Parcel p){
        Coordinate[] coordinates = p.getCoords();
        Coordinate[] pCoords = new Coordinate[coordinates.length];
        for (int i =0;i<pCoords.length;i++){
            pCoords[i] = new Coordinate(0,0,0);
        }
        for (int i =0;i<pCoords.length;i++) {
            pCoords[i].setZ(0);
            pCoords[i].setX(coordinates[i].computeProjectedX(viewer));
            pCoords[i].setY(coordinates[i].computeProjectedY(viewer));
        }
        return pCoords;
    }

    public void draw(Graphics g, Parcel p){
        Graphics2D g2 = (Graphics2D) g;
        Coordinate[] coordinates = this.getProjection(p);
        g2.setColor(Color.pink);
        g2.draw(new Line2D.Double((coordinates[0].getX()*100), (coordinates[0].getY()*100), (coordinates[1].getX()*100), (coordinates[1].getY()*100)));
        g2.setColor(Color.red);
        g2.draw(new Line2D.Double((coordinates[0].getX()*100), (coordinates[0].getY()*100), (coordinates[3].getX()*100), (coordinates[3].getY()*100)));
        g2.setColor(Color.black);
        g2.draw(new Line2D.Double((coordinates[0].getX()*100), (coordinates[0].getY()*100), (coordinates[6].getX()*100), (coordinates[6].getY()*100)));
        g2.setColor(Color.yellow);
        g2.draw(new Line2D.Double((coordinates[3].getX()*100), (coordinates[3].getY()*100), (coordinates[2].getX()*100), (coordinates[2].getY()*100)));
        g2.setColor(Color.orange);
        g2.draw(new Line2D.Double((coordinates[7].getX()*100), (coordinates[7].getY()*100), (coordinates[5].getX()*100), (coordinates[5].getY()*100)));
        g2.setColor(Color.green);
        g2.draw(new Line2D.Double((coordinates[2].getX()*100), (coordinates[2].getY()*100), (coordinates[5].getX()*100), (coordinates[5].getY()*100)));
        g2.setColor(Color.blue);
        g2.draw(new Line2D.Double((coordinates[2].getX()*100), (coordinates[2].getY()*100), (coordinates[1].getX()*100), (coordinates[1].getY()*100)));
        g2.setColor(Color.gray);
        g2.draw(new Line2D.Double((coordinates[4].getX()*100), (coordinates[4].getY()*100), (coordinates[1].getX()*100), (coordinates[1].getY()*100)));
        g2.setColor(Color.magenta);
        g2.draw(new Line2D.Double((coordinates[4].getX()*100), (coordinates[4].getY()*100), (coordinates[5].getX()*100), (coordinates[5].getY()*100)));
        g2.setColor(Color.cyan);
        g2.draw(new Line2D.Double((coordinates[4].getX()*100), (coordinates[4].getY()*100), (coordinates[6].getX()*100), (coordinates[6].getY()*100)));
        g2.setColor(Color.darkGray);
        g2.draw(new Line2D.Double((coordinates[6].getX()*100), (coordinates[6].getY()*100), (coordinates[7].getX()*100), (coordinates[7].getY()*100)));
        g2.setColor(new Color(128,183,180));
        g2.draw(new Line2D.Double((coordinates[3].getX()*100), (coordinates[3].getY()*100), (coordinates[7].getX()*100), (coordinates[7].getY()*100)));
    }

}
