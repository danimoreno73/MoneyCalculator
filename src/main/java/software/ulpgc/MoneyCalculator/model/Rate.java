package software.ulpgc.MoneyCalculator.model;

import software.ulpgc.MoneyCalculator.Loader.ExchangeRateLoader;

import java.time.LocalDate;
import java.util.Map;

public class Rate implements ExchangeRateLoader {

    Map<String, Double> rates;



    public Rate(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        if (from.code().equals(to.code())) return new ExchangeRate(LocalDate.now(),from,to,1);
        double rate = (1 / rates.get(from.code())) / (1 / rates.get(to.code()));
        return new ExchangeRate(LocalDate.now(), from, to, rate);
    }
}
