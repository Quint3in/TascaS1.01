package service;

import model.article.Article;
import model.article.BasketballArticle;
import model.article.F1Article;
import model.article.FootballArticle;
import model.article.MotorcyclingArticle;
import model.article.TennisArticle;

public class ArticleService {
    public Article createFootballArticle(String headline, String text, String tournament, String club, String player) {
        FootballArticle article = new FootballArticle(headline);
        article.setText(text);
        article.setTournament(tournament);
        article.setClub(club);
        article.setPlayer(player);
        return article;
    }

    public Article createBasketballArticle(String headline, String text, String tournament, String club) {
        BasketballArticle article = new BasketballArticle(headline);
        article.setText(text);
        article.setTournament(tournament);
        article.setClub(club);
        return article;
    }

    public Article createTennisArticle(String headline, String text, String tournament, java.util.List<String> players) {
        TennisArticle article = new TennisArticle(headline);
        article.setText(text);
        article.setTournament(tournament);
        for (String player : players) {
            article.addPlayer(player);
        }
        return article;
    }

    public Article createF1Article(String headline, String text, String constructorTeam) {
        F1Article article = new F1Article(headline);
        article.setText(text);
        article.setConstructorTeam(constructorTeam);
        return article;
    }

    public Article createMotorcyclingArticle(String headline, String text, String team) {
        MotorcyclingArticle article = new MotorcyclingArticle(headline);
        article.setText(text);
        article.setTeam(team);
        return article;
    }
}


