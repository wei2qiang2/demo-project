package com;

import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String pattern = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";

        System.out.println(Pattern.matches(pattern, "15300000000"));
    }
}
