package servises;

import models.Student;
import repositories.StudentRepository;
import repositories.StudentRepositoryFileImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentServiceImp implements StudentService {
    StudentRepository repository;

    //Dependency Injection
    public StudentServiceImp(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Integer> countGradeByStudent() {
        return repository.findAll()
                .stream()
                .collect(Collectors.toMap(st -> st.getName(), st -> st.getGrades().size()));
    }


    @Override
    public List<Student> getStudentsWithGradeMoreThen(double N) {
        return  repository.findAll().stream()
                .filter(st->st.getAverageGrade()>=N)
                .toList();

    }
}
