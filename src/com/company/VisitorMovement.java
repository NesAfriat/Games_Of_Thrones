package com.company;

public class VisitorMovement implements Visitor{

    GameBoard gb;
    public VisitorMovement(GameBoard gb)
    {
        this.gb=gb;
    }

    public void visit (Unit unit,Tile tile)
    {
        if (tile.getTile()=='.')//player/enemy meets empty
        {
            OurPair temp=tile.getPosition();
            gb.setTile(unit.getPosition(),tile);
            gb.setTile(temp,unit);
            tile.setPosition(unit.getPosition());
            unit.setPosition(temp);
        }
        //else (enemy on enemy,player/enemy on wall) nothing happens

    }
    public void visit (Enemy enemy, Player player)
    {
        enemy.attack(player);
    }
    public void visit(Player player,Enemy enemy)
    {
        player.attack(enemy);
    }
}
