package lt.retrolibrary.backend.retroproject;

public class ProjectDTO {
	
	private int id;
    private String projectName;
    private String projectSummary;
    private String cardIntro;
    private String projectIntro;
    private String projectImgUrl;
    private String projectStatus;
    private String youTubeLink;
    private String xLink;
    private String facebookLink;
    private String instaLink;
    private String patreonLink;
    private String payPalLink;
    private String authorEmailAddress;
    private String featureList;
    private int authorId;

    public ProjectDTO() {
    	
    }

	public ProjectDTO(ProjectEntity entity) {
		super();
		this.id = entity.getId();
		this.projectName = entity.getProjectName();
		this.projectSummary = entity.getProjectSummary();
		this.cardIntro = entity.getCardIntro();
		this.projectIntro = entity.getProjectIntro();
		this.projectImgUrl = entity.getProjectImgUrl();
		this.projectStatus = entity.getProjectStatus();
		this.youTubeLink = entity.getYouTubeLink();
		this.xLink = entity.getxLink();
		this.facebookLink = entity.getFacebookLink();
		this.instaLink = entity.getInstaLink();
		this.patreonLink = entity.getPatreonLink();
		this.payPalLink = entity.getPayPalLink();
		this.authorEmailAddress = entity.getAuthorEmailAddress();
		this.featureList = entity.getFeatureList();
		this.authorId = entity.getAuthor().getId();
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

	public String getInstaLink() {
		return instaLink;
	}

	public void setInstaLink(String instaLink) {
		this.instaLink = instaLink;
	}

	public String getPatreonLink() {
		return patreonLink;
	}

	public void setPatreonLink(String patreonLink) {
		this.patreonLink = patreonLink;
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

	public void setAuthorEmailAddress(String authorEmailAddress) {
		this.authorEmailAddress = authorEmailAddress;
	}

	public String getFeatureList() {
		return featureList;
	}

	public void setFeatureList(String featureList) {
		this.featureList = featureList;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
    
    
}
