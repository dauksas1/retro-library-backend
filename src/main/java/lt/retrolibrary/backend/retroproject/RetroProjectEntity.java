package lt.retrolibrary.backend.retroproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lt.retrolibrary.backend.author.AuthorEntity;

@Entity
@Table(name = "Projects")
public class RetroProjectEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String intro;
	private String imgUrl;
	private String status;
	//private Author Author;
	
	
	
	
	public RetroProjectEntity(String name, String status, String intro, String imgUrl , String description) {
		this.name = name;
		this.intro = intro;
		this.imgUrl = imgUrl;
		this.description = description;
		this.status = status;
		//Author = author;
	}


	public RetroProjectEntity() {
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


	public String getDescription() {
		return description;
	}

	

	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	


//	public Author getAuthor() {
//		return Author;
//	}
//
//
//	public void setAuthor(Author author) {
//		Author = author;
//	}


//	@Override
//	public String toString() {
//		return "RetroProject [id=" + id + ", name=" + name + ", Description=" + Description + ", Author=" + Author
//				+ "]";
//	}
//	
	

}
