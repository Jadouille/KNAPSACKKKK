import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 15/01/2016.
 */
public class KnapSack extends JFrame {
    public static void main(String[] args) {

        final ParcelGUI parcelGUI = new ParcelGUI();

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        parcelGUI.setFocusable(true);
        JFrame j = new JFrame();

        JComboBox selectAlgorithm = new JComboBox(parcelGUI.config.algorithmNames);
        if (parcelGUI.config.greedy)
            selectAlgorithm.setSelectedIndex(0);
        if (parcelGUI.config.genetic)
            selectAlgorithm.setSelectedIndex(1);
        if (parcelGUI.config.bruteForce)
            selectAlgorithm.setSelectedIndex(2);

        selectAlgorithm.setFocusable(false);
        selectAlgorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String selectedAlgorithm = (String) combo.getSelectedItem();


                if (selectedAlgorithm.equals(parcelGUI.config.algorithmNames[0])) {
                    if (!parcelGUI.config.greedy) {
                        parcelGUI.config.setGreedyAlgorithm();
                        parcelGUI.init();
                        parcelGUI.config.printBooleans();
                        System.out.println("greedy");
                    }
                } else if (selectedAlgorithm.equals(parcelGUI.config.algorithmNames[1])) {
                    if (!parcelGUI.config.genetic) {
                        parcelGUI.config.setGeneticAlgorithm();
                        parcelGUI.init();
                        parcelGUI.config.printBooleans();
                        System.out.println("genetic");
                    }
                } else if (selectedAlgorithm.equals(parcelGUI.config.algorithmNames[2])) {
                    if (!parcelGUI.config.bruteForce) {
                        parcelGUI.config.setBruteForceAlgorithm();
                        parcelGUI.config.printBooleans();
                        System.out.println("bruteforce");
                        parcelGUI.init();
                    }
                } else if (selectedAlgorithm.equals(parcelGUI.config.algorithmNames[3])) {
                    parcelGUI.config.setConfig();
                    ConfigGUI2 configGUI2 = new ConfigGUI2();
                    parcelGUI.init();
                    System.out.println("inited");
                    parcelGUI.repaint();
                    System.out.println("repainted");
                }
            }
        });

        j.add(selectAlgorithm, BorderLayout.NORTH);
        j.add(parcelGUI);
        j.setSize(screenWidth, screenHeight);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
