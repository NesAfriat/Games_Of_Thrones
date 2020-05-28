package com.company;

import com.company.OurPair;
import com.company.Player;
import javafx.util.Pair;

public class Mage extends Player {

    OurPair mana;//<manaPool,currentMana>
    int manaCost;
    int spellPower;
    int hitsCount;

    public Mage(String name,int healthPool,int attackPoints, int defensePoints,int manaPool,int manaCost,int spellPower,int hitsCount,int abilityRange)
    {
            super(name, healthPool, attackPoints, defensePoints);
            this.mana = new OurPair(manaPool, (manaPool / 4));
            this.manaCost = manaCost;
            this.spellPower = spellPower;
            this.hitsCount = hitsCount;
            this.abilityRange = abilityRange;

    }

    @Override
    public void levelUp() {
        super.levelUp();
        mana.setFirst(mana.getFirst()+(25*playerLevel));
        mana.setSecond(Math.min(mana.getSecond()+(mana.getFirst()/4),mana.getFirst()));
        this.spellPower=this.spellPower+(10*playerLevel);

    }

    @Override
    public void onGameTick() {
        mana.setSecond(Math.min(mana.getFirst(),mana.getSecond()+playerLevel));
    }

    @Override
    public void abilityCast() {
        if (mana.getSecond()<manaCost)
            System.out.println("Cant cast ability yet-need more mana");
        else{
            mana.setSecond(mana.getSecond()-manaCost);
            int hits=0;
            while (hits<hitsCount)//להוסיף תנאי שקיים אויב חי
            {
                ///////////
                ///////////
                //this.combatSystem.attack(randomenemy,spellPower);
                hits++;
            }

        }
    }
}
