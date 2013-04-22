package pub;

public class Article {

	private String user;
	private String body;
	
	public Article(String user, String body){
		this.user = user;
		this.body = body;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
