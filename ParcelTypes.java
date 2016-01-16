import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ParcelTypes {
    public ArrayList<Parcel> parcelPrototypes = new ArrayList<>();
    private Parcel typeA;
    private Parcel typeB;
    private Parcel typeC;

    public ParcelTypes() {
        typeA = new Parcel(10, 10, 10, 3, 1);
        typeB = new Parcel(10, 15, 20, 4, 2);
        typeC = new Parcel(15, 15, 15, 5, 3);
        setParcelTypes();
    }

    public Parcel getParcelType(int i) {
        switch (i) {
            case 1:
                return typeA;
            case 2:
                return typeB;
            case 3:
                return typeC;
            default:
                return typeA;
        }
    }

    public ArrayList<Parcel> getParcelProtoTypes() {

        return parcelPrototypes;
    }

    public void setParcelTypes() {
        parcelPrototypes.add(getParcelType(1));
        parcelPrototypes.add(getParcelType(2));
        parcelPrototypes.add(getParcelType(3));
    }

}
