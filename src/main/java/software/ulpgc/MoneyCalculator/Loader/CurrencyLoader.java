package software.ulpgc.MoneyCalculator.Loader;

import software.ulpgc.MoneyCalculator.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
