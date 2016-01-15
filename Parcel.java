import java.util.ArrayList;

public class Parcel implements Comparable {
    private int length;
    private int height;
    private int width;
    private int value;
    private int type;

    private ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> cornerCoords = new ArrayList<Coordinate>();

    public Parcel(int length, int height, int width, int value, int type) {
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
    }

    public ArrayList<Coordinate> getCoords() {
        return coords;
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

    public Parcel rotateWidth() { return new Parcel(this.height, this.length, this.width, this.value, this.type); }

    public Parcel rotateLength() { return new Parcel(this.length, this.width, this.height, this.value, this.type); }

    public Parcel rotateHeight()  {  return new Parcel(this.width, this.height, this.length, this.value, this.type); }

    public ArrayList<Parcel> generateRotations() {
        ArrayList<Parcel> result = new ArrayList<>();

        result.add(this);
        result.add(this.rotateWidth());
        result.add(this.rotateHeight().rotateWidth());
        result.add(this.rotateHeight());
        result.add(this.rotateHeight().rotateLength());
        result.add(this.rotateLength());

        return  result;
    }

	public ArrayList<Coordinate> getCornerCoords(){ return cornerCoords; }

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
        double densityFirst = (double)((Parcel) compareToParcel).getValue() / (((Parcel) compareToParcel).getWeight());
        double densitySecond = (double)this.getValue() / this.getWeight();
		double diff = densityFirst - densitySecond;

		if (diff > 0)
			result = 1;
		else if (diff < 0)
			result = -1;


        return result;
    }

    public void printDimensions() {
        System.out.println("Length = " + this.length + " Height = " + this.height + " Width = " + this.width);
    }

    public Parcel clone() {
        return new Parcel(length, height, width, value, type);
    }
}

	
	


