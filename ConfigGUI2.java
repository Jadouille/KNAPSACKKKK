import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 19/01/2016.
 */
public class ConfigGUI2 extends JFrame {

    public ParcelGUI parcelGUI = new ParcelGUI();
    //Class Declarations
    JTextField containerWidth, containerHeight, containerDepth, zoom;
    JButton save;
    JTextArea widthTextField, heightTextField, depthTextField, zoomTextField;
    String disp = "Saved Successfully";
    TextHandler handler = null;

    public ConfigGUI2() {
        super("Edit Configuration");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        containerWidth = new JTextField(Integer.toString(parcelGUI.config.containerWidth), 55);
        widthTextField = new JTextArea("Enter Container Width");
        widthTextField.setEditable(false);

        containerHeight = new JTextField(Integer.toString(parcelGUI.config.containerHeight), 55);
        heightTextField = new JTextArea("Enter Container Height");
        heightTextField.setEditable(false);

        containerDepth = new JTextField(Integer.toString(parcelGUI.config.containerDepth), 55);
        depthTextField = new JTextArea("Enter Container Depth");
        depthTextField.setEditable(false);

        zoom = new JTextField(Double.toString(parcelGUI.config.zoom), 55);
        zoomTextField = new JTextArea("Enter Zoom Level");
        zoomTextField.setEditable(false);


        container.add(widthTextField);
        container.add(containerWidth);
        container.add(heightTextField);
        container.add(containerHeight);
        container.add(depthTextField);
        container.add(containerDepth);
        container.add(zoomTextField);
        container.add(zoom);

        save = new JButton("Save");
        container.add(save);


        handler = new TextHandler();
        containerWidth.addActionListener(handler);
        save.addActionListener(handler);
        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class TextHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save) {
                parcelGUI.config.containerWidth = Integer.parseInt(containerWidth.getText());
                parcelGUI.config.containerHeight = Integer.parseInt(containerHeight.getText());
                parcelGUI.config.containerDepth = Integer.parseInt(containerDepth.getText());
                parcelGUI.config.zoom = Double.parseDouble(zoom.getText());

                System.out.println("container width: " + parcelGUI.config.containerWidth);
                System.out.println("container height: " + parcelGUI.config.containerHeight);
                System.out.println("container depth: " + parcelGUI.config.containerDepth);
                parcelGUI.init();
                parcelGUI.repaint();
                JOptionPane.showMessageDialog(null, disp);
                dispose();
            }
        }
    }
}

