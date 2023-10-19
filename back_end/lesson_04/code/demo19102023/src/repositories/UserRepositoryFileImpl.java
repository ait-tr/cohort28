package repositories;

import model.User;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserRepositoryFileImpl implements UserRepository{
    private final String fileName;
    private  Long currentID=0L;

    public UserRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        this.currentID = getLastID();
    }
    private long getLastID(){
            return findAll()
                    .stream()
                    .mapToLong(User::getId)
                    .max()
                    .orElse(0);

    }

    @Override
    public void save(User user) {
        user.setId(++currentID);
        String line = String.format("%d;%s;%s%n",user.getId(),user.getName(),user.getEmail());
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            writer.write(line);
        } catch (IOException e) {
            System.out.println("file save error");
        }
    }

    @Override
    public User findByID(Long id) {
        return findAll().stream()
                .filter(user->user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<User> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(this::parseLine)
                    .filter(Objects::nonNull)
                    .toList();

        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }

    }
    private User parseLine(String line){
        String[] tokenArray = line.split(";");
        try{
            return new User(Long.parseLong(tokenArray[0]),tokenArray[1],tokenArray[2]);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {}

    @Override
    public void update(User user) {}


    @Override
    public User findByEmail(String email) {
        return findAll().stream()
                .filter(user->user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
