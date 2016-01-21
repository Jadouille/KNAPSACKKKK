import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 19/01/2016.
 */
public class GUIConfig extends JFrame {

    public ParcelGUI parcelgui = null;
    //Class Declarations
    JTextField numberOfParcels, numberOfPentominos1, numberOfPentominos2, numberOfPentominos3, angle, containerWidth, containerHeight, containerDepth, zoom, Zmultiply1, Zmultiply2, numberOfGenerations, populationSize, mutationRate, centerPosition, positionX, positionY;
    JButton save;
    JTextArea amountOfParcelsTextField, amountOfLPentominoTextField, amountOfPPentominoTextField, amountOfTPentominoTextField, angleTextField, widthTextField, heightTextField, depthTextField, zoomTextField, Zmultiply1TextField, Zmultiply2TextField ,numberOfGenerationsTextField, populationSizeTextField, mutationRateTextField, centerPositionField, positionXField, positionYField ;
    JRadioButton greedy, genetic, bruteForce;
    JCheckBox pentominoParcels;
    String disp = "Saved Successfully";
    TextHandler handler = null;

    public GUIConfig() {
        super("Edit Configuration");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        init(container);
    }

    public void init(Container container) {

        containerWidth = new JTextField(Integer.toString(Config.containerWidth), 55);
        widthTextField = new JTextArea("Enter Container Width");
        widthTextField.setEditable(false);

        containerHeight = new JTextField(Integer.toString(Config.containerHeight), 55);
        heightTextField = new JTextArea("Enter Container Height");
        heightTextField.setEditable(false);

        containerDepth = new JTextField(Integer.toString(Config.containerDepth), 55);
        depthTextField = new JTextArea("Enter Container Depth");
        depthTextField.setEditable(false);

        angle = new JTextField(Double.toString(Config.angle), 55);
        angleTextField = new JTextArea("Enter Angle Level");
        angleTextField.setEditable(false);

        zoom = new JTextField(Double.toString(Config.zoom), 55);
        zoomTextField = new JTextArea("Enter Zoom Level");
        zoomTextField.setEditable(false);

        Zmultiply1 = new JTextField(Double.toString(Config.zmultiply1), 55);
        Zmultiply1TextField = new JTextArea("Enter Zmultiply1 Level");
        Zmultiply1TextField.setEditable(false);

        Zmultiply2 = new JTextField(Double.toString(Config.zmultiply2), 55);
        Zmultiply2TextField = new JTextArea("Enter Zmultiply2 Level");
        Zmultiply2TextField.setEditable(false);

        numberOfParcels = new JTextField(Integer.toString(Config.numberOfParcels), 55);
        amountOfParcelsTextField = new JTextArea("Set number of Parcels");
        amountOfParcelsTextField.setEditable(false);

        numberOfPentominos1 = new JTextField(Integer.toString(Config.numberOfPentominos1), 55);
        amountOfTPentominoTextField = new JTextArea("Set number of Pentomino's T");
        amountOfTPentominoTextField.setEditable(false);

        numberOfPentominos2 = new JTextField(Integer.toString(Config.numberOfPentominos2), 55);
        amountOfPPentominoTextField = new JTextArea("Set number of Pentomino's P");
        amountOfTPentominoTextField.setEditable(false);

        numberOfPentominos3 = new JTextField(Integer.toString(Config.numberOfPentominos3), 55);
        amountOfLPentominoTextField = new JTextArea("Set number of Pentomino's L");
        amountOfLPentominoTextField.setEditable(false);

        numberOfGenerations = new JTextField(Integer.toString(Config.numberOfGenerations), 55);
        numberOfGenerationsTextField = new JTextArea("Set number of Generations");
        numberOfGenerationsTextField.setEditable(false);

        populationSize = new JTextField(Integer.toString(Config.numberOfGenerations), 55);
        populationSizeTextField = new JTextArea("set number of population");
        populationSizeTextField.setEditable(false);

        mutationRate = new JTextField(Double.toString(Config.mutationRate), 55);
        mutationRateTextField = new JTextArea("set mutation Rate");
        mutationRateTextField.setEditable(false);

        centerPosition = new JTextField(Integer.toString(Config.centerPosition), 55);
        centerPositionField = new JTextArea("set Center position");
        centerPositionField.setEditable(false);

        positionX = new JTextField(Integer.toString(Config.initialpositionX), 55);
        positionXField = new JTextArea("set X position");
        positionXField.setEditable(false);

        positionY = new JTextField(Integer.toString(Config.initialpositionY), 55);
        positionYField = new JTextArea("set Y position");
        positionYField.setEditable(false);

        ButtonGroup group = new ButtonGroup();
        greedy = new JRadioButton("Greedy Algorithm");
        genetic = new JRadioButton("Genetic Algorithm");
        bruteForce = new JRadioButton("Brute Force");

        pentominoParcels = new JCheckBox("Pentomino Parcels");
        pentominoParcels.setSelected(Config.pentominoParcels);

        group.add(greedy);
        group.add(genetic);
        group.add(bruteForce);


        container.add(widthTextField);
        container.add(containerWidth);
        container.add(heightTextField);
        container.add(containerHeight);
        container.add(depthTextField);
        container.add(containerDepth);
        container.add(angleTextField);
        container.add(angle);
        container.add(zoomTextField);
        container.add(zoom);
        container.add(Zmultiply1TextField);
        container.add(Zmultiply1);
        container.add(Zmultiply2TextField);
        container.add(Zmultiply2);
        container.add(numberOfGenerationsTextField);
        container.add(numberOfGenerations);
        container.add(populationSizeTextField);
        container.add(populationSize);
        container.add(mutationRateTextField);
        container.add(mutationRate);
        container.add(centerPositionField);
        container.add(centerPosition);
        container.add(positionXField);
        container.add(positionX);
        container.add(positionYField);
        container.add(positionY);

        container.add(amountOfParcelsTextField);
        container.add(numberOfParcels);
        container.add(amountOfTPentominoTextField);
        container.add(numberOfPentominos1);
        container.add(amountOfPPentominoTextField);
        container.add(numberOfPentominos2);
        container.add(amountOfLPentominoTextField);
        container.add(numberOfPentominos3);

        container.add(greedy);
        container.add(genetic);
        //container.add(bruteForce);
        container.add(pentominoParcels);

        greedy.setSelected(Config.greedy);
        genetic.setSelected(Config.genetic);
        bruteForce.setSelected(Config.bruteForce);

        save = new JButton("Save");
        container.add(save);

        handler = new TextHandler();
        containerWidth.addActionListener(handler);
        save.addActionListener(handler);
        setSize(640, 850);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class TextHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save) {
                Config.containerWidth = Integer.parseInt(containerWidth.getText());
                Config.containerHeight = Integer.parseInt(containerHeight.getText());
                Config.containerDepth = Integer.parseInt(containerDepth.getText());
                Config.zoom = Double.parseDouble(zoom.getText());
                Config.zmultiply1 = Double.parseDouble(Zmultiply1.getText());
                Config.zmultiply2 = Double.parseDouble(Zmultiply2.getText());
                Config.numberOfParcels = Integer.parseInt(numberOfParcels.getText());
                Config.numberOfPentominos1 = Integer.parseInt(numberOfPentominos1.getText());
                Config.numberOfPentominos2 = Integer.parseInt(numberOfPentominos2.getText());
                Config.numberOfPentominos3 = Integer.parseInt(numberOfPentominos3.getText());
                Config.numberOfGenerations = Integer.parseInt(numberOfGenerations.getText());
                Config.populationSize = Integer.parseInt(populationSize.getText());
                Config.mutationRate = Double.parseDouble(mutationRate.getText());
                Config.centerPosition = Integer.parseInt(centerPosition.getText());
                Config.initialpositionX = Integer.parseInt(positionX.getText());
                Config.initialpositionY = Integer.parseInt(positionY.getText());

                if (greedy.isSelected() && !pentominoParcels.isSelected()) {
                    Config.setGreedyAlgorithm();
                    System.out.println("set to greedy algorithm");
                    //parcelgui.init();
                } else if (genetic.isSelected() && !pentominoParcels.isSelected()) {
                    Config.setGeneticAlgorithm();
                    System.out.println("set to genetic algorithm");
                    //parcelgui.init();
                } else if (bruteForce.isSelected() && !pentominoParcels.isSelected()) {
                    Config.setBruteForceAlgorithm();
                    //parcelgui.init();
                } else if (greedy.isSelected() && pentominoParcels.isSelected()) {
                    Config.setGreedyAlgorithm();
                    Config.pentominoParcels=true;
                } else if (genetic.isSelected() && pentominoParcels.isSelected()) {
                    Config.setGeneticAlgorithm();
                    Config.pentominoParcels=true;
                } /*else if (bruteForce.isSelected() && pentominoParcels.isSelected()) {
                    Config.setBruteForceAlgorithm();
                    Config.pentominoParcels=true;
                }*/

                //JOptionPane.showMessageDialog(null, disp);
                dispose();
                System.out.println("Config changed set to true!");
                if (Config.genetic)
                    Config.maxScore = 0;
                parcelgui.init();
                //parcelgui.repaint();


            }

        }
    }
}

