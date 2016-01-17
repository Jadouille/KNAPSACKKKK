/**
 * Created by Użytkownik on 08.01.2016.
 */

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Projector {

    private double viewer;
    private static double angleX = 0.0;
    private static double angleY = 0.0;
    private static double angleZ = 0.0;
    /**
     * Creates a projector that will help us to transforms 2D coordinates in 2D coordinates
     *
     * @param viewer is the cordinate in 3D from where we see the shape that's being projected
     */

    public Projector(double viewer) {
        this.viewer = viewer;
    }

    /**
     * Gets the projected coordinate thanks to the computeProjectedX/Y method
     */
    public ArrayList<Coordinate2D> getProjection(Parcel p, boolean rotateAroundX, int senseOfRotationX, boolean rotateAroundY, int senseOfRotationY, boolean rotateAroundZ, int senseOfRotationZ) {
        ArrayList<Coordinate2D> projectedCoords = new ArrayList<>();
        if (rotateAroundX){
            if (senseOfRotationX > 0) {
                angleX += 0.001;
                return p.rotateAroundX(angleX);
            }
            if (senseOfRotationX < 0) {
                angleX -= 0.001;
                return p.rotateAroundX(angleX);
            }

        }

        else if (rotateAroundY) {
            if (senseOfRotationY > 0) {
                angleY += 0.001;
                return p.rotateAroundY(angleY);
            }
            if (senseOfRotationY < 0) {
                angleY -= 0.001;
                return p.rotateAroundY(angleY);
            }
        }

        else if (rotateAroundZ) {
            if (senseOfRotationZ > 0){
                angleZ += 0.001;
            return p.rotateAroundZ(angleZ);
            }
            if (senseOfRotationZ < 0){
                angleZ -= 0.001;
                return p.rotateAroundZ(angleZ);
            }
        }

            else {
            ArrayList<Coordinate> coordinates = p.getCornerCoords();
            for (Coordinate curcoord : coordinates) {
                curcoord.printCoord();
            }


            for (int i = 0; i < coordinates.size(); i++) {
                projectedCoords.add(i, coordinates.get(i).computeProjectedCoordinate(this.viewer));
                projectedCoords.get(i).printCoords();

            }
            return projectedCoords;
        }
        return projectedCoords;

    }

    public void drawContainer(Graphics g, ContainerKnapsack c) {
        ArrayList<Parcel> parcels = c.getParcels();
        for (Parcel curParcel : parcels) {
            draw(g, curParcel, false, 0, false, 0, false, 0);
        }
    }


    /**
     * Draw a parcel
     */
    public void draw(Graphics g, Parcel p, boolean rotateAroundX, int senseOfRotationX, boolean rotateAroundY, int senseOfRotationY, boolean rotateAroundZ, int senseOfRotationZ) {

        Graphics2D g2 = (Graphics2D) g;
        ArrayList<Coordinate2D> coordinates = this.getProjection(p, rotateAroundX,senseOfRotationX, rotateAroundY, senseOfRotationY, rotateAroundZ, senseOfRotationZ );
        System.out.println("siza" + coordinates.size());
        g2.setColor(Color.pink);
        g2.draw(new Line2D.Double((coordinates.get(0).getX() * 100), (coordinates.get(0).getY() * 100), (coordinates.get(1).getX() * 100), (coordinates.get(1).getY() * 100)));
        g2.setColor(Color.red);
        g2.draw(new Line2D.Double((coordinates.get(1).getX() * 100), (coordinates.get(1).getY() * 100), (coordinates.get(2).getX() * 100), (coordinates.get(2).getY() * 100)));
        g2.setColor(Color.black);
        g2.draw(new Line2D.Double((coordinates.get(2).getX() * 100), (coordinates.get(2).getY() * 100), (coordinates.get(3).getX() * 100), (coordinates.get(3).getY() * 100)));
        g2.setColor(Color.yellow);
        g2.draw(new Line2D.Double((coordinates.get(0).getX() * 100), (coordinates.get(0).getY() * 100), (coordinates.get(3).getX() * 100), (coordinates.get(3).getY() * 100)));
        g2.setColor(Color.orange);
        g2.draw(new Line2D.Double((coordinates.get(3).getX() * 100), (coordinates.get(3).getY() * 100), (coordinates.get(7).getX() * 100), (coordinates.get(7).getY() * 100)));
        g2.setColor(Color.green);
        g2.draw(new Line2D.Double((coordinates.get(6).getX() * 100), (coordinates.get(6).getY() * 100), (coordinates.get(4).getX() * 100), (coordinates.get(4).getY() * 100)));
        g2.setColor(Color.blue);
        g2.draw(new Line2D.Double((coordinates.get(2).getX() * 100), (coordinates.get(2).getY() * 100), (coordinates.get(5).getX() * 100), (coordinates.get(5).getY() * 100)));
        g2.setColor(Color.gray);
        g2.draw(new Line2D.Double((coordinates.get(6).getX() * 100), (coordinates.get(6).getY() * 100), (coordinates.get(7).getX() * 100), (coordinates.get(7).getY() * 100)));
        g2.setColor(Color.magenta);
        g2.draw(new Line2D.Double((coordinates.get(7).getX() * 100), (coordinates.get(7).getY() * 100), (coordinates.get(5).getX() * 100), (coordinates.get(5).getY() * 100)));
        g2.setColor(Color.cyan);
        g2.draw(new Line2D.Double((coordinates.get(5).getX() * 100), (coordinates.get(5).getY() * 100), (coordinates.get(4).getX() * 100), (coordinates.get(4).getY() * 100)));
        g2.setColor(Color.darkGray);
        g2.draw(new Line2D.Double((coordinates.get(0).getX() * 100), (coordinates.get(0).getY() * 100), (coordinates.get(6).getX() * 100), (coordinates.get(6).getY() * 100)));
        g2.setColor(new Color(128, 183, 180));
        g2.draw(new Line2D.Double((coordinates.get(4).getX() * 100), (coordinates.get(4).getY() * 100), (coordinates.get(1).getX() * 100), (coordinates.get(1).getY() * 100)));
    }

}
