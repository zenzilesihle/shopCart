package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Formatter {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static double formatTaxCalculationMoney(double amount) {
        decimalFormat.setRoundingMode(RoundingMode.UP);

        return Double.valueOf(decimalFormat.format(amount));
    }

    public static double formatTotalPriceMoney(double amount) {
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        return Double.valueOf(decimalFormat.format(amount));
    }
}
