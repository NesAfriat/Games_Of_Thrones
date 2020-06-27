package com.company;

public class Empty extends Tile {
    public Empty(OurPair position) {
        super('.', position);
    }
    @Override
    protected void accept(VisitorMovement vm, Player player) {
        vm.visit(player,this);
    }
    @Override
    protected void accept(VisitorMovement vm, Enemy enemy ) {
        vm.visit(enemy,this);
    }
    @Override
    public String toString() {
        return ".";
    }
}
