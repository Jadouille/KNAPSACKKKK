import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm {

    public static void main(String[] argv) {
        ArrayList<Parcel> parcels = DistributionGenerator.generateEvenDistribution(ParcelTypes.get(), 20);
        ContainerKnapsack container = new ContainerKnapsack(165, 40, 25);
        testGreedy(container, parcels);
    }

    public static void testGreedy(ContainerKnapsack container, ArrayList<Parcel> parcels) {
        Collections.sort(parcels);

        for (Parcel curParcel : parcels) {
            Coordinate emptyCell = container.findCellToFitParcel(curParcel);
            if (emptyCell != null) {
                container.fillParcel(emptyCell, curParcel, 1);
            }
        }

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());


    }



}