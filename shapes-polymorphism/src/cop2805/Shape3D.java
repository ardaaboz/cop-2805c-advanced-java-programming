package cop2805;

import java.awt.*;

public abstract class Shape3D implements Comparable<Shape3D> {

    // Method to implement in subclasses
    abstract double Volume();

    // Making shapes comparable
    @Override
    public int compareTo(Shape3D otherShape) {
        if (this.Volume() > otherShape.Volume()) {
            return 1;
        } else if (this.Volume() < otherShape.Volume()) {
            return -1;
        } else {
            return 0;
        }
    }
}
