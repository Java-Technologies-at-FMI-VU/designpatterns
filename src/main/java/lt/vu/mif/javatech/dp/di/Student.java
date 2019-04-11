package lt.vu.mif.javatech.dp.di;

import java.util.Objects;

/**
 * Person
 * @author valdo
 */
public class Student implements Comparable<Student>{

    private final String name;
    private final String country;

    public Student(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", country=" + country + '}';
    }
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
    
}
