package it.uniroma3.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)

		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT username,password,1 FROM utente where username=?")
		.authoritiesByUsernameQuery("SELECT username,role FROM utente where username=?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		//		.antMatchers("/", "/login", "/registrationform", "/listautenti").permitAll()
			.antMatchers("/autoreform", "/listautenti", "/operaform", "/user", "/cancellaopera", "/cancellaautore").access("hasAuthority('ADMIN')")
			.antMatchers("/home","/autore","/listaautori", "/listaopere","/opera").access("hasAuthority('USER') or hasAuthority('ADMIN')")
			.anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/loginok")
			.permitAll()
			.failureUrl("/login?error")
			.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/logoutok")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
		.sessionManagement()
			.maximumSessions(1)
			.expiredUrl("/login?expired");
			
	}
}