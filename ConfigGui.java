import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 19/01/2016.
 */
public class ConfigGUI extends JFrame {

    //Class Declarations
    JTextField containerWidth, containerHeight, containerDepth, zoom, Zmultiply1, Zmultiply2;
    JButton save;
    JTextArea widthTextField, heightTextField, depthTextField, zoomTextField, Zmultiply1TextField, Zmultiply2TextField;
    JRadioButton greedy, genetic, bruteForce;
    String disp = "Saved Successfully";
    TextHandler handler = null;

    public ParcelGUI parcelgui = null;

    public ConfigGUI() {
        super("Edit Configuration");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        init(container);
    }
    public void init(Container container){

        containerWidth = new JTextField(Integer.toString(Config.containerWidth), 55);
        widthTextField = new JTextArea("Enter Container Width");
        widthTextField.setEditable(false);

        containerHeight = new JTextField(Integer.toString(Config.containerHeight), 55);
        heightTextField = new JTextArea("Enter Container Height");
        heightTextField.setEditable(false);

        containerDepth = new JTextField(Integer.toString(Config.containerDepth), 55);
        depthTextField = new JTextArea("Enter Container Depth");
        depthTextField.setEditable(false);

        zoom = new JTextField(Double.toString(Config.zoom), 55);
        zoomTextField = new JTextArea("Enter Zoom Level");
        zoomTextField.setEditable(false);

        Zmultiply1 = new JTextField(Double.toString(Config.zmultiply1), 55);
        Zmultiply1TextField = new JTextArea("Enter Zmultiply1 Level");
        Zmultiply1TextField.setEditable(false);

        Zmultiply2 = new JTextField(Double.toString(Config.zmultiply2), 55);
        Zmultiply2TextField = new JTextArea("Enter Zmultiply2 Level");
        Zmultiply2TextField.setEditable(false);

        ButtonGroup group = new ButtonGroup();
        greedy = new JRadioButton("Greedy Algorithm");
        genetic = new JRadioButton("Genetic Algorithm");
        bruteForce = new JRadioButton("Brute Force");
        group.add(greedy);
        group.add(genetic);
        group.add(bruteForce);

        container.add(widthTextField);
        container.add(containerWidth);
        container.add(heightTextField);
        container.add(containerHeight);
        container.add(depthTextField);
        container.add(containerDepth);
        container.add(zoomTextField);
        container.add(zoom);
        container.add(Zmultiply1TextField);
        container.add(Zmultiply1);
        container.add(Zmultiply2TextField);
        container.add(Zmultiply2);
        container.add(greedy);
        container.add(genetic);
        container.add(bruteForce);

        greedy.setSelected(Config.greedy);
        genetic.setSelected(Config.genetic);
        bruteForce.setSelected(Config.bruteForce);

        save = new JButton("Save");
        container.add(save);

        handler = new TextHandler();
        containerWidth.addActionListener(handler);
        save.addActionListener(handler);
        setSize(640, 340);
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

                if (greedy.isSelected()) {
                    Config.setGreedyAlgorithm();
                    System.out.println("set to greedy algorithm");
                    parcelgui.init();
                } else if (genetic.isSelected()) {
                    Config.setGeneticAlgorithm();
                    System.out.println("set to genetic algorithm");
                    parcelgui.init();
                } else if (bruteForce.isSelected()) {
                    Config.setBruteForceAlgorithm();
                    parcelgui.init();
                }

                JOptionPane.showMessageDialog(null, disp);
                parcelgui.init();
                parcelgui.repaint();
                System.out.println("Config changed set to true!");
                dispose();
            }

        }
    }
}

