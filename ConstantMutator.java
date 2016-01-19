import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ConstantMutator extends Mutator {
    public ConstantMutator(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public ParcelOrdering mutate(ParcelOrdering ordering)
    {
        ParcelOrdering result = new ParcelOrdering();

        result.set(ordering.get());

        ArrayList<Parcel> prototypes = ParcelTypes.get();


        for (int curParcel = 0; curParcel < ordering.getSize(); curParcel++) {
            result.add(ordering.get(curParcel));
            if (Math.random() <= mutationRate) {

                int randomType = (int) (Math.random() * prototypes.size());
                Parcel mutatedParcel = prototypes.get(randomType);

                ArrayList<Parcel> rotations = mutatedParcel.getRotations();
                int randRotation = (int)(Math.random() * rotations.size() + 1);

                Parcel randomRotation = rotations.get(randRotation - 1);

                result.set(randomRotation, curParcel);
            }
        }

        return result;
    }



    private double mutationRate;
}
