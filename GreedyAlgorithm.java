/**
 * Created by Użytkownik on 13.01.2016.
 */
public class GreedyAlgorithm {
    /**
     * Created by Użytkownik on 11.01.2016.
     */

        private static double containerWidth=2.5;
        private static double containerLength=16.5;
        private static double containerHeight=4;
        private static double containerWeight=165;
        private static double valueA = 3;
        private static double valueB = 4;
        private static double valueC = 5;
        private static int amountOfAParcels = 24;
        private static int amountOfBParcels = 26;
        private static int amountOfCParcels = 22;

        public static Parcel[] createAParcel(int arrayLength){
            Parcel[] parcelsA = new Parcel[arrayLength];
            for (int i =0; i < arrayLength; i++){
                parcelsA[i] = null;
            }
            for (int i = 0;i<arrayLength;i++){
                parcelsA[i] = new Parcel(new Coordinate(0,0,0),valueA,2,1,1,2);
            }
            return parcelsA;
        }
        public static Parcel[] createBParcel(int arrayLength){
            Parcel[] parcelsB = new Parcel[arrayLength];
            for (int i =0; i < arrayLength; i++){
                parcelsB[i] = null;
            }
            for (int i = 0;i<arrayLength;i++){
                parcelsB[i] = new Parcel(new Coordinate(0,0,0),valueB,3,1.5,1,2);
            }
            return parcelsB;
        }
        public static Parcel[] createCParcel(int arrayLength){
            Parcel[] parcelsC = new Parcel[arrayLength];
            for (int i =0; i < arrayLength; i++){
                parcelsC[i] = null;
            }
            for (int i = 0;i<arrayLength;i++){
                parcelsC[i] = new Parcel(new Coordinate(0,0,0),valueC,3.375,1.5,1.5,1.5);
            }
            return parcelsC;
        }

        public static Parcel[] removeParcel(Parcel[] p){
            Parcel[] temp = new Parcel[p.length - 1];
            temp = null;
            System.arraycopy(p, 1, temp, 0, p.length);
            return temp;
        }
        public static Parcel[] addParcel(Parcel[] p, Parcel parcel){
            Parcel[] temp = new Parcel[p.length + 1];
            temp = null;
            temp[0] = parcel;
            System.arraycopy(p, 0, temp, 1, p.length);
            return temp;
        }

        public static Container Algotithm(){
            /**Container container = new Container(1000, 10, 10, 10);
             Parcel one = new Parcel(new Coordinate(0, 0, 0), 0, 0, 1, 2, 1);
             Parcel two = new Parcel(new Coordinate(2, 0, 0), 1, 1, 1, 1, 1);
             container.getParcels().add(0,one);
             container.getParcels().add(1,two);
             container.getFirstEmptyCell(new Coordinate(0,0,0)).printCoord();*/

            Container container = new Container(containerWeight, containerWidth, containerLength, containerHeight);
            Parcel[] parcelsA = createAParcel(amountOfAParcels);
            Parcel[] parcelsB = createBParcel(amountOfBParcels);
            Parcel[] parcelsC = createCParcel(amountOfCParcels);

            if ((valueA/2) < (valueB/3)){
                Parcel[] temp = parcelsA;
                parcelsA = parcelsB;
                parcelsB = temp;
                double tempValue = valueA;
                valueA = valueB;
                valueB = tempValue;
            }

            if (valueB/3 < valueC/3.375) {
                Parcel[] temp = parcelsB;
                parcelsB = parcelsC;
                parcelsC = temp;
                double tempValue = valueB;
                valueB = valueC;
                valueC = tempValue;
            }

            if (valueA/parcelsA[0].getValue() < valueB/parcelsB[0].getValue()){
                Parcel[] temp = parcelsA;
                parcelsA = parcelsB;
                parcelsB = temp;
                double tempValue = valueA;
                valueA = valueB;
                valueB = tempValue;
            }

            Parcel[] parcels = new Parcel[parcelsA.length + parcelsB.length + parcelsC.length];
            System.arraycopy(parcelsA, 0, parcels, 0, parcelsA.length);
            System.arraycopy(parcelsB, 0, parcels, parcelsA.length, parcelsB.length);
            System.arraycopy(parcelsC, 0, parcels, parcelsA.length + parcelsB.length, parcelsC.length);
            Coordinate lastEmptyCell = new Coordinate(0,0,0);


            for (int i = 0; i < parcels.length; i++){
                if (container.getWeight() - parcels[i].getWeight() < 0)
                    break;
                else {
                    lastEmptyCell = container.getFirstEmptyCell(lastEmptyCell);
                    parcels[i] = new Parcel(lastEmptyCell,parcels[i].getValue(),parcels[i].getWeight(),parcels[i].getParcelWidth(),parcels[i].getParcelLength(),parcels[i].getParcelHeight());
                    if(container.checkCollision(parcels[i]))
                        break;
                    else {
                        container.setWeight(container.getWeight() - parcels[i].getWeight());
                        container.setValue(container.getValue() + parcels[i].getValue());
                        container.getParcels().add(parcels[i]);
                    }

                }
            }
            container.printParcelsValue();
            System.out.println(container.getWeight());
            System.out.println(container.getValue());
            container.printAmountOfParcels();



            return container;
        }
    }


