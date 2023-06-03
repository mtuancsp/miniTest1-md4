package com.codegym.minitest1.service;

import com.codegym.minitest1.model.Article;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {
    private static Map<Integer, Article> articleMap = new HashMap<>();

    static {
        Article article1 = new Article("Title 1", "Content 1", new Date());
        Article article2 = new Article("Title 2", "Content 2", new Date());
        Article article3 = new Article("Title 3", "Content 3", new Date());
        Article article4 = new Article("Title 4", "Content 4", new Date());
        Article article5 = new Article("Title 5", "Content 5", new Date());

        articleMap.put(article1.getId(), article1);
        articleMap.put(article2.getId(), article2);
        articleMap.put(article3.getId(), article3);
        articleMap.put(article4.getId(), article4);
        articleMap.put(article5.getId(), article5);
    }

    public static void main(String[] args) {
        articleMap.forEach((key, value) -> System.out.println(value));
    }

    public static List<Article> getAllArticles() {
        return new ArrayList<>(articleMap.values());
    }

    public static Article getArticleById(int id) {
        return articleMap.get(id);
    }

    public static void addArticle(Article article) {
        articleMap.put(article.getId(), article);
    }

    public static void updateArticle(Article updatedArticle) {
        articleMap.put(updatedArticle.getId(), updatedArticle);
    }

    public static void deleteArticle(int id) {
        articleMap.remove(id);
    }

    public static List<Article> search(String keyword) {
        List<Article> result = new ArrayList<>();

        for (Article article : articleMap.values()) {
            if (article.getTitle().toLowerCase().contains(keyword.toLowerCase()) || article.getContent().toLowerCase().contains(keyword.toLowerCase()) || article.getCreatedDate().toString().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(article);
            }
        }

        return result;
    }

}
