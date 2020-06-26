package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Warrior extends Player {
    OurPair cooldown;//<abilityCooldown,remainingCooldown>

    public Warrior(char type,OurPair position,String name,int healthPool,int attackPoints, int defensePoints,int abillityCooldown)
    {
        super(type,position,name, healthPool, attackPoints, defensePoints);
        super.abilityRange=3;
        this.cooldown=new OurPair(0,abillityCooldown);

    }

    @Override
    public void levelUp() {
        super.levelUp();
        cooldown.setFirst(0);
        health.setSecond(health.getSecond()+(5*playerLevel));
        attackPoints=attackPoints+(2*playerLevel);
        defensePoints=defensePoints+playerLevel;
    }
    public void onGameTick()
    {
        cooldown.setFirst(Math.max(cooldown.getFirst()-1,0));
    }

    @Override
    public void abilityCast(List<MyObserver> enemies) {
        if (cooldown.getFirst()>0)
            System.out.println("Cant cast ability yet-not cool enough");
        else {
            cooldown.setFirst(cooldown.getSecond());
            health.setFirst(Math.min(health.getFirst()+(10*defensePoints),health.getSecond()));

            LinkedList<MyObserver> releventEnemies=new LinkedList<>();//only enemies within range 3
            for (MyObserver mo:enemies)
            {
                Enemy emo=mo.getEnemy();
                if (this.getPosition().Range(emo.getPosition())<3)
                {
                    releventEnemies.add(mo);
                }
            }

            Random random=new Random();
            if (!releventEnemies.isEmpty()) {
                Enemy randomEnemy = (Enemy) releventEnemies.get(random.nextInt(releventEnemies.size()));
                this.attack(randomEnemy, health.getSecond() / 10);
            }

        }
    }


}
