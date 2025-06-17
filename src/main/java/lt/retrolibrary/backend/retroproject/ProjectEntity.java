package lt.retrolibrary.backend.retroproject;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lt.retrolibrary.backend.author.AuthorEntity;

@Entity
@Table(name = "Projects")
public class ProjectEntity {
	
	
	@ManyToOne
	@JoinColumn(name = "authorId")
	private AuthorEntity author;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition="TEXT")
	private String projectSummary;
	
	@Column(columnDefinition="TEXT")
	private String cardIntro;
	
	@Column(columnDefinition="TEXT")
	private String projectIntro;
	
	private String projectName;
	private String projectImgUrl;
	private String projectStatus;
	private String youTubeLink;
	private String xLink;
	private String facebookLink;
	private String instaLink;
	private String patreonLink;
	private String payPalLink;
	private String authorEmailAddress;
	
	
	
	@Column(columnDefinition="TEXT")
	private String featureList;
	
	
	public ProjectEntity() {
	}

	
	public ProjectEntity(AuthorEntity author, int id, String projectSummary, String cardIntro, String projectIntro,
			String projectName, String projectImgUrl, String projectStatus, String youTubeLink, String xLink,
			String facebookLink, String instaLink, String patreonLink, String payPalLink, String featureList, String authorEmailAddress) {
		super();
		this.author = author;
		this.id = id;
		this.projectSummary = projectSummary;
		this.cardIntro = cardIntro;
		this.projectIntro = projectIntro;
		this.projectName = projectName;
		this.projectImgUrl = projectImgUrl;
		this.projectStatus = projectStatus;
		this.youTubeLink = youTubeLink;
		this.xLink = xLink;
		this.facebookLink = facebookLink;
		this.instaLink = instaLink;
		this.patreonLink = patreonLink;
		this.payPalLink = payPalLink;
		this.featureList = featureList;
		this.authorEmailAddress = authorEmailAddress;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectSummary() {
		return projectSummary;
	}


	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}


	public String getCardIntro() {
		return cardIntro;
	}


	public void setCardIntro(String cardIntro) {
		this.cardIntro = cardIntro;
	}


	public String getProjectIntro() {
		return projectIntro;
	}


	public void setProjectIntro(String projectIntro) {
		this.projectIntro = projectIntro;
	}


	public String getProjectImgUrl() {
		return projectImgUrl;
	}


	public void setProjectImgUrl(String projectImgUrl) {
		this.projectImgUrl = projectImgUrl;
	}


	public String getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}


	public String getYouTubeLink() {
		return youTubeLink;
	}


	public void setYouTubeLink(String youTubeLink) {
		this.youTubeLink = youTubeLink;
	}


	public String getPatreonLink() {
		return patreonLink;
	}


	public void setPatreonLink(String patreonLink) {
		this.patreonLink = patreonLink;
	}


	public String getInstaLink() {
		return instaLink;
	}


	public void setInstaLink(String instaLink) {
		this.instaLink = instaLink;
	}

	
	public String getFeatureList() {
		return featureList;
	}


	public void setFeatureList(String featureList) {
		this.featureList = featureList;
	}
	
	
	public String getxLink() {
		return xLink;
	}


	public void setxLink(String xLink) {
		this.xLink = xLink;
	}


	public String getFacebookLink() {
		return facebookLink;
	}


	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}


	public String getPayPalLink() {
		return payPalLink;
	}


	public void setPayPalLink(String payPalLink) {
		this.payPalLink = payPalLink;
	}

	

	public String getAuthorEmailAddress() {
		return authorEmailAddress;
	}


	public void setAuthorEmailAddress(String emailAddress) {
		this.authorEmailAddress = emailAddress;
	}

	
	
	public AuthorEntity getAuthor() {
		return author;
	}


	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "RetroProjectEntity [id=" + id + ", projectName=" + projectName + ", projectSummary=" + projectSummary
				+ ", cardIntro=" + cardIntro + ", projectIntro=" + projectIntro + ", projectImgUrl=" + projectImgUrl
				+ ", projectStatus=" + projectStatus + ", youTubeLink=" + youTubeLink + ", patreonLink=" + patreonLink
				+ ", instaLink=" + instaLink + "]";
	}

	
}
