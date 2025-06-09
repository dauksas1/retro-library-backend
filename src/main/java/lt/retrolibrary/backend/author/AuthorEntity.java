package lt.retrolibrary.backend.author;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lt.retrolibrary.backend.retroproject.RetroProjectEntity;

@Entity
public class AuthorEntity {
	
	@OneToMany(mappedBy = "author")
	private List<RetroProjectEntity> projectList;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public AuthorEntity() {
	}
	
	
	public AuthorEntity(List projectList, int id, String name) {
		super();
		this.projectList = projectList;
		this.id = id;
		this.name = name;
	}


	public List getProjectList() {
		return projectList;
	}

	public void setProjectList(ArrayList<RetroProjectEntity> projectList) {
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
