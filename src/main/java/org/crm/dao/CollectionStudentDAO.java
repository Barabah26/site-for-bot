package org.crm.dao;

import org.crm.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionStudentDAO implements StudentsDAO{

    private static final String GET_STUDENT = """
            SELECT DISTINCT id, pip, group_name, year_entry, phone_number, statement
                    FROM students WHERE status is false ORDER BY pip""";

    private static final String UPDATE_STATUS = """
        UPDATE students SET status = true WHERE id = ?""";

    private final Connection conn;
    private List<Student> studentList;

    public CollectionStudentDAO(Connection conn) {
        this.conn = conn;
        this.studentList = new ArrayList<>();
    }
    public boolean updateStatus(long studentId) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(UPDATE_STATUS);
            ps.setLong(1, studentId);
            int rowsAffected = ps.executeUpdate();

            // Оновлення статусу об'єкта Student в studentList
            if (rowsAffected > 0) {
                for (Student student : studentList) {
                    if (student.getId() == studentId) {
                        student.setStatus(true);
                        break;
                    }
                }
            }

            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update student status", e);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public List<Student> getAllStudentsFromDB() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(GET_STUDENT);

            rs = ps.executeQuery();

            clearStudentList();

            while (rs.next()) {
                Student student = new Student(
                        rs.getLong("id"),
                        rs.getString("pip"),
                        rs.getString("group_name"),
                        rs.getString("year_entry"),
                        rs.getString("phone_number"),
                        rs.getString("statement")
                );
                saveStudent(student);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Closing resources in finally block to ensure they are released properly
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return studentList;

    }

    @Override
    public Optional<Student> getStudentById(long id) {
        return studentList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Student> getAllStudents() {
        return Optional.empty();
    }

    @Override
    public boolean saveStudent(Student student) {
        int indexOfAdmin = studentList.indexOf(student);

        if (indexOfAdmin != -1){
            studentList.set(indexOfAdmin, student);
        } else {
            studentList.add(student);
        }
        return true;
    }

    public void clearStudentList() {
        studentList.clear();
    }

}
