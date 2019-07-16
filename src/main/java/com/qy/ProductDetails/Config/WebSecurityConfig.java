package com.qy.ProductDetails.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
    UserDetailsService userDetailsService;
    
	private LogoutSuccessHandler LogoutSuccessHandler;
	
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("ashu").password(bCryptPasswordEncoder().encode("user1Pass")).roles("Buyer")
          .and()
          .withUser("abhitesh").password(bCryptPasswordEncoder().encode("user2Pass")).roles("Saler")
          .and()
          .withUser("admin").password(bCryptPasswordEncoder().encode("adminPass")).roles("admin");
        
    }
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
        	.authorizeRequests()
        	.antMatchers("/productRegistration").permitAll()
        	.antMatchers("/productInfo/**").permitAll()
           	.antMatchers("/deleteProduct/**").permitAll()
        	.antMatchers("/admin/**").hasRole("admin")
        	.antMatchers("/","/Buyer/**").permitAll()
        	.antMatchers("/Saler").hasRole("Saler")
        	.antMatchers("/login*").permitAll()
        	.antMatchers("/registerUser/{category}").permitAll()
        	.anyRequest().authenticated()
        	.and()
        	.logout()
        	.permitAll();
    }

	private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl antMatchers(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    }
