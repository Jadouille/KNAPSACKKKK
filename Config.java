/**
 * Created by Anthony on 19/01/2016.
 */
public class Config {

    public int numberOfParcels = 20;
    public int containerWidth = 165;
    public int containerHeight = 40;
    public int containerDepth = 25;

    public double zoom = 0.036;
    public double zmultiply1 = 0.027;
    public double zmultiply2 = 0.027;
    public double angle = 0.0006;

    public boolean greedy = false;
    public boolean randomRotations = false;
    public boolean genetic = true;
    public boolean bruteForce = false;
    public boolean pentominoParcels = false;

    public String algorithmNames[] = {"Greedy Algorithm", "Genetic Algorithm", "Brute Force"};

    public void setGreedyAlgorithm() {
        greedy = true;
        genetic = false;
        bruteForce = false;
    }

    public void setGeneticAlgorithm() {
        greedy = false;
        genetic = true;
        bruteForce = false;
    }

    public void setBruteForceAlgorithm() {
        greedy = false;
        genetic = false;
        bruteForce = true;
    }

    public void printBooleans() {
        System.out.println(greedy);
        System.out.println(genetic);
        System.out.println(bruteForce);
    }

}
