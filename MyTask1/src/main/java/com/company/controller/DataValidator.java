package com.company.controller;

public class DataValidator {
    public static final String NUMBER_REGEX = "\\d+";

    private DataValidator() {}

    public static boolean isValid(String data, String regex) {
        return data.matches(regex);
    }

    public static boolean isNotValid(String data, String regex) {
        return !isValid(data, regex);
    }
}
