package ait.citizens.dao;

import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator = (p1, p2) -> {
        int res = p1.getLastName().compareTo(p2.getLastName());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };
    private static Comparator<Person> ageComparator = (p1,p2) -> {
            int res = Integer.compare(p1.getAge(), p2.getAge());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        for (Person person : citizens) {
            add(person);
        }
    }

    //O(n)
    @Override
    public boolean add(Person person) {
        if (person == null) {
            return false;
        }
        int index = Collections.binarySearch(idList, person);
        if (index >= 0) {
            return false;
        }
        index = -index - 1;
        idList.add(index, person);
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index >= 0 ? index : -index - 1;
        ageList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index >= 0 ? index : -index - 1;
        lastNameList.add(index, person);
        return true;
    }

    //O(n)
    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if(victim == null){
            return false;
        }
        idList.remove(victim);
        lastNameList.remove(victim);
        ageList.remove(victim);
        return true;
    }

    //O(log(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, null, null, null);
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index);
    }

    //O(log(n)
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person pattern = new Person(Integer.MIN_VALUE, null, null, now.minusYears(minAge));
        int from = -Collections.binarySearch(ageList, pattern, ageComparator) -1;
        pattern = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
        int to = -Collections.binarySearch(ageList, pattern, ageComparator) -1;
        return ageList.subList(from, to);
    }

   //O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person pattern =  new Person(Integer.MIN_VALUE, null, lastName, null);
        int from = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) -1;
        pattern =  new Person(Integer.MAX_VALUE, null, lastName, null);
        int to = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) -1;
        return lastNameList.subList(from, to);
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    //O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    //O(1)
    @Override
    public int size() {
        return idList.size();
    }
}
