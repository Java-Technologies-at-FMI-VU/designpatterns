package lt.vu.mif.javatech.dp.behavioral;

import lt.vu.mif.javatech.dp.logger.ConsoleLogger;
import lt.vu.mif.javatech.dp.logger.FileLogger;
import lt.vu.mif.javatech.dp.logger.Logger;
import lt.vu.mif.javatech.dp.logger.Logger.LEVEL;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        Logger root = new ConsoleLogger(LEVEL.INFO);
        root.setNextLogger(new FileLogger(LEVEL.DEBUG));

        root.logMessage(LEVEL.ERROR, "Some error message");
        root.logMessage(LEVEL.INFO, "Some info message");
        root.logMessage(LEVEL.DEBUG, "Some debug message");

    }

}
