package com.isa.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PriceSummary {

    /**
     * /*
     *      * Complete the 'printPriceSummary' function below.
     *      *
     *      * The function is expected to return a STRING.
     *      * The function accepts following parameters:
     *      *  1. 2D_STRING_ARRAY lineItems
     *      *  2. 2D_STRING_ARRAY exchangeRates
     *      *  3. 2D_STRING_ARRAY currencySymbols
     */

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("Rental");
        item1.add("190.00");
        item1.add("EUR");

        List<String> item2 = new ArrayList<>();
        item2.add("GPS");
        item2.add("15.00");
        item2.add("GBP");

        List<String> item3 = new ArrayList<>();
        item3.add("Insurance");
        item3.add("30.00");
        item3.add("USD");

        items.add(item1);
        items.add(item2);
        items.add(item3);

        List<List<String>> exchangeRates = new ArrayList<>();
        List<String> rate1 = new ArrayList<>();
        rate1.add("GBP");
        rate1.add("0.70");

        List<String> rate2 = new ArrayList<>();
        rate2.add("USD");
        rate2.add("1.20");

        exchangeRates.add(rate1);
        exchangeRates.add(rate2);

        List<List<String>> currencys = new ArrayList<>();
        List<String> currency1 = new ArrayList<>();
        currency1.add("GBP");
        currency1.add("£");

        List<String> currency2 = new ArrayList<>();
        currency2.add("EUR");
        currency2.add("€");

        List<String> currency3 = new ArrayList<>();
        currency3.add("USD");
        currency3.add("$");

        currencys.add(currency1);
        currencys.add(currency2);
        currencys.add(currency3);

        String res = printPriceSummary(items, exchangeRates, currencys);
        System.out.println(res);
    }

    private final static String APPROX = " approx.";
    private final static String SYMBOL_EURO = "€";

    private static List<BigDecimal> priceList;

    public static String printPriceSummary(List<List<String>> lineItems,
                                           List<List<String>> exchangeRates,
                                           List<List<String>> currencySymbols) {

        // lineItems： name，price，currency
        // exchangeRates (non-euro currencies): currencyCode, rate
        // currencySymbols: currencyCode, currencySymbol

        StringBuilder result = new StringBuilder();
        priceList = new ArrayList<>();

        for (int i = 0; i < lineItems.size(); i++) {
            List<String> items = lineItems.get(i);
            String name = items.get(0);
            String price = items.get(1);
            String currency = items.get(2);
            result.append(name).append(": ");

            displayPrice(result, currencySymbols, exchangeRates, price, currency);
            result.append("\n");
        }

        // \n total \n
        result.append("\nTOTAL: ");
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal bigDecimal : priceList) {
            total = total.add(bigDecimal);
        }
        result.append(SYMBOL_EURO).append(total.doubleValue()).append(APPROX).append("\n");
        return result.toString();
    }

    private static void displayPrice(StringBuilder result,
                                     List<List<String>> currencySymbols,
                                     List<List<String>> exchangeRates, String price, String currency) {
        for (List<String> list : currencySymbols) {
            String symbolKey = list.get(0);
            String symbol = list.get(1);

            if (currency.equals(symbolKey)) {
                BigDecimal rateValue = new BigDecimal(0);
                if (!symbolKey.equals("EUR")) {
                    // format (non-euro symbol price) euro price approx.
                    result.append("(").append(symbol).append(price).append(") ");

                    // rate
                    String rate = getRate(exchangeRates, currency);
                    BigDecimal decimalPrice = new BigDecimal(price);
                    BigDecimal decimalRate = new BigDecimal(rate);
                    if (!decimalRate.equals(BigDecimal.ZERO)) {
                        rateValue = decimalPrice.divide(decimalRate, 2, RoundingMode.HALF_UP);
                        result.append(SYMBOL_EURO).append(rateValue).append(APPROX);
                    }
                } else {
                    rateValue = new BigDecimal(price);
                    result.append(symbol).append(price);
                }
                priceList.add(rateValue);
            }
        }
    }

    private static String getRate(List<List<String>> exchangeRates, String currency) {
        for (int i = 0; i < exchangeRates.size(); i++) {
            List<String> list = exchangeRates.get(i);
            String key = list.get(0);
            if (currency.equals(key)) {
                return list.get(1);
            }
        }
        return "";
    }
}
