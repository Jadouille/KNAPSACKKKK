/**
 * Created by Anthony on 19/01/2016.
 */
public class Config {

    public int numberOfParcels = 20;
    public int containerWidth = 165;
    private int containerHeight = 40;
    public int containerDepth = 25;

    public double zoom = 0.036;
    public double zmultiply1 = 0.027;
    public double zmultiply2 = 0.027;
    public double angle = 0.0006;

    public boolean greedy = true;
    public boolean randomRotations = false;
    public boolean genetic = false;
    public boolean bruteForce = false;
    public boolean pentominoParcels = false;
    public boolean configOpen = false;

    public Config() {
    	System.out.println("Making new config!");
    }
    public String algorithmNames[] = {"Greedy Algorithm", "Genetic Algorithm", "Brute Force", "Config"};

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

    public void setConfig() {
        greedy = false;
        genetic = false;
        bruteForce = false;
    }
    
    public boolean isConfig() {
    	return !greedy && !genetic && !bruteForce;
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

	public int getContainerHeight() {
		return containerHeight;
	}

	public void setContainerHeight(int containerHeight) {
		System.out.println("container height is being set!");
		this.containerHeight = containerHeight;
	}

}
