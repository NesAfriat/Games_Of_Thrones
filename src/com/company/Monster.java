package com.company;

import java.util.List;

public class Monster extends Enemy {
    private int visionRange;
    public Monster(char type, OurPair position, String name, int exp, int _visionRange, int health, int attackPoints, int defensePoints) {
        super(type, position, exp, name, health, attackPoints, defensePoints);
        this.visionRange=_visionRange;
    }

    @Override
    public void Action(GameBoard gb,Player player) {
        OurPair monsterP = this.getPosition();
        OurPair playerP= player.getPosition();
        double range= Range(monsterP, playerP);
        VisitorMovement vm= new VisitorMovement(gb);
        int dx, dy;
        if(range<visionRange) {
            dy = monsterP.getFirst() - playerP.getFirst();
            dx = monsterP.getSecond() - playerP.getSecond();
        if(Math.abs(dx)>Math.abs(dy)) {
            if (dx > 0)
                gb.getTile(monsterP.getFirst(), monsterP.getSecond() - 1).accept(vm,this);
            else
                gb.getTile(monsterP.getFirst(), monsterP.getSecond() + 1).accept(vm,this);
        }
            else if(dy>0)
                gb.getTile(monsterP.getFirst()-1, monsterP.getSecond()).accept(vm,this);
            else
                gb.getTile(monsterP.getFirst()+1, monsterP.getSecond()).accept(vm,this);
        }
        else
            MoveRandomly(vm,gb,monsterP);
    }

    private void MoveRandomly(VisitorMovement vm, GameBoard gb,OurPair monsterP) {
        int move = (int)Math.floor(Math.random()* 5);
        switch (move) {
            case 0:
               break;
            case 1:
                gb.getTile(monsterP.getFirst(), monsterP.getSecond() + 1).accept(vm,this);
                break;
            case 2:
                gb.getTile(monsterP.getFirst(), monsterP.getSecond() - 1).accept(vm,this);
                break;
            case 3:
                gb.getTile(monsterP.getFirst()+1, monsterP.getSecond()).accept(vm,this);
                break;
            case 4:
                gb.getTile(monsterP.getFirst()-1, monsterP.getSecond()).accept(vm,this);
                break;
        }

    }

    private double Range(OurPair position, OurPair playerLocation)
    {
        return Math.sqrt(Math.pow(position.getFirst()-playerLocation.getFirst(),2)+Math.pow(position.getSecond()-playerLocation.getSecond(),2));
    }
    @Override
    public String describe ()
    {
        return (this.name+"    health: "+health.getFirst()+"/"+health.getSecond()+"   Attack: "+attackPoints+"   Defense: "+defensePoints+"  Experience Value"+getExpValue()+" Vision range: "+visionRange);
    }
    @Override
    public String toString() {
        return String.valueOf(getTile());
    }
}
