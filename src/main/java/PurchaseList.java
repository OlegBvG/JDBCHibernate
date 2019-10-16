import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Embeddable
@Table(name = "purchaselist")

public class PurchaseList {
    @Id
    @ManyToOne
    @JoinColumn(
            name = "student_name",
            insertable = false, updatable = false)
    @NotNull

    protected String studentName;

    @Column(name =  "course_name")
    protected String courseName;

    @Column(name =  "price")
    protected int price;

    @Column(name =  "subscription_date")
    @Temporal(value= TemporalType.TIMESTAMP)
    protected Date subscriptionDate;

    public PurchaseList() {
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
