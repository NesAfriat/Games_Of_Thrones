package com.company;

public class OurPair {
    private int first;
    public int getFirst() {
        return first;
    }
    public void setFirst(int first) {
        this.first = first;
    }


    private int second;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }


    public OurPair(int i, int i1) {
    first=i;
    second=i1;
    }
    public double Range (OurPair other){
        double disx=Math.pow(this.getFirst()-other.getFirst(),2);
        double disy=Math.pow(this.getSecond()-other.getSecond(),2);
        return Math.sqrt(disx+disy);
    }
}
