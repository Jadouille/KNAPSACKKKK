import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ParcelTypes {

    public static ArrayList<Parcel> get() {
        Parcel typeA = new Parcel(10, 10, 10, 3, 1);
        Parcel typeB = new Parcel(10, 15, 20, 4, 2);
        Parcel typeC = new Parcel(15, 15, 15, 5, 3);

        ArrayList<Parcel> parcelPrototypes = new ArrayList<>();
        parcelPrototypes.add(typeA);
        parcelPrototypes.add(typeB);
        parcelPrototypes.add(typeC);

        return  parcelPrototypes;
    }
}
