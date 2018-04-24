package lt.vu.mif.javatech.dp.di;
 
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.inject.Inject;

class StudentFinder03 implements StudentFinder {
    
    @Inject
    private StudentDao dao;
    
    @Override
    public Student findStudent(String name) {
        return dao.get(name);
    }
    
}

//@RequiredArgsConstructor(onConstructor=@_({@Inject}))
class Course03 {
    
    private final String name;
    private final Collection<Student> students = new LinkedHashSet<>();
    
    @Inject
    private StudentFinder finder;
    
    @Inject
    public Course03(@Assisted String name) {
        this.name = name;
    }
    
    public void add(String name) {
        Student s = finder.findStudent(name);
        if (s != null) {
            students.add(s);
        }
    }
    
    public void remove(String name) {
        Student s = finder.findStudent(name);
        if (s != null) {
            students.remove(s);
        }
    }
    
    public void print(PrintStream out) {
        out.format("Course %s students:%n", name);
        int i = 1;
        for (Student s: students) {
            out.format("%d. %s%n", i++, s);
        }
    }

}

interface CourseFactory {
    
    Course03 create(String name);
            
}

class MyModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bind(StudentDao.class).to(StudentDaoDatabase.class);
        bind(StudentFinder.class).to(StudentFinder03.class);
        install(new FactoryModuleBuilder().build(CourseFactory.class));
    }
    
}

/**
 * DependencyInjectionDemo
 * @author valdo
 */
public class GuiceDemo {

    public static void main(String[] args) {
        
        Injector injector = Guice.createInjector(new MyModule());
        CourseFactory cf = injector.getInstance(CourseFactory.class);
        
        Course03 course = cf.create("Java");
        course.add("Vardenis");
        course.add("Bill Gates");
        
        course.print(System.out);
        
    }
    
}
