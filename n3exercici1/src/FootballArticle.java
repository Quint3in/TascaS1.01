public class FootballArticle extends Article {
    final double BASE_PRICE = 300;
    final int BASE_SCORE = 5;

    private String tournament;
    private String club;
    private String player;

    public FootballArticle(String headline) {
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

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (tournament.equalsIgnoreCase("Lliga de Campions")) {finalPrice+=100;}
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {finalPrice+=100;}
        if (text.toLowerCase().contains("ferran torres") || text.toLowerCase().contains("benzema")) {finalPrice+=50;}

        return finalPrice;
    }
    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (tournament.equalsIgnoreCase("Lliga de Campions")) {finalScore+=3;}
        if (tournament.equalsIgnoreCase("Lliga")) {finalScore+=2;}
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {finalScore+=1;}
        if (text.contains("ferran torres") || text.contains("benzema")) {finalScore+=1;}

        return finalScore;
    }
}
