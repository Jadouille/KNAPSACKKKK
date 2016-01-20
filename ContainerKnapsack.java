import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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

	public void fillParcel(Coordinate cell, Parcel parcel, int toAdd ){
		for (Coordinate curCoord : parcel.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(toAdd, parcel.getType()));
		}

		parcel.setCornerCoords(cell);
		parcels.add(parcel);
		weightLeft -= parcel.getWeight();
	}

	public void fillLParcel(Coordinate cell, lParcel l, int toAdd, int unit){
		for (Coordinate curCoord : l.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(toAdd, l.getType()));
			Parcel toFill = new Parcel(1,1,1,3,1);
			fillParcel(coord, toFill, 1);
		}
	}

	public void fillPParcel(Coordinate cell, pParcel p, int toAdd, int unit){
		for (Coordinate curCoord : p.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(toAdd, p.getType()));
			Parcel toFill = new Parcel(1,1,1,4,2);
			fillParcel(coord, toFill, 1);
		}
	}

	public void fillTParcel(Coordinate cell, tParcel t, int toAdd, int unit){
		for (Coordinate curCoord : t.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(toAdd, t.getType()));
			Parcel toFill = new Parcel(1,1,1,5,3);
			fillParcel(coord, toFill, 1);
		}
	}

	public void removeLastParcel(Coordinate cell){
		Parcel toRemove = parcels.get(parcels.size()-1).clone();
		for (Coordinate curCoord : toRemove.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(0, 0));
		}
		parcels.remove(parcels.size()-1);
		weightLeft += toRemove.getWeight();
	}

	public void setParcels(ArrayList<Parcel> parcels){
		this.parcels = parcels;
	}

	public boolean checkCollision(Parcel parcel, Coordinate coord) {

		if (coord.getX() + parcel.getLength()  > length
				|| coord.getY() + parcel.getHeight() > height
				|| coord.getZ() + parcel.getWidth() > width
				|| coord.getX() + parcel.getLength() < parcel.getLength()
				|| coord.getY() + parcel.getHeight() < parcel.getHeight()
				|| coord.getZ() + parcel.getWidth() < parcel.getWidth())
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

	public boolean checkLCollision(lParcel parcel, Coordinate coord){
		for (Coordinate curCoord : parcel.getCoords()) {
			if (coord.getX() + curCoord.getX() >= length
					|| coord.getY() + curCoord.getY() >= height
					|| coord.getZ() + curCoord.getZ() >= width
					|| coord.getX() + curCoord.getX() < 0
					|| coord.getY() + curCoord.getY() < 0
					|| coord.getZ() + curCoord.getZ() < 0)
				return true;
		}

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

	public boolean checkPCollision(pParcel parcel, Coordinate coord){
		for (Coordinate curCoord : parcel.getCoords()) {
			if (coord.getX() + curCoord.getX() >= length
					|| coord.getY() + curCoord.getY() >= height
					|| coord.getZ() + curCoord.getZ() >= width
					|| coord.getX() + curCoord.getX() < 0
					|| coord.getY() + curCoord.getY() < 0
					|| coord.getZ() + curCoord.getZ() < 0)
				return true;
		}

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

	public boolean checkTCollision(tParcel parcel, Coordinate coord){

		for (Coordinate curCoord : parcel.getCoords()) {
			if (coord.getX() + curCoord.getX() >= length
					|| coord.getY() + curCoord.getY() >= height
					|| coord.getZ() + curCoord.getZ() >= width
					|| coord.getX() + curCoord.getX() < 0
					|| coord.getY() + curCoord.getY() < 0
					|| coord.getZ() + curCoord.getZ() < 0)
				return true;
		}

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

	public Coordinate findCellToFitLPentomino(lParcel l){

		Coordinate result = null;

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++) {
					Coordinate coord = new Coordinate(x, y, z);
					if (container.get(coord).getMatrixValue() == 0 && !checkLCollision(l, coord)) {
						result = new Coordinate(x, y, z);
						return result;
					}
				}
			}
		}

		return result;
	}

	public Coordinate findCellToFitPPentomino(pParcel p){

		Coordinate result = null;

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++) {
					Coordinate coord = new Coordinate(x, y, z);
					if (container.get(coord).getMatrixValue() == 0 && !checkPCollision(p, coord)) {
						result = new Coordinate(x, y, z);
						return result;
					}
				}
			}
		}

		return result;
	}

	public Coordinate findCellToFitTPentomino(tParcel t){

		Coordinate result = null;

		for (int x = 0; x < length; x++) {
			for (int y = 0; y < height; y++) {
				for (int z = 0; z < width; z++) {
					Coordinate coord = new Coordinate(x, y, z);
					if (container.get(coord).getMatrixValue() == 0 && !checkTCollision(t, coord)) {
						result = new Coordinate(x, y, z);
						return result;
					}
				}
			}
		}

		return result;
	}

	public boolean checkIsolatedCellsPentominoes(int unit){
		boolean result = true;
		Parcel check = new Parcel(unit,unit,unit,0,0);

		return result;
	}


}
