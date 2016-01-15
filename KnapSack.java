import javax.swing.*;

/**
 * Created by Anthony on 15/01/2016.
 */
public class KnapSack {

    public static void main(String[] args) {
        ParcelGUI parcelGUI = new ParcelGUI();
        parcelGUI.setFocusable(true);
        JFrame j = new JFrame();
        j.add(parcelGUI);
        j.setSize(1024, 768);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
