package test;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import pub.Article;
import pub.Articles;
import pub.ArticlesRepository;
import pub.Publisher;
import pub.TwitterPub;
import pub.Users;

public class PublisherTest {

	Publisher pub;
	Article article;
	Articles articles;
	Users users;
	ArticlesRepository articlesRepo;
	TwitterPub twitterpub;
	String tweet;
	
	@Before
	public void setUp(){
		pub = new Publisher();
		article = new Article("pubMaster", "articleBody");
		articles = mock(Articles.class);
		users = mock(Users.class);
		articlesRepo = mock(ArticlesRepository.class);
		twitterpub = mock(TwitterPub.class);
		tweet = "I've published my new article...";
	}
	
	@Test
	public void pubSavesArticle() throws Exception{

		pub.setArticles(articles);
		pub.save(article);
		
		verify(articles).save(article);		
	}
	
	@Test
	public void pubChecksValidUser() throws Exception{
		pub.setArticles(articles);
		
		pub.save(article);
		
		when(users.canPublish(article.getUser())).thenReturn(false);
		verify(articles).save(article);
	}
	
	@Test
	public void validUserPublishArticle() throws Exception{
		pub.setArticles(articles);
		pub.save(article);
		
		when(users.canPublish(article.getUser())).thenReturn(true);		
		verify(articles).save(article);
	}
	
//	@Test
//	public void publishOnArticlesRepo() throws Exception{
//		articles.setArticlesRepo(articlesRepo);
//		pub.setArticles(articles);
//		pub.save(article);
//		
//		when(users.canPublish(article.getUser())).thenReturn(true);		
//		verify(articles).save(article);
//		verify(articlesRepo).saveToRepository(article);
//	}
	
	@Test
	public void validUserPublishAndTweetArticle() throws Exception{
		pub.setArticles(articles);
		pub.setTwitterPub(twitterpub);
		pub.saveAndTweet(article, tweet);
		
		when(users.canPublish(article.getUser())).thenReturn(true);		
		verify(articles).save(article);
		verify(twitterpub).sendTweet(tweet);
	}
	
	
}
