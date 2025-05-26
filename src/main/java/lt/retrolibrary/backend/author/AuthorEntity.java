package lt.retrolibrary.backend.author;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import lt.retrolibrary.backend.retroproject.RetroProjectEntity;

//@Entity
public class AuthorEntity {
	
	private int id;
	private String name;
	private ArrayList<RetroProjectEntity> projectList;
	
	
	public AuthorEntity(int id, String name, ArrayList<RetroProjectEntity> projectList) {
		this.id = id;
		this.name = name;
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


	public ArrayList<RetroProjectEntity> getProjectList() {
		return projectList;
	}


	public void setProjectList(ArrayList<RetroProjectEntity> projectList) {
		this.projectList = projectList;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", projectList=" + projectList + "]";
	}
	
	
}
