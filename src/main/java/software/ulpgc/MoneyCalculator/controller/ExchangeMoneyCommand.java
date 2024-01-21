package software.ulpgc.MoneyCalculator.controller;

import software.ulpgc.MoneyCalculator.view.CurrencyDialog;
import software.ulpgc.MoneyCalculator.Loader.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.view.MoneyDisplay;
import software.ulpgc.MoneyCalculator.model.*;

import java.text.DecimalFormat;

public class ExchangeMoneyCommand implements Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    private static final DecimalFormat format = new DecimalFormat("#.##");

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money( currency, twoDecimalDouble(exchangeRate, money));
        moneyDisplay.show(result);
    }

    private double twoDecimalDouble(ExchangeRate exchangeRate, Money money){

        String stringAmount = format.format(money.amount() * exchangeRate.rate());
        return Double.parseDouble(stringAmount.replace(',','.'));
    }
}
