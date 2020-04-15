package com.chang.enumtest;

public enum DayEnum {

    SUNDAY("sunday", 7),
    MONDAY("monday", 7),
    TUESDAY("Tuesday", 7);

    private String name;
    private int number;

    private DayEnum(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
