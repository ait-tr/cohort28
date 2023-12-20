package synhronizedExample;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDemo {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        BankAccount bankAccount = new BankAccount();

        for (int i = 0; i < 1000; i++) {

            bankAccount.setBalance(0);

            TestThread thread1 = new TestThread(bankAccount);
            TestThread thread2 = new TestThread(bankAccount);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            list.add(bankAccount.getBalance());

        }

        System.out.println(list);

    }
}
