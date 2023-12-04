package compareJavaObjects.doubleComparing;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        String nameFirstPerson = person1.getName();
        String nameSecondPerson = person2.getName();
        return nameFirstPerson.compareTo(nameSecondPerson);
    }
}
