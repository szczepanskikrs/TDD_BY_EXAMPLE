package org.tdd;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency);
    }

    public static Money dollar(int i, String currency) {
        return new Money(i, currency);
    }

    public static Money frank(int i, String currency) {
        return new Money(i, currency);
    }

    Money times(int times) {
        return new Money(amount * times, currency);
    }

    public String currency() {
        return currency;
    }

    Expression add(Money toAdd) {
        return new Money(amount+toAdd.amount,currency());
    }

    @Override
    public Money reduce(Bank bank, String reduceTo) {
        int rate = (currency.equals("CHF")&& reduceTo.equals("USD"))
                ?2:1;
        return new Money(amount /rate, reduceTo);
    }
}
