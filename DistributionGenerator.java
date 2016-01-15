import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class DistributionGenerator {

    public static ArrayList<Parcel> generateEvenDistribution(ArrayList<Parcel> parcelTypes, int amountOfParcelsPerType) {
        ArrayList<Parcel> result = new ArrayList<Parcel>();

        for (Parcel curType : parcelTypes) {
            for (int curParcel = 0; curParcel < amountOfParcelsPerType; curParcel++) {
                result.add(curType.clone());
            }
        }

        return result;
    }


}
