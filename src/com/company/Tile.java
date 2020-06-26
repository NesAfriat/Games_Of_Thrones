package com.company;


import java.util.List;

public class Tile implements MyObserver{
    private char tile;
    private OurPair position;
    public Tile(char type, OurPair position)
    {
        this.tile=type;
        this.position= position;
    }
    public String toString()
    {
        return String.valueOf(this.tile);
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

    @Override
    public void Action(GameBoard gb, Player p) {

    }

    @Override
    public boolean IsAlive() {
        return true;
    }

    @Override
    public Enemy getEnemy() {
        return null;
    }
}
