package gr.hua.dit.ds.springmvcdemo1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder1() {
	        return new BCryptPasswordEncoder();
	    }
	     
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder1());
	         
	        return authProvider;
	    }

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
         .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
         .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
         .antMatchers("/delete/**").hasAuthority("ADMIN")
         .anyRequest().authenticated()
         .and()
         .formLogin().permitAll()
         .and()
         .logout().permitAll()
         .and()
         .exceptionHandling().accessDeniedPage("/403")
         ;
 }


	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
