package com.gmail.ivanytskyy.vitaliy.homework07;
import static com.gmail.ivanytskyy.vitaliy.homework07.AnsiColorCode.*;
import static com.gmail.ivanytskyy.vitaliy.homework07.Logger.Level.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 29/04/2023
 */
public class Logger {
    private static Logger logger;
    private final String name;

    private Logger(String name) {
        this.name = name;
    }

    public void log(Level level, String msg){
        System.out.println(level.getColorCode()
                + name + "\n"
                + level + ": " + msg
                + RESET.getCode());
    }

    public void logInfo(String msg){
        log(INFO, msg);
    }

    public void logDebug(String msg){
        log(DEBUG, msg);
    }

    public void logWarn(String msg){
        log(WARN, msg);
    }

    public void logError(String msg){
        log(ERROR, msg);
    }

    public static Logger getLogger(String className){
        if(className == null || className.isBlank()){
            throw new IllegalArgumentException("Incorrect input value");
        }
        if(logger == null){
            logger = new Logger(className);
        }
        return logger;
    }

    public enum Level {
        INFO(GREEN),
        DEBUG(BLUE),
        WARN(YELLOW),
        ERROR(RED);
        private final AnsiColorCode ansiColorCode;

        Level(AnsiColorCode ansiColorCode){
            this.ansiColorCode = ansiColorCode;
        }
        public String getColorCode(){
            return ansiColorCode.getCode();
        }
    }
}
