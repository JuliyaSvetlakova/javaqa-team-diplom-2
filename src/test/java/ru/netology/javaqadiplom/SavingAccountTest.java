package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getMaxBalance());
    }

    //CreditAccount
    //Rate
    @Test
    public void IllegalArgumentExceptionWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5
        });
    }

    @Test
    public void atZeroRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0

        );
        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void withPositiveRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5

        );
        Assertions.assertEquals(5, account.getRate());
    }

    //InitialBalance
    @Test
    public void IllegalArgumentExceptionWithMinInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -1,
                    1_000,
                    10_000,
                    5;
        });
    }

    @Test
    public void withPositiveInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(2_000, account.getBalance());
    }

    //minBalance
    @Test
    public void withPositiveMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(1_000, account.getMinBalance();
    }

    @Test
    public void IllegalArgumentExceptionWithMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -500,
                    10_00,
                    5;

        });
    }

    @Test
    public void IllegalArgumentExceptionMaxBalanceLowMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    500,
                    250,
                    5;

        });
    }

    @Test
    public void IllegalArgumentExceptionInitialBalanceLowMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    500,
                    1_000,
                    10_000,
                    5;

        });
    }

    @Test
    public void IllegalArgumentExceptionInitialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    11_000,
                    1_000,
                    10_000,
                    5;

        });
    }

    //maxBalance
    @Test
    public void withPositiveMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5,
                );
        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void IllegalArgumentExceptionWithMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -1_000,
                    5;

        });
    }

    //Метод pay
    @Test
    public void purchaseAmountIsLessThanTheBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(500);
        Assertions.assertEquals(1_500, account.getBalance());

    }

    @Test
    public void purchaseAmountIsMoreThanTheBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(3_500);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void purchaseAmountIsEqualToTheMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(1_000);
        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void purchaseAmountIsLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(-5);
        Assertions.assertEquals(2_000, account.getMinBalance());
    }

    @Test
    public void purchaseAmountIsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);
        Assertions.assertEquals(2_000, account.getMinBalance());
    }

    //Метод Add
    @Test
    public void addToEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getMaxBalance());
    }
    @Test
    public void addMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(15_000);

        Assertions.assertEquals(2_000, account.getMaxBalance());
    }

    @Test
    public void addLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-5);

        Assertions.assertEquals(2_000, account.getMaxBalance());
    }

    @Test
    public void addZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getMaxBalance());
    }

    // Метод yearChange
    @Test
    public void calculationYearPercentWithPositiveBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(300, account.yearChange());
    }

    @Test
    public void calculationYearPercentWithMinBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(150, account.yearChange());
    }

    @Test
    public void calculationYearPercentWithMaxBalance() {
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(1_500, account.yearChange());
    }
}