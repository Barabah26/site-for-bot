package org.crm.dao;

import org.crm.Student;
import java.util.Optional;

public interface StudentsDAO {
    Optional<Student> getStudentById(long id);
    Optional<Student> getAllStudents();
    boolean saveStudent(Student student);
}
