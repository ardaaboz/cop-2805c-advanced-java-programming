package cop2805;

public class Test {
    public static void main(String[] args) {
        // Creating objects
        Cuboid cuboid = new Cuboid(628, 1, 1);
        Cylinder cylinder = new Cylinder(10, 2);

        // Checking the result and outputting result
        if (cuboid.compareTo(cylinder) > 0) {
            System.out.println("Cuboid is bigger!");
        } else if (cuboid.compareTo(cylinder) < 0) {
            System.out.println("Cylinder is bigger!");
        } else {
            // Impossible because we are using PI
            System.out.println("They are equal!");
        }
    }
}