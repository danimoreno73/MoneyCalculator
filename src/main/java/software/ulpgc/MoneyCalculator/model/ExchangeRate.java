package software.ulpgc.MoneyCalculator.model;

import java.time.LocalDate;

public record ExchangeRate(LocalDate localDate, Currency from, Currency to, double rate) {
}
