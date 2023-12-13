package robosim;
import robosim.FTCMap;
import robosim.DirectionVector;
import robosim.Toolbox;

public class RoboMap {
    public FTCMap RMap;
    public int[] roboPos;
    public RoboMap(int[] dimensions, int[] roboStartPos) {
        try {
            MapObject[][] pmap = new MapObject[dimensions[0]][dimensions[1]];
            for (int i = 0; i< pmap.length; ++i) {
                for (int j = 0; j<pmap[i].length; ++j) {
                    pmap[i][j] = new Air();
                }
            }
            this.RMap = new FTCMap(pmap);
            this.RMap.FMap[roboStartPos[0]][roboStartPos[1]] = new Robot();
            this.roboPos = roboStartPos;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void moveRobot(DirectionVector direction) {
        int[] newPos = new int[] {this.roboPos[0] + direction.getX(), this.roboPos[1] + direction.getY()};
        // Fun boundary shenanigans
        //this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = 0;
        //this.RMap.FMap[newPos[0]][newPos[1]] = 1;

        // Loop through until the xPos is correct, and update the position of the robot on the map each time
        while (newPos[0] != this.roboPos[0]) {
            if (newPos[0] > this.roboPos[0]) {
                if (this.RMap.FMap[this.roboPos[0]+1][this.roboPos[1]] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[0] += 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            } else if (newPos[0] < this.roboPos[0]) {
                if (this.RMap.FMap[this.roboPos[0]-1][this.roboPos[1]] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
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
                if (this.RMap.FMap[this.roboPos[0]][this.roboPos[1]+1] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[1] += 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            } else if (newPos[1] < this.roboPos[1]) {
                if (this.RMap.FMap[this.roboPos[0]][this.roboPos[1]-1] instanceof Barrier) {
                    System.out.println("Cannot move robot into barrier!");
                    break;
                }
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Air();
                this.roboPos[1] -= 1;
                this.RMap.FMap[this.roboPos[0]][this.roboPos[1]] = new Robot();
                Toolbox.printMap(this);
                Toolbox.sleep(200);
            }
        }
    }
    public void createBarrier(int x, int y) {
    try {
        this.RMap.FMap[y][x] = new Barrier();
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid coordinates for barrier: " + x + ", " + y);
    }
}
}
