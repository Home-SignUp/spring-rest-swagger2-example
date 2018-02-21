package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.domain.Article;
import com.concretepage.service.IArticleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("user")
public class ArticleController {
	@Autowired
	private IArticleService articleService;

	@RequestMapping(value = "article/{id}", method = RequestMethod.GET)
//	@ApiOperation(value = "Get Article by Id", notes = "${ArticleController.getArticleById.notes}")
	public ResponseEntity<Article> getArticleById(
//			@ApiParam(value = "${ArticleController.getArticleById.id}", required = true)
	        @PathVariable("id") Integer id)
	{
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	@RequestMapping(value = "articles", method = RequestMethod.GET)
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "article", method = RequestMethod.POST)
//	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
//        boolean flag = articleService.addArticle(article);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}
	public ResponseEntity<Void> addArticle(@RequestBody Article article) {
		boolean flag = articleService.addArticle(article);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "article", method = RequestMethod.PUT)
//	@ApiOperation(value = "Update Article", notes = "${ArticleController.updateArticle.notes}")
//	@ApiImplicitParams(
//			@ApiImplicitParam(name="article", value="${ArticleController.updateArticle.article}")
//	)
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	@RequestMapping(value = "article/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 