
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "students")

public class Students {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private int age;

        @Column(name =  "registration_date")
        private java.sql.Timestamp registrationDate;

        @OneToMany(mappedBy = "students")
        protected Set<Subscriptions> subscriptions = new HashSet<>();

        @OneToMany(mappedBy = "students")
        protected Set<PurchaseList> purchaseLists = new HashSet<>();



        @OneToMany
    @JoinColumn(name = "student_name", nullable = false,
            insertable = false, updatable = false)
        protected Set<PurchaseList> purchaseList = new HashSet<>();

    public Students() {
    }


    public Long getId() {
        return Long.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public Set<PurchaseList> getPurchaseLists() {
        return purchaseLists;
    }

    public Set<PurchaseList> getPurchaseList() {
        return purchaseList;
    }

    @Override
    public String toString() {
        return "Студент: {" +
                "Регистрационный номер " + id +
                ", ФИО '" + name + '\'' +
                ", возраст " + age +
                ", дата регистрации " + registrationDate +
                '}';
    }
}
