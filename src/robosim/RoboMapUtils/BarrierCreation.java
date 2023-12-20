package robosim.RoboMapUtils;

import robosim.Barrier;
import robosim.MapObjects;
import robosim.RoboMap;

public class BarrierCreation {
    public void createBarrier(RoboMap roboMap, int x, int y) {
        try {
            roboMap.RMap.FMap[y][x] = MapObjects.BARRIER.createInstance();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid coordinates for barrier: " + x + ", " + y);
        }
    }
}
