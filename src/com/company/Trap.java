package com.company;

import javafx.util.Pair;

public class Trap extends Enemy {
    private int visibilityTime;
    private int inVisibilityTime;
    private int tickCount=0;
    private boolean visible=false;
 //   private final int ABILITYRANGE=
    public Trap(char type, OurPair position,String name,int exp, int visibilityTime, int inVisibilityTime,int health, int attackPoints, int defensePoints) {
        super(type, position,exp, name,health , attackPoints,defensePoints);
        this.inVisibilityTime= inVisibilityTime;
        this.visibilityTime=visibilityTime;
        }
    }



