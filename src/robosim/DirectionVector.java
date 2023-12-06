package robosim;
import java.util.Vector;
public class DirectionVector {
    private Vector v;
    public DirectionVector(int x, int y) {
        this.v = new Vector<Integer>(2);
        this.v.add(0, -y); // Don't ask - idk
        this.v.add(1, x); // i think i made the matrix wrong
    }

    public int getX() {
        return (int) this.v.get(0);
    }

    public int getY() {
        return (int) this.v.get(1);
    }
}
