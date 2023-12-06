import robosim.RoboMap;
import robosim.Toolbox;
import robosim.DirectionVector;
public class Main {
    public static void main(String[] args) {
        RoboMap map = new RoboMap(new int[] {11, 11}, new int[] {5, 5});
        Toolbox.printMap(map);
        Toolbox.sleep(1000);
        map.moveRobot(new DirectionVector(1, -2));
        Toolbox.printMap(map);
    }
}
