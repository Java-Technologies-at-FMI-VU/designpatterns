package lt.vu.mif.javatech.dp.logger;

public abstract class Logger {

    public enum LEVEL {
        ERROR, INFO, DEBUG
    }

    protected final LEVEL level;
    protected Logger nextLogger;

    public Logger(LEVEL level) {
        this.level = level;
    }
    
    public void logMessage(LEVEL level, String message) {

        if (this.level.compareTo(level) >= 0) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }

    }

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    
    abstract protected void write(String message);

}
