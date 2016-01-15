import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GeneticAlgorithm {
    public GeneticAlgorithm(int populationSize,
                            int numberOfGenerations,
                            Recombinator recombinator) {
        ArrayList<Parcel> ordering = DistributionGenerator.generateEvenDistribution(ParcelTypes.get(), 5);

        for (int curIndividual = 0; curIndividual < populationSize; curIndividual++) {
            Collections.shuffle(ordering);
            population.add(new ParcelOrdering(ordering));
        }

        this.numberOfGenerations = numberOfGenerations;
        this.recombinator = recombinator;
    }

    public ArrayList<ParcelOrdering> evolve() {


        ArrayList<ParcelOrdering> result = null; //population.clone();

        /*
        for (int curGeneration = 0; curGeneration < numberOfGenerations; curGeneration++) {
            ArrayList<ParcelOrdering> elitist = getElitists(0.5f, population);
            ArrayList<ParcelOrdering> offspings = getOffspings(elitist);

        }
        */

        return  result;
    }

    public ArrayList<ParcelOrdering> getElitists(float ratio, ArrayList<ParcelOrdering> population) {
        Collections.sort(population, Collections.reverseOrder());

        int toIndex = (int)(population.size() * ratio);
        ArrayList<ParcelOrdering> elitist = (ArrayList<ParcelOrdering>)population.subList(0, toIndex);

        return  elitist;
    }

    public ArrayList<ParcelOrdering> getOffspings(ArrayList<ParcelOrdering> ancestors) {
        ArrayList<ParcelOrdering> result = new ArrayList<>();
        for (int cPair = 0; cPair < ancestors.size() - 1; cPair += 2)
        {
            ParcelOrdering newBorn = recombinator.recombine(ancestors.get(cPair), ancestors.get(cPair + 1));
            result.add(newBorn);
        }

        return result;
    }



    private int numberOfGenerations = 0;
    private ArrayList<ParcelOrdering> population  = new ArrayList<>();
    private Recombinator recombinator;

}