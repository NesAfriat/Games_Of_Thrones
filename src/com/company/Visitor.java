package com.company;

import com.company.Objects.Enemy;
import com.company.Objects.Empty;
import com.company.Objects.Unit;
import com.company.Objects.Wall;
import com.company.Objects.Player;

public interface Visitor {

    public void visit (Unit unit, Empty empty);
    public void visit(Unit unit, Wall wall);
    public void visit (Enemy enemy , Player player);
    public void visit(Player player,Enemy enemy);
}
