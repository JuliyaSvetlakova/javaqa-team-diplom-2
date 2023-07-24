package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    //CreditAccount
    //Rate
    @Test
    public void IllegalArgumentExceptionWithNegativeRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                -1
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
        });
    }
    @Test
    public void atZeroRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );
        Assertions.assertEquals(0,account.getRate());
    }
    @Test
    public void withPositiveRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                1
        );
        Assertions.assertEquals(1,account.getRate());
    }

    //InitialBalance
    @Test
    public void IllegalArgumentExceptionWithNegativeInitialBalance() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getBalance();
        });
    }
    @Test
    public void atZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0,account.getBalance());
    }
    @Test
    public void withPositiveInitialBalance() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );
        Assertions.assertEquals(1,account.getBalance());
    }

    //CreditLimit
    @Test
    public void IllegalArgumentExceptionWithNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                -1,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getCreditLimit();
        });
    }
    @Test
    public void atZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                15
        );
        Assertions.assertEquals(0,account.getCreditLimit());
    }
    @Test
    public void withPositiveCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                1,
                15
        );
        Assertions.assertEquals(1,account.getCreditLimit());
    }

    //Метод pay
    @Test
    public void purchaseAmountIsLessThanTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account. pay(7_999);
        Assertions.assertEquals(-4_999,account. getBalance());
    }
    @Test
    public void purchaseAmountIsMoreThanTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account. pay(8_001);
        Assertions.assertEquals(3_000,account. getBalance());
    }
    @Test
    public void purchaseAmountIsEqualToTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account. pay(8_000);
        Assertions.assertEquals(-5_000,account. getBalance());
    }
    @Test
    public void purchaseAmountIsZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account. pay(0);
        Assertions.assertEquals(2_000,account. getBalance());
    }
    @Test
    public void purchaseAmountIsLessThanZero() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.pay(-1);
        Assertions.assertEquals(3_000, account.getBalance());
    }

    //Метод Add
    @Test
    public void addToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void addToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_001, account.getBalance());
    }
    @Test
    public void addToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(2_999, account.getBalance());
    }
    @Test
    public void zeroReplenishment() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(-1, account.getBalance());
    }
    @Test
    public void negativeReplenishment() {
        CreditAccount account = new CreditAccount(
                -1,
                5_000,
                15
        );

        account.add(-1);

        Assertions.assertEquals(-1, account.getBalance());
    }

    // Метод yearChange
    @Test
    public void calculationOfInterestOnNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }
    @Test
    public void calculationOfInterestOnZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void calculationOfInterestOnPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
