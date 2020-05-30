package com.company;

public class GameBoard {
    private Tile[][] gameBoard;

    public GameBoard(char[][] level) {
        this.gameBoard = NextLevel(level);
    }

    private Tile[][] NextLevel(char[][] nextlevel) {
        Tile[][] gameObjects = new Tile[nextlevel.length][nextlevel[0].length];
        Tile tmp;
        for (int i = 0; i < nextlevel.length; i++)
            for (int j = 0; j < nextlevel[i].length; j++) {
                char sign = nextlevel[i][j];
                switch (sign) {
                    case '#': //game board objects
                        tmp = new Wall(new OurPair(i,j));
                        gameObjects[i][j] = tmp;
                        break;
                    case '.':
                        tmp = new Empty(new OurPair(i,j));
                        gameObjects[i][j] = tmp;
                        break;
                    case 's': //monsters cases
                        tmp=new Monster('s',new OurPair(i, j),"Lannister Solider",25, 3,80,8,3);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'k': //monsters cases
                        tmp=new Monster('s',new OurPair(i, j),"Lannister Knight",50, 4,200,14,8);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'q': //monsters cases
                        tmp=new Monster('q',new OurPair(i, j),"Queen’s Guard",100, 5,400,20,15);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'z': //monsters cases
                        tmp=new Monster('z',new OurPair(i, j),"Wright",100, 3,600,30,15);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'b': //monsters cases
                        tmp=new Monster('b',new OurPair(i, j),"Bear-Wright",250, 4,1000,75,30);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'g': //monsters cases
                        tmp=new Monster('g',new OurPair(i, j),"Giant-Wright",500, 5,1500,100,40);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'w': //monsters cases
                        tmp=new Monster('w',new OurPair(i, j),"White Walker",1000, 6,2000,150,50);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'M': //monsters cases
                        tmp=new Monster('M',new OurPair(i, j),"The Mountain",500, 6,1000,60,25);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'C': //monsters cases
                        tmp=new Monster('C',new OurPair(i, j),"Queen Cersei",1000, 1,100,10,10);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'K': //monsters cases
                        tmp=new Monster('K',new OurPair(i, j),"Night’s King",5000, 8,5000,300,150);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'B': //traps cases
                        tmp = new Trap('B', new OurPair(i, j), "Bonus Trap", 250, 1, 5, 1, 1, 1);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'Q': //traps cases
                        tmp = new Trap('B', new OurPair(i, j), "Queen's Trap", 100, 3, 7, 250, 50, 10);
                        gameObjects[i][j] = tmp;
                        break;
                    case 'D': //traps cases
                        tmp = new Trap('B', new OurPair(i, j), "Death Trap", 250, 1, 10, 500, 100, 20);
                        gameObjects[i][j] = tmp;
                        break;

                }
            }
        return gameObjects;
    }
}
//}
