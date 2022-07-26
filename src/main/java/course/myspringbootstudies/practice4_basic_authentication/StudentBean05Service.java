package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBean05Service {

    private StudentBean05Repository studentBean05Repository;
    @Autowired
    public StudentBean05Service(StudentBean05Repository studentBean05Repository){
        this.studentBean05Repository=studentBean05Repository;
    }
    public StudentBean05 selectStudentById(Long id){

        if(studentBean05Repository.findById(id).isPresent()){
            return studentBean05Repository.findById(id).get();
        }
        return new StudentBean05();

    }

    public List<StudentBean05> selectAllStudent(){
       return studentBean05Repository.findAll();

    }

    public StudentBean05 updateStudentById(Long id, StudentBean05 newStudent){
        StudentBean05 oldStudent=studentBean05Repository.findById(id).orElseThrow(()->new IllegalArgumentException(" the student can not found"));
        if(newStudent.getName()==null){
           oldStudent.setName(oldStudent.getName());
        } else
            oldStudent.setName(newStudent.getName());

        if(newStudent.getEmail()==null){
            oldStudent.setEmail(oldStudent.getEmail());
        } else
            oldStudent.setEmail(newStudent.getEmail());
        if(newStudent.getDob()==null){
            oldStudent.setDob(oldStudent.getDob());
        } else oldStudent.setDob(newStudent.getDob());

        return studentBean05Repository.save(oldStudent);
    }


}
