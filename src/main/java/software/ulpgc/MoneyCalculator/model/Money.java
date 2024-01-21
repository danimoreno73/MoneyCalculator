package software.ulpgc.MoneyCalculator.model;

public record Money(Currency currency, double amount) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
