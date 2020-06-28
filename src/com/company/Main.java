package com.company;
import com.company.Control.GameController;
import com.company.Control.MessageHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        MessageHandler m=new MessageHandler();
        GameController gc=new GameController(m);
        try {
            List<String> levelData;
            List<String> LevelFiles = Files.list(Paths.get(args[0])).sorted().map(Path::toString).collect(Collectors.toList());
            for(String levelPath : LevelFiles) {
                levelData = Files.readAllLines(Paths.get(levelPath));
                char[][]currentLevel= new char[levelData.size()][levelData.get(0).length()];
                int line= 0;
                for (String s : levelData) {
                    for(int i=0; i<s.length(); i++) {
                        currentLevel[line][i]=s.charAt(i);
                    }
                    line++;
                }
                    gc.NewLevel(currentLevel);
                    gc.Run();
                    if(gc.GameOver()) {
                        gc.EndGame();
                        break;
                    }
                    else
                    {
                        //load next level
                    }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
