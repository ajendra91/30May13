package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurity extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/").permitAll();

        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/mylogin")
                .loginProcessingUrl("/log").usernameParameter("name")
                .passwordParameter("pass").defaultSuccessUrl("/").permitAll();

        http.authorizeRequests().and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll();

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accesserror");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("super").password("super").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");

    }

    @Bean
    public NoOpPasswordEncoder fun() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}




