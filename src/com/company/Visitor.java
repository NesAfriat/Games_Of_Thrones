package com.company;

public interface Visitor {

    public void visit (Unit unit,Empty empty);
    public void visit(Unit unit,Wall wall);
    public void visit (Enemy enemy , Player player);
    public void visit(Player player,Enemy enemy);
}
