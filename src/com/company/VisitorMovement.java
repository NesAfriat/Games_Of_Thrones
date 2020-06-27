package com.company;

public class VisitorMovement implements Visitor{

    GameBoard gb;
    public VisitorMovement(GameBoard gb)
    {
        this.gb=gb;
    }

    public void visit (Unit unit,Empty empty)
    {

            OurPair temp=empty.getPosition();
            gb.setTile(unit.getPosition(),empty);
            gb.setTile(temp,unit);
            empty.setPosition(unit.getPosition());
            unit.setPosition(temp);


    }
    public void visit(Unit unit,Wall wall){}
    public void visit (Enemy enemy, Player player)
    {
        player.attack(enemy,gb);
    }
    public void visit(Player player,Enemy enemy)
    {
        enemy.attack(player,gb);
    }
}
