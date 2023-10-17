/*
Дан файл со списком студентов:
jack,3
john,5
nick,1
jack,4
и т.д. т.е. *имя,оценка"
необходитмо:

получить мэп, где ключ это имя студента, значение сколько у студента оценок (в рамках этой задачи, строки с одинаковым именем относятся к одному студенту т.е. у jack 2 оцеки)
получить список студентов с средним балом больше заданного.
Ркализоавть тесты.



1. repository
    прочитать файл -> List<Student>
   a) создать class Student [name, List<Double> grade]

service
2. получить мэп, где ключ это имя студента, значение сколько у студента оценок
   Map<String, Long> countGradeByStudent(List<Student> )
    getSize / getList.size()

3. получить список студентов с средним балом больше заданного
    List<Student> getStudentsWithGradeMoreThen(List<Student>, double N  )
        - пробежать по листу
        - для каждого получить средней бал
        - в итог те студенты у которых средний бал больше


 */


import models.Student;
import repositories.StudentRepository;
import repositories.StudentRepositoryFileImpl;
import servises.StudentService;
import servises.StudentServiceImp;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepositoryFileImpl("D:/ait-tr/gits/cohort28/back_end/students.txt");
        List<Student> all = repository.findAll();
        System.out.println(all);
        System.out.println("---------------------------------");

        StudentService service = new StudentServiceImp(repository);
        Map<String, Integer> mapCount = service.countGradeByStudent();
        System.out.println(mapCount);


    }
}