/**
 * Created by Michael on 15.01.2016.
 */
public class ConstantMutator extends Mutator {
    public ConstantMutator(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public void mutate(ParcelOrdering ordering)
    {
     /*   char[] chrom = i.getChromosome();
        for (int curGene = 0; curGene < i.getChromosome().length; curGene++) {
            if (Math.random() <= mutationRate) {
                int letter = (int) (Math.random() * GeneticAlgorithm.alphabet.length);
                chrom[curGene] = GeneticAlgorithm.alphabet[letter];
            }
        }
        */
    }



    private double mutationRate;
}
