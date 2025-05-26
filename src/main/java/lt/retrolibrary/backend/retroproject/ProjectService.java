package lt.retrolibrary.backend.retroproject;

import java.util.ArrayList;

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

}
