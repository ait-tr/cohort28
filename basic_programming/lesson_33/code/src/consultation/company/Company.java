package consultation.company;

import java.util.Objects;

public class Company implements Comparable<Company>{
    // fields (поля), состояние объекта
    String name; // название компании, сортировка по алфавиту
    int numOfEmployees; // кол-во сотрудников, сортировка по числам от меньшего к большему (стандартно)
    long profit; // годовая прибыль, сортировка по числам от меньшего к большему (стандартно)
    int yearOfBirth; // год основания компании, сортировка по числам от меньшего к большему (стандартно)

    // methods (методы), поведение или изменения объектов

    public Company(String name, int numOfEmployees, long profit, int yearOfBirth) {
        this.name = name;
        this.numOfEmployees = numOfEmployees;
        this.profit = profit;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Company name= " + name + ", numOfEmployees= " + numOfEmployees + ", profit=" + profit + ", yearOfBirth=" + yearOfBirth;
    }

    @Override
    public boolean equals(Object o) { // сравниваем текущий объект this с Object o
        if (this == o) return true; // если это сам тот же объект, то вернули true
        if (o == null || getClass() != o.getClass()) return false; // если сравнили с null или объектом из другого класса, то вернули false
        Company company = (Company) o; // присланный для сравнения объект мы "кастим" до нашего класса
        // логическое выражение, которое проверяет совпадение полей
        return numOfEmployees == company.numOfEmployees && profit == company.profit && yearOfBirth == company.yearOfBirth && Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numOfEmployees, profit, yearOfBirth);
    }

    @Override
    public int compareTo(Company o) {
       // return this.numOfEmployees - o.numOfEmployees; // сравниваем по количеству сотрудников, у кого меньше будет раньше в массиве

        return (int) (- this.profit + o.profit);
    }
}
