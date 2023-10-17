package servises;

import models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map<String, Integer> countGradeByStudent();
    List<Student> getStudentsWithGradeMoreThen(double N);
}
