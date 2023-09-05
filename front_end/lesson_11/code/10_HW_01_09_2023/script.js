/* 
    Необходимо создать объект bankAccount(дебет), представляющий банковский счёт со
    следующими свойствами:

    1. accountNumber: 123456789 (для номера счёта);
    2. accountHolderName для имени владельца счёта;
    3. balance для баланса;
    4. deposit() для описания действия по добавлению денег на счёт;
    5. withdraw() для описания действия по снятию денег со счёта;
    6. checkBalance() для проверки баланса.
*/ 


const bankAccount = {
    accountNumber: '123456789',
    accountHolderName: 'Alice',
    balance: 1000,
    deposit: function(amount) {
        amount > 60000
            ? console.log('Требуется подтверждение легальности доходов')
            : this.balance += amount;
    },
    withdraw(amount) {
        amount <= this.balance && amount > 0
            ? this.balance -= amount
            : console.log('Недостаточно средств на вашем балансе или вы ввели отрицательную сумму')
    },
    checkBalance() {
        console.log(`Баланс вашего счёта равен: ${this.balance}`)
    }
}

// console.log(bankAccount.checkBalance()); undefined
bankAccount.checkBalance();
bankAccount.deposit(500);
bankAccount.checkBalance();
bankAccount.withdraw(700);
bankAccount.checkBalance();
bankAccount.withdraw(1000);
bankAccount.checkBalance();