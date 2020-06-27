package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

public class GameBoard {
    private Tile[][] gameBoard;
    LinkedList<MyObserver> enemies;
    LinkedList<Enemy> Myenemies;
    OurPair playerLoaction;

    public GameBoard(char[][] level) {
        this.gameBoard = NextLevel(level);
    }

    protected Tile[][] NextLevel(char[][] nextlevel) {
        Tile[][] gameObjects = new Tile[nextlevel.length][nextlevel[0].length];
        enemies = new LinkedList<MyObserver>();
        Myenemies=new LinkedList<>();
        Tile tmp;
        Enemy e;
        for (int i = 0; i < nextlevel.length; i++)
            for (int j = 0; j < nextlevel[i].length; j++) {
                char sign = nextlevel[i][j];
                switch (sign) {
                    case '@':
                        playerLoaction = new OurPair(i, j);
                    case '#': //game board objects
                        tmp = new Wall(new OurPair(i, j));
                        gameObjects[i][j] = tmp;
                        break;
                    case '.':
                        tmp = new Empty(new OurPair(i, j));
                        gameObjects[i][j] = tmp;
                        break;
                    case 's': //monsters cases
                        e= new Monster('s', new OurPair(i, j), "Lannister Solider", 25, 3, 80, 8, 3);
                        gameObjects[i][j] =e;
                        Myenemies.add(e);

                        break;
                    case 'k': //monsters cases
                        e = new Monster('s', new OurPair(i, j), "Lannister Knight", 50, 4, 200, 14, 8);
                        gameObjects[i][j] =e;
                        Myenemies.add(e);
                        break;
                    case 'q': //monsters cases
                        e = new Monster('q', new OurPair(i, j), "Queen’s Guard", 100, 5, 400, 20, 15);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'z': //monsters cases
                        e = new Monster('z', new OurPair(i, j), "Wright", 100, 3, 600, 30, 15);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'b': //monsters cases
                        e = new Monster('b', new OurPair(i, j), "Bear-Wright", 250, 4, 1000, 75, 30);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'g': //monsters cases
                        e = new Monster('g', new OurPair(i, j), "Giant-Wright", 500, 5, 1500, 100, 40);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'w': //monsters cases
                        e = new Monster('w', new OurPair(i, j), "White Walker", 1000, 6, 2000, 150, 50);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'M': //monsters cases
                        e = new Monster('M', new OurPair(i, j), "The Mountain", 500, 6, 1000, 60, 25);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'C': //monsters cases
                        e = new Monster('C', new OurPair(i, j), "Queen Cersei", 1000, 1, 100, 10, 10);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'K': //monsters cases
                        e= new Monster('K', new OurPair(i, j), "Night’s King", 5000, 8, 5000, 300, 150);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'B': //traps cases
                        e = new Trap('B', new OurPair(i, j), "Bonus Trap", 250, 1, 5, 1, 1, 1);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'Q': //traps cases
                        e = new Trap('B', new OurPair(i, j), "Queen's Trap", 100, 3, 7, 250, 50, 10);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;
                    case 'D': //traps cases
                        e = new Trap('B', new OurPair(i, j), "Death Trap", 250, 1, 10, 500, 100, 20);
                        gameObjects[i][j] = e;
                        Myenemies.add(e);
                        break;

                }
            }
        return gameObjects;
    }

    public LinkedList<Enemy> getMyenemies() {
        return Myenemies;
    }

    public List<MyObserver> getEnemies() {
        return enemies;
    }

    public Tile getTile(int i, int j) {
        return gameBoard[i][j];
    }

    public OurPair getPlayerLoaction() {
        return playerLoaction;
    }

    public void setPlayer(Player player) {
        gameBoard[playerLoaction.getFirst()][playerLoaction.getSecond()] = player;
    }


    public String PrintBoard() {
        String board= "";
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                board= board+ gameBoard[i][j].getTile();
            }
            board= board + "\n";
        }
        return board;
    }
    public void setTile (OurPair o,Tile t)
    {
        gameBoard[o.getFirst()][o.getSecond()]=t;
    }
}

