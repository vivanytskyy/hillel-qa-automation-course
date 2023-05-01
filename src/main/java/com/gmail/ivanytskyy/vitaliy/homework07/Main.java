package com.gmail.ivanytskyy.vitaliy.homework07;
import static com.gmail.ivanytskyy.vitaliy.homework07.Logger.Level.*;

/*
*Task 1
* Написати свій клас Logger, який потім можна використовувати в різних місцях нашиї програм.
* Логер має підтримувати різні рівні логування (info, debug, warn, error).
* Можна створити Enum для різних рівнів, щоб передевати його як параметр,
* або ж використовувати в конкретних методах під кожний рівень.
*/
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 29/04/2023
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // to call the same log() method
        LOGGER.log(INFO, "info message 1)");
        LOGGER.log(DEBUG, "debug message 1");
        LOGGER.log(WARN, "warn message 1");
        LOGGER.log(ERROR, "error message 1");
        // to call different methods
        LOGGER.logInfo("info message 2");
        LOGGER.logDebug("debug message 2");
        LOGGER.logWarn("warn message 2");
        LOGGER.logError("error message 2");
    }
}