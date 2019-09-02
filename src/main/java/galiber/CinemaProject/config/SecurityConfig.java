package galiber.CinemaProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfig {
	@Configuration
	@EnableWebSecurity
	public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//	    private UserService userService;

//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	        auth.userDetailsService(userService).passwordEncoder(encoder());
//	    }


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
//	                .antMatchers("/css/**", "/scripts/**", "/*", "/recipe/details/*").permitAll()
//	                .antMatchers("/recipe/**", "/category/**", "/user/**").authenticated()
//	                .antMatchers("/admin/**").hasRole("Administrator")
//	                .anyRequest().authenticated()
//	                .antMatchers("")
	                .and()
	                .formLogin().loginPage("/login").permitAll()
	                .defaultSuccessUrl("/", true)
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .and()
	                .exceptionHandling().accessDeniedPage("/error/403")
	                .and()
	                .logout().logoutSuccessUrl("/")
	                .and()
	                .csrf().disable();

	    }

	    @Bean
	    BCryptPasswordEncoder encoder(){
	        return new BCryptPasswordEncoder();
	    }

//	    @Autowired
//	    public void setUserService(UserService userService){
//	        this.userService = userService;
//	    }

	}
}