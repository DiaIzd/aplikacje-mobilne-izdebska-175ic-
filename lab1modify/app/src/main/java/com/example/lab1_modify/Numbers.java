package com.example.lab1_modify;

public class Numbers extends Number {
private int id;
    private int value;

    public Numbers(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public Numbers(){}

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+this.value;
    }
}

