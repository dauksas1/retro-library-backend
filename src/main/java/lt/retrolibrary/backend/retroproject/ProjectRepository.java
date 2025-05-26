package lt.retrolibrary.backend.retroproject;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<RetroProjectEntity, Integer> {

}
