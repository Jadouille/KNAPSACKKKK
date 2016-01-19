import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm {

    public static void main(String[] argv) {
        ArrayList<Parcel> parcels = DistributionGenerator.generateEvenDistribution(ParcelTypes.get(), 20);
        ContainerKnapsack container = new ContainerKnapsack(165, 40, 25);
        testGreedy(container, parcels, false, false);

    }

    public static void testGreedy(ContainerKnapsack container, ArrayList<Parcel> parcels, boolean useRotations, boolean randomize) {

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

        long timeEnd = System.currentTimeMillis();

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());
        System.out.println("Time of execution: " + (timeEnd - timeStart));
        System.out.println("Type A: " + typeA);
        System.out.println("Type B: " + typeB);
        System.out.println("Type C: " + typeC);


    }

    public static void testGreedyBacktrack(ContainerKnapsack container, ArrayList<Parcel> parcels) {



    }



}