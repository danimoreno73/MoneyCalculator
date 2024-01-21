package software.ulpgc.MoneyCalculator.view;

import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.Money;

import java.util.List;

public interface MoneyDialog {
    Money get();
    MoneyDialog define(List<Currency> currencyList);
}
