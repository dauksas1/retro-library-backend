package lt.retrolibrary.backend.jwtsecurity;

import java.util.Optional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.retrolibrary.backend.user.Role;
import lt.retrolibrary.backend.user.UserEntity;
import lt.retrolibrary.backend.user.UserEntityDetailsService;
import lt.retrolibrary.backend.user.UserRepository;

@Service
public class AuthService {
	
	JwtUtils jwtUtils;
	UserRepository userRepository;
	AuthenticationManager authenticationManager;
	UserEntityDetailsService userEntityDetailsService;
	PasswordEncoder passwordEncoder;
	
	public AuthService(	UserRepository userRepository, 
						AuthenticationManager authenticationManager, 
						UserEntityDetailsService userEntityDetailsService,
						JwtUtils jwtUtils,
						PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userEntityDetailsService = userEntityDetailsService;
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
		this.passwordEncoder = passwordEncoder;
	}



	public void signUp(SignUpRequest signUpRequest) {
		UserEntity userEntity = new UserEntity(null,
							signUpRequest.username(), 
							Role.USER, 
							true, 
							signUpRequest.email(), 
							passwordEncoder.encode(signUpRequest.password()), 
							signUpRequest.email());
		userRepository.save(userEntity);
		
	}



	public Optional<String> signIn(SignInRequest signInRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.username(), signInRequest.password()));
				String jwt = jwtUtils.generateToken(signInRequest.username());
		return Optional.of(jwt);
		
	}

}
