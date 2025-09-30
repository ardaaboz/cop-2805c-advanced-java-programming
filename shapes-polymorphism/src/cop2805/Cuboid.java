package cop2805;

public class Cuboid extends Shape3D {
    // Variables
    int width;
    int depth;
    int height;

    // Constructor
    public Cuboid(int width, int depth, int height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    // Specialized Volume method
    @Override
    public double Volume() {
        return width * depth * height;
    }


}
