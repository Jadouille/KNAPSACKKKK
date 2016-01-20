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
                System.out.println("Adding parcel type " + result.size());
            }
        }

        return result;
    }


    public static ArrayList<Parcel> generateEvenDistributionWithRotations(ArrayList<Parcel> parcelTypes, int amountOfParcelsPerType) {
        ArrayList<Parcel> result = new ArrayList<Parcel>();

        for (Parcel curType : parcelTypes) {
            Parcel parcel = curType.clone();
            for (int curParcel = 0; curParcel < amountOfParcelsPerType; curParcel++) {
                ArrayList<Parcel> rotations = parcel.getRotations();
                for (Parcel curRotation : rotations) {
                    result.add(curRotation);
                }
            }
        }

        return result;
    }

    public static ArrayList<Parcel> generateUnevenDistribution(ArrayList<Parcel> parcelTypes, int typeA, int typeB, int typeC) {
        ArrayList<Parcel> result = new ArrayList<Parcel>();

        for (Parcel curType : parcelTypes) {

            for (int curParcel = 0; curParcel < typeA; curParcel++) {
                result.add(curType.clone());
            }

            for (int curParcel = 0; curParcel < typeB; curParcel++) {
                result.add(curType.clone());
            }

            for (int curParcel = 0; curParcel < typeC; curParcel++) {
                result.add(curType.clone());
            }

        }

        return result;
    }

}
