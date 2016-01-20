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
		Parcel fill1 = new Parcel(unit,unit,unit,l.getValue(),l.getType());
		Parcel fill2 = new Parcel(unit,unit,unit,0,0);
		this.fillParcel(cell, fill1, toAdd);
		this.fillParcel(cell.addCoords(l.getCoords().get(1).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(l.getCoords().get(2).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(l.getCoords().get(3).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(l.getCoords().get(4).multiplyByInt(unit)),fill2,toAdd);
	}

	public void fillPParcel(Coordinate cell, pParcel p, int toAdd, int unit){
		Parcel fill1 = new Parcel(unit,unit,unit,p.getValue(),p.getType());
		Parcel fill2 = new Parcel(unit,unit,unit,0,0);
		this.fillParcel(cell, fill1, toAdd);
		this.fillParcel(cell.addCoords(p.getCoords().get(1).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(p.getCoords().get(2).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(p.getCoords().get(3).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(p.getCoords().get(4).multiplyByInt(unit)),fill2,toAdd);
	}

	public void fillTParcel(Coordinate cell, tParcel t, int toAdd, int unit){
		Parcel fill1 = new Parcel(unit,unit,unit,t.getValue(),t.getType());
		Parcel fill2 = new Parcel(unit,unit,unit,0,0);
		this.fillParcel(cell, fill1, toAdd);
		this.fillParcel(cell.addCoords(t.getCoords().get(1).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(t.getCoords().get(2).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(t.getCoords().get(3).multiplyByInt(unit)),fill2,toAdd);
		this.fillParcel(cell.addCoords(t.getCoords().get(4).multiplyByInt(unit)),fill2,toAdd);
	}

	public void removeParcel(Coordinate cell, Parcel parcel) {
		for (Coordinate curCoord : parcel.getCoords()) {
			Coordinate coord = new Coordinate(cell.getX() + curCoord.getX(), cell.getY() + curCoord.getY(), cell.getZ() + curCoord.getZ());
			container.put(coord, new CellValues(0, 0));
		}
		parcels.remove(parcel);
		weightLeft += parcel.getWeight();
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

	public boolean checkLCollision(lParcel l, Coordinate cell, int unit){
		Parcel check = new Parcel(unit,unit,unit,0,0);
		if (this.checkCollision(check, cell))
			return true;
		if (this.checkCollision(check, cell.addCoords(l.getCoords().get(1).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(l.getCoords().get(2).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(l.getCoords().get(3).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(l.getCoords().get(4).multiplyByInt(unit))))
			return true;

		return false;
	}

	public boolean checkPCollision(pParcel p, Coordinate cell, int unit){
		Parcel check = new Parcel(unit,unit,unit,0,0);
		if (this.checkCollision(check, cell))
			return true;
		if (this.checkCollision(check, cell.addCoords(p.getCoords().get(1).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(p.getCoords().get(2).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(p.getCoords().get(3).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(p.getCoords().get(4).multiplyByInt(unit))))
			return true;

		return false;
	}

	public boolean checkTCollision(tParcel t, Coordinate cell, int unit){
		Parcel check = new Parcel(unit,unit,unit,0,0);
		if (this.checkCollision(check, cell))
			return true;
		if (this.checkCollision(check, cell.addCoords(t.getCoords().get(1).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(t.getCoords().get(2).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(t.getCoords().get(3).multiplyByInt(unit))))
			return true;
		if (this.checkCollision(check, cell.addCoords(t.getCoords().get(4).multiplyByInt(unit))))
			return true;

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
