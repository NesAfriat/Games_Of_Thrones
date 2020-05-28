package com.company;

import javafx.util.Pair;

public class Trap extends Enemy {
    private int visibilityTime;
    private int inVisibilityTime;
    private int tickCount=0;
    private boolean visible=false;
 //   private final int ABILITYRANGE=
    public Trap(char type, Pair<int, int> position,String name,int exp, int visibilityTime, int inVisibilityTime,int health, int attackPoints, int defensePoints) {
        super(type, position,exp, name,health , attackPoints,defensePoints);
        this.inVisibilityTime= inVisibilityTime;
        this.visibilityTime=visibilityTime;
        }
    }





/*     switch (typeCheck) {
            case 'B':
                name= "Bonus Trap";
                _health=1;
                attackPoints=1;
                defensePoints=1;
                exp=250;
                this.visibilityTime=1;
                this.inVisibilityTime=5;
            //   Point<int,int> health= new Point(_health,_health);

                break;
            case 'Q':
                name= "Queen's Trap";
                _health=250;
                attackPoints=50;
                defensePoints=10;
                exp=100;
                this.visibilityTime=3;
                this.inVisibilityTime=7;
                //   Point<int,int> health= new Point(_health,_health);
                break;
            case 'D':
                name= "Death Trap";
                _health=500;
                attackPoints=100;
                defensePoints=20;
                exp=250;
                this.visibilityTime=1;
                this.inVisibilityTime=10;
                //   Point<int,int> health= new Point(_health,_health);
                break;

    */