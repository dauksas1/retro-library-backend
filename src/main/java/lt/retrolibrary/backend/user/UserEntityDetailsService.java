package lt.retrolibrary.backend.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityDetailsService implements UserDetailsService{
	
	UserRepository userRepository;
	
	public UserEntityDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository
				.findByusername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found."));
		return User.builder()
					.username(userEntity.getUsername())
					.password(userEntity.getPassword())
					.authorities("ROLE_" + userEntity.getRole().name())
					.disabled(!userEntity.isActive())
					.build();
	}

}
