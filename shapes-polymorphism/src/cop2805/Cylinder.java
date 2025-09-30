package cop2805;

public class Cylinder extends Shape3D {

    // Variables
    int radius;
    int height;

    // Constructor
    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    // Specialized Volume method
    @Override
    public double Volume() {
        return Math.PI * radius * radius * height;
    }
}

