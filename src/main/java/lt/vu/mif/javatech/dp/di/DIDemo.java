package lt.vu.mif.javatech.dp.di;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
class SomeService {
    
}

class Test {
    
    @Inject
    private SomeService someService;    

    @Override
    public String toString() {
        return "Test{" + "someService=" + someService + '}';
    }
    
}

public class DIDemo {

    public static void main(String[] args) {
    
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                
            }
        });
        
        Test test1 = injector.getInstance(Test.class);
        System.out.println(test1);
        
        Test test2 = injector.getInstance(Test.class);
        System.out.println(test2);
        
    }
    
}
