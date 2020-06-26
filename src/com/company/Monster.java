package com.company;

import javafx.util.Pair;

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
        VisitorMovement vm= new VisitorMovement();
        int dx, dy;
        if(range<visionRange) {
            dx = monsterP.getFirst() - playerP.getFirst();
            dy = monsterP.getSecond() - playerP.getSecond();
        if(Math.abs(dx)>Math.abs(dy)) {
            if (dx > 0)
                vm.visit(this, gb.getTile(monsterP.getFirst(), monsterP.getSecond() - 1));
            else
                vm.visit(this, gb.getTile(monsterP.getFirst(), monsterP.getSecond() + 1));
        }
            else if(dy>0)
                vm.visit(this, gb.getTile(monsterP.getFirst()+1, monsterP.getSecond()));
            else
                vm.visit(this, gb.getTile(monsterP.getFirst()-1, monsterP.getSecond()));
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
                vm.visit(this, gb.getTile(monsterP.getFirst(), monsterP.getSecond() + 1));
                break;
            case 2:
                vm.visit(this, gb.getTile(monsterP.getFirst(), monsterP.getSecond() - 1));
                break;
            case 3:
                vm.visit(this, gb.getTile(monsterP.getFirst()+1, monsterP.getSecond()));
                break;
            case 4:
                vm.visit(this, gb.getTile(monsterP.getFirst()-1, monsterP.getSecond()));
                break;
        }

    }

    private double Range(OurPair position, OurPair playerLocation)
    {
        return Math.sqrt(Math.pow(position.getFirst()-playerLocation.getFirst(),2)+Math.pow(position.getSecond()-playerLocation.getSecond(),2));
    }
}
