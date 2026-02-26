import java.util.HashMap;
import java.util.Map;

public class Writer {
    static final double SALARY_COMPANY = 1500;

    private String name;
    private final String DNI;
    static double salary = SALARY_COMPANY;
    Map<String, Article> articles = new HashMap<>();

    public Writer(String DNI, String name) {
        this.DNI = DNI;
        this.name = name;
    }

    public void addArticle(Article article) {
        if (article != null && article.getHeadline() != null) {
            articles.put(article.getHeadline(), article);
        }
    }
    public void removeArticle(Article article) {
        articles.remove(article.getHeadline(),article);
    }
    public void removeArticle(String headline) {
        articles.remove(headline);
    }
    public void showHeadlines() {
        int i = 1;
        for (String headline : articles.keySet()) {
            System.out.println(i + ": " + headline);
            i++;
        }
    }
    public Article getArticle (String headline) {
        return articles.get(headline);
    }

}
