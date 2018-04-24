package lt.vu.mif.javatech.dp.guice;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CheckFinder {

    @Inject
    private Provider<CheckFinder> provider;

    private final DbWorker dbWorker;

    @Inject
    public CheckFinder(DbWorker dbWorker) {
        this.dbWorker = dbWorker;
    }

    public void checkDbWorker() {
        System.out.format("%s has %s%n", this, dbWorker);
    }

    public void checkDbWorkerRecursive() {
        Injector injector = Guice.createInjector(new DbModule());
        CheckFinder f = injector.getInstance(CheckFinder.class);
        //CheckFinder f = provider.get();
        f.checkDbWorker();
    }

}
