import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;


public class ParcelGUI extends JPanel implements KeyListener {
    private int x = 256;
    private int y = 105;
    private ParcelTypes parcelTypes = new ParcelTypes();
    private ArrayList<Parcel> containerParcels = null;
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
        container = new ContainerKnapsack(Config.containerWidth, Config.containerHeight, Config.containerDepth);
        containerParcels = container.getParcels();
    }

    public void init() {
        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), Config.numberOfParcels);
        if (Config.greedy) {
            GreedyAlgorithm.testGreedy(container, evenParcels, true, Config.randomRotations);
        }


        if (Config.genetic) {
            ParcelGUI parcelGUI = this;
            Thread t = new Thread(() -> {
                GeneticAlgorithm.testGenetic(container, evenParcels, parcelGUI);
            });
            t.start();
        }


        if (Config.bruteForce) {
            Thread t = new Thread(() -> {
                ArrayList<Parcel> usedParcesl = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), 1);
                ArrayList<Integer> max = new ArrayList<>();
                max.add(50);
                max.add(50);
                max.add(50);
                BruteForceAlgorithm.bruteForce(container, usedParcesl, max);
            });
            t.start();


        }
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Projector viewer = new Projector(new BigDecimal(Config.initialpositionY));


            try{
                for (Parcel curParcels : containerParcels) {
                viewer.draw(g, curParcels, rotateAroundX, senseOfRotationX, rotateAroundY, senseOfRotationY, rotateAroundZ, senseOfRotationZ);
                }
            }
            catch(Exception ex){



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
        }
        if (key == KeyEvent.VK_SPACE) {
            rotating ^= true;
        }
        if (key == KeyEvent.VK_ALT) {
            System.out.println(Config.containerWidth);
            System.out.println(Config.containerHeight);
            init();
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
