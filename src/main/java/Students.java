
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "students")

public class Students implements Serializable {

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



        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_name", referencedColumnName = "name", nullable = false,
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

    public void setSubscriptions(Set<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setPurchaseLists(Set<PurchaseList> purchaseLists) {
        this.purchaseLists = purchaseLists;
    }

    public void setPurchaseList(Set<PurchaseList> purchaseList) {
        this.purchaseList = purchaseList;
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
