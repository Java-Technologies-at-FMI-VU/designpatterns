package lt.vu.mif.javatech.dp.di;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * StudentDaoDatabase
 * @author valdo
 */
public class StudentDaoDatabase implements StudentDao {

    private final Collection<Student> db;

    public StudentDaoDatabase() {
        this.db = new HashSet<>(Arrays.asList(
            new Student[] {
                new Student("John Smith", "UK"),
                new Student("Bill Gates", "USA"),
                new Student("Vardenis", "Lietuva")
            }
        ));
    }
    
    @Override
    public Collection<Student> getAll() {
        return db;
    }

    @Override
    public Student get(String name) {
        for (Student s: db) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        db.add(student);
    }

}
