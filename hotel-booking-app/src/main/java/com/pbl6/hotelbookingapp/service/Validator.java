package com.pbl6.hotelbookingapp.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validatePhoneNumber(String phoneNumber) {

        String phonePattern = "\\d{10}";

        return phoneNumber.matches(phonePattern);
    }
}
