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

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    //CreditAccount
    //Rate
    @Test
    public void IllegalArgumentExceptionWithNegativeRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                -5

        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getRate();
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
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getBalance();
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
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void IllegalArgumentExceptionWithMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                10_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getMinBalance();
        });
    }

    //maxBalance
    @Test
    public void withPositiveMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void IllegalArgumentExceptionWithMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                1_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.getMaxBalance();
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
    public void purchaseAmountIsLessThanTheMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(500);
        Assertions.assertEquals(1_000, account.getBalance());

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
    public void purchaseAmountIsEqualToTheBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(2_000);
        Assertions.assertEquals(0, account.getBalance());
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
        Assertions.assertEquals(1_000, account.getBalance());
    }

    //Метод Add
    @Test
    public void addToMinBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
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

        Assertions.assertEquals(2_000, account.getBalance());
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