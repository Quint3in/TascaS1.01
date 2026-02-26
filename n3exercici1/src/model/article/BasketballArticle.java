package model.article;

public class BasketballArticle extends Article {
    private static final double BASE_PRICE = 250;
    private static final int BASE_SCORE = 4;

    private String tournament;
    private String club;

    public BasketballArticle(String headline) {
        super(headline);
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if ("EuroLliga".equalsIgnoreCase(tournament)) {
            finalPrice += 75;
        }
        if ("Barca".equalsIgnoreCase(club) || "Barca".equalsIgnoreCase(normalizeClub(club)) || "Madrid".equalsIgnoreCase(club)) {
            finalPrice += 75;
        }

        return finalPrice;
    }

    @Override
    public int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if ("EuroLliga".equalsIgnoreCase(tournament)) {
            finalScore += 3;
        }
        if ("ACB".equalsIgnoreCase(tournament)) {
            finalScore += 2;
        }
        if ("Barca".equalsIgnoreCase(club) || "Barca".equalsIgnoreCase(normalizeClub(club)) || "Madrid".equalsIgnoreCase(club)) {
            finalScore += 1;
        }

        return finalScore;
    }

    private String normalizeClub(String value) {
        return value == null ? "" : value.replace("ç", "c");
    }
}

