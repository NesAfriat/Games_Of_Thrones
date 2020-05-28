package com.company;

import javafx.util.Pair;

public class Monster extends Enemy {
    private int visionRange;
    public Monster(char type, Pair<int, int> position, String name, int exp, int _visionRange, int health, int attackPoints, int defensePoints) {
        super(type, position, exp, name, health, attackPoints, defensePoints);
        this.visionRange=_visionRange;
    }
}
