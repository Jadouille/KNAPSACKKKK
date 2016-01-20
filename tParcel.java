import java.util.ArrayList;

/**
 * Created by Jade on 15-01-16.
 */
public class tParcel {
    private int value;
    private int type;
    private ArrayList<tParcel> rotations = new ArrayList<>();
    private ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> cornerCoords = new ArrayList<Coordinate>();

    public tParcel(int value, int type){
        this.value = value;
        this.type = type;

        Coordinate coord1 = (new Coordinate(0, 0, 0)); coords.add(coord1);
        Coordinate coord2 = (new Coordinate(0, 1, 0)); coords.add(coord2);
        Coordinate coord3 = (new Coordinate(0, 2, 0)); coords.add(coord3);
        Coordinate coord4 = (new Coordinate(1, 1, 0)); coords.add(coord4);
        Coordinate coord5 = (new Coordinate(2, 1, 0)); coords.add(coord5);

    }

    public void generateRotations(){
        rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); this.setCoords(this.rotateAroundY()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); this.setCoords(this.rotateAroundY()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundZ()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotateAroundX()); rotations.add(this.clone());
        this.setCoords(this.rotations.get(1).getCoords()); this.setCoords(this.rotateAroundY()); this.setCoords(this.rotateAroundY()); rotations.add(this.clone());
    }

    public ArrayList<Coordinate> getCoords(){
        return coords;
    }

    public void setCornerCoords(Coordinate initialCoord, int cubeUnit){
        this.cornerCoords.add(0, initialCoord);
        this.cornerCoords.add(1, new Coordinate(initialCoord.getX(), initialCoord.getY(), initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(2, new Coordinate(initialCoord.getX() - cubeUnit, initialCoord.getY(), initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(3, new Coordinate(initialCoord.getX() - cubeUnit, initialCoord.getY(), initialCoord.getZ() + (3 * cubeUnit)));
        this.cornerCoords.add(4, new Coordinate(initialCoord.getX() + (2 * cubeUnit), initialCoord.getY(), initialCoord.getZ() + (3 * cubeUnit)));
        this.cornerCoords.add(5, new Coordinate(initialCoord.getX() + (2 * cubeUnit), initialCoord.getY(), initialCoord.getZ() + (2* cubeUnit)));
        this.cornerCoords.add(6, new Coordinate(initialCoord.getX() + cubeUnit, initialCoord.getY(), initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(7, new Coordinate(initialCoord.getX() + cubeUnit, initialCoord.getY(), initialCoord.getZ()));
        this.cornerCoords.add(8, new Coordinate(initialCoord.getX(), initialCoord.getY() + cubeUnit, initialCoord.getZ()));
        this.cornerCoords.add(9, new Coordinate(initialCoord.getX(), initialCoord.getY() + cubeUnit, initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(10, new Coordinate(initialCoord.getX() - cubeUnit, initialCoord.getY() + cubeUnit, initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(11, new Coordinate(initialCoord.getX() - cubeUnit, initialCoord.getY() + cubeUnit, initialCoord.getZ() + (3 * cubeUnit)));
        this.cornerCoords.add(12, new Coordinate(initialCoord.getX() + (2 * cubeUnit), initialCoord.getY() + cubeUnit, initialCoord.getZ() + (3 * cubeUnit)));
        this.cornerCoords.add(13, new Coordinate(initialCoord.getX() + (2 * cubeUnit), initialCoord.getY() + cubeUnit, initialCoord.getZ() + (2* cubeUnit)));
        this.cornerCoords.add(14, new Coordinate(initialCoord.getX() + cubeUnit, initialCoord.getY() + cubeUnit, initialCoord.getZ() + (2 * cubeUnit)));
        this.cornerCoords.add(15, new Coordinate(initialCoord.getX() + cubeUnit, initialCoord.getY() + cubeUnit, initialCoord.getZ()));



    }

    public ArrayList<Coordinate> getCornerCoords(){ return cornerCoords;}

    public int getValue(){ return value;}
    public int getType(){ return type;}

    public void setCornerCoords(ArrayList<Coordinate> cornerCoords) {
        this.cornerCoords = cornerCoords;
    }

    public void setCoords(ArrayList<Coordinate> coords) {
        this.coords = coords;
    }

    public void setCoords(Coordinate[] coords){
        for (int i = 0; i < coords.length; i++){
            this.coords.set(i,coords[i]);
        }
    }

    public int compareTo(Object compareToParcel){
        int result = 0;

        double densityFirst = (double) ((tParcel) compareToParcel).getValue();
        double densitySecond = (double) ((tParcel)this).getValue();
        double diff = densityFirst - densitySecond;

        if (diff > 0)
            result = 1;

        if (diff < 0)
            result = -1;

        return result;

    }

    public tParcel clone(){
        tParcel rParcel = new tParcel(this.value, this.type);
        rParcel.setCoords(this.coords);
        rParcel.setCornerCoords(this.cornerCoords);
        return rParcel;
    }

    public Coordinate[] multiplyArrays(double[][] rotationMatrix){
        Coordinate[] arrayMultiplied = new Coordinate[coords.size()];
        for (int i = 0; i < arrayMultiplied.length; i++) {
            arrayMultiplied[i] = new Coordinate(0, 0, 0);
        }
        int product;

        for (int i = 0; i < coords.size() ; i++){
            product = (int) ((this.coords.get(i).getX() * rotationMatrix[0][0]) + (this.coords.get(i).getY() * rotationMatrix[1][0]) + (this.coords.get(i).getZ() * rotationMatrix[2][0]));
            arrayMultiplied[i].setX(product);
            product = (int) ((this.coords.get(i).getX() * rotationMatrix[0][1]) + (this.coords.get(i).getY() * rotationMatrix[1][1]) + (this.coords.get(i).getZ() * rotationMatrix[2][1]));
            arrayMultiplied[i].setY(product);
            product = (int) ((this.coords.get(i).getX() * rotationMatrix[0][2]) + (this.coords.get(i).getY() * rotationMatrix[1][2]) + (this.coords.get(i).getZ() * rotationMatrix[2][2]));
            arrayMultiplied[i].setZ(product);
        }
        return arrayMultiplied;
    }

    public Coordinate[] rotateAroundX(){
        double[][] rotationMatrix = new double[3][3];
        double angle = ((Math.PI) / 2);
        rotationMatrix[0][0] = 1;
        rotationMatrix[0][1] = 0;
        rotationMatrix[0][2] = 0;
        rotationMatrix[1][0] = 0;
        rotationMatrix[1][1] = 0; //Math.cos(angle);
        rotationMatrix[1][2] = -1; //- (Math.sin(angle));
        rotationMatrix[2][0] = 0;
        rotationMatrix[2][1] = 1; //Math.sin(angle);
        rotationMatrix[2][2] = 0; //Math.cos(angle);

        Coordinate[] rotatedMatrix = this.multiplyArrays(rotationMatrix);

        return rotatedMatrix;
    }

    public Coordinate[] rotateAroundY(){
        double[][] rotationMatrix = new double[3][3];
        double angle = ((Math.PI) / 2);
        rotationMatrix[0][0] = 0; //Math.cos(angle);
        rotationMatrix[0][1] = 0;
        rotationMatrix[0][2] = 1; //Math.sin(angle);
        rotationMatrix[1][0] = 0;
        rotationMatrix[1][1] = 1;
        rotationMatrix[1][2] = 0;
        rotationMatrix[2][0] = - 1; //- (Math.sin(angle));
        rotationMatrix[2][1] = 0;
        rotationMatrix[2][2] = 0; //Math.cos(angle);

        Coordinate[] rotatedMatrix = this.multiplyArrays(rotationMatrix);

        return rotatedMatrix;

    }

    public Coordinate[] rotateAroundZ(){
        double[][] rotationMatrix = new double[3][3];
        double angle = ((Math.PI) / 2);
        rotationMatrix[0][0] = 0; //Math.cos(angle);
        rotationMatrix[0][1] = - 1; //- (Math.sin(angle));
        rotationMatrix[0][2] = 0;
        rotationMatrix[1][0] = 1; //Math.sin(angle);
        rotationMatrix[1][1] = 0; //Math.cos(angle);
        rotationMatrix[1][2] = 0;
        rotationMatrix[2][0] = 0;
        rotationMatrix[2][1] = 0;
        rotationMatrix[2][2] = 1;

        Coordinate[] rotatedMatrix = this.multiplyArrays(rotationMatrix);

        return rotatedMatrix;

    }
}
