package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentBean05Controller {

   public StudentBean05Service studentBean05Service;
    @Autowired
    public StudentBean05Controller(StudentBean05Service studentBean05Service){
        this.studentBean05Service=studentBean05Service;
    }
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean05 findStudentById(@PathVariable Long id){
       return studentBean05Service.selectStudentById(id);
    }


    @GetMapping(path="/selectAllStudent")
    public List<StudentBean05> getAllStudent(){
        return studentBean05Service.selectAllStudent();
    }

    @PutMapping(path="/updateStudentById/{id}")
    public StudentBean05 updateStudent(@PathVariable Long id, @RequestBody StudentBean05 newstudent){
         return studentBean05Service.updateStudentById(id,newstudent);
    }
}
