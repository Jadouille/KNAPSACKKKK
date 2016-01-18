import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
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
    private boolean rotateAroundX = false;
    private boolean rotateAroundY = false;
    private boolean rotateAroundZ = false;
    private int senseOfRotationX = 0;
    private int senseOfRotationY = 0;
    private int senseOfRotationZ = 0;
    private int counter = 0;
    private final int maxCounter=100;

    public ParcelGUI() {

        addKeyListener(this);
        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), 10);

        ContainerKnapsack container = new ContainerKnapsack(20, 20, 20);

        containerParcels = container.getParcels();

        if (greedyAlgorithm)
            GreedyAlgorithm.testGreedy(container, evenParcels, true);

        if (geneticAlgorithm)
            System.out.println("execute genetic algorithm");

        if (bruteForceAlgorithm)
            System.out.println("execute bruteforce algorithm");

        containerParcels = container.getParcels();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Projector viewer = new Projector(new BigDecimal(5));

        for (Parcel curParcels : containerParcels){
            viewer.draw(g, curParcels, rotateAroundX, senseOfRotationX, rotateAroundY, senseOfRotationY, rotateAroundZ, senseOfRotationZ);
        }


    }

    public void keyTyped(KeyEvent e) {
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

                rotateAroundX = false;
                rotateAroundZ = false;
                rotateAroundY = true;
                senseOfRotationY = +1;

            if(counter<=100) {
                repaint();
                try {

                    Robot robot = new Robot();
                    // Creates the delay of 5 sec so that you can open notepad before
                    // Robot start writting

                    robot.keyPress(KeyEvent.VK_LEFT);


                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
                counter++;
            }
            if(counter==maxCounter){
                counter=0;

            }

        }

        if (key == KeyEvent.VK_RIGHT) {

                rotateAroundX = false;
                rotateAroundZ = false;
                rotateAroundY = true;
                senseOfRotationY = -1;

                repaint();


        }

        if (key == KeyEvent.VK_UP) {
            rotateAroundY = false;
            rotateAroundZ = false;
            rotateAroundX = true;
            senseOfRotationX = +1;
            repaint();
        }
        if (key == KeyEvent.VK_DOWN) {
            rotateAroundY = false;
            rotateAroundZ = false;
            rotateAroundX = true;
            senseOfRotationX = -1;
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
