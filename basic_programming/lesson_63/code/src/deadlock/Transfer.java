package ait.bank.service;

import ait.bank.model.Account;

public class Transfer implements Runnable {
    Account accDonor;
    Account accRecipient;
    int sum;

    public Transfer(Account accDonor, Account accRecipient, int sum) {
        this.accDonor = accDonor;
        this.accRecipient = accRecipient;
        this.sum = sum;
    }

    @Override
    public void run() {
        transferMoney(accDonor, accRecipient, sum);
    }

    private void transferMoney(Account accFrom, Account accTo, int sum) {
        synchronized (accFrom) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (accTo) {
                if (accFrom.getBalance() >= sum) {
                    accFrom.debit(sum);
                    accTo.credit(sum);
                }
            }
        }
    }
}
