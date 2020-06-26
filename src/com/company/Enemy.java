package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Enemy extends Unit implements MyObserver{
    private int expValue;
    public Enemy(char type, OurPair position,int exp, String name,int health, int attackPoints, int defensePoints)
    {
        super(type, position, name, health, attackPoints, defensePoints);
        this.expValue=exp;
    }

    public void setExpValue(int expValue) {
        this.expValue = expValue;
    }
    public int getExpValue() {
        return expValue;
    }

    public void accept(VisitorMovement movementVisitor,Player player)
    {
        movementVisitor.visit(this,player);
    }
    public void accept(VisitorMovement movementVisitor,Enemy enemy)
    {
        movementVisitor.visit(this,enemy);
    }
    public void accept (VisitorMovement movementVisitor,Tile tile)
    {
        movementVisitor.visit(this,tile);
    }

    @Override
    public Enemy getEnemy() {
        return this;
    }

    @Override
    public void attack(Enemy enemy, int hitpower) {

    }

    @Override
    public void attack(Enemy enemy) {

    }

    public void attack(Player player)// enemy attacks,player defends - combat system
    {
        Random random=new Random();
        //player roll attack points
        int rollAttack=random.nextInt(this.attackPoints);
        //enemy roll defense points
        int rollDefense=random.nextInt(player.defensePoints);
        int diff=rollAttack-rollDefense;

        if (diff>0)
        {
            player.health.setFirst(player.health.getFirst()-diff);//check if player died
        }
    }
}
