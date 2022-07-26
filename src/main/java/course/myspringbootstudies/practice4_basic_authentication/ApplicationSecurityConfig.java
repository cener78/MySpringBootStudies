package course.myspringbootstudies.practice4_basic_authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordConfig passEncode;


    @Autowired
    public ApplicationSecurityConfig(PasswordConfig passEncode){
    this.passEncode = passEncode;
}




    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable() // for put,delete ,patch post method if we dont use this method spring security dont allow to us put,delete etc
               .authorizeRequests()// her request icin yetki sorgula
               .antMatchers("/","/Index","/css/*","/js/*").permitAll()// bu methodda belirtilenlere izin ver
               // free page nasil yapilir
               .anyRequest() //herhangibir istek
               .authenticated()// dogrulamadan gecenler
               .and()
               .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails student= User.builder().username("c").password(passEncode.passSifrele().encode("2222")).roles("STUDENT").build();
        UserDetails teacher= User.builder().username("e").password(passEncode.passSifrele().encode("3333")).roles("TEACHER").build();
        UserDetails manager= User.builder().username("z").password(passEncode.passSifrele().encode("4444")).roles("MANAGER").build();
        UserDetails boss= User.builder().username("m").password(passEncode.passSifrele().encode("5555")).roles("BOSS").build();
        return new InMemoryUserDetailsManager(student,teacher,manager,boss);
    }
}
