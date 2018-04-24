package lt.vu.mif.javatech.dp.di;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Person
 * @author valdo
 */
@Getter 
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(of = "name")
public class Student implements Comparable<Student>{

    private final String name;
    private final String country;

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
    
}
