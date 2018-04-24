package lt.vu.mif.javatech.dp.guice;

import javax.inject.Inject;

public class RunFinder {

    @Inject
    private DbWorker dbWorker;

    public Run findRun(int number) {
        return dbWorker.getRun(number);
    }

}
