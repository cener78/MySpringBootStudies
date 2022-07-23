package course.myspringbootstudies.practice3;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentBean04Config {
    @Bean // is used if method create object
    CommandLineRunner commandLineRunner (StudentBean04Repository studentBean04Repository){

       return args->studentBean04Repository.saveAll(List.of(
               new StudentBean04(110L, LocalDate.of(2012,11,23),"vej@sa.com","murtaza"),
               new StudentBean04(120L, LocalDate.of(2010,11,23),"ej@sa.nl","kamil")


       ));
    }


}
