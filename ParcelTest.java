import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class ParcelTest extends Applet {

    public void paint(Graphics g){

        Parcel typeA = new Parcel(10, 10, 20, 3, 1);
        Parcel typeB = new Parcel(10, 15, 20, 4, 2);
        Parcel typeC = new Parcel(15, 15, 15, 5, 3);

        ArrayList<Parcel> parcelPrototypes = new ArrayList<>();
        parcelPrototypes.add(typeA);
        parcelPrototypes.add(typeB);
        parcelPrototypes.add(typeC);

        ArrayList<Parcel> parcels = GreedyAlgorithm.generateParcelDistribution(parcelPrototypes);
        ContainerKnapsack container = new ContainerKnapsack(165, 40, 25);
        GreedyAlgorithm.testGreedy(container, parcels);
        ArrayList<Parcel> containerParcels = container.getParcels();

        Projector viewer = new Projector(new Coordinate(56, 15, 50));
        Parcel debugParcel = new Parcel(10, 10, 15, 1, 1);
        //debugParcel.setCornerCoords(new Coordinate(100, 100, 100));
        //viewer.draw(g, debugParcel);

        for (Parcel curParcels : containerParcels){
            viewer.draw(g, curParcels);
        }

    }



}
