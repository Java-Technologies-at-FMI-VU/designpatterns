package lt.vu.mif.javatech.dp.logger;

public class ConsoleLogger extends Logger {

    public ConsoleLogger(LEVEL level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger: " + message);
    }

}
