package com.company;

import java.util.List;

public interface MyObserver {
    public void Action(GameBoard gb,Player player);
    public boolean IsAlive();
}
