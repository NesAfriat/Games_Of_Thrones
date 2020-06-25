package com.company;

import com.company.OurPair;
import com.company.Player;

import java.util.List;


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
            while (hits < hitsCount)//להוסיף תנאי שקיים אויב חי
            {
                ///////////
                ///////////
                //this.combatSystem.attack(randomenemy,spellPower);
                hits++;
            }

        }

    }


    }

