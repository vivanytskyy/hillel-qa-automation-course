package com.gmail.ivanytskyy.vitaliy.homework02;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 */
public class AreaCalculatorTest {
    AreaCalculator areaCalculator;

    @BeforeTest
    public void preCondition(){
        areaCalculator = new AreaCalculator();
    }

    @Test(description = "Calculate area of the right triangle with legs = 1m")
    public void testRightTriangleAreaCalculation(){
        Assert.assertEquals(areaCalculator.calculateRightTriangleArea(1, 1), 0.5);
    }

    @Test(description = "Calculate area of the right triangle with legs = 25m and 1m")
    public void testRightTriangleAreaCalculationPositiveValue(){
        Assert.assertEquals(areaCalculator.calculateRightTriangleArea(25, 1), 12.5);
    }

    @Test(description = "Calculate area of the right triangle with legs = Integer.MAX_VALUE")
    public void testRightTriangleAreaCalculationBigValue(){
        Assert.assertEquals(areaCalculator
                .calculateRightTriangleArea(Integer.MAX_VALUE, Integer.MAX_VALUE), 2305843007066210304.5);
    }

    @Test(description = "Calculate area of the right triangle with fraction length values of legs")
    public void testRightTriangleAreaCalculationFractionValues(){
        Assert.assertEquals(areaCalculator.calculateRightTriangleArea(0.05, 0.078), 0.00195);
    }

    @Test(description = "Calculate area of the right triangle with legs = value * 10-6")
    public void testRightTriangleAreaCalculationSmallValue(){
        Assert.assertEquals(areaCalculator
                .calculateRightTriangleArea(0.000001, 0.000003), 0.0000000000015);
    }

    @Test(description = "Try to calculate area of the right triangle with 0 length of legs",
            expectedExceptions = IllegalArgumentException.class)
    public void testRightTriangleAreaCalculationZeroLengthValue(){
        areaCalculator.calculateRightTriangleArea(0, 0);
    }

    @Test(description = "Try to calculate area of the right triangle with negative length of legs",
            expectedExceptions = IllegalArgumentException.class)
    public void testRightTriangleAreaCalculationNegativeLengthValue(){
        areaCalculator.calculateRightTriangleArea(-1, 1);
    }

    @Test(description = "Calculate area of the circle with radius = 1m")
    public void testCircleAreaCalculation(){
        Assert.assertEquals(areaCalculator.calculateCircleArea(1), Math.PI);
    }

    @Test(description = "Calculate area of the circle with radius = 28m")
    public void testRightCircleAreaCalculationPositiveValue(){
        final double delta = 0.0001;
        Assert.assertEquals(areaCalculator.calculateCircleArea(28), 2463.0086, delta);
    }

    @Test(description = "Calculate area of the circle with fraction value of the radius")
    public void testCircleAreaCalculationFractionValues(){
        final double delta = 0.0001;
        Assert.assertEquals(areaCalculator.calculateCircleArea(0.27), 0.2290, delta);
    }

    @Test(description = "Try to calculate area of the circle with 0 radius value",
            expectedExceptions = IllegalArgumentException.class)
    public void testCircleAreaCalculationZeroRadiusValue(){
        areaCalculator.calculateCircleArea(0);
    }

    @Test(description = "Try to calculate area of the circle with negative radius value",
            expectedExceptions = IllegalArgumentException.class)
    public void testCircleAreaCalculationNegativeRadiusValue(){
        areaCalculator.calculateCircleArea(-1);
    }
}
