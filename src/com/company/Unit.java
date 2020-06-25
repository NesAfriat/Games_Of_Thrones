package com.company;


import java.util.Random;

public abstract class Unit extends Tile {
    protected String name;
    protected OurPair health;
    protected int attackPoints;
    protected int defensePoints;
 //   private final char DEADPLAYER= 'X';
    public Unit(char type, OurPair position,String name,int _health, int attackPoints, int defensePoints) {
        super(type, position);
        this.name= name;
        this.health=new OurPair(_health,_health);
        this.attackPoints=attackPoints;
        this.defensePoints=defensePoints;
    }
    public boolean isAlive()
    {
        return health.getFirst()!=0;
    }

    public void attack(Enemy enemy) // player attacks,enemy defends
    {
        Random random=new Random();
        //player roll attack points
        int rollAttack=random.nextInt(this.attackPoints);
        //enemy roll defense points
        int rollDefense=random.nextInt(enemy.defensePoints);
        int diff=rollAttack-rollDefense;

        if (diff>0)
        {
            //
        }

    }
    public void attack(Player player)// enemy attacks,player defends
    {
        Random random=new Random();
        //player roll attack points
        int rollAttack=random.nextInt(this.attackPoints);
        //enemy roll defense points
        int rollDefense=random.nextInt(player.defensePoints);
        int diff=rollAttack-rollDefense;

        if (diff>0)
        {
            //
        }
    }


}
