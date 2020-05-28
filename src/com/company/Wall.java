package com.company;

import javafx.util.Pair;

public class Wall extends Tile {
    public Wall(Pair<int, int> position) {
        super('#', position);
    }
}
