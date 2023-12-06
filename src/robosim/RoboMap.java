package robosim;
import robosim.FTCMap;
import robosim.DirectionVector;
import robosim.Toolbox;

public class RoboMap {
    public FTCMap RMap;
    public int[] roboPos;
    public RoboMap(int[] dimensions, int[] roboStartPos) {
        this.RMap = new FTCMap(new MapObject[dimensions[0]][dimensions[1]]);
        this.RMap.FMap[roboStartPos[0]][roboStartPos[1]] = new Robot();
        this.roboPos = roboStartPos;
    }
    public void moveRobot(DirectionVector direction) {
        int[] newPos = new int[] {this.roboPos[0] + direction.getX(), this.roboPos[1] + direction.getY()};
        // Fun boundary shenanigans
        //this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = 0;
        //this.RMap.FMap[newPos[0]][newPos[1]] = 1;

        // Loop through until the xPos is correct, and update the position of the robot on the map each time
        while (newPos[0] != this.roboPos[0]) {
            if (newPos[0] > this.roboPos[0]) {
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[0] += 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            } else if (newPos[0] < this.roboPos[0]) {
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[0] -= 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            }
        }
        // Loop through until the yPos is correct, and update the position of the robot on the map each time
        while (newPos[1] != this.roboPos[1]) {
            if (newPos[1] > this.roboPos[1]) {
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[1] += 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            } else if (newPos[1] < this.roboPos[1]) {
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[1] -= 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            }
        }
    }
}