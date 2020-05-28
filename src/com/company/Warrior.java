package com.company;

public class Warrior extends Player {
    OurPair cooldown;//<abilityCooldown,remainingCooldown>

    public Warrior(char type,OurPair position,String name,int healthPool,int attackPoints, int defensePoints,int abillityCooldown)
    {
        super(type,position,name, healthPool, attackPoints, defensePoints);
        super.abilityRange=3;
        this.cooldown=new OurPair(abillityCooldown,0);

    }

    @Override
    public void levelUp() {/////////////ask tal
        super.levelUp();
        cooldown.setSecond(0);
        health.setFirst(health.getFirst()+(5*playerLevel));
        attackPoints=attackPoints+(2*playerLevel);
        defensePoints=defensePoints+playerLevel;
    }
    public void onGameTick()
    {
        cooldown.setSecond(Math.max(cooldown.getSecond()-1,0));
    }

    @Override
    public void abilityCast() {
        if (cooldown.getSecond()>0)
            System.out.println("Cant cast ability yet-not cool enough");
        else {
            cooldown.setSecond(cooldown.getFirst());
            health.setSecond(Math.min(health.getSecond()+(10*defensePoints),health.getFirst()));

            /////////hit random enemy

        }
    }
}
