package robosim;
import robosim.FTCMap;
import robosim.DirectionVector;
import robosim.Toolbox;
import robosim.RoboMapUtils.RobotMovement;
import robosim.RoboMapUtils.BarrierCreation;
import robosim.MapObjects;

import java.util.Map;

public class RoboMap {
    public FTCMap RMap;
    public int[] roboPos;
    public int[] dimensions;
    public RoboMap(int[] dimensions, int[] roboStartPos) {
        try {
            this.dimensions = dimensions;
            MapObject[][] pmap = initializeMap(dimensions);
            this.RMap = new FTCMap(pmap);
            this.RMap.FMap[roboStartPos[0]][roboStartPos[1]] = MapObjects.ROBOT.createInstance();
            this.roboPos = roboStartPos;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public MapObject[][] initializeMap(int[] dimensions) {
        MapObject[][] map = new MapObject[dimensions[0]][dimensions[1]];
        mapFixer(dimensions, map);
        return map;
    }

    private void mapFixer(int[] dimensions, MapObject[][] map) {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                map[i][j] = MapObjects.AIR.createInstance();
            }
        }
    }

    public void moveRobot(DirectionVector dvector) {
        RobotMovement rm = new RobotMovement();
        rm.moveRobot(this, dvector);
    }
    public void createBarrier(int x, int y) {
        BarrierCreation bc = new BarrierCreation();
        bc.createBarrier(this, x, this.dimensions[1] - y);
    }
}
