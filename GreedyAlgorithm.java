import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm {
    private ParcelGUI parcelGUI;

    public static void testGreedy(ContainerKnapsack container, ArrayList<Parcel> parcels, boolean useRotations, boolean randomize, ParcelGUI parcelGUI) {
        GreedyAlgorithm ga = new GreedyAlgorithm();
            ga.setParcelGUI(parcelGUI);

        long timeStart = System.currentTimeMillis();

        Collections.sort(parcels);
        int typeA = 0;
        int typeB = 0;
        int typeC = 0;


        for (Parcel curParcel : parcels) {

            if (container.getWeightLeft() == 0)
                break;

            Coordinate emptyCell = null;

            if (useRotations) {
                ArrayList<Parcel> rotations = curParcel.getRotations();

                if (randomize) {
                    int curRotation = 0;
                    while (curRotation < rotations.size()) {
                        int randRotation = (int)(Math.random() * rotations.size() + 1);
                        emptyCell = container.findCellToFitParcel(rotations.get(randRotation - 1));
                        if (emptyCell != null) {
                            container.fillParcel(emptyCell, rotations.get(randRotation - 1), 1);
                            if (rotations.get(randRotation - 1).getType() == 1)
                                typeA++;
                            else if (rotations.get(randRotation - 1).getType() == 2)
                                typeB++;
                            else
                                typeC++;

                            break;
                        }

                        curRotation++;
                    }
                }
                else
                {
                    for (Parcel curRotation : rotations) {
                        emptyCell = container.findCellToFitParcel(curRotation);
                        if (emptyCell != null) {
                            container.fillParcel(emptyCell, curRotation, 1);

                            if (curRotation.getType() == 1)
                                typeA++;
                            else if (curRotation.getType() == 2)
                                typeB++;
                            else
                                typeC++;

                            break;
                        }
                    }
                }
            }
            else {
                emptyCell = container.findCellToFitParcel(curParcel);
                if (emptyCell != null)
                    container.fillParcel(emptyCell, curParcel, 1);
            }
        }
        Config.maxScore=container.getTotalValue();
        parcelGUI.repaint();

        long timeEnd = System.currentTimeMillis();

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());
        System.out.println("Time of execution: " + (timeEnd - timeStart));
        System.out.println("Type A: " + typeA);
        System.out.println("Type B: " + typeB);
        System.out.println("Type C: " + typeC);


    }

    public static void testGreedyPentomino(ContainerKnapsack container, int max1, int max2, int max3) {

        long timeStart = System.currentTimeMillis();

        lParcel l = new lParcel(3,1);
        pParcel p = new pParcel(4,2);
        tParcel t = new tParcel(5,3);

        int amount1 = 0;
        int amount2 = 0;
        int amount3 = 0;
        boolean coulPut = true;
        while ((amount1 < max1) && coulPut){
            Coordinate cell = container.findCellToFitTPentomino(t);
            if (cell != null) {
                container.fillTParcel(cell, t, 1, 1);
                amount1++;
            }
            else coulPut = false;
        }
        coulPut = true;
        while (amount2 < max2 && coulPut){
            Coordinate cell = container.findCellToFitPPentomino(p);
            if (cell != null) {
                container.fillPParcel(cell, p, 1, 1);
                amount2++;
            }
            else coulPut = false;
        }
        coulPut = true;
        while (amount3 < max3 && coulPut){
            Coordinate cell = container.findCellToFitLPentomino(l);
            if (cell != null) {
                container.fillLParcel(cell, l, 1, 1);
                amount3++;
            }
            else coulPut = false;
        }




        long timeEnd = System.currentTimeMillis();
        //Config.maxScore=((amount1 * 5) + (amount2 * 4) + (amount3 * 3));
        System.out.println("Total container value: " + ((amount1 * 5) + (amount2 * 4) + (amount3 * 3)));
        System.out.println("Total number of parcels: " + container.getParcels().size());
        System.out.println("Time of execution: " + (timeEnd - timeStart));
        System.out.println("T Pentomino: " + amount1);
        System.out.println("P Pentomino: " + amount2);
        System.out.println("L Pentomino: " + amount3);


    }

    public static void testGreedyBacktrack(ContainerKnapsack container, ArrayList<Parcel> parcels) {



    }
    public void setParcelGUI(ParcelGUI parcelGUI) {
        this.parcelGUI = parcelGUI;
    }


}