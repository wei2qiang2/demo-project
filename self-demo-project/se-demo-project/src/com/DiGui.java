package com;

public class DiGui {

    public static void main(String[] args) {
        s(12);
    }

    private static int s(int i) {
        if (i > 1) {
            if (i % 2 != 0)
                System.out.println(s((i + 1) / 2));
            System.out.println(s(i / 2));
        }
        return i;
    }
}
