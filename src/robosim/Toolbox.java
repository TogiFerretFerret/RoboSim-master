package robosim;
import robosim.FTCMap;
import robosim.RoboMap;
public class Toolbox {
    public Toolbox() {

    }
    public static void writeToFile(String filename, String content) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(filename);
            fw.write(content);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String readFile(String filename) {
        try {
            java.io.FileReader fr = new java.io.FileReader(filename);
            String content = "";
            int i;
            while ((i = fr.read()) != -1) {
                content += (char) i;
            }
            fr.close();
            return content;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
    public static void printMap(RoboMap map) {
        FTCMap mmap = map.RMap;
        String mapString = "";
        for (MapObject[] row : mmap.FMap) {
            for (MapObject cell : row) {
                mapString += cell.getChar();
                mapString += " ";
            }
            mapString += "\n";
        }
        writeToFile("map.txt", mapString);
        System.out.println(mapString);
    }
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
