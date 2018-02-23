package excercise3;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public interface Geometric extends Comparable<Geometric>{
    public double getLeft();
    public double getRight();
    public double getTop();
    public double getBottom();
    public double getArea();
    public void move(double dx, double dy);
}
