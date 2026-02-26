public class BasketballArticle extends Article{
    final double BASE_PRICE = 250;
    final int BASE_SCORE = 4;

    private String tournament;
    private String club;

    public BasketballArticle(String headline) {
        super(headline);
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (tournament.equalsIgnoreCase("EuroLliga")) {finalPrice+=75;}
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {finalPrice+=75;}

        return finalPrice;
    }

    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (tournament.equalsIgnoreCase("EuroLliga")) {finalScore+=3;}
        if (tournament.equalsIgnoreCase("ACB")) {finalScore+=2;}
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {finalScore+=1;}

        return finalScore;
    }
}
