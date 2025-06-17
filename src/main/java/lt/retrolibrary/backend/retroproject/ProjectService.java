package lt.retrolibrary.backend.retroproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
		
	}

	public ArrayList<ProjectDTO> getAllProjects(){
		List<ProjectEntity> entities = projectRepository.findAll();
		ArrayList<ProjectDTO> dtos = new ArrayList<>();
		
		for (ProjectEntity entity : entities) {
			dtos.add(new ProjectDTO(entity));
		}
		
		return dtos;
	}
	
	public ArrayList<ProjectDTO> getProjectsByAuthorId(int id) {
		List<ProjectEntity> entities = projectRepository.findByAuthorId(id);
		ArrayList<ProjectDTO> filteredEntities = new ArrayList<>();
		for(ProjectEntity entity : entities) {
			filteredEntities.add(new ProjectDTO(entity));
		}
		return filteredEntities;
	}

	public ProjectDTO getProjectbyId(int id) {
		Optional<ProjectEntity> entity = projectRepository.findById(id);
		return new ProjectDTO(entity.get());
	}
	
	public ResponseEntity<String> uploadProject(ProjectEntity project) {
		
		projectRepository.save(project);
		return ResponseEntity.ok("Project Saved");
		
	}

	public ResponseEntity<String> editProject(ProjectEntity project) {
		if(projectRepository.existsById(project.getId())) {
			projectRepository.save(project);
			return ResponseEntity.ok("Project Updated");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
		}
		
	}

	public ResponseEntity<String> deleteProject(int id) {
			if(projectRepository.existsById(id)) {
				projectRepository.deleteById(id);
				return ResponseEntity.ok("Project id: " + id + "has been deleted from the database");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
			}
				
			
	}

	
		
		
}

	


