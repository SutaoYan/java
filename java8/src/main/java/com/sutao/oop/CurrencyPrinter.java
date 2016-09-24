package com.sutao.oop;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyPrinter {
    public static void main(String[] args) {
        double amount = 1234567.8901234;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(amount));

        nf = NumberFormat.getNumberInstance(Locale.FRANCE);
        System.out.println(nf.format(amount));

        System.out.print(nf.getClass().getName());
    }
}
