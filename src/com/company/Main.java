package com.company;
import java.beans.EventHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        GameController gc=new GameController();
        try {
            List<String> levelData;
            List<String> LevelFiles = Files.list(Paths.get(args[0])).sorted().map(Path::toString).collect(Collectors.toList());
            for(String levelPath : LevelFiles) {
                levelData = Files.readAllLines(Paths.get(levelPath));
                char[][]currentLevel= new char[levelPath.length()][levelData.size()];
                int line= 0;
                for (String s : levelData) {
                    for(int i=0; i<s.length(); i++) {
                        currentLevel[line][i]=s.charAt(i);
                    }
                    line++;
                }
                   GameBoard gb = new GameBoard(currentLevel,gc);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
