package service;

import model.Writer;
import model.article.Article;
import repository.WriterRepository;

import java.util.List;

public class WriterService {
    private final WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public void addWriter(String dni, String name) {
        writerRepository.save(new Writer(dni, name));
    }

    public void removeWriter(String dni) {
        writerRepository.deleteByDni(dni);
    }

    public Writer findWriter(String dni) {
        return writerRepository.findByDni(dni);
    }

    public boolean addArticleToWriter(String dni, Article article) {
        Writer writer = writerRepository.findByDni(dni);
        if (writer == null) {
            return false;
        }

        writer.addArticle(article);
        return true;
    }

    public boolean removeArticleFromWriter(String dni, String headline) {
        Writer writer = writerRepository.findByDni(dni);
        if (writer == null) {
            return false;
        }

        writer.removeArticle(headline);
        return true;
    }

    public List<String> getHeadlinesByWriter(String dni) {
        Writer writer = writerRepository.findByDni(dni);
        if (writer == null) {
            return java.util.Collections.emptyList();
        }

        return writer.getHeadlines();
    }

    public Integer calculateArticleScore(String dni, String headline) {
        Writer writer = writerRepository.findByDni(dni);
        if (writer == null) {
            return null;
        }

        Article article = writer.getArticle(headline);
        if (article == null) {
            return null;
        }

        int score = article.calculateArticleScore();
        article.setScore(score);
        return score;
    }

    public Double calculateArticlePrice(String dni, String headline) {
        Writer writer = writerRepository.findByDni(dni);
        if (writer == null) {
            return null;
        }

        Article article = writer.getArticle(headline);
        if (article == null) {
            return null;
        }

        double price = article.calculateArticlePrice();
        article.setPrice(price);
        return price;
    }
}


