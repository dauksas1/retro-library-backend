package lt.retrolibrary.backend.user;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lt.retrolibrary.backend.retroproject.ProjectEntity;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean active;
	
	private String name;
	private String password;
	private String email;
	private ArrayList<ProjectEntity> userSubscribtionList;
	
	
	public UserEntity() {
		
	}


	public UserEntity(Long id, String username, Role role, boolean active, String name, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.active = active;
		this.name = name;
		this.password = password;
		this.email = email;
		this.userSubscribtionList = new ArrayList<>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public ArrayList<ProjectEntity> getUserSubscribtionList() {
		return userSubscribtionList;
	}


	public void setUserSubscribtionList(ArrayList<ProjectEntity> userSubscribtionList) {
		this.userSubscribtionList = userSubscribtionList;
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", role=" + role + ", active=" + active + ", name="
				+ name + ", password=" + password + ", email=" + email + ", userSubscribtionList="
				+ userSubscribtionList + "]";
	}
	
	
}
