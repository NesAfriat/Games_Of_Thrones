package com.company;

public class GameBoard {
    private Tile[][]gameBoard;
    public GameBoard(char[][]level)
    {
        this.gameBoard=NextLevel(level);
    }
    private Tile[][] NextLevel(char[][]nextlevel) {
    Tile[][] gameObjects= new Tile[nextlevel.length][nextlevel[0].length];
       for (int i = 0; i < nextlevel.length; i++)
           for (int j = 0; j < nextlevel[i].length; j++)
            {
            char sign= nextlevel[i][j];
            switch (sign){
                case 'B':
                    Trap tmp = new Trap('B', new OurPair(i,j),"Bonus Trap",250,1,5,1,1,1);
           gameObjects[i][j]=tmp;
                    break;
                case 'Q':
                    name= "Queen's Trap";
                    _health=250;
                    attackPoints=50;
                    defensePoints=10;
                    exp=100;
                    this.visibilityTime=3;
                    this.inVisibilityTime=7;
                    //   Point<int,int> health= new Point(_health,_health);
                    break;
                case 'D':
                    name= "Death Trap";
                    _health=500;
                    attackPoints=100;
                    defensePoints=20;
                    exp=250;
                    this.visibilityTime=1;
                    this.inVisibilityTime=10;
                    //   Point<int,int> health= new Point(_health,_health);
                    break;

            }
    }
//}
