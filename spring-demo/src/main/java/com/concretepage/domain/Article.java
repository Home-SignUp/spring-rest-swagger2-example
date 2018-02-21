package com.concretepage.domain;

public class Article { 
    private int articleId;  
    private String title;
	private String category;
	public Article() {}	
	public Article(int articleId, String title, String category) {
		this.articleId = articleId;
		this.title = title;
		this.category = category;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
} 