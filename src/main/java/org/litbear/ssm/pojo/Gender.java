package org.litbear.ssm.pojo;

public enum Gender {
    MALE(1),
    FEMALE(0);

    private final int databaseValue;

    Gender(int databaseValue) {
        this.databaseValue = databaseValue;
    }


    public int getDatabaseValue() {
        return databaseValue;
    }
}
