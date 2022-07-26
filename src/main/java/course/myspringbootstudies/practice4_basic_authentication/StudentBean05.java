package course.myspringbootstudies.practice4_basic_authentication;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name="students1")
public class StudentBean05 {

    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    private String errMsg;

    public StudentBean05() {
        this.errMsg="Student is absent";
    }

    public StudentBean05(Long id, LocalDate dob, String email, String name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate date) {
        this.dob = date;
    }

    public Integer getAge() {
        if(this.dob==null) {

            return null;}

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "StudentBean05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + dob +
                ", age=" + age +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
