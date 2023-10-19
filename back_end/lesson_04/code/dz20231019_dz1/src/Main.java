/*
a)


b)

c)  Дан список Person {name, age}. Написать метод, который вернет Map/<Boolean, List/<Person>>, где ключ false - если Person моложе 18 лет, true - если уже есть 18. Значение, список соответствующих персон
    Подсказка: обратите внимание на коллектор Сollectors.partitioningBy().

Чуть сложнее:

d)

 */

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Jack", 10),  // Jack 1
                new Person("John", 20),   // John 1
                new Person("Ann", 10),   // Ann 1
                new Person("Nick", 25),
                new Person("Ann", 23)   // Ann  put(get(Ann)+1)   2
        );
        System.out.println(mapPersonsByAge(people));
        System.out.println("------- 2 ---------");
        System.out.println(countingNames(people));
        System.out.println("------- 3 ---------");
        System.out.println(mapSplitByAge(people, 18));
        System.out.println("------- 4 ---------");
        System.out.println(mapNamesByAge(people));

    }

    /*
    Дан список Person {name, age}. Написать метод, который вернет Map/<Integer,List/<Person>>, где ключ это возраст, значение - лист персон.
   Подсказка: обратите внимание на коллектор .).
     */
    public static Map<Integer, List<Person>> mapPersonsByAge(List<Person> list){
        //return list.stream().collect(Collectors.groupingBy(p -> p.getAge()));
        return list.stream().collect(Collectors.groupingBy(Person::getAge));

    }


    /*
    Дан список Person {name, age}. Написать метод, который вернет Map/<String, Integer>, где ключ это имя, значение сколько раз встретилось это имя.
    Подсказка: обратите внимание на коллектор Сollectors.toMap().
     */
    public static  Map<String,Integer> countingNames(List<Person> list){
        return list.stream().collect(Collectors.toMap(Person::getName, p->1, Integer::sum  ));
        //list.stream().collect(Collectors.toMap(Person::getName, p->1, (v1,v2)->v1+v2  ));
        //list.stream().collect(Collectors.toMap(Person::getName, p->1, (v1,v2)->v1+1  ));



        /*
           ann 3   // (3,1) -> 3+1->4
           jack 1  //  (1,1) -> 2
           nick 1
         */
    }

    /*
    Дан список Person {name, age}. Написать метод, который вернет Map/<Boolean, List/<Person>>, где ключ false - если Person моложе 18 лет, true - если уже есть 18. Значение, список соответствующих персон
    Подсказка: обратите внимание на коллектор Сollectors.partitioningBy().
     */
    public static Map<Boolean, List<Person>> mapSplitByAge(List<Person> list, int age){
        return  list.stream().collect(Collectors.partitioningBy(p->p.getAge()>age));
    }

    /*
    Дан список Person {name, age}. Написать метод, который вернет Map/<Integer,List/<String>>, где ключ это возраст, значение - лист строк-имен персонов.
   Подсказка: задача очень похожа на пункт a), на в качестве значений используется не лмст из Person, а лист ищ строк с именами. Т.е. решение как пункт a), но Сollectors.groupingBy() вызываем с
   дополнительным параметром - коллектором Mapping
     */

    public static Map<Integer, List<String>> mapNamesByAge(List<Person> list){
        //return list.stream().collect(Collectors.groupingBy(p -> p.getAge()));
        return list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.toList())));
    }
    //{20=[John], 23=[Ann], 25=[Nick], 10=[Jack , Ann ]}
}

