package com.gmail.ivanytskyy.vitaliy.homework03;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 09/04/2023
 */
public class TriangleTest {

    @Test(description = "Casual case with correct values of sides")
    public void testCreateTrianglePositiveCasualCase(){
        double a = 1.5, b = 2.6, c = 4.0;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getA(), a);
        Assert.assertEquals(triangle.getB(), b);
        Assert.assertEquals(triangle.getC(), c);
    }
    @Test(description = "Positive case (a == b == c)")
    public void testCreateTrianglePositiveCaseAllSidesEqual(){
        double a = 22.1, b = 22.1, c = 22.1;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getA(), a);
        Assert.assertEquals(triangle.getB(), b);
        Assert.assertEquals(triangle.getC(), c);
    }

    @Test(description = "Negative case with incorrect values of sides (a + b < c)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseAPlusBLessC(){
        double a = 1.4, b = 2.8, c = 4.3;
        new Triangle(a, b, c);
    }

    @Test(description = "Negative case with incorrect values of sides (a + c < b)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseAPlusCLessB(){
        double a = 21.4, b = 33.7, c = 12.2;
        new Triangle(a, b, c);
    }

    @Test(description = "Negative case with incorrect values of sides (b + c < a)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseBPlusCLessA(){
        double a = 12.44, b = 3.77, c = 8.66;
        new Triangle(a, b, c);
    }

    @Test(description = "Negative case with incorrect values of sides (a == b == c == 0)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseABCEqualZero(){
        double a = 0, b = 0, c = 0;
        new Triangle(a, b, c);
    }
    @Test(description = "Negative case with incorrect values of sides (a is negative)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseAIsNegative(){
        double a = -4, b = 5, c = 3;
        new Triangle(a, b, c);
    }

    @Test(description = "Negative case with incorrect values of sides (b is negative)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseBIsNegative(){
        double a = 4, b = -5, c = 3;
        new Triangle(a, b, c);
    }

    @Test(description = "Negative case with incorrect values of sides (c is negative)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseCIsNegative(){
        double a = 4, b = 5, c = -3;
        new Triangle(a, b, c);
    }
    @Test(description = "Negative case with incorrect values of sides (all sides are negative and equal each other)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = Triangle.EXCEPTION_MESSAGE)
    public void testCreateTriangleNegativeCaseAllSidesAreNegativeAndEqualEachOther(){
        double a = -7.0, b = -7.0, c = -7.0;
        new Triangle(a, b, c);
    }

    @Test(description = "Casual case when triangle is isosceles")
    public void testIsTriangleIsoscelesTriangleIsIsoscelesCase(){
        double a = 2.6, b = 2.6, c = 4.0;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.isIsosceles());
    }

    @Test(description = "Casual case when triangle isn't isosceles")
    public void testIsTriangleIsoscelesTriangleIsNotIsoscelesCase(){
        double a = 3.7, b = 3.6, c = 4.0;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertFalse(triangle.isIsosceles());
    }

    @Test(description = "Positive case (a == b == c)")
    public void testIsTriangleIsoscelesAllSidesEqualCase(){
        double a = 17.0, b = 17.0, c = 17.0;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.isIsosceles());
    }

    @Test(description = "Casual case when triangle is isosceles and side lengths is small")
    public void testIsTriangleIsoscelesTriangleIsIsoscelesWithSmallSideLengthCase(){
        double a = 0.00005, b = 0.00009, c = 0.00005;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.isIsosceles());
    }
    @Test(description = "Casual case when triangle is equilateral")
    public void testIsTriangleIsoscelesTriangleIsEquilateralCase(){
        double a = 7.6, b = 7.6, c = 7.6;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.isEquilateral());
    }

    @Test(description = "Casual case when triangle isn't equilateral")
    public void testIsTriangleIsoscelesTriangleIsNotEquilateralCase(){
        double a = 5.7, b = 5.6, c = 5.7;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertFalse(triangle.isEquilateral());
    }

    @Test(description = "Casual case when triangle is equilateral and side lengths is small")
    public void testIsTriangleIsoscelesTriangleIsEquilateralCaseWithSmallSideLengthCase(){
        double a = 0.000004, b = 0.000004, c = 0.000004;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertTrue(triangle.isEquilateral());
    }

    @Test(description = "Casual case getting perimeter")
    public void testGetPerimeterCasualCase(){
        double a = 12.3, b = 16.55, c = 14.77;
        Triangle triangle = new Triangle(a, b, c);
        final double delta = 0.0001;
        Assert.assertEquals(triangle.getPerimeter(), 43.62, delta);
    }

    @Test(description = "Casual case getting perimeter when triangle is isosceles")
    public void testGetPerimeterWhenTriangleIsIsoscelesCase(){
        double a = 2.99, b = 3.01, c = 2.99;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getPerimeter(), 8.99);
    }

    @Test(description = "Casual case getting perimeter when triangle is equilateral")
    public void testGetPerimeterWhenTriangleIsEquilateralCase(){
        double a = 14.99, b = 14.99, c = 14.99;
        Triangle triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getPerimeter(), 44.97);
    }

    @Test(description = "Casual case getting perimeter when when lengths is small")
    public void testIsTriangleIsoscelesTriangleWithSmallSideLengthCase(){
        double a = 0.00000012, b = 0.00000016, c = 0.00000018;
        Triangle triangle = new Triangle(a, b, c);
        final double delta = 0.0000000001;
        Assert.assertEquals(triangle.getPerimeter(), 0.00000046, delta);
    }
}
