package lt.retrolibrary.backend.retroproject;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/")
public class ProjectController {
	

	private ProjectService projectService;
	

	public ProjectController(lt.retrolibrary.backend.retroproject.ProjectService projectService) {
		this.projectService = projectService;
	}
	
	
	@GetMapping("/projects")
	public ArrayList<RetroProjectEntity> projectList(){
		
		return projectService.getAllProjects();
		
	}
	
	@GetMapping("/search/{query}")
	public ArrayList<RetroProjectEntity> searchProjects(@PathVariable String query){
		
		return projectService.getAllProjects()
				.stream()
				.filter((s) -> s.getProjectName()
								.toLowerCase()
								.replace(" ", "")
								.contains(query))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	@GetMapping("/projects/{id}")
	public RetroProjectEntity getProjectById(@PathVariable int id) {
		return projectService.getProjectbyId(id);
	}
	
	@PostMapping("projects/upload")
	public ResponseEntity<String> uploadProject(@RequestBody RetroProjectEntity project) {
        System.out.println("Received project: " + project);
        projectService.uploadProject(project);
        return ResponseEntity.ok("Project uploaded successfully");
    }
	
	@PutMapping("projects/editProject/{id}")
	public ResponseEntity<String> updateProject(@RequestBody RetroProjectEntity project) {
        System.out.println("Received project: " + project);
        projectService.editProject(project);
        return ResponseEntity.ok("Project updated successfully");
    }


	
}
