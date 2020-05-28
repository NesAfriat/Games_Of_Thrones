package com.company;

import javafx.util.Pair;

public abstract class Unit extends Tile {
    private String name;
    private Pair<int,int> health;
    private int attackPoints;
    private int defensePoints;
 //   private final char DEADPLAYER= 'X';
    public Unit(char type, Pair<int, int> position,String name,int _health, int attackPoints, int defensePoints) {
        super(type, position);
        this.name= name;
        this.health=new Pair(_health,_health);
        this.attackPoints=attackPoints;
        this.defensePoints=defensePoints;
    }
}
