package lt.retrolibrary.backend.retroproject;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
		
	}

	public ArrayList<RetroProjectEntity> getAllProjects(){
		
		return new ArrayList<RetroProjectEntity>(projectRepository.findAll());
	}

	public RetroProjectEntity getProjectbyId(int id) {
		return projectRepository.findById(id).get();
	}
	
	public ResponseEntity<String> uploadProject(RetroProjectEntity project) {
		
		projectRepository.save(project);
		return ResponseEntity.ok("Project Saved");
		
	}

	public ResponseEntity<String> editProject(RetroProjectEntity project) {
		if(projectRepository.existsById(project.getId())) {
			projectRepository.save(project);
			return ResponseEntity.ok("Project Updated");
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
		
	}

	

}
