package org.litbear.ssm.pojo;

public enum Gender {
    MALE("1"),
    FEMALE("0");

    private final String databaseValue;

    Gender(String databaseValue) {
        this.databaseValue = databaseValue;
    }


    public String getDatabaseValue() {
        return databaseValue;
    }
}
