package util;

import java.text.DecimalFormat;

public class Formatter {
    public static double formatPrice(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        return Double.valueOf(decimalFormat.format(amount));
    }
}
