package lt.vu.mif.javatech.dp.guice;

import com.google.inject.AbstractModule;

public class DbModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(DbWorker.class).to(SingletonDbWorker.class);

    }

}
