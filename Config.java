/**
 * Created by Anthony on 19/01/2016.
 */
public class Config {

    public int numberOfParcels = 20;
    public int containerWidth = 20;
    public int containerHeight = 20;
    public int containerDepth = 20;

    public double zoom = 0.08;
    public double angle = 0.0008;

    public boolean greedy = true;
    public boolean randomRotations = false;
    public boolean genetic = false;
    public boolean bruteForce = false;
    public boolean pentominoParcels = false;

    public void setGreedyAlgorithm() {
        boolean greedy = true;
        boolean genetic = false;
        boolean bruteForce = false;
    }

    public void setGeneticAlgorithm() {
        boolean greedy = false;
        boolean genetic = true;
        boolean bruteForce = false;
    }

    public void setBruteForceAlgorithm() {
        boolean greedy = false;
        boolean genetic = false;
        boolean bruteForce = true;
    }

}
