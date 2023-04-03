package com.gmail.ivanytskyy.vitaliy.homework02;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * @author Vitaliy Ivanytskyy
 */
public class TemperatureConverter {
    public static final double MIN_VALUE_OF_CELSIUS = -273.15;
    public static final double MIN_VALUE_OF_FAHRENHEIT = -459.67;
    public static final double MIN_VALUE_OF_KELVIN = 0;
    public static final String EXCEPTION_MESSAGE = "Incorrect input value: ";

    public double convertCelsiusToFahrenheit(double celsiusValue){
        if (celsiusValue < MIN_VALUE_OF_CELSIUS || Double.isNaN(celsiusValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + celsiusValue);
        double resultAsDouble = celsiusValue * 9 / 5 + 32;
        return roundDoubleValue(resultAsDouble);
    }

    public double convertCelsiusToKelvin(double celsiusValue){
        if (celsiusValue < MIN_VALUE_OF_CELSIUS || Double.isNaN(celsiusValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + celsiusValue);
        double resultAsDouble = celsiusValue + Math.abs(MIN_VALUE_OF_CELSIUS);
        return roundDoubleValue(resultAsDouble);
    }

    public double convertFahrenheitToCelsius(double fahrenheitValue){
        if (fahrenheitValue < MIN_VALUE_OF_FAHRENHEIT || Double.isNaN(fahrenheitValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + fahrenheitValue);
        double resultAsDouble = (fahrenheitValue - 32) * 5 / 9;
        return roundDoubleValue(resultAsDouble);
    }

    public double convertFahrenheitToKelvin(double fahrenheitValue){
        if (fahrenheitValue < MIN_VALUE_OF_FAHRENHEIT || Double.isNaN(fahrenheitValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + fahrenheitValue);
        double resultAsDouble = (fahrenheitValue - 32) * 5 / 9 + Math.abs(MIN_VALUE_OF_CELSIUS);
        return roundDoubleValue(resultAsDouble);
    }

    public double convertKelvinToCelsius(double kelvinValue){
        if (kelvinValue < MIN_VALUE_OF_KELVIN || Double.isNaN(kelvinValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + kelvinValue);
        double resultAsDouble = kelvinValue - Math.abs(MIN_VALUE_OF_CELSIUS);
        return roundDoubleValue(resultAsDouble);
    }

    public double convertKelvinToFahrenheit(double kelvinValue){
        if (kelvinValue < MIN_VALUE_OF_KELVIN || Double.isNaN(kelvinValue))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE + kelvinValue);
        double resultAsDouble = (kelvinValue - Math.abs(MIN_VALUE_OF_CELSIUS)) * 9 / 5 + 32;
        return roundDoubleValue(resultAsDouble);
    }

    private double roundDoubleValue(double valueForRounding){
        BigDecimal result = BigDecimal.valueOf(valueForRounding).setScale(2, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}