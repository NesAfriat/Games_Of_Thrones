package com.company.Tests;

import com.company.Objects.GameBoard;
import com.company.Objects.Player;
import com.company.Objects.Warrior;
import com.company.OurPair;
import org.junit.After;
import org.junit.Before;
import org.junit.*;


import static org.junit.Assert.*;
public class Tests {
    Player player= new Warrior('@', new OurPair(-1, -1), "Jon Snow", 300, 30, 4, 3);
    OurPair monsterPos;
    boolean attack;
    boolean enemyDied;
    int expGained;
    @Before
    public void setUp() throws Exception {
        player.setPosition(new OurPair(1,1));
    }

    //Players' attack combat system Test
    @Test
    public void attackNotLeveling()
    {
        System.out.println("Attacking without Leveling Test - ");
        monsterPos= new OurPair(0,0);
        attack= true;
        Assert.assertTrue(player.attackTest(false,0,monsterPos, attack));
        Assert.assertEquals(1,player.getLevel());
    }
    @Test
    public void attackLevelUp()
    {
        System.out.println("Attacking with Leveling Test - ");
        monsterPos= new OurPair(0,0);
        attack= true;
        enemyDied=true;
        Assert.assertTrue(player.attackTest(enemyDied,50,monsterPos, attack));
        Assert.assertEquals(2,player.getLevel());
    }
    @Test
    public void NotAttackingTest()
    {
        System.out.println("Not Attacking with The enemy- negative diff of rolls - ");
        player= new Warrior('@', new OurPair(-1, -1), "Jon Snow", 300, 1, 4, 3);
        monsterPos= new OurPair(0,0);
        attack= false;
        enemyDied= false;
        Assert.assertFalse(player.attackTest(enemyDied,0,monsterPos, attack));
    }
    @Test
    public void DefeatedEnemySwap()
    {
        System.out.println("Defeating Monster - swap places - ");
        monsterPos= new OurPair(2,1);
        attack= true;
        enemyDied=true;
        Assert.assertTrue(player.attackTest(enemyDied,30,monsterPos, attack));
        Assert.assertEquals(monsterPos,player.getPosition());
    }
    @Test
    public void GainedExpTest()
    {
        System.out.println("Defeating Monster - gain 30 exp - ");
        monsterPos= new OurPair(2,1);
        attack= true;
        enemyDied=true;
        Assert.assertTrue(player.attackTest(enemyDied,30,monsterPos, attack));
        Assert.assertEquals(30,player.getExp());
    }






}