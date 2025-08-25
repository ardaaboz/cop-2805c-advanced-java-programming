package cop2805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Created the ArrayList and added the elements inside it.
        ArrayList<Double> doubleList = new ArrayList<Double> //
                (List.of(1.5, 2.35, -4.7, 0.01));

        // Printed each element using the method
        System.out.println("Original list: ");
        printEachElement(doubleList);

        // Sorted elements
        Collections.sort(doubleList);

        // Printed the sorted ArrayList
        System.out.println("Sorted list: ");
        printEachElement(doubleList);

        // Search for the value
        int index = Collections.binarySearch(doubleList, 1.5);
        // Print the found index
        System.out.println("Found 1.5 at index " + index + "\n");

        // Fill the list with 0.0
        Collections.fill(doubleList, 0.0);
        // Print again
        System.out.println("Zero list: ");
        printEachElement(doubleList);


    }

    public static void printEachElement(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}