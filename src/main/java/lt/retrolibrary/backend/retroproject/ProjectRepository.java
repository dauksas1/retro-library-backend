package lt.retrolibrary.backend.retroproject;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	List<ProjectEntity> findByAuthorId(int id);

}
