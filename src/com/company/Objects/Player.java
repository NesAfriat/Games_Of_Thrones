package com.company.Objects;


import com.company.*;

import java.util.List;
import java.util.Random;

public abstract class Player extends Unit {
    int exp;
    int playerLevel;
    int abilityRange;


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Player(char type, OurPair position, String name, int healthPool, int attackPoints, int defensePoints) {
        super(type, position, name, healthPool, attackPoints, defensePoints);
        exp = 0;
        playerLevel = 1;

    }

    public void levelUp() {
        exp = exp - 50 * playerLevel;
        playerLevel = playerLevel + 1;
        health.setSecond(health.getSecond() + (10 * playerLevel));
        health.setFirst(health.getSecond());
        attackPoints = attackPoints + 4 * playerLevel;
        defensePoints = defensePoints + playerLevel;

    }

    public abstract void onGameTick();

    public abstract void abilityCast(List<Enemy> Myenemies, GameBoard gb);

    public String getName() {
        return name;
    }

    public int getAbilityRange() {
        return abilityRange;
    }

    public int getDefencePoints() {
        return this.defensePoints;
    }

    public OurPair getHealth() {
        return this.health;
    }

    @Override
    public void accept(VisitorMovement movementVisitor, Enemy enemy) {
        movementVisitor.visit(this, enemy);
    }
    //@Override
    // public void accept (VisitorMovement movementVisitor,Tile tile)
    //{
    //  movementVisitor.visit(this,tile);
    //}

    public void attack(Enemy enemy, int hitPower, GameBoard gb) // player attacks,enemy defends
    {
        Random random = new Random();
        //player roll attack points
        int rollAttack = hitPower;
        //enemy roll defense points
        int rollDefense = random.nextInt(enemy.getDefensePoints());
        m.sendMessage(enemy.GetName() + " rolled " + rollDefense + " defense points");
        int diff = rollAttack - rollDefense;

        if (diff > 0) {
            m.sendMessage(this.name + " hit " + enemy.GetName() + " for " + diff + " ability damage.");
            enemy.health.setFirst(enemy.health.getFirst() - diff);//check if enemy died

            if (!enemy.isAlive()) {
                m.sendMessage(enemy.GetName() + " died. " + this.name + " gained " + enemy.getExpValue() + " experience.");
                this.exp += enemy.getExpValue();
                if (this.exp >= 50 * playerLevel) {
                    this.levelUp();
                }
                OurPair tmp = enemy.getPosition();
                Tile e = new Empty(tmp);
                gb.setTile(tmp, e);
                gb.Myenemies.remove(enemy);

            }

        }
    }

    public void attack(Enemy enemy, GameBoard gb) {
        m.sendMessage(this.name + " engaged in combat with " + enemy.name);
        m.sendMessage(this.describe());
        m.sendMessage(enemy.describe());
        Random random = new Random();
        //player roll attack points
        int rollAttack = random.nextInt(this.attackPoints);
        m.sendMessage(this.name + " rolled " + rollAttack + " attack points");
        //enemy roll defense points
        int rollDefense = random.nextInt(enemy.getDefensePoints());
        m.sendMessage(enemy.name + " rolled " + rollDefense + " defense points");
        int diff = rollAttack - rollDefense;

        if (diff > 0) {
            m.sendMessage(this.name + " dealt " + diff + " damage to " + enemy.name);
            enemy.health.setFirst(enemy.health.getFirst() - diff);
            if (!enemy.isAlive()) {
                this.exp += enemy.getExpValue();
                m.sendMessage(enemy.name + " died. " + this.name + " gained " + enemy.getExpValue() + " experience.");
                if (this.exp >= 50 * playerLevel) {
                    this.levelUp();
                }
                OurPair tmp = enemy.getPosition();
                Tile e = new Empty(tmp);
                OurPair playerp = this.getPosition();
                gb.setTile(tmp, this);
                e.setPosition(playerp);
                this.setPosition(tmp);
                gb.setTile(playerp, e);
                gb.Myenemies.remove(enemy);


            }
        } else {
            m.sendMessage(this.name + " dealt 0 damage to " + enemy.name);
        }
    }

    @Override
    public void attack(Player player, GameBoard gb) {

    }

    @Override
    public String toString() {
        if (!isAlive())
            return "X";
        return "@";
    }

    public abstract String describe();


    //A method for tests
    public boolean attackTest(boolean enemyDied, int expGained, OurPair monsterP, boolean attacking) {
        Random random = new Random();
        System.out.println(this.name + " engaged in combat with The enemy");
        //player roll attack points
        int rollAttack = random.nextInt(this.attackPoints);
        System.out.println(this.name + " rolled " + rollAttack + " attack points");
        //enemy roll defense points
        int rollDefense = random.nextInt(15);
        System.out.println("The monster rolled " + rollDefense + " defense points");
        int diff = rollAttack - rollDefense;
        if (attacking) {
            System.out.println(this.name + " dealt " + diff + " damage to the enemy " );
            if (enemyDied) {
                this.exp += expGained;
                System.out.println("The enemy died. " + this.name + " gained " + expGained + " experience.");
                if (this.exp >= 50 * playerLevel) {
                    this.playerLevel++;
                    System.out.println(this.getName() + " Leveled up");
                }
                OurPair enemyP = monsterP;
                this.setPosition(enemyP);
            }
            return true;
        } else {
            System.out.println("Player cast 0 damage to the enemy");
            return false;
        }
    }

    public int getLevel()
    {
        return this.playerLevel;
    }
}