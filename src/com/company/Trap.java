

package com.company;

import java.util.List;
import java.util.Observer;

public class Trap extends Enemy  {
    private int visibilityTime;
    private int inVisibilityTime;
    private int tickCount=0;
    private boolean visible=true;
 //   private final int ABILITYRANGE=
    public Trap(char type, OurPair position,String name,int exp, int visibilityTime, int inVisibilityTime,int health, int attackPoints, int defensePoints) {
        super(type, position,exp, name,health , attackPoints,defensePoints);
        this.inVisibilityTime= inVisibilityTime;
        this.visibilityTime=visibilityTime;
        }
   @Override
    public void Action(GameBoard gb,Player player) {
        VisitorMovement vm= new VisitorMovement(gb);
        OurPair playerP= player.getPosition();
        OurPair trapP= this.getPosition();
        double range= Range(trapP,playerP);
        visible = tickCount< visibilityTime;
        if (tickCount == (visibilityTime+inVisibilityTime))
            tickCount=0;
        else
            tickCount=tickCount+1;
        if(range<2) //attack player
            vm.visit(player,this);
    }

    private double Range(OurPair position, OurPair playerLocation) {
        return Math.sqrt(Math.pow(position.getFirst()-playerLocation.getFirst(),2)+Math.pow(position.getSecond()-playerLocation.getSecond(),2));
    }


    @Override
    public String describe ()
    {
        return (this.name+"    health: "+health.getFirst()+"/"+health.getSecond()+"    attack: "+attackPoints+" defense: "+defensePoints+"  Experience Value"+getExpValue());
    }
    @Override
    public String toString() {
        if (!visible)
        return ".";
        return String.valueOf(getTile());
    }


}



