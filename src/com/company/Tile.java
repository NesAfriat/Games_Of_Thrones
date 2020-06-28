
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


    @Override
    public String toString() {
        return "";
    }

    public Enemy getEnemy() {
        return null;
    }



    protected void accept(VisitorMovement vm, Player player) {

    }
    protected void accept(VisitorMovement vm, Enemy enemy ) {

    }
}

