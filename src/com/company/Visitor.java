package com.company;

public interface Visitor {

    public void visit (Unit unit,Tile tile);
    public void visit (Enemy enemy , Player player);
    public void visit(Player player,Enemy enemy);
}
