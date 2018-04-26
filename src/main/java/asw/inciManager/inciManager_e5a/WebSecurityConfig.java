package asw.inciManager.inciManager_e5a;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		.csrf().disable() 
		.authorizeRequests() 
		.antMatchers("/css/**", "/img/**", "/script/**", "/", "/signup","/userlogin/**").permitAll()
		.antMatchers("/mark/add").hasAuthority("ROLE_PROFESOR")
		.antMatchers("/mark/edit/*").hasAuthority("ROLE_PROFESOR")
		.antMatchers("/mark/delete/*").hasAuthority("ROLE_PROFESOR")
		.antMatchers("/mark/**").hasAnyAuthority("ROLE_STUDENT","ROLE_PROFESOR","ROLE_ADMIN")
		.antMatchers("/user/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/userlogin").permitAll()
		.anyRequest().authenticated() 
		.and() 
		//.formLogin() 
		//.loginPage("/userlogin").permitAll().defaultSuccessUrl("/")
		//.and()
		.logout()
		.permitAll();
	}
}