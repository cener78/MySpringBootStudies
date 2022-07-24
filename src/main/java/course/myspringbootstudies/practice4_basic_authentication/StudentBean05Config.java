package course.myspringbootstudies.practice4_basic_authentication;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentBean05Config {
    @Bean // is used if method create object
    CommandLineRunner commandLineRunner (StudentBean05Repository studentBean05Repository){

       return args->studentBean05Repository.saveAll(List.of(
               new StudentBean05(110L, LocalDate.of(2012,11,23),"vej@sa.com","murtaza"),
               new StudentBean05(120L, LocalDate.of(2010,11,23),"ej@sa.nl","kamil")


       ));
    }


}
