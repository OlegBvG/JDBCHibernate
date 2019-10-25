import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "subscriptionsext")
public class SubscriptionsExt implements Serializable {

        @Id
//        @GeneratedValue(generator = "ID_GENERATOR")

        public Integer id;
        public Integer studentId;
        public String student;
        public Integer courseId;
        public String course;
        public Timestamp subscriptionDate;

        public SubscriptionsExt() {
        }

        public SubscriptionsExt(Integer studentId, String student, Integer courseId, String course, Timestamp subscriptionDate) {
                this.studentId = studentId;
                this.student = student;
                this.courseId = courseId;
                this.course = course;
                this.subscriptionDate = subscriptionDate;
        }

        public SubscriptionsExt(Integer studentId, String student, Integer courseId, String course, Timestamp subscriptionDate, Integer id) {
                        this.studentId = studentId;
                        this.student = student;
                        this.courseId = courseId;
                        this.course = course;
                        this.subscriptionDate = subscriptionDate;
                        this.id = id;

        }

        public SubscriptionsExt(Integer integer, String s, Integer integer1, String s1) {
                this.studentId = integer;
                this.student = s;
                this.courseId = integer1;
                this.course = s1;
        }

        public Integer getStudentId() {
                return studentId;
        }

        public void setStudentId(Integer studentId) {
                this.studentId = studentId;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getStudent() {
                return student;
        }

        public void setStudent(String student) {
                this.student = student;
        }

        public Integer getCourseId() {
                return courseId;
        }

        public void setCourseId(Integer courseId) {
                this.courseId = courseId;
        }

        public String getCourse() {
                return course;
        }

        public void setCourse(String course) {
                this.course = course;
        }

        public Timestamp getSubscriptionDate() {
                return subscriptionDate;
        }

        public void setSubscriptionDate(Timestamp subscriptionDate) {
                this.subscriptionDate = subscriptionDate;
        }

        @Override
        public String toString() {
                return "SubscriptionsExt{" +
                        "studentId=" + studentId +
                        ", student='" + student + '\'' +
                        ", courseId=" + courseId +
                        ", course='" + course + '\'' +
                        '}';
        }
}
