package course.myspringbootstudies.practice3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean04Service {

    private StudentBean04Repository studentBean04Repository;
    @Autowired
    public StudentBean04Service(StudentBean04Repository studentBean04Repository){
        this.studentBean04Repository=studentBean04Repository;
    }
    public StudentBean04 selectStudentById(Long id){

        if(studentBean04Repository.findById(id).isPresent()){
            return studentBean04Repository.findById(id).get();
        }
        return new StudentBean04();

    }


}
