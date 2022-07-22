package course.myspringbootstudies.practice2;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Studentbean03Service {

    List<StudentBean03>studentlist=List.of(new StudentBean03(1,"zeki","ce@as)", LocalDate.of(2012,12,23)));
public StudentBean03 getStudentById(int id){

    if(studentlist.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()){
        return new StudentBean03();
    }
    return studentlist.stream().filter(t->t.getId()==id).findFirst().get();
}
public List<StudentBean03> getAllStudent(){
    return studentlist;
}

}
