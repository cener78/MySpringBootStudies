package course.myspringbootstudies.practice3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean04Controller {

   public StudentBean04Service studentBean04Service;
    @Autowired
    public StudentBean04Controller (StudentBean04Service studentBean04Service){
        this.studentBean04Service=studentBean04Service;
    }
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean04 findStudentById(@PathVariable Long id){
       return studentBean04Service.selectStudentById(id);
    }
}
