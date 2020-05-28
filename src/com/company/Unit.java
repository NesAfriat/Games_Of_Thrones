package com.company;

import javafx.util.Pair;

public abstract class Unit extends Tile {
    protected String name;
    protected OurPair health;
    protected int attackPoints;
    protected int defensePoints;
 //   private final char DEADPLAYER= 'X';
    public Unit(char type, OurPair position,String name,int _health, int attackPoints, int defensePoints) {
        super(type, position);
        this.name= name;
        this.health=new OurPair(_health,_health);
        this.attackPoints=attackPoints;
        this.defensePoints=defensePoints;
    }
}
