import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class ParcelGUI extends JPanel implements KeyListener {
    public boolean greedyAlgorithm = true;
    public boolean geneticAlgorithm = false;
    public boolean bruteForceAlgorithm = false;
    private int x = 256;
    private int y = 105;
    private int zoom = 50;
    private ParcelTypes parcelTypes = new ParcelTypes();
    private ArrayList<Parcel> containerParcels;

    public ParcelGUI() {
        addKeyListener(this);
        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), 10);

        ContainerKnapsack container = new ContainerKnapsack(20, 20, 20);

        containerParcels = container.getParcels();

        if (greedyAlgorithm)
            GreedyAlgorithm.testGreedy(container, evenParcels, false);

        if (geneticAlgorithm)
            System.out.println("execute genetic algorithm");

        if (bruteForceAlgorithm)
            System.out.println("execute bruteforce algorithm");

        containerParcels = container.getParcels();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Projector viewer = new Projector(new Coordinate(x, y, zoom));

        for (Parcel curParcels : containerParcels){
            viewer.draw(g, curParcels);
        }

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

        if (key == KeyEvent.VK_CONTROL) {
            zoom -= 25;
        }
        if (key == KeyEvent.VK_SPACE) {
            x = 256;
            y = 105;
            zoom = 50;
        }
        if (key == KeyEvent.VK_ALT) {
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
