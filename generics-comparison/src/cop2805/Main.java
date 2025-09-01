package cop2805;

public class Main {
    public static void main(String[] args) {
        // Arrays
        String[] colors = {"Red","Green","Blue"};
        Integer[] numbers = {1, 2, 3};
        Double[] circleRadius = {3.0, 5.9, 2.9};

        // Outputting results
        System.out.println("Colors: " + min(colors));
        System.out.println("Numbers: " + min(numbers));
        System.out.println("Circle radiuses: " + min(circleRadius));
    }

    // Method to find minimum
    public static <E extends Comparable<E>> E min (E [] list) {
        // Initializing comparison from the first element in the array
        E minimumElement = list[0];

        // Going through each element and comparing if it's smaller
        for (int i = 1; i < list.length; i++) {
            if (minimumElement.compareTo(list[i]) > 0) {
                minimumElement = list[i];
            }
        }
        return minimumElement;
    }
}