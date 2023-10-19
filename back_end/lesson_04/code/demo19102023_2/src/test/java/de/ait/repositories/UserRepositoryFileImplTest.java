package de.ait.repositories;

import de.ait.model.User;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryFileImplTest {
    public static final String TEST_FILE = "users_test.txt";
    UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UserRepositoryFileImpl(TEST_FILE);
        File file = new File(TEST_FILE);
        if (file.exists()){
            file.delete();
        }
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("create file error");
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE);
        if (file.exists()){
            file.delete();
        }
    }

    @Test
    @DisplayName("Test normal save")
    void save() throws Exception {
        // подготовка исзодных данных
        // ожидаемый рез.
        // вызываем тестируемый метод
        // сравнить ожилания и результат метода

        User user = new User("qwer", "qwer@qwert.com");
        String expected = "1;qwer;qwer@qwert.com";
        repository.save(user);

        try(BufferedReader bf= new BufferedReader(new FileReader(TEST_FILE))){
          String result= bf.readLine();
          Assertions.assertEquals(expected,result);
        }


    }
}