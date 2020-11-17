package com.cg.go.greatoutdoor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("naresh").password("1234").roles("ADMIN").and()
        .withUser("aravind").password("1234").roles("ADMIN").and()
        .withUser("vidya").password("1234").roles("ADMIN").and()
        .withUser("niharika").password("1234").roles("ADMIN").and()
        .withUser("uma").password("1234").roles("ADMIN").and()
        .withUser("uma user").password("1234").roles("USER").and()
        .withUser("niharika user").password("1234").roles("USER").and()
        .withUser("vidya user").password("1234").roles("USER").and()
        .withUser("aravind user").password("1234").roles("USER").and()
        .withUser("naresh user").password("1234").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().httpBasic().and().authorizeRequests().
               antMatchers("/userlogin/**").hasAnyRole("USER")
               .antMatchers("/admin/**").hasAnyRole("ADMIN")
               .and().formLogin().permitAll().
               and().logout().deleteCookies("JSESSIONID");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
	PasswordEncoder encoder= NoOpPasswordEncoder.getInstance();
       return encoder;
    }
}
