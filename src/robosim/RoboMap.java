package robosim;
import robosim.FTCMap;
import robosim.DirectionVector;
import robosim.Toolbox;
import robosim.RoboMapUtils.RobotMovement;
import robosim.RoboMapUtils.BarrierCreation;
public class RoboMap {
    public FTCMap RMap;
    public int[] roboPos;
    public RoboMap(int[] dimensions, int[] roboStartPos) {
        try {
            MapObject[][] pmap = initializeMap(dimensions);
            this.RMap = new FTCMap(pmap);
            this.RMap.FMap[roboStartPos[0]][roboStartPos[1]] = new Robot();
            this.roboPos = roboStartPos;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public MapObject[][] initializeMap(int[] dimensions) {
        MapObject[][] map = new MapObject[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                map[i][j] = new Air();
            }
        }
        return map;
    }
    public void moveRobot(DirectionVector dvector) {
        RobotMovement rm = new RobotMovement();
        rm.moveRobot(this, dvector);
    }
    public void createBarrier(int x, int y) {
        BarrierCreation bc = new BarrierCreation();
        bc.createBarrier(this, x, y);
    }
}
