import javax.swing.*;
import java.awt.*;

/**
 * Created by Anthony on 15/01/2016.
 */
public class KnapSack {

    public static void main(String[] args) {

        final ParcelGUI parcelGUI = new ParcelGUI();

        parcelGUI.setFocusable(true);

        GUIConfig GUIConfig = new GUIConfig();
        GUIConfig.setVisible(false);
        GUIConfig.parcelgui = parcelGUI;

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight() - 100;



        JFrame j = new JFrame();
        JButton configButton = new JButton("config");
        JButton startButton = new JButton("Start Algorithm");
        startButton.setFocusable(false);
        configButton.setFocusable(false);


        j.add(configButton, BorderLayout.NORTH);
        j.add(startButton, BorderLayout.SOUTH);
        j.add(parcelGUI, BorderLayout.CENTER);
        j.setSize(screenWidth, screenHeight);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        configButton.addActionListener(e -> {
            GUIConfig.setFocusable(true);
            GUIConfig.setVisible(true);

        });

        startButton.addActionListener(e -> {
            parcelGUI.init();
            parcelGUI.repaint();
        });
    }
}
