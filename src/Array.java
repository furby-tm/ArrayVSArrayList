import java.util.ArrayList;
import java.util.Random;

public class Array {
    static int initialSize = 10000000;

    public static int[] array = new int[initialSize];
    public static ArrayList<Integer> arrayList = new ArrayList<Integer>(initialSize);

    public static int[] arrayWithSameValues = new int[initialSize];
    public static ArrayList<Integer> arrayListWithSameValues = new ArrayList<Integer>(initialSize);

    public static ArrayList<Integer> arrayListB = new ArrayList<Integer>(initialSize);
    public static ArrayList<Integer> arrayListSize10 = new ArrayList<Integer>(10);

    public static int[] randomArray = new int[1000];

    public static void fillArray() {
        for (int i = 0; i < initialSize; i++) {
            array[i] = randomFill();
        }
    }

    public static void fillArrayList() {
        for (int i = 0; i < initialSize; i++) {
            arrayList.add(randomFill());
        }
    }

    public static void incrementArray() {
        for (int i = 0; i < initialSize; i++) {
            array[i] = array[i] + 1;
        }
    }

    public static void incrementArrayList() {
        for (int i = 0; i < initialSize; i++) {
            int oldVal = arrayList.get(i);
            int newVal = oldVal + 1;
            arrayList.set(i, newVal);
        }
    }

    public static void searchArray() {
        int counter = 0;
        for(int i = 0; i < randomArray.length; i++) {
            for(int j = 0; j < initialSize; j++) {
                if (randomArray[i]==arrayWithSameValues[j]) {
                    counter += 1;
                    break;
                }
            }
        }
    }

    public static void searchArrayList() {
        int counter = 0;
        for(int i = 0; i < randomArray.length; i++) {
            for(int j = 0; j < initialSize; j++) {
                if (randomArray[i]==arrayListWithSameValues.get(j)) {
                    counter += 1;
                    break;
                }
            }
        }
    }

    public static void fillBothArrayLists() {
        for (int i = 0; i < initialSize; i++) {
            int newValue = randomFill();
            arrayWithSameValues[i] = newValue;
            arrayListWithSameValues.add(newValue);
        }
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomFill();
        }
    }

    public static void expandArrayListB() {
        for(int i = 0; i < initialSize; i++) {
            arrayListB.add(randomFill());
        }
    }

    public static void expandArraySize10() {
        for (int i = 0; i < initialSize; i++) {
            arrayListSize10.add(randomFill());
        }
    }

    public static int randomFill() {
        Random rand = new Random();
        int randomNum = rand.nextInt(1000);
        return randomNum;
    }

    public static void main(String[] args) {

        // BEGIN CALCULATING TIME FOR ARRAY

        System.out.println("################# CALCULATE FILL TIME #########################\n");

        long arrayStartTime = System.nanoTime();
        fillArray();
        long arrayEndTime = System.nanoTime();

        long arrayDuration = (arrayEndTime - arrayStartTime);
        System.out.println("Filling the array took " + (arrayDuration) + " milliseconds.");

        //#######...END ARRAY...########

        // BEGIN CALCULATING TIME FOR ARRAYLIST

        long arrayListStartTime = System.nanoTime();
        fillArrayList();
        long arrayListEndTime = System.nanoTime();

        long arrayListDuration = (arrayListEndTime - arrayListStartTime);
        System.out.println("Filling the ArrayList took " + (arrayListDuration) + " milliseconds.");

        //#######...END ARRAYLIST...#######


        System.out.println("");
        if (arrayDuration < arrayListDuration) {
            System.out.println("The array was " + (arrayListDuration - arrayDuration) + " milliseconds faster than the ArrayList.");
            System.out.println("Arrays are quicker to fill than ArrayLists.\n\n");
        } else {
            System.out.println("The ArrayList was " + (arrayDuration - arrayListDuration) + " milliseconds faster than the array.");
            System.out.println("ArrayLists are quicker to fill than arrays.\n");
        }
        //#######...END TIMING FOR FILL METHOD...########

        System.out.println("################### CALCULATE INCREMENT TIME #################\n");

        //#######...BEGIN TIMING FOR INCREMENT METHOD...#######
        long arrayIncrementStartTime = System.nanoTime();
        incrementArray();
        long arrayIncrementEndTime = System.nanoTime();

        long arrayIncrementDuration = (arrayIncrementEndTime - arrayIncrementStartTime);
        System.out.println("Incrementing the array took " + (arrayIncrementDuration) + " milliseconds.");


        long arrayListIncrementStartTime = System.nanoTime();
        incrementArrayList();
        long arrayListIncrementEndTime = System.nanoTime();

        long arrayListIncrementDuration = (arrayListIncrementEndTime - arrayListIncrementStartTime);
        System.out.println("Incrementing the ArrayList took " + (arrayListIncrementDuration) + " milliseconds.");

        System.out.println("");
        if (arrayIncrementDuration < arrayListIncrementDuration) {
            System.out.println("The array was " + (arrayListIncrementDuration - arrayIncrementDuration) + " milliseconds faster than the ArrayList.");
            System.out.println("Arrays are quicker to increment than ArrayLists.\n\n");
        } else {
            System.out.println("The ArrayList was " + (arrayIncrementDuration - arrayListIncrementDuration) + " milliseconds faster than the array.");
            System.out.println("ArrayLists are quicker to increment than arrays.\n");
        }
        //#######...END TIMING FOR INCREMENT METHOD...#######

        System.out.println("################### CALCULATE SEARCH TIME ###################\n");

        fillBothArrayLists();

        //#######...BEGIN TIMING FOR SEARCH METHOD...#######
        long arraySearchStartTime = System.nanoTime();
        searchArray();
        long arraySearchEndTime = System.nanoTime();

        long arraySearchDuration = (arraySearchEndTime - arraySearchStartTime);
        System.out.println("Searching the array took " + (arraySearchDuration) + " milliseconds.");

        long arrayListSearchStartTime = System.nanoTime();
        searchArrayList();
        long arrayListSearchEndTime = System.nanoTime();

        long arrayListSearchDuration = (arrayListSearchEndTime - arrayListSearchStartTime);
        System.out.println("Searching the ArrayList took " + (arrayListSearchDuration) + " milliseconds.");

        System.out.println("");
        if (arraySearchDuration < arrayListSearchDuration) {
            System.out.println("The array was " + (arrayListSearchDuration - arraySearchDuration) + " milliseconds faster than the ArrayList.");
            System.out.println("Arrays are quicker to search than ArrayLists.\n\n");
        } else {
            System.out.println("The ArrayList was " + (arraySearchDuration - arrayListSearchDuration) + " milliseconds faster than the array.");
            System.out.println("ArrayLists are quicker to search than arrays.\n");
        }
        //#######...END TIMING FOR SEARCH METHOD...#######

        arrayList.clear();
        System.out.println("################### CALCULATE EXPAND TIME ###################\n");

        //#######...BEGIN TIMING FOR EXPAND METHOD...#######
        long arrayListBExpandStartTime = System.nanoTime();
        expandArrayListB();
        long arrayListBExpandEndTime = System.nanoTime();

        long arrayListBExpandDuration = (arrayListBExpandEndTime - arrayListBExpandStartTime);
        System.out.println("Searching the array took " + (arrayListBExpandDuration) + " milliseconds.");

        long arrayListSize10ExpandStartTime = System.nanoTime();
        expandArraySize10();
        long arrayListSize10ExpandEndTime = System.nanoTime();

        long arrayListSize10ExpandDuration = (arrayListSize10ExpandEndTime - arrayListSize10ExpandStartTime);
        System.out.println("Searching the array took " + (arrayListSize10ExpandDuration) + " milliseconds.");

        System.out.println("");
        if (arrayListBExpandDuration < arrayListSize10ExpandDuration) {
            System.out.println("Expanding the ArrayList was " + (arrayListSize10ExpandDuration - arrayListBExpandDuration) + " milliseconds slower than the ArrayList that was already set to the proper initial value.");
            System.out.println("It's quite costly to expand an ArrayList as the program runs.\n\n");
        } else {
            System.out.println("The ArrayList that was already set to the proper initial value was " + (arrayListBExpandDuration - arrayListSize10ExpandDuration) + " milliseconds slower than the smaller ArrayList.");
            System.out.println("Yeah... That would never happen.\n\n");
        }
        //#######...END TIMING FOR EXPAND METHOD...#######
    }
}
