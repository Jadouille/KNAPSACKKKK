public class CellValues
{
    private int matrixValue = 0;
    private int type = 0;

    CellValues(int inMatrixValue, int inType) {
        matrixValue = inMatrixValue;
        type = inType;
    }

    public int getMatrixValue() { return matrixValue; }
    public int getType() { return type; }
}
