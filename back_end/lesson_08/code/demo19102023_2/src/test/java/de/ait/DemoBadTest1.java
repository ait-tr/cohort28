package de.ait;

import de.ait.model.User;
import de.ait.repositories.UserRepository;
import de.ait.repositories.UserRepositoryFileImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DemoBadTest1 {
    UserRepository repository=new UserRepositoryFileImpl("123.txt");
    @Test
    void findAll() {
        List<User> expected = List.of(
                new User(1L,"jack","jac@mail.com"),
                new User(2L,"nick","nick@mail.com")
        );
        repository.save(new User("jack","jac@mail.com"));
        repository.save(new User("nick","nick@mail.com"));
        List<User> result = repository.findAll();
        Assertions.assertAll(
                ()->Assertions.assertEquals(expected, result),
                ()->Assertions.assertEquals(expected.size(), result.size())
        );
        }

    
    @Test
    void deleteUserByIdAssertNull() {
        repository.deleteById(2L);
        User actual = repository.findByID(2L);
        Assertions.assertNull(actual);
    }

}
