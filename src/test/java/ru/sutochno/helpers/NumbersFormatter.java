package ru.sutochno.helpers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class NumbersFormatter {
    public String addDigitSpace(Integer number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' '); //разделитель тысяч '
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

}
