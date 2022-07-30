package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentBean05Controller {

   public StudentBean05Service studentBean05Service;
    @Autowired
    public StudentBean05Controller(StudentBean05Service studentBean05Service){
        this.studentBean05Service=studentBean05Service;
    }
    @GetMapping(path = "/selectStudentById/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT')")
    public StudentBean05 findStudentById(@PathVariable Long id){
       return studentBean05Service.selectStudentById(id);
    }


    @GetMapping(path="/selectAllStudent")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")// depend on role
    public List<StudentBean05> getAllStudent(){
        return studentBean05Service.selectAllStudent();
    }


    @PutMapping(path="/updateStudentById/{id}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public StudentBean05 updateStudent(@PathVariable Long id, @Validated @RequestBody StudentBean05 newstudent){
         return studentBean05Service.updateStudentById(id,newstudent);
    }

    @DeleteMapping(path="/deleteStudentById/{id}")
    @PreAuthorize("hasAnyAuthority('student:write')") //depend on permission
    public String removeStudentById(@PathVariable Long id){

        return studentBean05Service.deleteStudentById(id);

    }

    @PatchMapping(path="/patchStudentById/{id}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public StudentBean05 patchStudent(@PathVariable Long id,@Validated @RequestBody StudentBean05 newstudent){
        return studentBean05Service.patchStudentById(id,newstudent);
    }

    @PostMapping(path="/addStudent")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public StudentBean05 newStudent(@Validated  @RequestBody StudentBean05 newstudent) throws SQLException, ClassNotFoundException {
       return studentBean05Service.addStudent(newstudent);
    }
}
