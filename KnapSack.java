import javax.sound.midi.MidiDevice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 15/01/2016.
 */
public class KnapSack {

    public static void main(String[] args) {

        final ParcelGUI parcelGUI = new ParcelGUI();
        final InfoGUI infoGUI = new InfoGUI();

        parcelGUI.setFocusable(true);

        ConfigGUI configGUI = new ConfigGUI();
        configGUI.parcelgui = parcelGUI;

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight() - 100;

        configGUI.setVisible(false);

        JFrame j = new JFrame();
        JButton configButton = new JButton("config");
        JButton startButton = new JButton("Start Algorithm");
        startButton.setFocusable(false);
        configButton.setFocusable(false);

        j.add(configButton, BorderLayout.NORTH);
        j.add(startButton, BorderLayout.SOUTH);
        j.add(parcelGUI, BorderLayout.CENTER);
        j.add(infoGUI, BorderLayout.EAST);
        j.setSize(screenWidth, screenHeight);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        configButton.addActionListener(e -> {
            configGUI.setFocusable(true);
            configGUI.setVisible(true);

        });

        startButton.addActionListener(e -> {
            parcelGUI.init();
            parcelGUI.repaint();
        });
    }
}
