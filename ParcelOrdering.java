import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class ParcelOrdering implements Comparable {

    public ParcelOrdering() {}

    public ParcelOrdering(ArrayList<Parcel> value, ContainerKnapsack container) {
        ordering = new ArrayList<Parcel>(value);
        this.container = container;
    }

    public Parcel get(int index) {
        return ordering.get(index);
    }

    public int getSize() {
        return ordering.size();
    }

    public void add(Parcel parcel) { ordering.add(parcel); fitness = -1; }

    public void set(Parcel parcel, int index) { ordering.set(index, parcel); fitness = -1; }

    public void set(ContainerKnapsack container) { this.container = container; }

    public ContainerKnapsack get() { return container; }

    public void printFittedParcels() {

        System.out.println("Type A: " + typeA);
        System.out.println("Type B: " + typeB);
        System.out.println("Type C: " + typeC);
    }

    public void printWholeOrdering() {
        for (Parcel curParcel : ordering) {
            System.out.println("Parcel type: " + curParcel.getType() + ", value: " + curParcel.getValue()  + ", length: " + curParcel.getLength() + " height: " + curParcel.getHeight() + " width: " + curParcel.getWidth());
        }
    }

    public int calculateFitness()
    {
        if (fitness == -1) {
            for (Parcel curParcel : ordering) {
                Coordinate emptyCell = container.findCellToFitParcel(curParcel);
                if (emptyCell != null) {
                    container.fillParcel(emptyCell, curParcel, 1);

                    if (curParcel.getType() == 1)
                        typeA++;
                    else if (curParcel.getType() == 2)
                        typeB++;
                    else
                        typeC++;
                }
                else
                    break;
            }

            fitness = container.getTotalValue();

            container.clear();

            return fitness;
        }
        else
            return fitness;
    }

    @Override
    public int compareTo(Object compareWith) {
        return this.calculateFitness() - ((ParcelOrdering)compareWith).calculateFitness();
    }

    public ParcelOrdering clone() {
        return new ParcelOrdering(this.ordering, this.container);
    }

    private ArrayList<Parcel> ordering = new ArrayList<>();
    private ContainerKnapsack container = null;//new ContainerKnapsack(165, 40, 25);
    private int fitness = -1;
    private int typeA = 0;
    private int typeB = 0;
    private int typeC = 0;
}
