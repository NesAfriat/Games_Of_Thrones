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
    public void Action(GameBoard gb) {

    }
}
