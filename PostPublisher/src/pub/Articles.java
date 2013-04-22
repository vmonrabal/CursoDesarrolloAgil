package pub;

public class Articles {

	private Users pubUsers;
	private ArticlesRepository articlesRepo;
	
	public void save(Article article) throws Exception{
		
		if(pubUsers.canPublish(article.getUser())){
			articlesRepo.saveToRepository(article);
		}
		else
			throw new Exception();
	}
	
	public void setPubUsers(Users usrpubs){
		this.pubUsers = usrpubs;
	}
	
	public void setArticlesRepo(ArticlesRepository artRepo){
		this.articlesRepo = artRepo;
	}
}
