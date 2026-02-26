public class F1Article extends Article {
    final double BASE_PRICE = 100;
    final int BASE_SCORE = 4;

    private String constructorTeam;


    public F1Article(String headline) {
        super(headline);
    }

    public String getConstructorTeam() {
        return constructorTeam;
    }

    public void setConstructorTeam(String constructorTeam) {
        this.constructorTeam = constructorTeam;
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if(constructorTeam.equalsIgnoreCase("Ferrari") ||
                constructorTeam.equalsIgnoreCase("Mercedes") ){
            finalPrice+=50;
        }
        return finalPrice;
    }

    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if(constructorTeam.equalsIgnoreCase("Ferrari") ||
                constructorTeam.equalsIgnoreCase("Mercedes") ){
            finalScore+=2;
        }

        return finalScore;
    }
}
