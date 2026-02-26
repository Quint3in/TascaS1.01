public abstract class Article {

    protected String headline;
    protected String text;
    protected int score;
    protected double price;

    public Article(String headline) {
        this.headline = headline;
    }

    abstract double calculateArticlePrice();

    abstract int calculateArticleScore();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHeadline() {
        return headline;
    }
}
