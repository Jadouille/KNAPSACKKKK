import java.util.ArrayList;

/**
 * Created by Użytkownik on 16.01.2016.
 */
public class BruteForceAlgorithm {

    public static void main(String[] args){
        ContainerKnapsack containerKnapsack = new ContainerKnapsack(40, 40, 25);
        ArrayList<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel(10, 10, 20, 3, 1));
        parcels.add(new Parcel(10, 15, 20, 4, 2));
        parcels.add(new Parcel(15, 15, 15, 5, 3));

        OptimalBruteForce(containerKnapsack, parcels, 100, 100, 100);
    }

    public static void OptimalBruteForce(ContainerKnapsack containerKnapsack, ArrayList<Parcel> parcels, int max1, int max2, int max3){
        boolean stop = false;
        ArrayList<Integer> max = new ArrayList<>();
        max.add(max1); max.add(max2); max.add(max3);
        for (int x = 0; x < max1; x++){
            for (int y = 0; y < max2; y++){
                for (int z = 0; z < max3; z++){
                    int sum = (2000 * x) + (3000 * y) + (3375 * z);
                    if (sum == containerKnapsack.getWeight() && !stop){
                        bruteForce(containerKnapsack, parcels, max);
                        System.out.println((2000 * x) + (3000 * y) + (3375 * z));
                        System.out.println("type 1: " + x + " type 2: " + y + " type 3: " + z);
                    }
                    if (stop)
                        break;
                }
                if (stop)
                    break;
            }
            if (stop)
                break;
        }
    }

    public static void bruteForce(ContainerKnapsack container, ArrayList<Parcel> parcels, ArrayList<Integer> max){
        for (Parcel curParcel : parcels){
            curParcel.generateRotations();
        }
        ArrayList<Integer> amount = new ArrayList<>(max.size());
        ContainerKnapsack result = new ContainerKnapsack(container.getLength(), container.getHeight(), container.getWidth());
        boolean run = true;
        ArrayList<Integer> type = new ArrayList<>();
        ArrayList<Integer> resultType = new ArrayList<>();
        ArrayList<Integer> rotation = new ArrayList<>();
        ArrayList<Integer> resultRotation = new ArrayList<>();
        ArrayList<Coordinate> cells = new ArrayList<>();
        ArrayList<Parcel> parcelsPut = new ArrayList<>();
        int lastType = 0;
        int lastRotation = 0;
        Coordinate lastCell;
        Parcel lastParcel;
        int action = 0;
        int backTrack = 0;
        boolean backTrackPut = false;
        boolean full = false;

        while (run){
            backTrackPut = false;
            for (int i = 0; i < parcels.size(); i++){
                if (amount.get(i) < max.get(i)){
                    for (int j = 0; j < parcels.get(i).getRotations().size(); j++){
                        Coordinate cell = container.findCellToFitParcel(parcels.get(i).getRotations().get(j));
                        if (!container.checkCollision(parcels.get(i).getRotations().get(j), cell)){
                            container.fillParcel(cell,parcels.get(i).getRotations().get(j),1);
                            amount.set(i,amount.get(1) + 1);
                            type.add(i);
                            rotation.add(j);
                            cells.add(cell);
                            i--;
                            break;
                        }
                    }
                }
            }
            full = true;
            for (int i = 0; i < parcels.size(); i++){
                if(amount.get(i) != max.get(i))
                    full = false;
            }
            if (!full){
                if(container.getTotalValue() > result.getTotalValue()){
                    result.setParcels(new ArrayList<>(container.getParcels()));
                }
                while(!backTrackPut && container.getParcels().size() != 0) {
                    lastCell = cells.get(cells.size() - 1);
                    cells.remove(cells.size() - 1);
                    lastRotation = rotation.get(rotation.size() - 1);
                    rotation.remove(rotation.size() - 1);
                    lastType = type.get(type.size() - 1);
                    type.remove(type.size() - 1);
                    container.removeLastParcel(lastCell);
                    for (int i = lastType; i < parcels.size(); i++){
                        if (amount.get(i) < max.get(i)){
                            for (int j = lastRotation; j < parcels.get(i).getRotations().size(); j++){
                                Coordinate cell = container.findCellToFitParcel(parcels.get(i).getRotations().get(j));
                                if (!container.checkCollision(parcels.get(i).getRotations().get(j), cell)){
                                    container.fillParcel(cell,parcels.get(i).getRotations().get(j),1);
                                    amount.set(i,amount.get(1) + 1);
                                    type.add(i);
                                    rotation.add(j);
                                    cells.add(cell);
                                    i--;
                                    backTrackPut = true;
                                    break;
                                }
                            }
                        }
                        if (backTrackPut)
                            break;
                    }
                }
                if (container.getParcels().size() == 0)
                    run = false;
            } else {
                result.setParcels(new ArrayList<>(container.getParcels()));
                run = false;
            }
        }
        container.setParcels(result.getParcels());
        System.out.println();
        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());
        int cntr1 = 0;
        int cntr2 = 0;
        int cntr3 = 0;
        for(Parcel curParcel : container.getParcels()) {
            if (curParcel.getType() == 1)
                cntr1++;
            if (curParcel.getType() == 2)
                cntr2++;
            if (curParcel.getType() == 3)
                cntr3++;
        }
        System.out.println("amount of parcel 1 " + cntr1);
        System.out.println("amount of parcel 2 " + cntr2);
        System.out.println("amount of parcel 3 " + cntr3);
        for (int i = 0; i < resultType.size(); i++) {
            System.out.println("Parcel " + (i + 1) + " = " + resultType.get(i) + "in rotation = " + resultRotation.get(i));
        }
    }

    public static void BruteForcePentominoes(){

    }

}
