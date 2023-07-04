package consultation.company;

public class Filial extends Company{

    String country; // страна

    public Filial(String name, int numOfEmployees, long profit, int yearOfBirth) {
        super(name, numOfEmployees, profit, yearOfBirth); // наследуемые поля
    }
}
