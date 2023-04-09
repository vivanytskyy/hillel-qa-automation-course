package com.gmail.ivanytskyy.vitaliy.homework03;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 09/04/2023
 */
public class NumbersCheckServiceTest {
    private NumbersCheckService checkService;

    @BeforeTest
    public void preCondition(){
        checkService = new NumbersCheckService();
    }

    @Test(description = "Check casual odd value")
    public void checkOddOrEvenCasualOddValue(){
        Assert.assertEquals(checkService.checkOddOrEven(7), NumbersCheckService.ODD_NUMBER_MESSAGE);
    }

    @Test(description = "Check casual even value")
    public void checkOddOrEvenCasualEvenValue(){
        Assert.assertEquals(checkService.checkOddOrEven(12), NumbersCheckService.EVEN_NUMBER_MESSAGE);
    }

    @Test(description = "Boundary-value analysis. Min odd value case (num equals 1)")
    public void checkOddOrEvenMinOddValue(){
        Assert.assertEquals(checkService.checkOddOrEven(1), NumbersCheckService.ODD_NUMBER_MESSAGE);
    }

    @Test(description = "Boundary-value analysis. Min even value case (num equals 2)")
    public void checkOddOrEvenMinIvenValue(){
        Assert.assertEquals(checkService.checkOddOrEven(2), NumbersCheckService.EVEN_NUMBER_MESSAGE);
    }

    @Test(description = "Boundary-value analysis. Value less then min odd value case (num equals 0)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void checkOddOrEvenZeroValue(){
        checkService.checkOddOrEven(0);
    }

    @Test(description = "Boundary-value analysis. Max odd value case (num equals Integer.MAX_VALUE)")
    public void checkOddOrEvenMaxOddValue(){
        Assert.assertEquals(checkService.checkOddOrEven(Integer.MAX_VALUE), NumbersCheckService.ODD_NUMBER_MESSAGE);
    }

    @Test(description = "Boundary-value analysis. Max even value case (num equals Integer.MAX_VALUE - 1)")
    public void checkOddOrEvenMaxIvenValue(){
        Assert.assertEquals(checkService.checkOddOrEven(Integer.MAX_VALUE - 1), NumbersCheckService.EVEN_NUMBER_MESSAGE);
    }

    @Test(description = "Negative value case (num equals -1)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void checkOddOrEvenNegativeValue(){
        checkService.checkOddOrEven(-1);
    }

    @Test(description = "Min negative value case (num equals Integer.MIN_VALUE)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void checkOddOrEvenMinNegativeValue(){
        checkService.checkOddOrEven(Integer.MIN_VALUE);
    }

    @Test(description = "Casual case (num1 and num2 are positive, num1 > num2)")
    public void compareAbsValuesNum1AndNum2PositiveNum1MoreNum2(){
        Assert.assertEquals(checkService.compareAbsValues(7, 5),
                "Absolute value of " + 7 + " more than " + 5);
    }

    @Test(description = "Casual case (num1 and num2 are positive, num1 < num2)")
    public void compareAbsValuesNum1AndNum2PositiveNum1LessNum2(){
        Assert.assertEquals(checkService.compareAbsValues(33, 34),
                "Absolute value of " + 34 + " more than " + 33);
    }

    @Test(description = "Casual case (num1 and num2 are positive, num1 == num2)")
    public void compareAbsValuesNum1AndNum2PositiveNum1EqualsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(67, 67), NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Casual case (num1 is positive and num2 is negative, abs(num1) > abs(num2))")
    public void compareAbsValuesNum1IsPositiveAndNum2IsNegativeAbsNum1MoreAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(12, -9),
                "Absolute value of " + 12 + " more than " + -9);
    }

    @Test(description = "Casual case (num1 is positive and num2 is negative, abs(num1) < abs(num2))")
    public void compareAbsValuesNum1IsPositiveAndNum2IsNegativeAbsNum1LessAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(15, -16),
                "Absolute value of " + -16 + " more than " + 15);
    }

    @Test(description = "Casual case (num1 is positive and num2 is negative, abs(num1) == abs(num2))")
    public void compareAbsValuesNum1IsPositiveAndNum2IsNegativeAbsNum1EqualsAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(154, -154),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Casual case (num1 is negative and num2 is positive, abs(num1) > abs(num2))")
    public void compareAbsValuesNum1IsNegativeAndNum2IsPositiveAbsNum1MoreAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-22, 20),
                "Absolute value of " + -22 + " more than " + 20);
    }

    @Test(description = "Casual case (num1 is negative and num2 is positive, abs(num1) < abs(num2))")
    public void compareAbsValuesNum1IsNegativeAndNum2IsPositiveAbsNum1LessAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-99, 120),
                "Absolute value of " + 120 + " more than " + -99);
    }

    @Test(description = "Casual case (num1 is negative and num2 is positive, abs(num1) == abs(num2))")
    public void compareAbsValuesNum1IsNegativeAndNum2IsPositiveAbsNum1EqualsAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-1024, 1024),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Casual case (num1 and num2 are negative, abs(num1) > abs(num2))")
    public void compareAbsValuesNum1AndNum2NegativeAbsNum1MoreAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-77, -5),
                "Absolute value of " + -77 + " more than " + -5);
    }

    @Test(description = "Casual case (num1 and num2 are negative, abs(num1) < abs(num2))")
    public void compareAbsValuesNum1AndNum2NegativeAbsNum1LessAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-18, -33),
                "Absolute value of " + -33 + " more than " + -18);
    }

    @Test(description = "Casual case (num1 and num2 are negative, abs(num1) == abs(num2))")
    public void compareAbsValuesNum1AndNum2NegativeAbsNum1EqualsAbsNum2(){
        Assert.assertEquals(checkService.compareAbsValues(-55, -55),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Casual case (num1 is positive and num2 equals 0)")
    public void compareAbsValuesNum1IsPositiveNum2EqualsZero(){
        Assert.assertEquals(checkService.compareAbsValues(1, 0),
                "Absolute value of " + 1 + " more than " + 0);
    }

    @Test(description = "Casual case (num1 is negative and num2 equals 0)")
    public void compareAbsValuesNum1IsNegativeNum2EqualsZero(){
        Assert.assertEquals(checkService.compareAbsValues(-111, 0),
                "Absolute value of " + -111 + " more than " + 0);
    }

    @Test(description = "Casual case (num1 equals 0 and num2 is positive)")
    public void compareAbsValuesNum2IsPositiveNum1EqualsZero(){
        Assert.assertEquals(checkService.compareAbsValues(0, 11),
                "Absolute value of " + 11 + " more than " + 0);
    }

    @Test(description = "Casual case (num1 equals 0 and num2 is negative)")
    public void compareAbsValuesNum2IsNegativeNum1EqualsZero(){
        Assert.assertEquals(checkService.compareAbsValues(0, -10),
                "Absolute value of " + -10 + " more than " + 0);
    }

    @Test(description = "Casual case (num1 and num2 equal 0)")
    public void compareAbsValuesNum1AndNum2EqualZero(){
        Assert.assertEquals(checkService.compareAbsValues(0, 0),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Positive test (num1 == (Integer.MIN_VALUE + 1) and num2 == Integer.MAX_VALUE)")
    public void compareAbsValuesNum1EqualsMinValuePlusOneAndNum2EqualsMaxValue(){
        Assert.assertEquals(checkService.compareAbsValues(Integer.MIN_VALUE + 1, Integer.MAX_VALUE),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Positive test (num1 == Integer.MAX_VALUE and num2 == Integer.MIN_VALUE + 1)")
    public void compareAbsValuesNum1EqualsMaxValueAndNum2EqualsMinValuePlusOne(){
        Assert.assertEquals(checkService.compareAbsValues(Integer.MAX_VALUE, Integer.MIN_VALUE + 1),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Positive test (num1 and num2 == Integer.MAX_VALUE)")
    public void compareAbsValuesNum1EqualsMaxValueAndNum2EqualsMaxValue(){
        Assert.assertEquals(checkService.compareAbsValues(Integer.MAX_VALUE, Integer.MAX_VALUE),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Positive test (num1 and num2 == Integer.MIN_VALUE + 1)")
    public void compareAbsValuesNum1EqualsMinValuePlusOneAndNum2EqualsMinValuePlusOne(){
        Assert.assertEquals(checkService.compareAbsValues(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1),
                NumbersCheckService.EQUAL_VALUES_MESSAGE);
    }

    @Test(description = "Negative test (num1 == Integer.MIN_VALUE and num2 == Integer.MAX_VALUE)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void compareAbsValuesNegativeTestNum1EqualsMinValueAndNum2EqualsMaxValue(){
        checkService.compareAbsValues(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Test(description = "Negative test (num1 == Integer.MAX_VALUE and num2 == Integer.MIN_VALUE)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void compareAbsValuesNegativeTestNum1EqualsMaxValueAndNum2EqualsMinValue(){
        checkService.compareAbsValues(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    @Test(description = "Negative test (num1 and num2 equal Integer.MIN_VALUE)",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = NumbersCheckService.EXCEPTION_MESSAGE)
    public void compareAbsValuesNegativeTestNum1EqualsMinValueAndNum2EqualsMinValue(){
        checkService.compareAbsValues(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @AfterTest
    public void postCondition(){
        checkService = null;
    }
}
