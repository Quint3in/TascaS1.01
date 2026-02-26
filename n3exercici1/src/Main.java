

import menu.ArticleInputMenu;
import menu.ConsoleMenu;
import repository.InMemoryWriterRepository;
import repository.WriterRepository;
import service.ArticleService;
import service.WriterService;

public class Main {
    public static void main(String[] args) {
        WriterRepository writerRepository = new InMemoryWriterRepository();
        WriterService writerService = new WriterService(writerRepository);
        ArticleService articleService = new ArticleService();

        ArticleInputMenu articleInputMenu = new ArticleInputMenu(articleService);
        ConsoleMenu consoleMenu = new ConsoleMenu(writerService, articleInputMenu);
        consoleMenu.start();
    }
}


