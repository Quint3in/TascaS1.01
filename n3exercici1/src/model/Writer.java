package model;

import model.article.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Writer {
    public static final double SALARY_COMPANY = 1500;

    private final String dni;
    private String name;
    private double salary = SALARY_COMPANY;
    private final Map<String, Article> articles = new HashMap<>();

    public Writer(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void addArticle(Article article) {
        if (article != null && article.getHeadline() != null) {
            articles.put(article.getHeadline(), article);
        }
    }

    public void removeArticle(String headline) {
        articles.remove(headline);
    }

    public Article getArticle(String headline) {
        return articles.get(headline);
    }

    public List<String> getHeadlines() {
        return new ArrayList<>(articles.keySet());
    }
}


