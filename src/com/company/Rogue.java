package com.company;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Rogue extends Player {

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
    public void abilityCast(List<Enemy> enemies,GameBoard gb) {
        if(energy.getFirst()<abilityCost)
            m.sendMessage(this.name+" tried to cast Fan of Knives, but there was not enough energy: "+energy.getFirst()+"/"+energy.getSecond());
        else {
            m.sendMessage(this.name +" cast Fan of Knives");
            energy.setFirst(energy.getFirst()-abilityCost);
            for (Enemy mo:enemies)
            {

                if (this.getPosition().Range(mo.getPosition())<2)//checking if range is less than 2
                {
                    this.attack(mo,attackPoints,gb);
                }
            }
        }
    }

    @Override
    public void levelUp() {
        super.levelUp();
        energy.setSecond(100);
        attackPoints=attackPoints+(3*playerLevel);
        m.sendMessage(this.name +"  leveled up and gained:+"+ 10*playerLevel+" Health ,+"+ 7*playerLevel+ " Attack ,+"+1*playerLevel + "Defense");

    }


    public String describe() {
        return (this.name+ "    Health:"+health.getFirst()+"/"+health.getSecond()+"  Attack: "+attackPoints+"   Defense: "+defensePoints+"   Level: "+playerLevel+"    Experience: "+this.exp+"/"+50*playerLevel+"   Energy: "+energy.getFirst()+"/"+energy.getSecond());

    }
}
