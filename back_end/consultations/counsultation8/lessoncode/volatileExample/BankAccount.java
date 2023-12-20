package volatileExample;

class BankAccount {
    private volatile int balance = 0;

    public void deposit(int amount) {
        // Сложная операция: чтение, изменение и запись нового значения баланса
        balance += amount;
    }

    public void withdraw(int amount) {
        // Сложная операция: чтение, изменение и запись нового значения баланса
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

