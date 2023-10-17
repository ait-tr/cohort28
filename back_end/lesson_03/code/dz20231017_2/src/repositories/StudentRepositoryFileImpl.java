package repositories;

import models.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepositoryFileImpl implements StudentRepository{
    private String file;

    public StudentRepositoryFileImpl(String file) {
        this.file = file;
    }


    @Override
    public List<Student> findAll() {
        try(BufferedReader br= new BufferedReader(new FileReader(file))){
            /*
            Map<String, List<String[]>> collect = br.lines()
                    .map(line -> line.split(","))
                    .filter(arr -> arr.length == 2)
                    .collect(Collectors.groupingBy((String[] arr) -> arr[0], Collectors.toList()));
            */
            // Collectors
            //  groupingBy -> map <key, List<Stream Object>>
            //  toMap -> задаем и key и value
            // partitioningBy() -> map <Boolean, List<Stream Object>> -



            Map<String, List<Double>> mapStudent = br.lines()
                    .map(line -> line.split(","))
                    .filter(arr -> arr.length == 2)
                    .collect(Collectors.groupingBy((String[] arr) -> arr[0],
                            Collectors.mapping(arr -> Double.parseDouble(arr[1]), Collectors.toList())));

            return mapStudent.entrySet().stream()
                    .map(e->new Student(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
