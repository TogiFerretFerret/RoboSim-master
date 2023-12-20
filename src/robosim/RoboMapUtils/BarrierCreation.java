package robosim.RoboMapUtils;

import robosim.Barrier;
import robosim.RoboMap;

public class BarrierCreation {
    public void createBarrier(RoboMap roboMap, int x, int y) {
        try {
            roboMap.RMap.FMap[y][x] = new Barrier();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid coordinates for barrier: " + x + ", " + y);
        }
    }
}
