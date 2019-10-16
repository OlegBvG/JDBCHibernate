import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        System.out.println("\ntable: course");
        Course course = session.get(Course.class, 1);
        System.out.println("Наименование курса " + course.getName());
        System.out.println("ФИО учителя " + course.getTeacher().getName());


        System.out.println("\ntable: students");
        Students students = session.get(Students.class, 1);
        System.out.println(students.getName());
        System.out.println(students);
        System.out.println(session.get(Students.class, 3));

        System.out.println("\ntable: teacher");
        System.out.println("Учитель: " + session.get(Teacher.class, 1).getName());

        System.out.println("\ntable: subsriptions - КУРС => СТУДЕНТЫ");
        Course course1 = session.get(Course.class, 1);
        Set<Subscriptions> subscriptionsSet = course1.getSubscriptions();
        System.out.println("КУРС: " + course1.getName());
        for (Subscriptions subscriptions : subscriptionsSet){
            System.out.println(subscriptions.students);
        }

        System.out.println("\ntable: subsriptions -  СТУДЕНТ => КУРСЫ ");
        Students students1 = session.get(Students.class, 1);
        Set<Subscriptions> subscriptionsSetStudent = students1.getSubscriptions();
        System.out.println(students1);
        for (Subscriptions subscriptions : subscriptionsSetStudent){
            System.out.println(subscriptions.course.getName());
        }

    sessionFactory.close();

    }

}
