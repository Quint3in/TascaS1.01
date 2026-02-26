package menu;

import model.article.Article;
import service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.InputUtils.readValidNumber;
import static util.InputUtils.readValidString;

public class ArticleInputMenu {
    private final ArticleService articleService;

    public ArticleInputMenu(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Article readArticle(Scanner input) {
        System.out.println("Titular:");
        String headline = readValidString(input);

        System.out.println("Text:");
        String text = readValidString(input);

        int articleType = askArticleType(input);
        return createArticleByType(articleType, headline, text, input);
    }

    private int askArticleType(Scanner input) {
        System.out.println("""
                Que tipus de noticia vols introduir:
                1.Futbol
                2.Basquet
                3.Tenis
                4.F1
                5.Motociclisme""");
        return readValidNumber(input);
    }

    private Article createArticleByType(int articleType, String headline, String text, Scanner input) {
        return switch (articleType) {
            case 1 -> createFootballArticle(headline, text, input);
            case 2 -> createBasketballArticle(headline, text, input);
            case 3 -> createTennisArticle(headline, text, input);
            case 4 -> createF1Article(headline, text, input);
            case 5 -> createMotorcyclingArticle(headline, text, input);
            default -> null;
        };
    }

    private Article createFootballArticle(String headline, String text, Scanner input) {
        System.out.println("Competicio:");
        String tournament = readValidString(input);
        System.out.println("Club:");
        String club = readValidString(input);
        System.out.println("Jugador:");
        String player = readValidString(input);

        return articleService.createFootballArticle(headline, text, tournament, club, player);
    }

    private Article createBasketballArticle(String headline, String text, Scanner input) {
        System.out.println("Competicio:");
        String tournament = readValidString(input);
        System.out.println("Club:");
        String club = readValidString(input);

        return articleService.createBasketballArticle(headline, text, tournament, club);
    }

    private Article createTennisArticle(String headline, String text, Scanner input) {
        System.out.println("Competicio:");
        String tournament = readValidString(input);

        List<String> players = new ArrayList<>();
        boolean morePlayers = true;
        while (morePlayers) {
            System.out.println("Escriu el nom de jugadors o 'suficient' si has acabat:");
            String player = readValidString(input);

            if ("suficient".equalsIgnoreCase(player)) {
                morePlayers = false;
            } else {
                players.add(player);
            }
        }

        return articleService.createTennisArticle(headline, text, tournament, players);
    }

    private Article createF1Article(String headline, String text, Scanner input) {
        System.out.println("Escuderia:");
        String constructorTeam = readValidString(input);

        return articleService.createF1Article(headline, text, constructorTeam);
    }

    private Article createMotorcyclingArticle(String headline, String text, Scanner input) {
        System.out.println("Escuderia:");
        String team = readValidString(input);

        return articleService.createMotorcyclingArticle(headline, text, team);
    }
}


