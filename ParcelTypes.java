import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ParcelTypes {

    public static ArrayList<Parcel> get() {
        ArrayList<Parcel> parcelPrototypes = new ArrayList<>();

        parcelPrototypes.add(typeA);
        parcelPrototypes.add(typeB);
        parcelPrototypes.add(typeC);

        return  parcelPrototypes;
    }

    static Parcel typeA = new Parcel(10, 10, 20, 3, 1);
    static Parcel typeB = new Parcel(10, 15, 20, 4, 2);
    static Parcel typeC = new Parcel(15, 15, 15, 5, 3);
}
