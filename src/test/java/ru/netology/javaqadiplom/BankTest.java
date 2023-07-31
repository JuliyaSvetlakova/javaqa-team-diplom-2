package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void successfulTransferOfTheAmountFromTheAccount1ToAccount2() {
        SavingAccount account1 = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        SavingAccount account2 = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Bank account = new Bank();
        account.transfer(account1, account2, 500);

        Assertions.assertEquals(2_000 - 500, account1.getBalance());
        Assertions.assertEquals(2_000 + 500, account2.getBalance());
    }

    @Test
    public void transferOfTheAmountGreaterThanTheMinBalanceINAccount1() {
        SavingAccount account1 = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        SavingAccount account2 = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Bank account = new Bank();
        account.transfer(account1, account2, 1_500);

        Assertions.assertEquals(2_000, account1.getBalance());
        Assertions.assertEquals(2_000, account2.getBalance());
    }

    @Test
    public void transferOfTheAmountGreaterThanTheMaxBalanceINAccount2() {
        SavingAccount account1 = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );
        SavingAccount account2 = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5
        );

        Bank account = new Bank();
        account.transfer(account1, account2, 2_000);

        Assertions.assertEquals(3_000, account1.getBalance());
        Assertions.assertEquals(2_000, account2.getBalance());

    }
    @Test
    public void zeroTransfer() {
        SavingAccount account1 = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );
        SavingAccount account2 = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5
        );

        Bank account = new Bank();
        account.transfer(account1, account2, 0);

        Assertions.assertEquals(3_000, account1.getBalance());
        Assertions.assertEquals(2_000, account2.getBalance());

    }
    @Test
    public void negativeTransfer() {
        SavingAccount account1 = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );
        SavingAccount account2 = new SavingAccount(
                2_000,
                1_000,
                3_000,
                5
        );

        Bank account = new Bank();
        account.transfer(account1, account2, -1);

        Assertions.assertEquals(3_000, account1.getBalance());
        Assertions.assertEquals(2_000, account2.getBalance());

    }
}