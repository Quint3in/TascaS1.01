public class MotorcyclingArticle extends Article{
    final double BASE_PRICE = 100;
    final int BASE_SCORE = 3;

    private String team;

    public MotorcyclingArticle(String headline) {
        super(headline);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (team.equalsIgnoreCase("Honda") ||
            team.equalsIgnoreCase("Yamaha")) {
            finalPrice+=50;
        }
        return finalPrice;
    }

    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (team.equalsIgnoreCase("Honda") ||
                team.equalsIgnoreCase("Yamaha")) {
            finalScore+=3;
        }
        return finalScore;
    }
}
