import java.util.ArrayList;
import java.util.HashMap;


public class ContainerKnapsack {
	private HashMap<Coordinate, CellValues> container = new HashMap<Coordinate, CellValues>();
	private int width;
	private int length;
	private int height;
	private int weightLeft;
	private ArrayList<Parcel> parcels = new ArrayList<Parcel>();

	public ContainerKnapsack(int length, int height, int width) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.weightLeft = getWeight();

		clear();
	}

	public void clear() {
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++)
					container.put(new Coordinate(x, y, z), new CellValues(0, 0));
			}
		}

		parcels.clear();
	}

	public int getLength() { return length; }
	public int getHeight() { return height; }
	public int getWidth() { return  width; }

	public int getWeight() { return length * height * width; }

	public int getWeightLeft() { return weightLeft; }

	public int getTotalValue() {
		int result = 0;
		for (Parcel curParcel : parcels) {
			result += curParcel.getValue();
		}

		return result;
	}

	public ArrayList<Parcel> getParcels() { return parcels; }

	public void setParcels(ArrayList<Parcel> parcels) {
		this.parcels = parcels;
	}

	public void fillParcel(Coordinate cell, Parcel parcel, int toAdd ){
		for (Coordinate curCoord : parcel.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(toAdd, parcel.getType()));
		}

		parcel.setCornerCoords(cell);
		parcels.add(parcel);
		weightLeft -= parcel.getWeight();
	}

	public void removeParcel(Coordinate cell, Parcel parcel) {
		for (Coordinate curCoord : parcel.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(0, 0));
		}
		parcels.remove(parcel);
		weightLeft += parcel.getWeight();
	}

	public boolean checkCollision(Parcel parcel, Coordinate coord) {

		if (coord.getX() + parcel.getLength()  > length
				|| coord.getY() + parcel.getHeight() > height
				|| coord.getZ() + parcel.getWidth() > width)
			return true;

		for (Coordinate curCoord : parcel.getCoords()) {

			try {
				Coordinate checkCell = new Coordinate(curCoord.getX() + coord.getX(), curCoord.getY() + coord.getY(), curCoord.getZ() + coord.getZ());
				if (container.get(checkCell).getMatrixValue() == 1)
					return true;

			} catch (Exception e){
				e.printStackTrace();
			}
		}

		return false;

	}

	public Coordinate findCellToFitParcel(Parcel parcel) {

		Coordinate result = null;

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++) {
					Coordinate coord = new Coordinate(x, y, z);
					if (container.get(coord).getMatrixValue() == 0 && !checkCollision(parcel, coord)) {
						result = new Coordinate(x, y, z);
						return result;
					}
				}
			}
		}

		return result;
	}


}
