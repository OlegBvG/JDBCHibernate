import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        EntityManager em = sessionFactory.createEntityManager();

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

        System.out.println("\ntable: purchaselist - СТУДЕНТ => КУРСЫ ");
        Students studentsPur = session.get(Students.class, 2);
        Set<PurchaseList> purchaseListSet = studentsPur.getPurchaseLists();
        System.out.println(studentsPur);
        System.out.println(purchaseListSet.size());
        for (PurchaseList purchaseList : purchaseListSet){
            System.out.println(purchaseList.getCoursePur().getName());
        }

        System.out.println("\ntable: purchaselist - КУРС => СТУДЕНТЫ");
        Course coursePur = session.get(Course.class, 2);
        Set<PurchaseList> purchaseListSet1 = coursePur.getPurchaseLists();
        System.out.println("КУРС: " + coursePur.getName());
        System.out.println("КУРС: " );
        for (PurchaseList purchaseList : purchaseListSet1){
            System.out.println(purchaseList.getStudentsPur());
        }

        System.out.println(" \nПолучим purchaseList по Id ");
        PurchaseList.IdPur id = new PurchaseList.IdPur("Фуриков Эрнст", "Мобильный разработчик с нуля");
        PurchaseList purchaseList = session.get(PurchaseList.class, id);
        System.out.println("Курс: " + purchaseList.getCoursePur().getName() + "; Студент: " + purchaseList.getStudentsPur());
        System.out.println("Курс: " + id.course_name + "; Студент: " + id.student_name);

//        create table if not exist subscriptionsext (id integer not null, course varchar(255), courseId integer, student varchar(255), studentId integer, subscriptionDate datetime, primary key (id)) engine=MyISAM

        org.hibernate.SQLQuery query = session.createSQLQuery(
                " SELECT  s.id as studentId, s.name as student, c.id as courseId, c.name as course, p.subscription_date as subscriptionDate " +
                        "FROM purchaselist p, students s, courses c  where  p.student_name=s.name and p.course_name=c.name"
        );

        List<Object[]> result =  query.list();
        System.out.println("\n Количество записей в purchaselist: " + result.size());
        Integer idd = 1;

        Transaction transaction = session.beginTransaction();

        for (Object[] tuple : result) {
            System.out.println(tuple[0] + " - " + tuple[1] + " - " + tuple[2] + " - " + tuple[3] + " - " + tuple[4]);

            session.saveOrUpdate("subscriptionsext", new SubscriptionsExt( (Integer) tuple[0] , (String) tuple[1] , (Integer) tuple[2] , (String) tuple[3], (Timestamp) tuple[4], idd++));
//            session.saveOrUpdate("subscriptionsext", new SubscriptionsExt( (Integer) tuple[0] , (String) tuple[1] , (Integer) tuple[2] , (String) tuple[3], (Timestamp) tuple[4]));
        }
        transaction.commit();

    sessionFactory.close();

    }
}

