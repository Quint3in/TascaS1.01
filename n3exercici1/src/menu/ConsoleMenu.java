package menu;

import model.article.Article;
import service.WriterService;

import java.util.List;
import java.util.Scanner;

import static util.InputUtils.enterToContinue;
import static util.InputUtils.readValidNumber;
import static util.InputUtils.readValidString;

public class ConsoleMenu {
    private final WriterService writerService;
    private final ArticleInputMenu articleInputMenu;

    public ConsoleMenu(WriterService writerService, ArticleInputMenu articleInputMenu) {
        this.writerService = writerService;
        this.articleInputMenu = articleInputMenu;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMainMenu();
            int option = readValidNumber(input);
            running = handleMainOption(option, input);
        }
    }

    private void showMainMenu() {
        System.out.println("""
                --MENU--
                1.Introduir redactor
                2.Eliminar redactor
                3.Introduir noticia a un redactor
                4.Eliminar noticia
                5.Mostrar totes les noticies d'un redactor
                6.Calcular puntuació d'una noticia
                7.Calcular preu d'una noticia
                8.Sortir""");
    }

    private boolean handleMainOption(int option, Scanner input) {
        switch (option) {
            case 1 -> addWriter(input);
            case 2 -> removeWriter(input);
            case 3 -> addArticleToWriter(input);
            case 4 -> removeArticle(input);
            case 5 -> showArticlesPerWriter(input);
            case 6 -> calculateScorePerArticle(input);
            case 7 -> calculatePricePerArticle(input);
            case 8 -> {
                return false;
            }
            default -> {
                System.out.println("Numero no valid");
                enterToContinue(input);
            }
        }

        return true;
    }

    private void addWriter(Scanner input) {
        System.out.println("DNI del redactor:");
        String writerDni = readValidString(input);

        System.out.println("Nom del redactor:");
        String writerName = readValidString(input);

        writerService.addWriter(writerDni, writerName);
    }

    private void removeWriter(Scanner input) {
        System.out.println("DNI del redactor:");
        writerService.removeWriter(readValidString(input));
    }

    private String askWriterDni(Scanner input) {
        System.out.println("DNI del redactor:");
        String writerDni = readValidString(input);

        if (writerService.findWriter(writerDni) == null) {
            System.out.println("Redactor inexistent");
            return null;
        }

        return writerDni;
    }

    private void addArticleToWriter(Scanner input) {
        String writerDni = askWriterDni(input);
        if (writerDni == null) {
            return;
        }

        Article article = articleInputMenu.readArticle(input);
        if (article == null) {
            System.out.println("Tipus de noticia no valid");
            return;
        }

        writerService.addArticleToWriter(writerDni, article);
        System.out.println("Noticia amb el titular '" + article.getHeadline() + "' afegida");
    }

    private void removeArticle(Scanner input) {
        String writerDni = askWriterDni(input);
        if (writerDni == null) {
            return;
        }

        System.out.println("Titular de la noticia:");
        String headline = readValidString(input);
        writerService.removeArticleFromWriter(writerDni, headline);
    }

    private void showArticlesPerWriter(Scanner input) {
        String writerDni = askWriterDni(input);
        if (writerDni == null) {
            return;
        }

        List<String> headlines = writerService.getHeadlinesByWriter(writerDni);
        int index = 1;
        for (String headline : headlines) {
            System.out.println(index + ": " + headline);
            index++;
        }
    }

    private void calculateScorePerArticle(Scanner input) {
        String writerDni = askWriterDni(input);
        if (writerDni == null) {
            return;
        }

        System.out.println("Titular de la noticia:");
        String headline = readValidString(input);
        Integer score = writerService.calculateArticleScore(writerDni, headline);

        if (score == null) {
            System.out.println("No s'ha trobat la noticia");
            return;
        }

        System.out.println("La puntuacio d'aquesta noticia es " + score);
    }

    private void calculatePricePerArticle(Scanner input) {
        String writerDni = askWriterDni(input);
        if (writerDni == null) {
            return;
        }

        System.out.println("Titular de la noticia:");
        String headline = readValidString(input);
        Double price = writerService.calculateArticlePrice(writerDni, headline);

        if (price == null) {
            System.out.println("No s'ha trobat la noticia");
            return;
        }

        System.out.println("El preu d'aquesta noticia es " + price);
    }
}


