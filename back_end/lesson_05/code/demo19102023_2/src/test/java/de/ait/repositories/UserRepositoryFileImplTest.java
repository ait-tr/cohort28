package de.ait.repositories;


import de.ait.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DisplayName("UsersRepositoryFileImpl")
class UserRepositoryFileImplTest {
    public static final String TEST_FILE = "users_test.txt";
    UserRepository repository;

    @BeforeEach
    void setUp() {
        //createDataFile(TEST_FILE,null);
        repository = new UserRepositoryFileImpl(TEST_FILE);
    }

    @AfterEach
    void tearDown() {
        deleteFile(TEST_FILE);
    }

    private static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()){
            boolean isDeleted=file.delete();
            if(!isDeleted){
                throw new IllegalStateException("Unable to delete" + file);
            }
        }
    }
    private void createDataFile(String fileName, List<String> data) {
        deleteFile(fileName);
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fileName))) {
            if(data==null|| data.isEmpty()){
                return;
            }
            for(String line:data) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e){
            throw new IllegalStateException("Unable to create file with data" + fileName);
        }
    }

    /**
     * Generate list of Users with
     *  name: "jack[index]"  (jack1,jack2, jack3 etc)
     *  email: "jack[index]@mail.com"
     *  id: if withID is true id = index else id = null
     *
     * @param startIndex
     * @param qty
     * @return List of Users
     */
    private List<User> generateUsers(int startIndex, int qty, boolean withID){
        return IntStream.range(startIndex,startIndex+qty)
                .mapToObj(i -> {
                    String name = "jack" + i, mail = name + "@mail.com";
                    return new User(withID?Long.valueOf(i):null,name, mail);
                })
                .collect(Collectors.toList());
    }

    private List<String> generateRecordStrings(int startIndex, int qty){
        return IntStream.range(startIndex, startIndex+qty)
                .mapToObj(index->String.format("%d;jack%d;jack%d@mail.com",index,index,index))
                .collect(Collectors.toList());
    }






    @Nested
    @DisplayName("test save()")
    class SaveTest {


        @Test
        @DisplayName("save one User to not existing file")
        void save_one_user() throws Exception {

            User user = new User("jack", "jack@mail.com");
            String expected = "1;jack;jack@mail.com";

            repository.save(user);

            try (BufferedReader bf = new BufferedReader(new FileReader(TEST_FILE))) {
                String result = bf.readLine();
                Assertions.assertEquals(expected, result);
            }
        }

        @Test
        @DisplayName("save several Users to not existing file")
        void save_several_records() throws Exception {
            int recordsQty = 4;
            List<User> users = generateUsers(1,recordsQty,false);
            List<String> expected = generateRecordStrings(1,recordsQty);

            users.forEach(user->repository.save(user));

            try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
                List<String> result = br.lines().collect(Collectors.toList());
                Assertions.assertEquals(expected, result);
            }
        }

        @ValueSource(ints = {1,10,10000,100000})
        @ParameterizedTest(name="save {0} users")
        @DisplayName("save several Users not existing file")
        void save_several_records2(int recordsQty) throws Exception {
            List<User> users = generateUsers(1,recordsQty,false);
            List<String> expected = generateRecordStrings(1,recordsQty);

            users.forEach(user->repository.save(user));

            try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
                List<String> result = br.lines().collect(Collectors.toList());
                Assertions.assertEquals(expected, result);
            }
        }

        @Test
        @DisplayName("append several Users to exist file")
        void save_several_records_to_existing_file() throws Exception {
            // create file with existingUser
            int existingUsers=3;
            int qtyAddedUser=4;
            List<String> dataToFile = generateRecordStrings(1,existingUsers);
            createDataFile(TEST_FILE,dataToFile);

            // init repository
            repository= new UserRepositoryFileImpl(TEST_FILE);

            List<User> users = generateUsers(existingUsers+1, qtyAddedUser,false);
            List<String> expected = generateRecordStrings(1,existingUsers+qtyAddedUser);

            users.forEach(user->repository.save(user));

            try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
                List<String> result = br.lines().collect(Collectors.toList());
                Assertions.assertEquals(expected, result);
            }
        }

    }

    @Nested
    @DisplayName("test findAll()")
    class FindAll{

        @Test
        @DisplayName("read several Users from existing file")
        public void findAll_from_regular_file(){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            List<User> expected = generateUsers(1, usersInDataFile,true);

            List<User> actual = repository.findAll();

            Assertions.assertEquals(expected,actual);
        }

        //parametrized
        @ValueSource(ints={1,10,1000,100000})
        @ParameterizedTest(name="{0} users")
        @DisplayName("findAll several Users from existing file")
        public void findAll_from_regular_file2(int usersInDataFile){
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);
            List<User> expected = generateUsers(1, usersInDataFile,true);

            List<User> actual = repository.findAll();

            Assertions.assertEquals(expected,actual);
        }


        @Test
        @DisplayName("attempt read Users from not existing file")
        public void findAll_from_not_existing_file(){
            deleteFile(TEST_FILE);

            List<User> actual = repository.findAll();

            Assertions.assertTrue(actual.isEmpty());
        }
    }

    @Nested
    @DisplayName("test findByID()")
    class FindByID{
        @Test
        @DisplayName("find existing user User from existing file")
        public void findById_when_existing_user(){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            Long findID=3L;
            User actualUser = repository.findByID(findID);

            Assertions.assertEquals(findID,actualUser.getId());
        }

        //parametrized
        @ValueSource(longs={1,5,3})
        @ParameterizedTest(name="find UserID={0}")
        @DisplayName("findAll several Users from existing file")
        public void findById_when_existing_user2(Long userID){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            User actualUser = repository.findByID(userID);

            Assertions.assertEquals(userID, actualUser.getId());
        }


        @Test
        @DisplayName("when datafile not exist return_null")
        public void when_data_file_not_exist_return_null(){
            deleteFile(TEST_FILE);
            List<User> expected = Collections.EMPTY_LIST;

            User actual = repository.findByID(10L);

            Assertions.assertNull(actual);
        }

        //parametrized
        @ValueSource(longs={0,6,10})
        @ParameterizedTest(name="find UserID={0} return null")
        @DisplayName("find not existing user return null")
        public void find_not_existing_user(Long userID){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            User actualUser = repository.findByID(userID);

            Assertions.assertNull(actualUser);
        }

    }


    @Nested
    @DisplayName("test findByEmail()")
    class FindByEmail{
        @Test
        @DisplayName("find existing user User from existing file")
        public void find_existing_user_by_existing_file(){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            String findEmail="jack3@mail.com";
            User actualUser = repository.findByEmail(findEmail);

            Assertions.assertEquals(findEmail,actualUser.getEmail());
        }

        //parametrized
        @ValueSource(strings={"jack1@mail.com","jack3@mail.com","jack5@mail.com"})
        @ParameterizedTest(name="find UserEmail={0}")
        @DisplayName("find User from existing file")
        public void find_user_from_existing_file2(String userEmail){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            User actualUser = repository.findByEmail(userEmail);

            Assertions.assertEquals(userEmail, actualUser.getEmail());
        }


        @Test
        @DisplayName("when datafile not exist return_null")
        public void when_data_file_not_exist_return_null(){
            deleteFile(TEST_FILE);
            List<User> expected = Collections.EMPTY_LIST;

            User actual = repository.findByEmail("jack1@mail.com");

            Assertions.assertNull(actual);
        }

        //parametrized
        @ValueSource(strings={"jack0@mail.com","jack6@mail.com","jack10@mail.com"})
        @NullSource
        @ParameterizedTest(name="find UserID={0} return null")
        @DisplayName("when find not existing user return null")
        public void find_not_existing_user(String email){
            int usersInDataFile=5;
            List<String> dataToFile = generateRecordStrings(1, usersInDataFile);
            createDataFile(TEST_FILE,dataToFile);

            User actualUser = repository.findByEmail(email);

            Assertions.assertNull(actualUser);
        }

    }

}