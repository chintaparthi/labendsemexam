package exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        insertClients();
        printAllClients();
    }

    // Insert records
    private static void insertClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Client client1 = new Client();
        client1.setName("Alice");
        client1.setGender("Female");
        client1.setAge(28);
        client1.setLocation("New York");
        client1.setEmail("alice@example.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Bob");
        client2.setGender("Male");
        client2.setAge(32);
        client2.setLocation("Los Angeles");
        client2.setEmail("bob@example.com");
        client2.setMobileNumber("9876543210");

        session.persist(client1);
        session.persist(client2);

        transaction.commit();
        session.close();
        System.out.println("Clients inserted successfully!");
    }

    // Print all records
    private static void printAllClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "FROM Client";
        Query<Client> query = session.createQuery(hql, Client.class);
        List<Client> clients = query.getResultList();

        for (Client client : clients) {
            System.out.println(client);
        }

        session.close();
    }
}
