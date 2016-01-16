import java.util.ArrayList;

/**
 * Created by Michael on 15.01.2016.
 */
public class AlternatingRecombinator implements Recombinator {
    public ParcelOrdering recombine (ParcelOrdering p1, ParcelOrdering p2) {
        ParcelOrdering result = new ParcelOrdering();

        for (int curParcel = 0; curParcel < p1.getSize(); curParcel++) {
            if (curParcel % 2 == 0)
                result.add(p1.get(curParcel));
            else
                result.add(p2.get(curParcel));
        }

        return  result;
    }
}
