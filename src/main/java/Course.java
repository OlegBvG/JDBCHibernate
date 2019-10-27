
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")

public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    @Column(name =  "price_per_hour")
    private float pricePerHour;
    @Column(name =  "students_count")
    private int studentsCount;
    @Column(name =  "teacher_id")
    private int teacherId;

//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "enum")
//    private CourseType type;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DESIGN', 'PROGRAMMING', 'MARKETING', 'MANAGEMENT', 'BUSINESS')")
    private CourseType type;

    private String description;
    private int duration;

    @OneToMany(mappedBy = "course")
    protected Set<Subscriptions> subscriptions = new HashSet<>();

    @OneToMany(mappedBy = "course")
    protected Set<PurchaseList> purchaseLists = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id",referencedColumnName="id", insertable=false, updatable=false)
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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


}
