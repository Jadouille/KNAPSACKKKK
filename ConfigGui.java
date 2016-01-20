import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfigGUI {

    JFrame frame;
    JButton button;

    public ConfigGUI() {
        frame = new JFrame("Config");
        button = new JButton("Save Config");
        JTextField containerWidth = new JTextField("test");

        JPanel panel = new JPanel();

        panel.add(button);

        frame.add(containerWidth);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(640, 468);
        frame.setVisible(true);
    }

    public void setButtonActionListener(ActionListener al) {
        button.addActionListener(al);
    }

    // gui method to check if box is checked


}

