package org.crm.services;

import org.crm.Student;
import org.crm.dao.CollectionStudentDAO;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private CollectionStudentDAO collectionStudentDAO;

    public StudentService(CollectionStudentDAO collectionStudentDAO) {
        this.collectionStudentDAO = collectionStudentDAO;
    }

    public List<Student> getAllStudentsFromDB() {
        return collectionStudentDAO.getAllStudentsFromDB();

    }

    public Optional<Student> getStudentById(long id) {
        return collectionStudentDAO.getStudentById(id);
    }


    public Optional<Student> getAllStudents() {
        return Optional.empty();
    }

    public boolean saveStudent(Student student) {
        return collectionStudentDAO.saveStudent(student);
    }
}
