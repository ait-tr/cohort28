package repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFileImpl implements CrudRepository {
    private String fileName;
    private  Long currentID=1L;

    public UserRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            user.setId(currentID++);
            writer.write(user.getId()+";"+user.getName()+";"+ user.getEmail()); // 1;jack;jack@email.com
            writer.newLine();

        } catch (IOException e) {
            System.out.println("file save error");;
        }
    }

    @Override
    public User findByID(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(l->l.split(";"))
                    .map(uArr->new User(Long.parseLong(uArr[0]),uArr[1],uArr[2]))
                    .toList();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User user) {

    }
}
