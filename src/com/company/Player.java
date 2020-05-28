package com.company;

import com.company.Unit;

public abstract class Player extends Unit {

    int exp;
    int playerLevel;
    int abilityRange;

    public Player(String name,int healthPool,int attackPoints, int defensePoints) {
        super(name, healthPool, attackPoints, defensePoints);
        exp = 0;
        playerLevel = 1;

    }

    public void levelUp() {
        exp=exp-50*playerLevel;
        playerLevel=playerLevel+1;
        health.setFirst(health.getFirst()+(10*playerLevel));
        health.setSecond(health.getFirst());
        attackPoints=attackPoints+4*playerLevel;
        defensePoints=defensePoints+playerLevel;
    }
    public abstract void onGameTick();
    public abstract void abilityCast();

    @Override
    public String toString() {
        return ("your level is:"+playerLevel+ " your health is:"+health.getSecond()+" out of "+health.getFirst()+" your attackP is: "+attackPoints+" your defenseP is: "+defensePoints);
    }
}