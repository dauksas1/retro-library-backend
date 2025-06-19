package lt.retrolibrary.backend;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lt.retrolibrary.backend.jwtsecurity.JwtUtils;
import lt.retrolibrary.backend.user.Role;
import lt.retrolibrary.backend.user.UserEntity;
import lt.retrolibrary.backend.user.UserRepository;

@Configuration
public class InitConfig {
	
	private final JwtUtils jwtUtils;
	private final UserRepository userRepository;
	
	
	public InitConfig(UserRepository userRepository, JwtUtils jwtUtils) {
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
	}
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                .allowedOrigins("http://localhost:5173")
	                .allowedMethods("*")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	        }
	    };
	}



	
	@Bean
	CommandLineRunner init(PasswordEncoder encoder) {
		return args -> {
			if(userRepository.findByusername("alice").isEmpty()) {
				UserEntity userEntity = new UserEntity(	null, 
														"alice", 
														Role.ADMIN , 
														true, "AliceAlice", 
														encoder.encode("pass1234"), 
														"email@email.com");
				userRepository.save(userEntity);
			}
		};
	}
	
}
