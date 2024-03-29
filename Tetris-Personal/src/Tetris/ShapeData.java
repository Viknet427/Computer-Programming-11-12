package Tetris;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeData {

    boolean[][][] rotationStates = new boolean[4][4][4];
    String name;
    int defaultState;
    int colorIndex;

    public static final ShapeData line = new ShapeData("/res/line.txt", "line", 1, 0);
    public static final ShapeData square = new ShapeData("/res/square.txt", "square", 0, 1);
    public static final ShapeData lshape = new ShapeData("/res/lshape.txt", "lshape", 1, 2);
    public static final ShapeData jshape = new ShapeData("/res/jshape.txt", "jshape", 3, 3);
    public static final ShapeData tee = new ShapeData("/res/tee.txt", "tee", 0, 4);
    public static final ShapeData zshape = new ShapeData("/res/zshape.txt", "zshape", 1, 5);
    public static final ShapeData sshape = new ShapeData("/res/sshape.txt", "sshape", 1, 6);

    public ShapeData(String filename, String name, int defaultState, int colorIndex)
    {
        this.name = name;
        this.defaultState = defaultState;
        this.colorIndex = colorIndex;

        Scanner s = new Scanner(ShapeData.class.getResourceAsStream(filename));
        for(int i = 0;  i < 4; i++)
        {
            for(int j = 0 ; j < 4; j++)
            {
                String line = s.nextLine();
                for(int k = 0; k < 4; k++)
                {
                    rotationStates[i][j][k] = line.charAt(k) == '1';
                }
            }
        }
        s.close();
        System.out.println("Tetris shape " + name + " successfully loaded from " + filename);
    }

}
