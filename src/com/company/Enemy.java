package com.company;

import javafx.util.Pair;

import java.util.HashMap;


public class Enemy extends Unit{
    private int expValue;
    public Enemy(char type, OurPair position,int exp, String name,int health, int attackPoints, int defensePoints)
    {
        super(type, position, name, health, attackPoints, defensePoints);
        this.expValue=exp;
    }

    public void setExpValue(int expValue) {
        this.expValue = expValue;
    }
    public int getExpValue() {
        return expValue;
    }
}
