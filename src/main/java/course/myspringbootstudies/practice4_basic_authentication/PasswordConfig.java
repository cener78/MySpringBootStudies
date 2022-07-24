package course.myspringbootstudies.practice4_basic_authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

  @Bean
    public PasswordEncoder passSifrele(){
        return new BCryptPasswordEncoder(10
        );
    }



}
