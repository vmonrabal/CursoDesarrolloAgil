package pub;

public class Publisher{

	private Articles articles;
	private TwitterPub twitterPub;
	
	public void save(Article article) throws Exception{
		articles.save(article);
	}
	
	public void saveAndTweet(Article article, String tweet) throws Exception{
		articles.save(article);
		twitterPub.sendTweet(tweet);
	}
	
	public void setArticles(Articles articles){
		this.articles = articles;
	}
	
	public void setTwitterPub(TwitterPub tPub){
		this.twitterPub = tPub;
	}
}
