package lt.retrolibrary.backend.jwtsecurity;

public record SignUpRequest(String username, String password, String name, String email) {

}
