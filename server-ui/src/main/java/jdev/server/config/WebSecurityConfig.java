package jdev.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/css","/img").permitAll()
                .antMatchers("/home","/hello").authenticated()
                .antMatchers("/routes/**", "/payments/**").hasAnyRole("CLIENT","MANAGER","ROOT")
                .antMatchers("/registerClient/**").hasAnyRole("MANAGER","ROOT")
                .antMatchers("/**").hasRole("ROOT")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("User").password("user").roles("CLIENT")
                .and()
                .withUser("Manager").password("manager").roles("MANAGER")
                .and()
                .withUser("Admin").password("root").roles("ROOT");
    }

}







