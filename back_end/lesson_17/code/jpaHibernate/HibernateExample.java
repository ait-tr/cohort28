package jpaHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Настройка конфигурации Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // создаем сотрудника

        Employee employee = new Employee("John", "IT");

        // сохраняем сотрудника в базу данных

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();

        // чтение сотрудника из базы

        session = sessionFactory.openSession();
        Employee received = session.get(Employee.class,1);
        System.out.println("Received employer: " + received);
        session.close();

        // закрыть фабрики сессий Hibernate
        sessionFactory.close();


    }
}
