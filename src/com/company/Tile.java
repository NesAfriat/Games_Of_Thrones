package com.company;


import javafx.util.Pair;

public class Tile {
    private char tile;
    private Pair<int,int> position;
    public Tile(char type, Pair<int,int> position)
    {
        this.tile=type;
        this.position= position;
    }
    public String toString()
    {
        return String.valueOf(this.tile);
    }
}
