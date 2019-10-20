import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "purchaselist")
@org.hibernate.annotations.Immutable

public class PurchaseList {

    @EmbeddedId
    protected IdPur idPur = new IdPur();

    @Column(name = "subscription_date", updatable = false)
    @NotNull
    protected Timestamp subscriptionDate;

    @Column(name = "price", updatable = false)
    @NotNull
    protected int price;

    public PurchaseList() {
    }

    public IdPur getIdPur() {
        return idPur;
    }

    public void setIdPur(IdPur idPur) {
        this.idPur = idPur;
    }

    public Timestamp getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Embeddable
    public static class IdPur implements Serializable {
        protected String student_name;
        protected String course_name;

        protected IdPur() {
        }

        public IdPur(String student_name, String course_name) {
            this.student_name = student_name;
            this.course_name = course_name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdPur idPur = (IdPur) o;
            if (!course_name.equals(idPur.course_name)) return false;
            if (!student_name.equals(idPur.student_name)) return false;
            return true;
        }
        @Override
        public int hashCode() {
            int result = student_name.hashCode();
            result = 31 * result + course_name.hashCode();
            return result;
        }
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_name", referencedColumnName = "name", insertable=false, updatable=false)
    @NotNull
    protected Students students;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_name", referencedColumnName = "name", insertable=false, updatable=false)
    @NotNull
    protected Course course;



    public Students getStudentsPur() {
        return students;
    }

    public void setStudentsPur(Students studentsPur) {
        this.students = studentsPur;
    }

    public Course getCoursePur() {
        return course;
    }

    public void setCoursePur(Course coursePur) {
        this.course = coursePur;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}




