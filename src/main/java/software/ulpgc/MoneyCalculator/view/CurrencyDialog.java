package software.ulpgc.MoneyCalculator.view;


import software.ulpgc.MoneyCalculator.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
