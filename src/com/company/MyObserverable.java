package com.company;
import java.util.List;

public interface MyObserverable {
    public void removeObserver(MyObserver o);
    public void PlayTheRest(List<MyObserver> enemies);
}
