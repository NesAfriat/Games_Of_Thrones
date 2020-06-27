
package com.company;

import java.util.List;

public class Tile {
    private char tile;
    private OurPair position;

    MessageHandler m;

    public Tile(char type, OurPair position)
    {
        this.tile=type;
        this.position= position;
        m=new MessageHandler();
    }
    //public String toString()
    //{
      //  return String.valueOf(this.tile);
    //}
    public void setPosition(OurPair position)
    {
        this.position=position;
    }

    public char getTile() {
        return tile;
    }

    public OurPair getPosition() {
        return position;
    }


    public void Action(GameBoard gb, Player p) {

    }


    public boolean IsAlive() {
        return true;
    }


    public Enemy getEnemy() {
        return null;
    }


}

