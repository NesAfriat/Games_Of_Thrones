package com.company;

public interface Interactions {

    public void encounter (Unit unit,Empty empty);
    public void encounter (Unit unit,Wall wall);
    public void encounter (Unit unit,Player player);
    public void encounter (Unit unit,Enemy enemy);



}
