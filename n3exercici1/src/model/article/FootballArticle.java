package model.article;

public class FootballArticle extends Article {
    private static final double BASE_PRICE = 300;
    private static final int BASE_SCORE = 5;

    private String tournament;
    private String club;
    private String player;

    public FootballArticle(String headline) {
        super(headline);
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if ("Lliga de Campions".equalsIgnoreCase(tournament)) {
            finalPrice += 100;
        }
        if ("Barca".equalsIgnoreCase(club) || "Barca".equalsIgnoreCase(normalizeClub(club)) || "Madrid".equalsIgnoreCase(club)) {
            finalPrice += 100;
        }
        if (text != null && (text.toLowerCase().contains("ferran torres") || text.toLowerCase().contains("benzema"))) {
            finalPrice += 50;
        }

        return finalPrice;
    }

    @Override
    public int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if ("Lliga de Campions".equalsIgnoreCase(tournament)) {
            finalScore += 3;
        }
        if ("Lliga".equalsIgnoreCase(tournament)) {
            finalScore += 2;
        }
        if ("Barca".equalsIgnoreCase(club) || "Barca".equalsIgnoreCase(normalizeClub(club)) || "Madrid".equalsIgnoreCase(club)) {
            finalScore += 1;
        }
        if (text != null && (text.toLowerCase().contains("ferran torres") || text.toLowerCase().contains("benzema"))) {
            finalScore += 1;
        }

        return finalScore;
    }

    private String normalizeClub(String value) {
        return value == null ? "" : value.replace("ç", "c");
    }
}

