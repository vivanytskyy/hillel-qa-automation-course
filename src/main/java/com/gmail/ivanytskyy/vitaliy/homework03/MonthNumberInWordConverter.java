package com.gmail.ivanytskyy.vitaliy.homework03;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/04/2023
 */
public class MonthNumberInWordConverter {
    public static final String DEFAULT_MESSAGE = "Not a valid month";
    private final TextStyle textStyle;
    private final Locale locale;

    public MonthNumberInWordConverter(TextStyle textStyle, Locale locale) {
        this.textStyle = textStyle;
        this.locale = locale;
    }

    public String convertToMonthInDefaultCase(int monthNumber, ImplVariant implVariant){
        return routeImpl(monthNumber, implVariant);
    }

    public String convertToMonthInUpperCase(int monthNumber, ImplVariant implVariant){
        return routeImpl(monthNumber, implVariant).toUpperCase();
    }

    public String convertToMonthInLowerCase(int monthNumber, ImplVariant implVariant){
        return routeImpl(monthNumber, implVariant).toLowerCase();
    }

    private String routeImpl(int monthNumber, ImplVariant implVariant){
        return switch (implVariant){
            case BY_IF_ELSE -> getMonthNameByIfElse(monthNumber);
            case BY_SWITCH -> getMonthNameBySwitch(monthNumber);
            case BY_JAVA_MONTH_ENUM_METHOD -> getMonthNameByMonthEnumMethod(monthNumber);
        };
    }

    private String getMonthNameByIfElse(int monthNumber){
        String result;
        if(monthNumber == 1){
            result = Month.JANUARY.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 2){
            result = Month.FEBRUARY.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 3){
            result = Month.MARCH.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 4){
            result = Month.APRIL.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 5){
            result = Month.MAY.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 6){
            result = Month.JUNE.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 7){
            result = Month.JULY.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 8){
            result = Month.AUGUST.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 9){
            result = Month.SEPTEMBER.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 10){
            result = Month.OCTOBER.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 11){
            result = Month.NOVEMBER.getDisplayName(this.textStyle, this.locale);
        }else if(monthNumber == 12){
            result = Month.DECEMBER.getDisplayName(this.textStyle, this.locale);
        }else{
            result = DEFAULT_MESSAGE;
        }
        return result;
    }

    private String getMonthNameBySwitch(int monthNumber){
        return switch (monthNumber) {
            case 1 -> Month.JANUARY.getDisplayName(this.textStyle, this.locale);
            case 2 -> Month.FEBRUARY.getDisplayName(this.textStyle, this.locale);
            case 3 -> Month.MARCH.getDisplayName(this.textStyle, this.locale);
            case 4 -> Month.APRIL.getDisplayName(this.textStyle, this.locale);
            case 5 -> Month.MAY.getDisplayName(this.textStyle, this.locale);
            case 6 -> Month.JUNE.getDisplayName(this.textStyle, this.locale);
            case 7 -> Month.JULY.getDisplayName(this.textStyle, this.locale);
            case 8 -> Month.AUGUST.getDisplayName(this.textStyle, this.locale);
            case 9 -> Month.SEPTEMBER.getDisplayName(this.textStyle, this.locale);
            case 10 -> Month.OCTOBER.getDisplayName(this.textStyle, this.locale);
            case 11 -> Month.NOVEMBER.getDisplayName(this.textStyle, this.locale);
            case 12 -> Month.DECEMBER.getDisplayName(this.textStyle, this.locale);
            default -> DEFAULT_MESSAGE;
        };
    }

    private String getMonthNameByMonthEnumMethod(int monthNumber){
        if(monthNumber < 1 || monthNumber > 12){
            return DEFAULT_MESSAGE;
        }
        return Month.of(monthNumber).getDisplayName(this.textStyle, this.locale);
    }

    enum ImplVariant{
        BY_SWITCH,
        BY_IF_ELSE,
        BY_JAVA_MONTH_ENUM_METHOD
    }
}
