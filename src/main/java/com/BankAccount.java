package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankAccount {

    public static void main(String[] args) {
        /*
        bankAccounts = [(“a”, 80), (“b”, 180), ("c", 90)]
        transfers = makeTransfers(bankAccounts)
         # transfers = [(“b”, “a”, 20), ("b", "c", 10)]
        */

        ArrayList<BankAccounts> bankAccounts = new ArrayList();
//        bankAccounts.add(new BankAccounts("a", 80));
//        bankAccounts.add(new BankAccounts("b", 180));
//        bankAccounts.add(new BankAccounts("c", 90));

        bankAccounts.add(new BankAccounts("a", 90));
        bankAccounts.add(new BankAccounts("b", 140));
        bankAccounts.add(new BankAccounts("c", 80));
        bankAccounts.add(new BankAccounts("d", 65));
        bankAccounts.add(new BankAccounts("e", 130));
        System.out.println(makeTransfers(bankAccounts));
        System.out.println(bankAccounts);
    }

    public static class Tuple {
        public String from;
        public String to;
        public int amount;

        public Tuple(String from, String to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        public String toString() {
            return "(from :" + from
                    + ", to:" + to +
                    ", amount:" + amount + ")";
        }
    }

    public static class BankAccounts {
        public String account;
        public int amount;

        public BankAccounts(String account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        public String toString() {
            return "(" + account
                    + ":" + amount + ")";
        }
    }

    private static ArrayList<Tuple> makeTransfers(ArrayList<BankAccounts> bankAccounts) {
        if (null == bankAccounts || bankAccounts.isEmpty()) return null;

        //sort backaccounts;
        bankAccounts.sort(new Comparator<BankAccounts>() {
            @Override
            public int compare(BankAccounts o1, BankAccounts o2) {
                return o1.amount - o2.amount;
            }
        });

        if (bankAccounts.get(0).amount >= 100) return null;
        if (bankAccounts.get(bankAccounts.size() - 1).amount < 100) {
            throw new RuntimeException("all amount smaller than 100");
        }

        ArrayList<Tuple> res = new ArrayList<>();
        for (int i = 0; i < bankAccounts.size() && bankAccounts.get(i).amount < 100; i++) {
            transferFromRich(bankAccounts, i, res);
        }

        return res;
    }

    private static void transferFromRich(ArrayList<BankAccounts> bankAccounts, int to, List<Tuple> res) {
        BankAccounts toAccount = bankAccounts.get(to);
        int gap = 100 - toAccount.amount;
        for (int i = bankAccounts.size() - 1; i > to && gap > 0; i--) {
            if (bankAccounts.get(i).amount > 100) {
                int canTransfer = Math.min(bankAccounts.get(i).amount - 100, gap);
                res.add(new Tuple(bankAccounts.get(i).account, toAccount.account, canTransfer));
                bankAccounts.get(i).amount -= canTransfer;
                toAccount.amount += canTransfer;
                if (gap == canTransfer) {
                    return;
                } else {
                    gap -= canTransfer;
                }
            }
        }
        if (gap > 0) {
            throw new RuntimeException("can't fulfill transfer");
        }
    }
}
