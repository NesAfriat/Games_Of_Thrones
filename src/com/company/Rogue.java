package com.company;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Rogue extends Player implements MyObserver {

    OurPair energy;//<energyPool,currentEnergy>
    int abilityCost;

    public Rogue(char type,OurPair position,String name,int healthPool,int attackPoints, int defensePoints,int abilityCost){
        super(type,position,name, healthPool, attackPoints, defensePoints);
        this.energy=new OurPair(100,100);
        this.abilityCost=abilityCost;
        abilityRange=2;
    }

    @Override
    public void onGameTick() {
        energy.setFirst(Math.min(energy.getFirst()+10,100));
    }

    @Override
    public void abilityCast(List<MyObserver> enemies) {
        if(energy.getFirst()<abilityCost)
            System.out.println("Cant cast ability yet-try eating energy bar");
        else {
            energy.setFirst(energy.getFirst()-abilityCost);
            for (MyObserver mo:enemies)
            {

                Enemy emo=mo.getEnemy();
                if (this.getPosition().Range(emo.getPosition())<3)
                {
                    this.attack(emo,attackPoints);
                }
            }
        }
    }

    @Override
    public void levelUp() {
        super.levelUp();
        energy.setSecond(100);
        attackPoints=attackPoints+(3*playerLevel);
    }




}
