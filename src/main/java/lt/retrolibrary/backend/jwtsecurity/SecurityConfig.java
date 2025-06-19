package lt.retrolibrary.backend.jwtsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lt.retrolibrary.backend.user.Role;

@Configuration
public class SecurityConfig {
	
	private final JwtRequestFilter jwtRequestFilter;
	

    SecurityConfig(JwtRequestFilter jwtRequestFilter) {
    		this.jwtRequestFilter = jwtRequestFilter;
    }
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	        		.requestMatchers("/auth/**").permitAll()
	        		.requestMatchers("/admin/**").hasRole("Admin")
	        		.requestMatchers("/manager/**").hasAnyRole("Manager","Admin")
	        		.requestMatchers("/api/user/**").hasAnyRole(Role.USER.toString(), "Manager","Admin")
	        		.anyRequest().permitAll()
	        	)
	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
	    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	}
}
