import java.util.ArrayList;
import java.util.Collections;

public class GeneticAlgorithm {
    private static int max = 0;
    public GeneticAlgorithm(int populationSize,
                            int numberOfGenerations,
                            Recombinator recombinator,
                            Mutator mutator,
                            ContainerKnapsack container) {
        ParcelTypes types = new ParcelTypes();
        ArrayList<Parcel> ordering = DistributionGenerator.generateEvenDistributionWithRotations(types.getParcelProtoTypes(), 5);

        for (int curIndividual = 0; curIndividual < populationSize; curIndividual++) {
            Collections.shuffle(ordering);
            population.add(new ParcelOrdering(ordering, container));
        }

        this.numberOfGenerations = numberOfGenerations;
        this.recombinator = recombinator;
        this.mutator = mutator;
        this.container = container;
    }

    public static void testGenetic(ContainerKnapsack container, ArrayList<Parcel> parcels, ParcelGUI parcelGUI) {

        long timeStart = System.currentTimeMillis();

        Recombinator recombinator = new AlternatingRecombinator();
        Mutator mutator = new ConstantMutator(Config.mutationRate);
        GeneticAlgorithm ga = new GeneticAlgorithm(Config.populationSize, Config.numberOfGenerations, recombinator, mutator, container);
        ga.setParcelGUI(parcelGUI);

        ArrayList<ParcelOrdering> result = ga.evolve(container);
        Collections.sort(result, Collections.reverseOrder());

        result.get(0).printWholeOrdering();
        ga.printGeneration(Config.numberOfGenerations, result);

        long timeEnd = System.currentTimeMillis();

        System.out.println("Total container value: " + container.getTotalValue());
        System.out.println("Total number of parcels: " + container.getParcels().size());
        System.out.println("Time of execution: " + (timeEnd - timeStart));

    }

    public ArrayList<ParcelOrdering> evolve(ContainerKnapsack container) {

        ArrayList<ParcelOrdering> result = new ArrayList<ParcelOrdering>(population);

        for (int curGeneration = 0; curGeneration < numberOfGenerations; curGeneration++) {



            container.clear();
            System.out.println("Before sorting: ");
            printGeneration(curGeneration, result);


            Collections.sort(result, Collections.reverseOrder());

            System.out.println("After sorting: ");
            printGeneration(curGeneration, result);

            result.get(0).printFittedParcels();



            ArrayList<ParcelOrdering> elitist = getElitists(0.5f, result);
            ArrayList<ParcelOrdering> offspingsFirst = getOffsprings(elitist);
            ArrayList<ParcelOrdering> offspingsSecond = getOffsprings(elitist);
            ArrayList<ParcelOrdering> mutatedOffspringsFirst = mutate(offspingsFirst);
            ArrayList<ParcelOrdering> mutatedOffspringsSecond = mutate(offspingsSecond);


            result.clear();

            result.addAll(elitist);
            result.addAll(mutatedOffspringsFirst);
            result.addAll(mutatedOffspringsSecond);

           // printGeneration(curGeneration, result);
        }

        return  result;
    }

    public void printGeneration(int curGeneration, ArrayList<ParcelOrdering> result) {
        System.out.println("Generation " + curGeneration + ": ");

        for (ParcelOrdering curOrdering : result) {
            int fitness = curOrdering.calculateFitness();
            System.out.println(fitness);
            if (max < fitness) {
                max = fitness;
                System.out.println("found better value combination");
                Config.maxScore = max;
                parcelGUI.repaint();

            }
        }

    }


    public ArrayList<ParcelOrdering> getElitists(float ratio, ArrayList<ParcelOrdering> population) {
        Collections.sort(population, Collections.reverseOrder());

        int toIndex = (int)(population.size() * ratio);
        ArrayList<ParcelOrdering> elitist = new ArrayList<ParcelOrdering>(population.subList(0, toIndex));

        return  elitist;
    }

    public ArrayList<ParcelOrdering> getOffsprings(ArrayList<ParcelOrdering> ancestors) {
        ArrayList<ParcelOrdering> result = new ArrayList<>();
        for (int cPair = 0; cPair < ancestors.size() - 1; cPair += 2)
        {
            ParcelOrdering newBorn = recombinator.recombine(ancestors.get(cPair), ancestors.get(cPair + 1));
            result.add(newBorn);
        }

        return result;
    }


    public ArrayList<ParcelOrdering> mutate(ArrayList<ParcelOrdering> offsprings) {
        ArrayList<ParcelOrdering> result = new ArrayList<>();

        for (ParcelOrdering curOrdering : offsprings) {
            result.add(mutator.mutate(curOrdering));
        }

        return result;
    }

    public void setParcelGUI(ParcelGUI parcelGUI) {
        this.parcelGUI = parcelGUI;
   }



    private int numberOfGenerations = 0;
    private ArrayList<ParcelOrdering> population  = new ArrayList<>();
    private Recombinator recombinator;
    private Mutator mutator;
    private ContainerKnapsack container;
    private ParcelGUI parcelGUI;

}