package model.article;

public class MotorcyclingArticle extends Article {
    private static final double BASE_PRICE = 100;
    private static final int BASE_SCORE = 3;

    private String team;

    public MotorcyclingArticle(String headline) {
        super(headline);
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)) {
            finalPrice += 50;
        }
        return finalPrice;
    }

    @Override
    public int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)) {
            finalScore += 3;
        }
        return finalScore;
    }
}

