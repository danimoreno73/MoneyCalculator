package software.ulpgc.MoneyCalculator.Mock;

import software.ulpgc.MoneyCalculator.Loader.FixerExchangeRateLoader;

public class MockFixerExchangeRateLoader {

    public static void main(String[] args) {

        FixerExchangeRateLoader example = new FixerExchangeRateLoader();
        System.out.println(example.load());

    }


}
