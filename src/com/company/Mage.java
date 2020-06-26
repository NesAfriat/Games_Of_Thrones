package com.company;

import com.company.OurPair;
import com.company.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Mage extends Player {

    OurPair mana;//<manaPool,currentMana>
    int manaCost;
    int spellPower;
    int hitsCount;

    public Mage(char type,OurPair position,String name,int healthPool,int attackPoints, int defensePoints,int manaPool,int manaCost,int spellPower,int hitsCount,int abilityRange)
    {
            super(type, position, name, healthPool, attackPoints, defensePoints);
            this.mana = new OurPair((manaPool / 4),manaPool);
            this.manaCost = manaCost;
            this.spellPower = spellPower;
            this.hitsCount = hitsCount;
            this.abilityRange = abilityRange;

    }

    @Override
    public void levelUp() {
        super.levelUp();
        mana.setSecond(mana.getSecond()+(25*playerLevel));
        mana.setFirst(Math.min(mana.getFirst()+(mana.getSecond()/4),mana.getSecond()));
        this.spellPower=this.spellPower+(10*playerLevel);

    }

    @Override
    public void onGameTick() {
        mana.setFirst(Math.min(mana.getSecond(),mana.getFirst()+playerLevel));
    }

    @Override
    public void abilityCast(List<MyObserver> enemies) {
        if (mana.getFirst() < manaCost)
            System.out.println("Cant cast ability yet-need more mana");
        else {
            mana.setFirst(mana.getFirst() - manaCost);
            int hits = 0;
            LinkedList<MyObserver> releventEnemies=enemyInRange(enemies);
            while (hits < hitsCount&!releventEnemies.isEmpty())
            {
                Random random=new Random();
                Enemy randomEnemy = (Enemy) releventEnemies.get(random.nextInt(releventEnemies.size()));
                this.attack(randomEnemy,spellPower);
                hits++;
            }

        }
    }
    private LinkedList<MyObserver> enemyInRange(List<MyObserver> enemies)
    {
        LinkedList<MyObserver> releventEnemies=new LinkedList<>();//only enemies within range 3
        for (MyObserver mo:enemies)
        {
            Enemy emo=mo.getEnemy();
            if (this.getPosition().Range(emo.getPosition())<abilityRange)
            {
                releventEnemies.add(mo);
            }
        }
        return releventEnemies;
    }


    }

