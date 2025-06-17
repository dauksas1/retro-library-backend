package lt.retrolibrary.backend.author;

public class AuthorDTO {
	
	private int id;
	private String name;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(AuthorEntity author) {
		this.id = author.getId();
		this.name = author.getName();
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
