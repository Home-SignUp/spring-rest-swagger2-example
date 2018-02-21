package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.concretepage.domain.Article;
@Service
public class ArticleService implements IArticleService {
	private List<Article> list = new ArrayList<>();
	{
		list.add(new Article(1, "Angular 2 Tutorial using CLI", "Angular"));
		list.add(new Article(2, "Spring Boot Getting Started", "Spring Boot"));
		list.add(new Article(3, "Lambda Expressions Java 8 Example", "Java 8"));
	}
	@Override
	public Article getArticleById(int articleId) {
		Predicate<Article> articlePredicate = a-> a.getArticleId() == articleId;
		Article obj = list.stream().filter(articlePredicate).findFirst().get();
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
	    return list;
	}
	@Override
	public boolean addArticle(Article article){
	    list.add(article);	   
	    return true;
	}
	@Override
	public void updateArticle(Article article) { 
		Predicate<Article> articlePredicate = a-> a.getArticleId() == article.getArticleId();
		Article obj = list.stream().filter(articlePredicate).findFirst().get();
		obj.setTitle(article.getTitle());
		obj.setCategory(article.getCategory());
	}
	@Override
	public void deleteArticle(int articleId) {
		Predicate<Article> articlePredicate = a-> a.getArticleId() == articleId;
		Article obj = list.stream().filter(articlePredicate).findFirst().get();		
		list.remove(obj);
	}
}
