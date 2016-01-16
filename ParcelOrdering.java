import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ParcelOrdering implements Comparable {

    public ParcelOrdering() {}

    public ParcelOrdering(ArrayList<Parcel> value) {
        ordering = value;
    }

    public Parcel get(int index) {
        return ordering.get(index);
    }

    public int getSize() {
        return ordering.size();
    }

    public void add(Parcel parcel) { ordering.add(parcel); }

    public int calculateFitness() {
        return 0;
    }

    @Override
    public int compareTo(Object compareWith) {
        return this.calculateFitness() - ((ParcelOrdering)compareWith).calculateFitness();
    }

    private ArrayList<Parcel> ordering = new ArrayList<>();
}
