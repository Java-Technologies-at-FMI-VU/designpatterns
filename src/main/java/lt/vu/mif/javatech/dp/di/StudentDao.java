package lt.vu.mif.javatech.dp.di;

import java.util.Collection;

/**
 * StudentDao
 * @author valdo
 */
public interface StudentDao {

    Collection<Student> getAll();
    Student get(String name);
    void save(Student student);
    
}
