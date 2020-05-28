package com.company;

import javafx.util.Pair;

import java.util.HashMap;


public class Enemy extends Unit{
    private int expValue;
    public Enemy(char type, Pair<int,int>position,int exp, String name,int health, int attackPoints, int defensePoints)
    {
        super(type, position, name, health, attackPoints, defensePoints);
        this.expValue=exp;
    }
}
