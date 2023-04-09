package com.gmail.ivanytskyy.vitaliy.homework03;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import static com.gmail.ivanytskyy.vitaliy.homework03.MonthNumberInWordConverter.ImplVariant.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/04/2023
 */
public class MonthNumberInWordConverterTest {
    private MonthNumberInWordConverter converter;
    private static final TextStyle TEXT_STYLE = TextStyle.SHORT;
    private static final Locale LOCALE = Locale.ENGLISH;

    @BeforeTest
    public void preCondition(){
        converter = new MonthNumberInWordConverter(TEXT_STYLE, LOCALE);
    }

    @Test (description = "Convert casual value by if-else implementation")
    public void convertToMonthInDefaultCaseIfElseImpl(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(5, BY_IF_ELSE),
                Month.of(5).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Min value case (num equals 1)")
    public void convertToMonthInDefaultCaseIfElseImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(1, BY_IF_ELSE),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value less then min value (num equals 0)")
    public void convertToMonthInDefaultCaseIfElseImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(0, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Max value case (num equals 12)")
    public void convertToMonthInDefaultCaseIfElseImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(12, BY_IF_ELSE),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value more then max value (num equals 13)")
    public void convertToMonthInDefaultCaseIfElseImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(13, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert negative value by if-else implementation")
    public void convertToMonthInDefaultCaseIfElseImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(-1, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert casual value by switch implementation")
    public void convertToMonthInDefaultCaseSwitchImpl(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(4, BY_SWITCH),
                Month.of(4).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Min value case (num equals 1)")
    public void convertToMonthInDefaultCaseSwitchImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(1, BY_SWITCH),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value less then min value (num equals 0)")
    public void convertToMonthInDefaultCaseSwitchImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(0, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Max value case (num equals 12)")
    public void convertToMonthInDefaultCaseSwitchImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(12, BY_SWITCH),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value more then max value (num equals 13)")
    public void convertToMonthInDefaultCaseSwitchImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(13, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert negative value by switch implementation")
    public void convertToMonthInDefaultCaseSwitchImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(-1, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert casual value by Java Month.of() method implementation")
    public void convertToMonthInDefaultCaseMonthOfImpl(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(8, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(8).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Min value case (num equals 1)")
    public void convertToMonthInDefaultCaseMonthOfImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(1, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value less then min value (num equals 0)")
    public void convertToMonthInDefaultCaseMonthOfImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(0, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Max value case (num equals 12)")
    public void convertToMonthInDefaultCaseMonthOfImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(12, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE));
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value more then max value (num equals 13)")
    public void convertToMonthInDefaultCaseMonthOfImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(13, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert negative value by Month.of() method implementation")
    public void convertToMonthInDefaultCaseMonthOfImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInDefaultCase(-1, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE);
    }

    @Test (description = "Convert casual value by if-else implementation")
    public void convertToMonthInUpperCaseIfElseImpl(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(5, BY_IF_ELSE),
                Month.of(5).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Min value case (num equals 1)")
    public void convertToMonthInUpperCaseIfElseImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(1, BY_IF_ELSE),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value less then min value (num equals 0)")
    public void convertToMonthInUpperCaseIfElseImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(0, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Max value case (num equals 12)")
    public void convertToMonthInUpperCaseIfElseImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(12, BY_IF_ELSE),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value more then max value (num equals 13)")
    public void convertToMonthInUpperCaseIfElseImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(13, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert negative value by if-else implementation")
    public void convertToMonthInUpperCaseIfElseImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(-1, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert casual value by switch implementation")
    public void convertToMonthInUpperCaseSwitchImpl(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(6, BY_SWITCH),
                Month.of(6).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Min value case (num equals 1)")
    public void convertToMonthInUpperCaseSwitchImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(1, BY_SWITCH),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value less then min value (num equals 0)")
    public void convertToMonthInUpperCaseSwitchImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(0, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Max value case (num equals 12)")
    public void convertToMonthInUpperCaseSwitchImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(12, BY_SWITCH),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value more then max value (num equals 13)")
    public void convertToMonthInUpperCaseSwitchImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(13, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert negative value by switch implementation")
    public void convertToMonthInUpperCaseSwitchImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(-1, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert casual value by Java Month.of() method implementation")
    public void convertToMonthInUpperCaseMonthOfImpl(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(9, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(9).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Min value case (num equals 1)")
    public void convertToMonthInUpperCaseMonthOfImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(1, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value less then min value (num equals 0)")
    public void convertToMonthInUpperCaseMonthOfImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(0, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Max value case (num equals 12)")
    public void convertToMonthInUpperCaseMonthOfImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(12, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toUpperCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value more then max value (num equals 13)")
    public void convertToMonthInUpperCaseMonthOfImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(13, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert negative value by Month.of() method implementation")
    public void convertToMonthInUpperCaseMonthOfImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInUpperCase(-1, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toUpperCase());
    }

    @Test (description = "Convert casual value by if-else implementation")
    public void convertToMonthInLowerCaseIfElseImpl(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(5, BY_IF_ELSE),
                Month.of(5).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Min value case (num equals 1)")
    public void convertToMonthInLowerCaseIfElseImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(1, BY_IF_ELSE),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value less then min value (num equals 0)")
    public void convertToMonthInLowerCaseIfElseImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(0, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Max value case (num equals 12)")
    public void convertToMonthInLowerCaseIfElseImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(12, BY_IF_ELSE),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. If-else implementation. Value more then max value (num equals 13)")
    public void convertToMonthInLowerCaseIfElseImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(13, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Convert negative value by if-else implementation")
    public void convertToMonthInLowerCaseIfElseImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(-1, BY_IF_ELSE),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Convert casual value by switch implementation")
    public void convertToMonthInLowerCaseSwitchImpl(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(9, BY_SWITCH),
                Month.of(9).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Min value case (num equals 1)")
    public void convertToMonthInLowerCaseSwitchImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(1, BY_SWITCH),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value less then min value (num equals 0)")
    public void convertToMonthInLowerCaseSwitchImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(0, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Max value case (num equals 12)")
    public void convertToMonthInLowerCaseSwitchImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(12, BY_SWITCH),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Switch implementation. Value more then max value (num equals 13)")
    public void convertToMonthInLowerCaseSwitchImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(13, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Convert negative value by switch implementation")
    public void convertToMonthInLowerCaseSwitchImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(-1, BY_SWITCH),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Convert casual value by Java Month.of() method implementation")
    public void convertToMonthInLowerCaseMonthOfImpl(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(10, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(10).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Min value case (num equals 1)")
    public void convertToMonthInLowerCaseMonthOfImplMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(1, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(1).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value less then min value (num equals 0)")
    public void convertToMonthInLowerCaseMonthOfImplValueLessThanMinValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(0, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Max value case (num equals 12)")
    public void convertToMonthInLowerCaseMonthOfImplMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(12, BY_JAVA_MONTH_ENUM_METHOD),
                Month.of(12).getDisplayName(TEXT_STYLE, LOCALE).toLowerCase());
    }

    @Test (description = "Boundary-value analysis. Month.of() method implementation. Value more then max value (num equals 13)")
    public void convertToMonthInLowerCaseMonthOfImplValueMoreThanMaxValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(13, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @Test (description = "Convert negative value by Month.of() method implementation")
    public void convertToMonthInLowerCaseMonthOfImplNegativeValue(){
        Assert.assertEquals(converter.convertToMonthInLowerCase(-1, BY_JAVA_MONTH_ENUM_METHOD),
                MonthNumberInWordConverter.DEFAULT_MESSAGE.toLowerCase());
    }

    @AfterTest
    public void postCondition(){
        converter = null;
    }
}
