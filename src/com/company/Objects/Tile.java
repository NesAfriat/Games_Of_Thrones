
package com.company.Objects;

import com.company.Control.MessageHandler;
import com.company.OurPair;
import com.company.VisitorMovement;

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



    public void accept(VisitorMovement vm, Player player) {

    }
    public void accept(VisitorMovement vm, Enemy enemy) {

    }
}

