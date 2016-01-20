import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ParcelGUI extends JPanel implements KeyListener {
    public Config config = new Config();
    private int x = 256;
    private int y = 105;
    private double zoom = config.zoom;
    private ParcelTypes parcelTypes = new ParcelTypes();
    private ArrayList<Parcel> containerParcels;
    private boolean rotateAroundX = false;
    private boolean rotateAroundY = false;
    private boolean rotateAroundZ = false;
    private int senseOfRotationX = 0;
    private int senseOfRotationY = 0;
    private int senseOfRotationZ = 0;
    private boolean rotating = true;
    private ContainerKnapsack container;

    public ParcelGUI() {
        addKeyListener(this);
        init();
    }

    public void init() {
        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), 10);

        container = new ContainerKnapsack(config.containerWidth, config.containerHeight, config.containerDepth);

        containerParcels = container.getParcels();

        if (config.greedy) {
            GreedyAlgorithm.testGreedy(container, evenParcels, true, false);
            repaint();
        }


        if (config.genetic) {
            //GeneticAlgorithm.testGenetic(container, evenParcels);
            //repaint();
        }


        /*if (config.bruteForce) {
            System.out.println("execute bruteforce algorithm");
            repaint();
        }*/


        containerParcels = container.getParcels();

        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Projector viewer = new Projector(new BigDecimal(2));

        for (Parcel curParcels : containerParcels) {
            viewer.draw(g, curParcels, rotateAroundX, senseOfRotationX, rotateAroundY, senseOfRotationY, rotateAroundZ, senseOfRotationZ);
        }


    }

    public void keyTyped(KeyEvent e) {
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            rotateAroundX = false;
            rotateAroundY = true;
            rotateAroundZ = false;
            senseOfRotationY = +1;
            repaint();

            if (rotating) {

                try {

                    Robot robot = new Robot();
                    // Creates the delay of 5 sec so that you can open notepad before
                    // Robot start writting

                    robot.keyPress(KeyEvent.VK_LEFT);


                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        }

        if (key == KeyEvent.VK_RIGHT) {

            rotateAroundX = false;
            rotateAroundY = true;
            rotateAroundZ = false;
            senseOfRotationY = -1;
            repaint();
            if (rotating) {

                try {

                    Robot robot = new Robot();
                    // Creates the delay of 5 sec so that you can open notepad before
                    // Robot start writting

                    robot.keyPress(KeyEvent.VK_RIGHT);


                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }


        }

        if (key == KeyEvent.VK_UP) {
            rotateAroundX = true;
            rotateAroundY = false;
            rotateAroundZ = false;
            senseOfRotationX = +1;
            repaint();
            if (rotating) {

                try {

                    Robot robot = new Robot();
                    // Creates the delay of 5 sec so that you can open notepad before
                    // Robot start writting

                    robot.keyPress(KeyEvent.VK_UP);


                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (key == KeyEvent.VK_DOWN) {
            rotateAroundX = true;
            rotateAroundY = false;
            rotateAroundZ = false;
            senseOfRotationX = -1;
            repaint();
            if (rotating) {

                try {

                    Robot robot = new Robot();
                    // Creates the delay of 5 sec so that you can open notepad before
                    // Robot start writting

                    robot.keyPress(KeyEvent.VK_DOWN);


                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        }

        if (key == KeyEvent.VK_CONTROL) {
            zoom -= 0.05;
            repaint();
        }
        if (key == KeyEvent.VK_SPACE) {
            rotating ^= true;
        }
        if (key == KeyEvent.VK_ALT) {
            zoom += 0.05;
            repaint();


            repaint();

        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
