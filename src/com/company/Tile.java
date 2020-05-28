package com.company;


import javafx.util.Pair;

public class Tile {
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
}
