package com.company;

public class Rogue extends Player {

    OurPair energy;//<energyPool,currentEnergy>
    int abilityCost;

    public Rogue(String name,int healthPool,int attackPoints, int defensePoints,int abilityCost){
        super(name, healthPool, attackPoints, defensePoints);
        this.energy=new OurPair(100,100);
        this.abilityCost=abilityCost;
        abilityRange=2;
    }

    @Override
    public void onGameTick() {
        energy.setSecond(Math.min(energy.getSecond()+10,100));
    }

    @Override
    public void levelUp() {
        super.levelUp();
        energy.setSecond(100);
        attackPoints=attackPoints+(3*playerLevel);
    }

    @Override
    public void abilityCast() {
        if(energy.getSecond()<abilityCost)
            System.out.println("Cant cast ability yet-try eating energy bar");
        else {
            energy.setSecond(energy.getSecond()-abilityCost);
            ////do attack
        }
    }
}
