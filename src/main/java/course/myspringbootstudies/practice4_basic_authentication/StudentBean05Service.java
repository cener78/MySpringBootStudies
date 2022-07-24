package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
