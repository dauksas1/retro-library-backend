package lt.retrolibrary.backend.author;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lt.retrolibrary.backend.retroproject.ProjectEntity;

@Entity
@Table(name = "authors")
public class AuthorEntity {
	
	@OneToMany(mappedBy = "author")
	private List<ProjectEntity> projectList;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public AuthorEntity() {
	}
	
	
	public AuthorEntity(List<ProjectEntity> projectList, int id, String name) {
		super();
		this.projectList = projectList;
		this.id = id;
		this.name = name;
	}


	public List<ProjectEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(ArrayList<ProjectEntity> projectList) {
		this.projectList = projectList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
