import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm {


    public static void main(String[] argv) {
        ParcelTypes parcelTypes = new ParcelTypes();
        ArrayList<Parcel> parcels = DistributionGenerator.generateEvenDistribution(parcelTypes.getParcelProtoTypes(), 20);
        ContainerKnapsack container = new ContainerKnapsack(165, 40, 25);
        testGreedy(container, parcels, false);

    }

    public static void testGreedy(ContainerKnapsack container, ArrayList<Parcel> parcels, boolean useRotations) {
        Collections.sort(parcels);

        for (Parcel curParcel : parcels) {

            if (container.getWeightLeft() == 0)
                break;

            if (useRotations) {
                ArrayList<Parcel> rotations = curParcel.generateRotations();
                for (Parcel curRotation : rotations) {
                    Coordinate emptyCell = container.findCellToFitParcel(curRotation);
                    if (emptyCell != null) {
                        container.fillParcel(emptyCell, curRotation, 1);
                        break;
                    }
                }
            }
            else {
                Coordinate emptyCell = container.findCellToFitParcel(curParcel);
                if (emptyCell != null)
                    container.fillParcel(emptyCell, curParcel, 1);
            }
        }

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());


    }

    public static void testGreedyBacktrack(ContainerKnapsack container, ArrayList<Parcel> parcels) {



    }



}