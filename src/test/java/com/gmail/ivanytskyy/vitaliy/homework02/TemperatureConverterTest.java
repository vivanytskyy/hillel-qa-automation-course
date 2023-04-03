package com.gmail.ivanytskyy.vitaliy.homework02;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 */
public class TemperatureConverterTest {
    TemperatureConverter temperatureConverter;

    @BeforeTest
    public void preCondition(){
        temperatureConverter = new TemperatureConverter();
    }

    @Test(description = "Convert 0 Celsius to Fahrenheit")
    public void testCelsiusToFahrenheitConversion(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToFahrenheit(0), 32);
    }

    @Test(description = "Convert positive Celsius value to Fahrenheit")
    public void testCelsiusToFahrenheitConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToFahrenheit(10), 50);
    }

    @Test(description = "Convert negative Celsius value to Fahrenheit")
    public void testCelsiusToFahrenheitConversionNegativeValue(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToFahrenheit(-10.5), 13.1);
    }

    @Test(description = "Convert min Celsius value to Fahrenheit")
    public void testCelsiusToFahrenheitConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                        .convertCelsiusToFahrenheit(TemperatureConverter.MIN_VALUE_OF_CELSIUS),
                TemperatureConverter.MIN_VALUE_OF_FAHRENHEIT);
    }

    @Test(description = "Try to convert wrong Celsius value to Fahrenheit",
            expectedExceptions = IllegalArgumentException.class)
    public void testCelsiusToFahrenheitConversionLessThanMinValue(){
        temperatureConverter.convertCelsiusToFahrenheit(-273.16);
    }

    @Test(description = "Convert 0 Celsius to Kelvin")
    public void testCelsiusToKelvinConversion(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToKelvin(0), 273.15);
    }

    @Test(description = "Convert positive Celsius value to Kelvin")
    public void testCelsiusToKelvinConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToKelvin(10), 283.15);
    }

    @Test(description = "Convert negative Celsius value to Kelvin")
    public void testCelsiusToKelvinConversionNegativeValue(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToKelvin(-10.5), 262.65);
    }

    @Test(description = "Convert min Celsius negative integer value to Kelvin")
    public void testCelsiusToKelvinConversionNegativeIntegerValue(){
        Assert.assertEquals(temperatureConverter.convertCelsiusToKelvin(-273), 0.15);
    }

    @Test(description = "Convert min Celsius value to Kelvin")
    public void testCelsiusToKelvinConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                .convertCelsiusToKelvin(TemperatureConverter.MIN_VALUE_OF_CELSIUS),
                TemperatureConverter.MIN_VALUE_OF_KELVIN);
    }

    @Test(description = "Try to convert wrong Celsius value to Kelvin",
            expectedExceptions = IllegalArgumentException.class)
    public void testCelsiusToKelvinConversionLessThanMinValue(){
        temperatureConverter.convertCelsiusToKelvin(-273.16);
    }

    @Test(description = "Convert 0 Fahrenheit to Celsius")
    public void testFahrenheitToCelsiusConversion(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToCelsius(0), -17.78);
    }

    @Test(description = "Convert positive Fahrenheit value to Celsius")
    public void testFahrenheitToCelsiusConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToCelsius(10), -12.22);
    }

    @Test(description = "Convert negative Fahrenheit value to Celsius")
    public void testFahrenheitToCelsiusConversionNegativeValue(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToCelsius(-10.5), -23.61);
    }

    @Test(description = "Convert min Fahrenheit value to Celsius")
    public void testFahrenheitToCelsiusConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                .convertFahrenheitToCelsius(TemperatureConverter.MIN_VALUE_OF_FAHRENHEIT),
                TemperatureConverter.MIN_VALUE_OF_CELSIUS);
    }

    @Test(description = "Try to convert wrong Fahrenheit value to Celsius",
            expectedExceptions = IllegalArgumentException.class)
    public void testFahrenheitToCelsiusConversionLessThanMinValue(){
        temperatureConverter.convertFahrenheitToCelsius(-459.68);
    }

    @Test(description = "Convert 0 Fahrenheit to Kelvin")
    public void testFahrenheitToKelvinConversion(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToKelvin(0), 255.37);
    }

    @Test(description = "Convert positive Fahrenheit value to Kelvin")
    public void testFahrenheitToKelvinConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToKelvin(10), 260.93);
    }

    @Test(description = "Convert negative Fahrenheit value to Kelvin")
    public void testFahrenheitToKelvinConversionNegativeValue(){
        Assert.assertEquals(temperatureConverter.convertFahrenheitToKelvin(-10.5), 249.54);
    }

    @Test(description = "Convert min Fahrenheit value to Kelvin")
    public void testFahrenheitToKelvinConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                .convertFahrenheitToKelvin(TemperatureConverter.MIN_VALUE_OF_FAHRENHEIT),
                TemperatureConverter.MIN_VALUE_OF_KELVIN);
    }

    @Test(description = "Try to convert wrong Fahrenheit value to Kelvin",
            expectedExceptions = IllegalArgumentException.class)
    public void testFahrenheitToKelvinConversionLessThanMinValue(){
        temperatureConverter.convertFahrenheitToKelvin(-469.58);
    }

    @Test(description = "Convert 273.15 Kelvin to Celsius")
    public void testKelvinToCelsiusConversion(){
        Assert.assertEquals(temperatureConverter.convertKelvinToCelsius(273.15), 0);
    }

    @Test(description = "Convert positive Kelvin value to Celsius")
    public void testKelvinToCelsiusConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertKelvinToCelsius(10), -263.15);
    }

    @Test(description = "Convert min Kelvin value to Celsius")
    public void testKelvinToCelsiusConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                .convertKelvinToCelsius(TemperatureConverter.MIN_VALUE_OF_KELVIN),
                TemperatureConverter.MIN_VALUE_OF_CELSIUS);
    }

    @Test(description = "Try to convert wrong Kelvin value to Celsius",
            expectedExceptions = IllegalArgumentException.class)
    public void testKelvinToCelsiusConversionLessThanMinValue(){
        temperatureConverter.convertKelvinToCelsius(-0.01);
    }

    @Test(description = "Convert Kelvin to 0 Fahrenheit")
    public void testKelvinToFahrenheitConversion(){
        Assert.assertEquals(temperatureConverter.convertKelvinToFahrenheit(255.3722), 0);
    }

    @Test(description = "Convert positive Kelvin value to Fahrenheit")
    public void testKelvinToFahrenheitConversionPositiveValue(){
        Assert.assertEquals(temperatureConverter.convertKelvinToFahrenheit(10), -441.67);
    }

    @Test(description = "Convert min Kelvin value to Fahrenheit")
    public void testKelvinToFahrenheitConversionMinCelsiusValue(){
        Assert.assertEquals(temperatureConverter
                .convertKelvinToFahrenheit(TemperatureConverter.MIN_VALUE_OF_KELVIN),
                TemperatureConverter.MIN_VALUE_OF_FAHRENHEIT);
    }

    @Test(description = "Try to convert wrong Kelvin value to Fahrenheit",
            expectedExceptions = IllegalArgumentException.class)
    public void testKelvinToFahrenheitConversionLessThanMinValue(){
        temperatureConverter.convertKelvinToFahrenheit(-0.01);
    }

    @AfterTest
    public void postCondition(){
        temperatureConverter = null;
    }
}
