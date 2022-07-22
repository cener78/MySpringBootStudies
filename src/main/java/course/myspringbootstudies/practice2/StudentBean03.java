package course.myspringbootstudies.practice2;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class StudentBean03 {
    private int id;
    private String name;
    private String email;
    private LocalDate date;
    private Integer age;
    private String errMsg;

    public StudentBean03() {
        this.errMsg="Student is absent";
    }

    public StudentBean03(int id, String name, String email, LocalDate date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAge() {
        if(this.date==null) {

            return null;}

        return Period.between(this.date, LocalDate.now()).getYears();
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
        return "StudentBean03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", age=" + age +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
