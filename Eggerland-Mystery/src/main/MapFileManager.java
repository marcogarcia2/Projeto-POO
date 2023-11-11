package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MapFileManager {

    private static final String FILE_PATH = "res/saves/mapsave.txt";;

    public static int readCurrentMap() {
        try {
            Scanner scanner = new Scanner(new File(FILE_PATH));
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Return a default value if the file doesn't exist or cannot be read
        return 0;
    }

    public static void writeCurrentMap(int currentMap) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(Integer.toString(currentMap));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
