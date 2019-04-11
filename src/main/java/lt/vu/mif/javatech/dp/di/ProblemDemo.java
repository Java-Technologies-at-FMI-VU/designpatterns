package lt.vu.mif.javatech.dp.di;
 
import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedHashSet;

class StudentFinder01 implements StudentFinder {
    
    private final StudentDao dao;

    public StudentFinder01(StudentDao dao) {
        this.dao = dao;
    }
    
    @Override
    public Student findStudent(String name) {
        return dao.get(name);
    }
    
}

class Course01 {
    
    private final String name;
    private final StudentFinder finder;
    private final Collection<Student> students = new LinkedHashSet<>();

    public Course01(String name, StudentFinder finder) {
        this.name = name;
        this.finder = finder;
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

/**
 * DependencyInjectionDemo
 * @author valdo
 */
public class ProblemDemo {

    public static void main(String[] args) {
        
        StudentDao dao = new StudentDaoDatabase();
        StudentFinder finder = new StudentFinder01(dao);
        
        Course01 course = new Course01("Java", finder);
        course.add("Vardenis");
        course.add("Bill Gates");
        
        course.print(System.out);
        
    }
    
}
