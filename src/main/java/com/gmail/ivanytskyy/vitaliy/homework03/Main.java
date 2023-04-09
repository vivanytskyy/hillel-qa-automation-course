package com.gmail.ivanytskyy.vitaliy.homework03;

import java.time.format.TextStyle;
import java.util.Locale;
import static com.gmail.ivanytskyy.vitaliy.homework03.MonthNumberInWordConverter.ImplVariant.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/04/2023
 */
/*
* Task 1
* Написати програму "CheckOddEven" яка друкує "Odd number", якщо змінна непарна,
* або "Even number", якщо парна. Перед завершенням роботи програма має друкувати "BYE".
* Значення змінної можна задати вручну через Scanner або присвоїти початкове значення в коді
*
* Task 2
* Написати програму "PrintMonthInWord" яка друкує "JAN", "FEB" ... "DEC"
* якщо значення int змінної дорівнює 1, 2, 3 ... 12. Або повинна вивести "Not a valid month".
* Розв'язати завдвання 2 способами:
* 1) за допомогою операторів if-else
* 2) за допомогою оператора switch
*
* Task 3
* Написати програму, яка буде порівнювати абсолютні значення двох чисел.
* Наприклад, для чисел 3 та -9 програма повинна надрукувати, що -9 має більше абсолютне значення.
* Для визначення абсолютного значення можна скористатися методом зі стандратної бібліотеки Math.abs()
*
* Task 4
* Написати програму, яка визначає, чи є трикутник рівнобедреним.
* Значення сторін трикутника задавати самостійно
 */
public class Main {
    public static void main(String[] args) {
        // Check number is odd or even. Print result with BYE.
        System.out.println("\n" + "Task 1");
        int inputInt = 5;
        NumbersCheckService numbersCheck = new NumbersCheckService();
        System.out.println(numbersCheck.checkOddOrEven(inputInt) + "\n" + "BYE");

        // Print month in word
        System.out.println("\n" + "Task 2");
        int monthNumber = 2;
        MonthNumberInWordConverter converter = new MonthNumberInWordConverter(TextStyle.SHORT, Locale.ENGLISH);
        // Implementation by if-else
        System.out.println(converter.convertToMonthInUpperCase(monthNumber, BY_IF_ELSE));
        // Implementation by switch
        System.out.println(converter.convertToMonthInUpperCase(monthNumber, BY_SWITCH));
        // Implementation by Java Month.of() method
        System.out.println(converter.convertToMonthInUpperCase(monthNumber, BY_JAVA_MONTH_ENUM_METHOD));

        // Compare abs values
        System.out.println("\n" + "Task 3");
        int num1 = 3, num2 = -16;
        System.out.println(numbersCheck.compareAbsValues(num1, num2));

        // Check if triangle is isosceles
        System.out.println("\n" + "Task 4");
        double a = 3.5, b = 3.5, c = 4.7;
        Triangle triangle = new Triangle(a, b, c);
        if(triangle.isIsosceles()){
            System.out.printf("Triangle with a = %.2f, b = %.2f and c = %.2f is isosceles", a, b, c);
        }else{
            System.out.printf("Triangle with a = %.2f, b = %.2f and c = %.2f isn't isosceles", a, b, c);
        }
    }
}