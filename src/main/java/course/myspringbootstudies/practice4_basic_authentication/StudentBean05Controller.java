package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
