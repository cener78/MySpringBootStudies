package course.myspringbootstudies.practice4_basic_authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentBean05Repository extends JpaRepository<StudentBean05,Long> {

    Optional<StudentBean05> findByEmail(String email);
}
