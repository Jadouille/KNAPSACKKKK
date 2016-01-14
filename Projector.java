/**
 * Created by Użytkownik on 08.01.2016.
 */

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Projector {
    private Coordinate viewer;


    /**
     * Creates a projector that will help us to transforms 2D coordinates in 2D coordinates
     *
     * @param viewer is the cordinate in 3D from where we see the shape that's being projected
     */
    public Projector(Coordinate viewer) {
        this.viewer = viewer;
    }


    /**
     * Gets the projected coordinate thanks to the computeProjectedX/Y method
     */
    public Coordinate2D[] getProjection(Parcel p) {
        ArrayList<Coordinate> coordinates = p.getCornerCoords(new Coordinate(0, 0, 0));
        Coordinate2D[] projectedCoords = new Coordinate2D[coordinates.size()];
        for (int i = 0; i < projectedCoords.length; i++) {
            projectedCoords[i] = new Coordinate2D(0, 0);
        }
        for (int i = 0; i < projectedCoords.length; i++) {
            projectedCoords[i].setX((coordinates.get(i).computeProjectedX(viewer)));
            projectedCoords[i].setY(coordinates.get(i).computeProjectedY(viewer));
        }
        return projectedCoords;
    }


    /**
     * Draw a parcel
     */
    public void draw(Graphics g, Parcel p) {
        Graphics2D g2 = (Graphics2D) g;
        Coordinate2D[] coordinates = this.getProjection(p);
        g2.setColor(Color.pink);
        g2.draw(new Line2D.Double((coordinates[0].getX() * 100), (coordinates[0].getY() * 100), (coordinates[1].getX() * 100), (coordinates[1].getY() * 100)));
        g2.setColor(Color.red);
        g2.draw(new Line2D.Double((coordinates[0].getX() * 100), (coordinates[0].getY() * 100), (coordinates[3].getX() * 100), (coordinates[3].getY() * 100)));
        g2.setColor(Color.black);
        g2.draw(new Line2D.Double((coordinates[0].getX() * 100), (coordinates[0].getY() * 100), (coordinates[6].getX() * 100), (coordinates[6].getY() * 100)));
        g2.setColor(Color.yellow);
        g2.draw(new Line2D.Double((coordinates[3].getX() * 100), (coordinates[3].getY() * 100), (coordinates[2].getX() * 100), (coordinates[2].getY() * 100)));
        g2.setColor(Color.orange);
        g2.draw(new Line2D.Double((coordinates[7].getX() * 100), (coordinates[7].getY() * 100), (coordinates[5].getX() * 100), (coordinates[5].getY() * 100)));
        g2.setColor(Color.green);
        g2.draw(new Line2D.Double((coordinates[2].getX() * 100), (coordinates[2].getY() * 100), (coordinates[5].getX() * 100), (coordinates[5].getY() * 100)));
        g2.setColor(Color.blue);
        g2.draw(new Line2D.Double((coordinates[2].getX() * 100), (coordinates[2].getY() * 100), (coordinates[1].getX() * 100), (coordinates[1].getY() * 100)));
        g2.setColor(Color.gray);
        g2.draw(new Line2D.Double((coordinates[4].getX() * 100), (coordinates[4].getY() * 100), (coordinates[1].getX() * 100), (coordinates[1].getY() * 100)));
        g2.setColor(Color.magenta);
        g2.draw(new Line2D.Double((coordinates[4].getX() * 100), (coordinates[4].getY() * 100), (coordinates[5].getX() * 100), (coordinates[5].getY() * 100)));
        g2.setColor(Color.cyan);
        g2.draw(new Line2D.Double((coordinates[4].getX() * 100), (coordinates[4].getY() * 100), (coordinates[6].getX() * 100), (coordinates[6].getY() * 100)));
        g2.setColor(Color.darkGray);
        g2.draw(new Line2D.Double((coordinates[6].getX() * 100), (coordinates[6].getY() * 100), (coordinates[7].getX() * 100), (coordinates[7].getY() * 100)));
        g2.setColor(new Color(128, 183, 180));
        g2.draw(new Line2D.Double((coordinates[3].getX() * 100), (coordinates[3].getY() * 100), (coordinates[7].getX() * 100), (coordinates[7].getY() * 100)));
    }

}
