import java.util.ArrayList;
import java.util.Collections;

public class GreedyAlgorithm {

    public static void main(String[] argv) {

        Parcel typeA = new Parcel(10, 10, 20, 3, 1);
        Parcel typeB = new Parcel(10, 15, 20, 4, 2);
        Parcel typeC = new Parcel(15, 15, 15, 5, 3);

        ArrayList<Parcel> parcelPrototypes = new ArrayList<>();
        parcelPrototypes.add(typeA);
        parcelPrototypes.add(typeB);
        parcelPrototypes.add(typeC);

        ArrayList<Parcel> parcels = generateParcelDistribution(parcelPrototypes);
        ContainerKnapsack container = new ContainerKnapsack(165, 40, 25);
        testGreedy(container, parcels);
    }

    public static void testGreedy(ContainerKnapsack container, ArrayList<Parcel> parcels)
    {
        Collections.sort(parcels);

        for (Parcel curParcel : parcels)
        {
            Coordinate emptyCell = container.findCellToFitParcel(curParcel);
            if (emptyCell != null)
            {
                container.fillParcel(emptyCell, curParcel, 1);
            }
        }

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());
    }


    public static ArrayList<Parcel> generateParcelDistribution(ArrayList<Parcel> parcelTypes) {
        ArrayList<Parcel> result = new ArrayList<Parcel>();

        int amountOfParcelsPerType = 20;

        for (Parcel curType : parcelTypes) {
            for (int curParcel = 0; curParcel < amountOfParcelsPerType; curParcel++) {
                result.add(curType.clone());
            }
        }

        return result;
    }
}