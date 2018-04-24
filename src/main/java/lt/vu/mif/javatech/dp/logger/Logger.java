package lt.vu.mif.javatech.dp.logger;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class Logger {

    public enum LEVEL {
        ERROR, INFO, DEBUG
    }

    protected final LEVEL level;

    @Setter
    protected Logger nextLogger;

    public void logMessage(LEVEL level, String message) {

        if (this.level.compareTo(level) >= 0) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }

    }

    abstract protected void write(String message);

}
