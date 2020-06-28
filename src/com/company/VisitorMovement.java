package com.company;

import com.company.Objects.Empty;
import com.company.Objects.GameBoard;
import com.company.Objects.Enemy;
import com.company.Objects.Unit;
import com.company.Objects.Wall;
import com.company.Objects.Player;

public class VisitorMovement implements Visitor{

    GameBoard gb;
    public VisitorMovement(GameBoard gb)
    {
        this.gb=gb;
    }

    public void visit (Unit unit, Empty empty)
    {

            OurPair temp=empty.getPosition();
            gb.setTile(unit.getPosition(),empty);
            gb.setTile(temp,unit);
            empty.setPosition(unit.getPosition());
            unit.setPosition(temp);


    }
    public void visit(Unit unit, Wall wall){}
    public void visit (Enemy enemy, Player player)
    {
        player.attack(enemy,gb);
    }
    public void visit(Player player,Enemy enemy)
    {
        enemy.attack(player,gb);
    }
}
