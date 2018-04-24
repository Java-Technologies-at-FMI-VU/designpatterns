package lt.vu.mif.javatech.dp.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDemo {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new DbModule());
        RunFinder finder = injector.getInstance(RunFinder.class);

		//System.out.println(finder.findRun(158560));
        CheckFinder f1 = injector.getInstance(CheckFinder.class);
        f1.checkDbWorker();
        f1.checkDbWorkerRecursive();

        CheckFinder f2 = injector.getInstance(CheckFinder.class);
        f2.checkDbWorker();
        f2.checkDbWorkerRecursive();

    }

}
