import java.util.ArrayList;

public class Parcel implements Comparable {
	private int length;
	private int height;
	private int width;
	private int value;
	private int type;

	private ArrayList<Coordinate> coords = new ArrayList<Coordinate>();

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

	public ArrayList<Coordinate> getCoords() { return coords; }

	public int getLength() { return this.length; }

	public int getWidth(){ return this.width; }

	public int getHeight() { return this.height; }
	
	public int getWeight(){ 
		return (this.height * this.width * this.length);
	}

	public int getType() { return type; }

	public int getValue() { return  value; }

	@Override
	public int compareTo(Object compareToParcel) {

		// descending order
		int densityFirst = ((Parcel) compareToParcel).getValue() / (((Parcel) compareToParcel).getWeight());
		int densitySecond = this.getValue() / this.getWeight();
		return  densityFirst - densitySecond ;
	}

	public Parcel clone() {
		return new Parcel(length, height, width, value, type);
	}
}
	
	
	


