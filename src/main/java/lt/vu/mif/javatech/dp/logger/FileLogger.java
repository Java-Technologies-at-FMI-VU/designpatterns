package lt.vu.mif.javatech.dp.logger;

public class FileLogger extends Logger {

    public FileLogger(LEVEL level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }

}
