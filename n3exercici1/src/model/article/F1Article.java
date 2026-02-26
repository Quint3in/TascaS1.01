package model.article;

public class F1Article extends Article {
    private static final double BASE_PRICE = 100;
    private static final int BASE_SCORE = 4;

    private String constructorTeam;

    public F1Article(String headline) {
        super(headline);
    }

    public void setConstructorTeam(String constructorTeam) {
        this.constructorTeam = constructorTeam;
    }

    @Override
    public double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if ("Ferrari".equalsIgnoreCase(constructorTeam) || "Mercedes".equalsIgnoreCase(constructorTeam)) {
            finalPrice += 50;
        }
        return finalPrice;
    }

    @Override
    public int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if ("Ferrari".equalsIgnoreCase(constructorTeam) || "Mercedes".equalsIgnoreCase(constructorTeam)) {
            finalScore += 2;
        }

        return finalScore;
    }
}

