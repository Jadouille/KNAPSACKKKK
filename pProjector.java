import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jade on 15-01-16.
 */
public class pProjector {

    private Coordinate viewer;

    /**
     * Creates a projector that will help us to transforms 2D coordinates in 2D coordinates
     *
     * @param viewer is the cordinate in 3D from where we see the shape that's being projected
     */
    public pProjector(Coordinate viewer) {
        this.viewer = viewer;
    }


    /**
     * Gets the projected coordinate thanks to the computeProjectedX/Y method
     */
    public Coordinate2D[] getProjection(pParcel p) {
        ArrayList<Coordinate> coordinates = p.getCornerCoords();
        for (Coordinate curcoord : coordinates){
            curcoord.printCoord();
        }

        Coordinate2D[] projectedCoords = new Coordinate2D[coordinates.size()];
        for (int i = 0; i < projectedCoords.length; i++) {
            projectedCoords[i] = new Coordinate2D(0, 0);
        }
        for (int i = 0; i < projectedCoords.length; i++) {
            projectedCoords[i].setX((coordinates.get(i).computeProjectedX(viewer)));
            projectedCoords[i].setY(coordinates.get(i).computeProjectedY(viewer));
            projectedCoords[i].printCoords();

        }
        return projectedCoords;
    }

    /**public void drawContainer(Graphics g, ContainerKnapsack c){
        ArrayList<Parcel > parcels = c.getParcels();
        for (Parcel curParcel : parcels){
            draw(g, curParcel);
        }
    }
     */


    /**
     * Draw a parcel
     */
    public void draw(Graphics g, pParcel p) {
        Graphics2D g2 = (Graphics2D) g;
        Coordinate2D[] coordinates = this.getProjection(p);

        Random rand = new Random();
        float r = rand.nextFloat();
        float c = rand.nextFloat();
        float b = rand.nextFloat();
        Color BeautifulColor = new Color(r, c, b);
        g2.setColor(BeautifulColor);

        g2.draw(new Line2D.Double((coordinates[0].getX() * 200), (coordinates[0].getY() * 200), (coordinates[1].getX() * 200), (coordinates[1].getY() * 200)));
        //g2.setColor(Color.red);
        g2.draw(new Line2D.Double((coordinates[1].getX() * 200), (coordinates[1].getY() * 200), (coordinates[2].getX() * 200), (coordinates[2].getY() * 200)));
        //g2.setColor(Color.black);
        g2.draw(new Line2D.Double((coordinates[2].getX() * 200), (coordinates[2].getY() * 200), (coordinates[3].getX() * 200), (coordinates[3].getY() * 200)));
        //g2.setColor(Color.yellow);
        g2.draw(new Line2D.Double((coordinates[4].getX() * 200), (coordinates[4].getY() * 200), (coordinates[3].getX() * 200), (coordinates[3].getY() * 200)));
        //g2.setColor(Color.orange);
        g2.draw(new Line2D.Double((coordinates[3].getX() * 200), (coordinates[3].getY() * 200), (coordinates[9].getX() * 200), (coordinates[9].getY() * 200)));
        //g2.setColor(Color.green);
        g2.draw(new Line2D.Double((coordinates[5].getX() * 200), (coordinates[5].getY() * 200), (coordinates[4].getX() * 200), (coordinates[4].getY() * 200)));
        //g2.setColor(Color.blue);
        g2.draw(new Line2D.Double((coordinates[0].getX() * 200), (coordinates[0].getY() * 200), (coordinates[5].getX() * 200), (coordinates[5].getY() * 200)));
        //g2.setColor(Color.gray);
        g2.draw(new Line2D.Double((coordinates[6].getX() * 200), (coordinates[6].getY() * 200), (coordinates[7].getX() * 200), (coordinates[7].getY() * 200)));
        //g2.setColor(Color.magenta);
        g2.draw(new Line2D.Double((coordinates[7].getX() * 200), (coordinates[7].getY() * 200), (coordinates[8].getX() * 200), (coordinates[8].getY() * 200)));
        //g2.setColor(Color.cyan);
        g2.draw(new Line2D.Double((coordinates[2].getX() * 200), (coordinates[2].getY() * 200), (coordinates[8].getX() * 200), (coordinates[8].getY() * 200)));
        //g2.setColor(Color.darkGray);
        g2.draw(new Line2D.Double((coordinates[0].getX() * 200), (coordinates[0].getY() * 200), (coordinates[6].getX() * 200), (coordinates[6].getY() * 200)));
        //g2.setColor(new Color(128, 183, 180));
        g2.draw(new Line2D.Double((coordinates[7].getX() * 200), (coordinates[7].getY() * 200), (coordinates[1].getX() * 200), (coordinates[1].getY() * 200)));

        g2.draw(new Line2D.Double((coordinates[6].getX() * 200), (coordinates[6].getY() * 200), (coordinates[11].getX() * 200), (coordinates[11].getY() * 200)));
        //g2.setColor(Color.red);
        g2.draw(new Line2D.Double((coordinates[10].getX() * 200), (coordinates[10].getY() * 200), (coordinates[11].getX() * 200), (coordinates[11].getY() * 200)));
        //g2.setColor(Color.black);
        g2.draw(new Line2D.Double((coordinates[10].getX() * 200), (coordinates[10].getY() * 200), (coordinates[9].getX() * 200), (coordinates[9].getY() * 200)));
        //g2.setColor(Color.yellow);
        g2.draw(new Line2D.Double((coordinates[5].getX() * 200), (coordinates[5].getY() * 200), (coordinates[11].getX() * 200), (coordinates[11].getY() * 200)));
        //g2.setColor(Color.orange);
        g2.draw(new Line2D.Double((coordinates[4].getX() * 200), (coordinates[4].getY() * 200), (coordinates[10].getX() * 200), (coordinates[10].getY() * 200)));
    }

}
