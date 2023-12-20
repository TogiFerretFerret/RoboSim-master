package robosim.RoboMapUtils;

import robosim.RoboMap;
import robosim.DirectionVector;
import robosim.Toolbox;
import robosim.MapObject;
import robosim.Robot;
import robosim.Barrier;
import robosim.Air;
import robosim.MapObjects;
public class RobotMovement {
    public void moveRobot(RoboMap roboMap, DirectionVector direction) {
        int[] newPos = new int[] {roboMap.roboPos[0] + direction.getX(), roboMap.roboPos[1] + direction.getY()};

        // Loop through until the xPos is correct, and update the position of the robot on the map each time
        xMove(roboMap, newPos);
        // Loop through until the yPos is correct, and update the position of the robot on the map each time
        yMove(roboMap, newPos);
    }

    private void yMove(RoboMap roboMap, int[] newPos) {
        while (newPos[1] != roboMap.roboPos[1]) {
            if (newPos[1] > roboMap.roboPos[1]) {
                if (roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]+1] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = new Air();
                roboMap.roboPos[1] += 1;
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = new Robot();
                Toolbox.printMap(roboMap);
                Toolbox.sleep(200);
            } else if (newPos[1] < roboMap.roboPos[1]) {
                if (roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]-1] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.AIR.createInstance();
                roboMap.roboPos[1] -= 1;
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.ROBOT.createInstance();
                Toolbox.printMap(roboMap);
                Toolbox.sleep(200);
            }
        }
    }

    private void xMove(RoboMap roboMap, int[] newPos) {
        while (newPos[0] != roboMap.roboPos[0]) {
            if (newPos[0] > roboMap.roboPos[0]) {
                if (roboMap.RMap.FMap[roboMap.roboPos[0]+1][roboMap.roboPos[1]] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.AIR.createInstance();
                roboMap.roboPos[0] += 1;
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.ROBOT.createInstance();
                Toolbox.printMap(roboMap);
                Toolbox.sleep(200);
            } else if (newPos[0] < roboMap.roboPos[0]) {
                if (roboMap.RMap.FMap[roboMap.roboPos[0]-1][roboMap.roboPos[1]] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.AIR.createInstance();
                roboMap.roboPos[0] -= 1;
                roboMap.RMap.FMap[roboMap.roboPos[0]][roboMap.roboPos[1]] = MapObjects.ROBOT.createInstance();
                Toolbox.printMap(roboMap);
                Toolbox.sleep(200);
            }
        }
    }
}
