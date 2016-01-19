import java.math.BigDecimal;
import java.util.ArrayList;


public class Parcel implements Comparable {
    private static ArrayList<Coordinate3D> rotatedCornerCoords;
    private final int initialPositionInt = 5;
    private int length;
    private int height;
    private int width;
    private int value;
    private int type;
    private ArrayList<Parcel> rotations = new ArrayList<>();
    private ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> cornerCoords = new ArrayList<Coordinate>();

    public Parcel(int length, int height, int width, int value, int type) {
        this(length, height, width, value, type, true);
    }

    public Parcel(int length, int height, int width, int value, int type, boolean fillRotations) {
        this.length = length;
        this.height = height;
        this.width = width;

        this.value = value;
        this.type = type;

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < width; z++) {
                    Coordinate coord = new Coordinate(x, y, z);
                    coords.add(coord);
                }
            }
        }
        if (fillRotations)
            generateRotations();
    }

    public ArrayList<Coordinate> getCoords() {
        return coords;
    }

	public ArrayList<Parcel> getRotations() { return rotations; }

    public Parcel rotateWidth() {
        return new Parcel(this.height, this.length, this.width, this.value, this.type, false);
    }

    public Parcel rotateLength() {
        return new Parcel(this.length, this.width, this.height, this.value, this.type, false);
    }

    public Parcel rotateHeight() {
        return new Parcel(this.width, this.height, this.length, this.value, this.type, false);
    }

    public void generateRotations() {
        rotations.add(this);
        rotations.add(this.rotateWidth());
        rotations.add(this.rotateHeight().rotateWidth());
        rotations.add(this.rotateHeight());
        rotations.add(this.rotateHeight().rotateLength());
        rotations.add(this.rotateLength());
    }

    public ArrayList<Coordinate> getCornerCoords() {
        return cornerCoords;
    }

    public void setCornerCoords(ArrayList<Coordinate> coords) {
        this.cornerCoords = coords;
    }

    public void setCornerCoords(Coordinate initialCoord) {
        this.cornerCoords.add(0, initialCoord);
        this.cornerCoords.add(1, new Coordinate(initialCoord.getX(), initialCoord.getY() + height, initialCoord.getZ()));
        this.cornerCoords.add(2, new Coordinate(initialCoord.getX() + length, initialCoord.getY() + height, initialCoord.getZ()));
        this.cornerCoords.add(3, new Coordinate(initialCoord.getX() + length, initialCoord.getY(), initialCoord.getZ()));
        this.cornerCoords.add(4, new Coordinate(initialCoord.getX(), initialCoord.getY() + height, initialCoord.getZ() + width));
        this.cornerCoords.add(5, new Coordinate(initialCoord.getX() + length, initialCoord.getY() + height, initialCoord.getZ() + width));
        this.cornerCoords.add(6, new Coordinate(initialCoord.getX(), initialCoord.getY(), initialCoord.getZ() + width));
        this.cornerCoords.add(7, new Coordinate(initialCoord.getX() + length, initialCoord.getY(), initialCoord.getZ() + width));

    }



    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return (this.height * this.width * this.length);
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Object compareToParcel) {

        int result = 0;
        // descending order
        double densityFirst = (double) ((Parcel) compareToParcel).getValue() / (((Parcel) compareToParcel).getWeight());
        double densitySecond = (double) this.getValue() / this.getWeight();
        double diff = densityFirst - densitySecond;

        if (diff > 0)
            result = 1;
        else if (diff < 0)
            result = -1;


		//return ((Parcel) compareToParcel).getValue() - this.getValue();
        return result;
    }

    public void printDimensions() {
        System.out.println("Length = " + this.length + " Height = " + this.height + " Width = " + this.width);
    }

    public Parcel clone() {
            return new Parcel(length, height, width, value, type);
    }

    public ArrayList<Coordinate3D> multiplyArrays(double[][] rotationMatrix) {
        ArrayList<Coordinate3D> arrayMultiplied = new ArrayList<Coordinate3D>();

        float productX;
        float productY;
        float productZ;

        for (int i = 0; i < cornerCoords.size(); i++) {
            productX = (int) ((cornerCoords.get(i).getX() * rotationMatrix[0][0]) + (cornerCoords.get(i).getY() * rotationMatrix[1][0]) + (cornerCoords.get(i).getZ() * rotationMatrix[2][0]));
            productY = (int) ((cornerCoords.get(i).getX() * rotationMatrix[0][1]) + (cornerCoords.get(i).getY() * rotationMatrix[1][1]) + (cornerCoords.get(i).getZ() * rotationMatrix[2][1]));
            productZ = (int) ((cornerCoords.get(i).getX() * rotationMatrix[0][2]) + (cornerCoords.get(i).getY() * rotationMatrix[1][2]) + (cornerCoords.get(i).getZ() * rotationMatrix[2][2]));
            arrayMultiplied.add(i, new Coordinate3D(productX, productY, productZ));
        }

        return arrayMultiplied;
    }

    public ArrayList<Coordinate2D> rotateAroundX(double angle) {
        double[][] rotationMatrix = new double[3][3];
        rotationMatrix[0][0] = 1;
        rotationMatrix[0][1] = 0;
        rotationMatrix[0][2] = 0;
        rotationMatrix[1][0] = 0;
        rotationMatrix[1][1] = Math.cos(angle);
        rotationMatrix[1][2] = -(Math.sin(angle));
        rotationMatrix[2][0] = 0;
        rotationMatrix[2][1] = Math.sin(angle);
        rotationMatrix[2][2] = Math.cos(angle);

        ArrayList<Coordinate3D> newCornerCoords = this.multiplyArrays(rotationMatrix);
        ArrayList<Coordinate2D> rotatedProjected = new ArrayList<Coordinate2D>();
        for (int i = 0; i < newCornerCoords.size(); i++) {
            rotatedProjected.add(i, newCornerCoords.get(i).computeProjectedCoordinate(new BigDecimal(initialPositionInt)));
        }
        return rotatedProjected;
    }

    public ArrayList<Coordinate2D> rotateAroundY(double angle) {
        double[][] rotationMatrix = new double[3][3];
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = 0;
        rotationMatrix[0][2] = Math.sin(angle);
        rotationMatrix[1][0] = 0;
        rotationMatrix[1][1] = 1;
        rotationMatrix[1][2] = 0;
        rotationMatrix[2][0] = -(Math.sin(angle));
        rotationMatrix[2][1] = 0;
        rotationMatrix[2][2] = Math.cos(angle);

        ArrayList<Coordinate3D> newCornerCoords = this.multiplyArrays(rotationMatrix);
        ArrayList<Coordinate2D> rotatedProjected = new ArrayList<Coordinate2D>();
        for (int i = 0; i < newCornerCoords.size(); i++) {
            rotatedProjected.add(i, newCornerCoords.get(i).computeProjectedCoordinate(new BigDecimal(initialPositionInt)));
        }
        return rotatedProjected;

    }

    public ArrayList<Coordinate2D> rotateAroundZ(double angle) {
        double[][] rotationMatrix = new double[3][3];
        //double angle = ((Math.PI) / 2);
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = -(Math.sin(angle));
        rotationMatrix[0][2] = 0;
        rotationMatrix[1][0] = Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        rotationMatrix[1][2] = 0;
        rotationMatrix[2][0] = 0;
        rotationMatrix[2][1] = 0;
        rotationMatrix[2][2] = 1;

        ArrayList<Coordinate3D> newCornerCoords = this.multiplyArrays(rotationMatrix);
        ArrayList<Coordinate2D> rotatedProjected = new ArrayList<Coordinate2D>();
        for (int i = 0; i < newCornerCoords.size(); i++) {
            rotatedProjected.add(i, newCornerCoords.get(i).computeProjectedCoordinate(new BigDecimal(initialPositionInt)));
        }
        return rotatedProjected;

    }
}