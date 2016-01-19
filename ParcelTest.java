import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ParcelTest extends Applet implements KeyListener {
    private int x = 256;
    private int y = 105;
    private int zoom = 150;
    private ArrayList<Parcel> containerParcels;
    private ContainerKnapsack container;

    public ParcelTest() {
        setFocusable(true);
        setSize(1000, 1000);
        addKeyListener(this);

        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(ParcelTypes.get(), 60);
        //ArrayList<Parcel> unevenParcels = DistributionGenerator.generateUnevenDistribution(ParcelTypes.get(), );

        this.container = new ContainerKnapsack(165, 40, 25);
       // GreedyAlgorithm.testGreedy(this.container, evenParcels, true, false);
        GeneticAlgorithm.testGenetic(container, evenParcels);
        containerParcels = this.container.getParcels();
    }

    public void paint(Graphics g){


        Projector viewer = new Projector(new Coordinate(x, y, zoom));

        for (Parcel curParcels : containerParcels){

            viewer.draw(g, curParcels);
        }

        viewer.drawBorders(g, this.container);


    }

    public void keyTyped(KeyEvent e) {
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            x -= 25;
        }

        if (key == KeyEvent.VK_RIGHT) {
            x += 25;
        }

        if (key == KeyEvent.VK_UP) {
            y -= 25;
        }
        if (key == KeyEvent.VK_DOWN) {
            y += 25;
        }

        if (key == KeyEvent.VK_ADD) {
            zoom -= 25;
        }
        if (key == KeyEvent.VK_SPACE) {
            x = 256;
            y = 105;
            zoom = 150;
        }
        if (key == KeyEvent.VK_SUBTRACT) {
            zoom += 25;
        }

        repaint();
    }


    public void keyReleased(KeyEvent e) {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("zoom: " + zoom);
        System.out.println();
    }
}
