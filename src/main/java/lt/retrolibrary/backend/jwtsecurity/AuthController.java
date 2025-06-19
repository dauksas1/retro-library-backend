package lt.retrolibrary.backend.jwtsecurity;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	AuthService authService;
	
	AuthController(AuthService authService){
		this.authService = authService;
	}

	@PostMapping("/signup")
	public ResponseEntity<String> SignUp(@RequestBody SignUpRequest signUpRequest){
		authService.signUp(signUpRequest);
		return ResponseEntity.ok("SignedUp successfuly");
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<SignInResponse> SignIn(@RequestBody SignInRequest signInRequest){
		System.out.println("🔐 Received login request from frontend");
		Optional<String> jwt = authService.signIn(signInRequest);
		if(jwt.isPresent()) {
			System.out.println("✅ Returning token: " + jwt.get());
			return ResponseEntity.ok(new SignInResponse(jwt.get()));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		            .header("Access-Control-Allow-Origin", "http://localhost:5173")
		            .build();
		}


		
	}
	
}
