package lt.vu.mif.javatech.dp.di;
 
import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedHashSet;

class ServiceLocator {
    
    private static class Holder {
        public static final StudentDao DAO = new StudentDaoDatabase();
        public static final StudentFinder FINDER = new StudentFinder02();
    }
    
    public static StudentDao getDao() {
        return Holder.DAO;
    }
    
    public static StudentFinder getFinder() {
        return Holder.FINDER;
    }
    
}

class StudentFinder02 implements StudentFinder {
    
    @Override
    public Student findStudent(String name) {
        return ServiceLocator.getDao().get(name);
    }
    
}

class Course02 {
    
    private static final StudentFinder FINDER = ServiceLocator.getFinder();
    private final String name;
    private final Collection<Student> students = new LinkedHashSet<>();

    public Course02(String name) {
        this.name = name;
    }
    
    public void add(String name) {
        Student s = FINDER.findStudent(name);
        if (s != null) {
            students.add(s);
        }
    }
    
    public void remove(String name) {
        Student s = FINDER.findStudent(name);
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

/**
 * DependencyInjectionDemo
 * @author valdo
 */
public class LocatorDemo {

    public static void main(String[] args) {
        
        Course02 course = new Course02("Java");
        course.add("Vardenis");
        course.add("Bill Gates");
        
        course.print(System.out);
        
    }
    
}
