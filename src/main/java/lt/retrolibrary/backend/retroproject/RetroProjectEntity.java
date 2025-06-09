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
public class RetroProjectEntity {
	
	
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
	private String patreonLink;
	private String instaLink;
	
	@Column(columnDefinition="TEXT")
	private String featureList;
	
	
	public RetroProjectEntity() {
	}

	
	public RetroProjectEntity(int id, String projectName, String projectSummary, String cardIntro, String projectIntro,
			String projectImgUrl, String projectStatus, String youTubeLink, String patreonLink, String instaLink,
			String featureList) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectSummary = projectSummary;
		this.cardIntro = cardIntro;
		this.projectIntro = projectIntro;
		this.projectImgUrl = projectImgUrl;
		this.projectStatus = projectStatus;
		this.youTubeLink = youTubeLink;
		this.patreonLink = patreonLink;
		this.instaLink = instaLink;
		this.featureList = featureList;
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


	@Override
	public String toString() {
		return "RetroProjectEntity [id=" + id + ", projectName=" + projectName + ", projectSummary=" + projectSummary
				+ ", cardIntro=" + cardIntro + ", projectIntro=" + projectIntro + ", projectImgUrl=" + projectImgUrl
				+ ", projectStatus=" + projectStatus + ", youTubeLink=" + youTubeLink + ", patreonLink=" + patreonLink
				+ ", instaLink=" + instaLink + "]";
	}

	
}
