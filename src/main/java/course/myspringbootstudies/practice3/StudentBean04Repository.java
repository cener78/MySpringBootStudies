package course.myspringbootstudies.practice3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentBean04Repository extends JpaRepository<StudentBean04 ,Long> {

    Optional<StudentBean04> findByEmail(String email);
}
