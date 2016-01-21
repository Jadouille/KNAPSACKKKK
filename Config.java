/**
 * Created by Anthony on 19/01/2016.
 */
public class Config {


    public static int containerWidth = 165;
    public static int containerHeight = 40;
    public static int containerDepth = 25;
    public static int centerPosition = 0;
    public static int initialpositionX=15;
    public static int initialpositionY=5;
    public static int maxScore=0;

    /* Genetic Algorithm Configurations */
    public static int numberOfGenerations=50;
    public static int populationSize=50;
    public static double mutationRate=0.1;

    /* Greedy Algorithm Configurations */
    public static int numberOfParcels = 20;
    public static boolean randomRotations = false;

    public static double zoom = 0.036;
    public static double zmultiply1 = 0.027;
    public static double zmultiply2 = 0.027;
    public static double angle = 0.0006;

    public static boolean greedy = true;
    public static boolean genetic = false;
    public static boolean bruteForce = false;
    public static boolean loading=false;

    public static boolean pentominoParcels = false;

    public Config() {
    }


    public static void setGreedyAlgorithm() {
        greedy = true;
        genetic = false;
        bruteForce = false;
    }

    public static void setGeneticAlgorithm() {
        greedy = false;
        genetic = true;
        bruteForce = false;
    }

    public static void setConfig() {
        greedy = false;
        genetic = false;
        bruteForce = false;
    }
    
    public static boolean isConfig() {
    	return !greedy && !genetic && !bruteForce;
    }

    public static void setBruteForceAlgorithm() {
        greedy = false;
        genetic = false;
        bruteForce = true;
    }

    public static void printBooleans() {
        System.out.println(greedy);
        System.out.println(genetic);
        System.out.println(bruteForce);
    }

	public static int getContainerHeight() {
		return containerHeight;
	}



}
