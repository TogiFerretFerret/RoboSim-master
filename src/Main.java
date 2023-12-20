import robosim.RoboMap;
import robosim.Toolbox;
import robosim.DirectionVector;

public class Main {
    public static void main(String[] args) {
        RoboMap map = new RoboMap(new int[] {11, 11}, new int[] {5, 5});
        map.createBarrier(5, 2);
        map.createBarrier(7, 3);
        map.createBarrier(7, 2);
        map.createBarrier(6, 2);
        Toolbox.printMap(map);
        Toolbox.sleep(1000);
        map.moveRobot(new DirectionVector(3, -3));
        Toolbox.printMap(map);
        Toolbox.sleep(1000);
        map.createBarrier(6, 5);
        map.createBarrier(7, 5);
        map.createBarrier(6, 4);
        Toolbox.printMap(map);
        Toolbox.sleep(1000);
    }
}