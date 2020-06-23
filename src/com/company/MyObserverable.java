package com.company;

public interface MyObserverable {
    public void addObserver(MyObserver o);
    public void removeObserver(MyObserver o);
    public void NotifyObservers();
}
