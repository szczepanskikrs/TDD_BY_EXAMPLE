package org.tdd.FinancialCalculations;

public class Money implements Expression {
    protected int amount;
    public String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount && currency().equals(money.currency);
    }

    public static Money dollar(int i) {
        return new Money(i, "USD");
    }

    public static Money frank(int i) {
        return new Money(i, "CHF");
    }

    public Expression times(int times) {
        return new Money(amount * times, currency);
    }

    public String currency() {
        return currency;
    }

    public Expression add(Money toAdd) {
        return new Sum(this, toAdd);
    }

    @Override
    public Money reduce(Bank bank, String reduceTo) {
        int rate = (currency.equals("CHF") && reduceTo.equals("USD"))
                ? 2 : 1;
        return new Money(amount / rate, reduceTo);
    }

    @Override
    public Expression plus(Expression tenFrancs) {
        return new Sum(this, tenFrancs);
    }


}
