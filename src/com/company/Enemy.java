package com.company;

import java.util.HashMap;
import java.util.List;


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
    public void Update(List<MyObserver> characters) {

    }
}
