package com.gmail.ivanytskyy.vitaliy.homework02;
import java.util.Locale;
/**
 * @author Vitaliy Ivanytskyy
 */
/*
 * Task 1
 * 1. Написати програму, яка конвертує градуси Цельсія у Фаренгейти и Кельвіни
 * Формули
 * Celsius = 5/9 (F - 32)
 * Kelvin = C + 273.16
 * Вивід має бути приблизно таким: X C: Y F; Z K,
 * де X - початкове значення в градусах Цельсія,
 * Y и Z - обчислені значення в Фаренгейтах и Кельвінах відповідно.
 *
 * Task 2
 * Написати програму, яка обчислює площу прямокутного трикутника,
 * початкові значення сторін можна задати довільно.
 *
 * Task 3
 * Написати програму, яка обчислює площу кола.
 * Для обчислень можна використовівати библіотеку Math (Math.pow() для зведення у ступінь 2)
 */
public class Main {
    public static void main(String[] args) {
        // Celsius to Fahrenheit/Kelvin conversion (Task 1).
        TemperatureConverter converter = new TemperatureConverter();
        double celsiusValue = -273.15;
        System.out.printf(Locale.ROOT, "%.2f℃: %.2f℉; %.2fK\n",
                celsiusValue,
                converter.convertCelsiusToFahrenheit(celsiusValue),
                converter.convertCelsiusToKelvin(celsiusValue));

        // Area of the right triangle (Task 2).
        AreaCalculator areaCalculator = new AreaCalculator();
        double leg1 = 0.05;
        double leg2 = 0.078;
        double rightTriangleArea = areaCalculator.calculateRightTriangleArea(leg1, leg2);
        //System.out.printf("Area of a right triangle: %.3f ㎡\n", rightTriangleArea);
        System.out.println("Area of a right triangle: " + rightTriangleArea + " ㎡");

        // Area of the circle (Task 3).
        double circleRadius = 0.55;
        double circleArea = areaCalculator.calculateCircleArea(circleRadius);
        System.out.printf(Locale.ROOT, "Area of a circle: %.4f ㎡\n", circleArea);
    }
}
