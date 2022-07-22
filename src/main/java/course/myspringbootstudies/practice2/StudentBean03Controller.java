package course.myspringbootstudies.practice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentBean03Controller {


    Studentbean03Service studentbean03Service;
    @Autowired
        public StudentBean03Controller(Studentbean03Service stdService){
        this.studentbean03Service=stdService;
    }

    @GetMapping(path="/getStudentById/{id}")
    public StudentBean03 getStudentWithId(@PathVariable int id){
       return studentbean03Service.getStudentById(id) ;
    }



    @GetMapping(path="/getAllStudents")
    public List<StudentBean03> getAll(){
       return studentbean03Service.getAllStudent();
    }
}
