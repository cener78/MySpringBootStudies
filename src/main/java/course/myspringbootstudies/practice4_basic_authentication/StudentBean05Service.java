package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentBean05Service {

    private StudentBean05Repository studentBean05Repository;

    @Autowired
    public StudentBean05Service(StudentBean05Repository studentBean05Repository) {
        this.studentBean05Repository = studentBean05Repository;
    }

    public StudentBean05 selectStudentById(Long id) {

        if (studentBean05Repository.findById(id).isPresent()) {
            return studentBean05Repository.findById(id).get();
        }
        return new StudentBean05();

    }

    public List<StudentBean05> selectAllStudent() {
        return studentBean05Repository.findAll();

    }

    public StudentBean05 updateStudentById(Long id, StudentBean05 newStudent) {
        StudentBean05 oldStudent = studentBean05Repository.findById(id).orElseThrow(() -> new IllegalArgumentException(" the student can not found"));

        if (newStudent.getName() == null) {
            oldStudent.setName(oldStudent.getName());
        } else
            oldStudent.setName(newStudent.getName());

        if (newStudent.getEmail() == null) {
            oldStudent.setEmail(oldStudent.getEmail());
        } else
            oldStudent.setEmail(newStudent.getEmail());
        if (newStudent.getDob() == null) {
            oldStudent.setDob(oldStudent.getDob());
        } else oldStudent.setDob(newStudent.getDob());

        return studentBean05Repository.save(oldStudent);
    }

    public String deleteStudentById(Long id) {
        if (!studentBean05Repository.existsById(id)) {
            throw new IllegalStateException("Student was not found");
        }
        studentBean05Repository.deleteById(id);
        return "The student who has" + id + " id was removed";
    }

    public StudentBean05 patchStudentById(Long id, StudentBean05 newstudent) {
        StudentBean05 existingStudent = studentBean05Repository.findById(id).orElseThrow(() -> new IllegalMonitorStateException("the student cannot found"));
        if (newstudent.getName() == null) {
            existingStudent.setName(existingStudent.getName());
        } else
            existingStudent.setName(newstudent.getName());

        if (newstudent.getEmail() == null) {
            existingStudent.setEmail(existingStudent.getEmail());
        } else
            existingStudent.setEmail(newstudent.getEmail());
        if (newstudent.getDob() == null) {
            existingStudent.setDob(existingStudent.getDob());
        } else existingStudent.setDob(newstudent.getDob());

        return studentBean05Repository.save(existingStudent);
    }

    public StudentBean05 addStudent(StudentBean05 newstudent) throws ClassNotFoundException, SQLException {


        Optional<StudentBean05> existingStudent = studentBean05Repository.findByEmail(newstudent.getEmail());
        if (existingStudent.isPresent()) {
            throw new IllegalStateException("the student is already exist");

        }

        if (newstudent.getName() == null) {
            throw new IllegalStateException(" no name was found");
        }


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "?");
        Statement st = con.createStatement();


        String sqlQueryForMaxId = "select max(id) from students1";
        ResultSet result = st.executeQuery(sqlQueryForMaxId);
        Long maxId = 0l;

        while (result.next()) {
            maxId = result.getLong(1);
        }
        newstudent.setId(maxId + 1);
        newstudent.setAge(newstudent.getAge());
        newstudent.setErrMsg(null);

        return studentBean05Repository.save(newstudent);
    }


}
