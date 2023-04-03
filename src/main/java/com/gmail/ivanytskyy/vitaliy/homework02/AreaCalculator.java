package com.gmail.ivanytskyy.vitaliy.homework02;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Vitaliy Ivanytskyy
 */

public class AreaCalculator {
    private final String exceptionMessage = "Value less than 0";

    public double calculateRightTriangleArea(double leg1, double leg2){
        if(leg1 <= 0 || leg2 <= 0) throw new IllegalArgumentException(exceptionMessage);
        BigDecimal leg1BD = BigDecimal.valueOf(leg1);
        BigDecimal leg2BD = BigDecimal.valueOf(leg2);
        BigDecimal result = leg1BD.multiply(leg2BD).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    public double calculateCircleArea(double radius){
        if(radius <= 0) throw new IllegalArgumentException(exceptionMessage);
        return Math.PI * radius * radius;
    }
}
