package com.company.Objects;

import com.company.OurPair;

import java.util.LinkedList;
import java.util.List;

public class Hunter extends Player {
    int range;
    int arrowsCount;
    int ticksCount;

    public Hunter(char type, OurPair position, String name, int healthPool, int attackPoints, int defensePoints, int arrowsCount, int range) {
        super(type, position, name, healthPool, attackPoints, defensePoints);
        this.arrowsCount=arrowsCount;
        this.range = range;
    }

    public void levelUp() {
        super.levelUp();
        arrowsCount=arrowsCount+10*playerLevel;
        this.attackPoints=this.attackPoints+2*playerLevel;
        this.defensePoints=this.defensePoints+playerLevel;
        this.m.sendMessage(this.name + " leveled up and gained:+" + 10 * this.playerLevel + " Health ,+" + 6 * this.playerLevel + " Attack ," + 2 * this.playerLevel + " Defense , " + 10*playerLevel+" arrows");
    }

    public void onGameTick() {
        if(this.ticksCount==10)
        {
            arrowsCount=arrowsCount+playerLevel;
            this.ticksCount=0;
        }
        else{
            this.ticksCount++;
        }
    }




    public void abilityCast(List<Enemy> enemies, GameBoard gb) {
        if (this.arrowsCount==0) {
            this.m.sendMessage(this.name + " tried to cast Shoot but there was not arrows ");
        } else {
            LinkedList<Enemy> releventEnemies = this.enemyInRange(enemies);
            if(releventEnemies.isEmpty()){
                this.m.sendMessage(this.name + " cast Shoot but no one was in sight.");
            }
            else{
                Enemy e1=releventEnemies.get(0);
                for(Enemy e2:releventEnemies)//choosing the the closest enemy
                {
                    if(e1.getPosition().Range(this.getPosition())>e2.getPosition().Range(this.getPosition()))
                        e1=e2;
                }
                arrowsCount=arrowsCount-1;
                this.attack(e1,this.attackPoints,gb);
            }
        }
    }



    private LinkedList<Enemy> enemyInRange(List<Enemy> enemies) {//picking only enemies in range
        LinkedList<Enemy> releventEnemies = new LinkedList();

        for (Enemy e:enemies) {
            if (this.getPosition().Range(e.getPosition()) <= this.range) {
                releventEnemies.add(e);
            }
        }

        return releventEnemies;
    }

    public String describe() {

        return (this.name + "     Health:" + this.health.getFirst() + "/" + this.health.getSecond() + "  Attack: " + this.attackPoints + "   Defense: " + this.defensePoints + "   Level: " + this.playerLevel + "    Experience: " + this.exp + "/" + 50 * this.playerLevel + "   arrows: " + this.arrowsCount+  "    ticksCount: " + this.ticksCount);
    }
}
