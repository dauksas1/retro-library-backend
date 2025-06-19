package lt.retrolibrary.backend.jwtsecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtils {
	
	private final SecretKey secretKey;
	
	private final long expirationMillis;
	
	public JwtUtils(
			
			@Value("${jwt.secret}") String secret,
			@Value("${jwt.expiration}") long expirationMillis) {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.expirationMillis = expirationMillis;
		
	}
	
	public String generateToken(String username) {
		Instant now = Instant.now();
		return Jwts.builder()
					.subject(username)
					.issuedAt(Date.from(now))
					.expiration(Date.from(now.plusMillis(expirationMillis)))
					.signWith(secretKey)
					.compact();
	}
	
	
	public String extractUsername(String token) {
		return Jwts.parser()
					.verifyWith(secretKey)
					.build()
					.parseSignedClaims(token)
					.getPayload()
					.getSubject();
	}
	
	public boolean validateToken(String token, String username) {
		try {
			String extractedUsername = extractUsername(token);
			return extractedUsername.equals(username) && !isTokenExpired(token);
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isTokenExpired(String token) {
		Date expiration = Jwts.parser()
								.verifyWith(secretKey)
								.build()
								.parseSignedClaims(token)
								.getPayload()
								.getExpiration();
		return expiration.before(new Date());
	}
	
	

}
