package course.myspringbootstudies.practice1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class StudentBean01Controller {

    /*
    @RequestMapping(method= RequestMethod.GET, path="/getRequest")
    @ResponseBody
    public String getMedhod1(){
        return "Get method1 was run";
    }

     */

    @GetMapping(path="/getRequest")
    public String getMedhod2(){
        return "Get method2 was run";
    }
    @GetMapping(path="/getObject")   // bu yaptigimiz aslinda tight coupling
    public StudentBean01 getObject(){
        return new StudentBean01("Cengiz",44,"001");
    }

    // loose coupling
    @Autowired
    StudentBean01 student;

    @GetMapping (path="/getObjByLoos")

        public StudentBean01 getObjByLoos(){
        student.setAge(12);
        student.setId("23");
        student.setName("metin");
        return student;
        }

        // tight coupling ...
    @GetMapping(path="/getObjByparameter/{school}")
    public StudentBean01 getObjByParameter(@PathVariable String school){
        return new StudentBean01("cengiz erdem", 44,String.format("ce19%s",school));
    }

    @GetMapping(path="/getObjList")
    public List<StudentBean01> getObjList(){
        return List.of(new StudentBean01("ali",23,"wer"),(new StudentBean01("ali",23,"wer")));
    }

    @Autowired
    StudentBean01 student2;
    @Autowired
    StudentBean02 student3;
    @GetMapping(path="/getStudy")
    public String getStudy(){
        return student2.study();
    }
    @Autowired
            @Qualifier(value="studentBean01")
    StudentInterface studentInterface;
    @GetMapping(path="getStudy1")
    public String getStudy02(){
        return studentInterface.study();
    }

}
