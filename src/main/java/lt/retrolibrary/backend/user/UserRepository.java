package lt.retrolibrary.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	Optional<UserEntity> findByusername(String username);
}
