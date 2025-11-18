import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CalculadoraService calculadoraService = new CalculadoraService();
        MenuController menuController = new MenuController(scanner, calculadoraService);

        int opcao;

        do {
            menuController.mostrarMenu();

            opcao = menuController.evitarCrashPrograma();

            menuController.processarOpcao(opcao);
        } while (opcao != 0);

        scanner.close();
    }
}