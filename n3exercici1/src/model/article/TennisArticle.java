package model.article;

import java.util.ArrayList;
import java.util.List;

public class TennisArticle extends Article {
    private static final double BASE_PRICE = 150;
    private static final int BASE_SCORE = 4;

    private String tournament;
    private final List<String> players = new ArrayList<>();

    public TennisArticle(String headline) {
        super(headline);
    }

    public void addPlayer(String player) {
        players.add(player);
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    @Override
    public double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        for (String player : players) {
            if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) {
                finalPrice += 100;
                break;
            }
        }

        return finalPrice;
    }

    @Override
    public int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        for (String player : players) {
            if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) {
                finalScore += 3;
                break;
            }
        }

        return finalScore;
    }
}

