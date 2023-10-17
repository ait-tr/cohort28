package repositories;

import models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
