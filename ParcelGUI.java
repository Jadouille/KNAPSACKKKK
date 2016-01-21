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
    private boolean rotatingRight;
    private boolean rotatingLeft;
    private boolean rotatingUp;
    private boolean rotatingDown;
    private ContainerKnapsack container;
    private JTextArea maxValue = new JTextArea();
    Font font = new Font("Verdana", Font.BOLD, 36);

    public ParcelGUI() {
        addKeyListener(this);
        container = new ContainerKnapsack(Config.containerWidth, Config.containerHeight, Config.containerDepth);
        containerParcels = container.getParcels();
        maxValue.setEditable(false);
        maxValue.setFocusable(false);
        maxValue.setFont(font);
        this.add(maxValue);
    }

    public void init() {

        ArrayList<Parcel> evenParcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), Config.numberOfParcels);
        if (Config.greedy) {
            ParcelGUI parcelGUI = this;
            Config.loading=true;
            Config.maxScore=0;
            Thread t = new Thread(() -> {
                GreedyAlgorithm.testGreedy(container, evenParcels, true, Config.randomRotations, parcelGUI);
            });
            t.start();
        }


        if (Config.genetic) {
            Config.loading=true;
            Config.maxScore=0;
            ParcelGUI parcelGUI = this;
            Thread t = new Thread(() -> {
                GeneticAlgorithm.testGenetic(container, evenParcels, parcelGUI);
            });
            t.start();
        }


        if (Config.bruteForce) {
            Config.loading=true;
            Config.maxScore=0;
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
        //repaint();
    }


    public void paintComponent(Graphics g) {
        paintScore();
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
    public void paintScore(){
        if(Config.maxScore>0)
        maxValue.setText("Value Container: " + Integer.toString(Config.maxScore));

        if(Config.maxScore==0 && !Config.loading)
            maxValue.setText("Start Algorithm!");

        if(Config.loading)
            maxValue.setText("Loading...");
    }


    public void keyTyped(KeyEvent e) {
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            rotatingLeft=false;
            rotatingUp=false;
            rotatingDown=false;


            rotateAroundX = false;
            rotateAroundY = true;
            rotateAroundZ = false;
            senseOfRotationY = -1;
            repaint();
            if (rotating && rotatingRight) {

                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_RIGHT);
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }


        }
        if (key == KeyEvent.VK_LEFT) {
            rotatingRight=false;
            rotatingUp=false;
            rotatingDown=false;

            rotateAroundX = false;
            rotateAroundY = true;
            rotateAroundZ = false;
            senseOfRotationY = +1;
            repaint();

            if (rotating && rotatingLeft) {

                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_LEFT);
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        }



        if (key == KeyEvent.VK_UP) {
            rotatingRight=false;
            rotatingLeft=false;
            rotatingDown=false;

            rotateAroundX = true;
            rotateAroundY = false;
            rotateAroundZ = false;
            senseOfRotationX = +1;
            repaint();
            if (rotating && rotatingUp) {

                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_UP);
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (key == KeyEvent.VK_DOWN) {
            rotatingRight=false;
            rotatingLeft=false;
            rotatingUp=false;

            rotateAroundX = true;
            rotateAroundY = false;
            rotateAroundZ = false;
            senseOfRotationX = -1;
            repaint();
            if (rotating && rotatingDown) {
                try {
                    Robot robot = new Robot();
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
            init();
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            rotatingLeft = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rotatingRight = true;
        }
        if (key == KeyEvent.VK_UP) {
            rotatingUp = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            rotatingDown = true;
        }
    }
    public void setRotatingDirectionsFalse(){
        rotatingLeft=false;
        rotatingRight=false;
        rotatingUp=false;
        rotatingDown=false;
    }

}
