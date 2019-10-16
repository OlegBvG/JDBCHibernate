import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "subscriptions")
@org.hibernate.annotations.Immutable

public class Subscriptions {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "student_id")
        protected Integer studentId;
        @Column(name = "course_id")
        protected Integer courseId;

        public Id() {
        }

        public Id(Integer studentId, Integer courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.studentId.equals(that.studentId)
                        && this.courseId.equals(that.courseId);
            }
            return false;
        }

        public int hashCode() {
            return studentId.hashCode() + courseId.hashCode();
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(name = "subscription_date", updatable = false)
    @NotNull
    protected Timestamp subscriptionDate;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            insertable = false, updatable = false)
    protected Students students;

    @ManyToOne
    @JoinColumn(
            name = "course_id",
            insertable = false, updatable = false)
    protected Course course;

    public Subscriptions(){}

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Timestamp getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
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




