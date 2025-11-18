import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner;
    private final CalculadoraService calculadoraService;

    public MenuController(Scanner scanner, CalculadoraService calculadoraService) {
        this.scanner = scanner;
        this.calculadoraService = calculadoraService;
    }

    public void mostrarMenu() {
        System.out.println("============== CALCULADORA ==============");
        System.out.println("1- soma");
        System.out.println("2- subtração");
        System.out.println("3- multiplicação");
        System.out.println("4- divisão");
        System.out.println("0- sair");
        System.out.println("-----------------------------------------");
        System.out.print("Escolha: ");
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                somar();
                break;
            case 2:
                subtrair();
                break;
            case 3:
                multiplicar();
                break;
            case 4:
                dividir();
                break;
            case 0:
                encerrarPrograma();
                break;
            default:
                if (opcao != -999) {
                    System.out.println("Opcão inválida! Digite um número entre 0 e 4.");
                    System.out.println("-----------------------------------------");
                }
        }
    }

    private void somar() {
        try {
            System.out.println("Você escolheu somar!");
            System.out.println("-----------------------------------------");

            System.out.println("Digite um número: ");
            int n1soma = scanner.nextInt();

            System.out.println("Digite outro número: ");
            int n2soma = scanner.nextInt();

            System.out.println("Resultado: " + calculadoraService.adicao(n1soma, n2soma));
        } catch (InputMismatchException e) {
            System.out.println("Erro: você deve digitar apenas números!");
            scanner.nextLine();
        } finally {
            System.out.println("-----------------------------------------");
        }
    }

    private void subtrair() {
        try {
            System.out.println("Você escolheu subtrair!");
            System.out.println("-----------------------------------------");

            System.out.println("Digite um número: ");
            int n1subtrair = scanner.nextInt();

            System.out.println("Digite outro número: ");
            int n2subtrair = scanner.nextInt();

            System.out.println("Resultado: " + calculadoraService.subtracao(n1subtrair, n2subtrair));
        } catch (InputMismatchException e) {
            System.out.println("Erro: você deve digitar apenas números!");
            scanner.nextLine();
        } finally {
            System.out.println("-----------------------------------------");
        }
    }

    private void multiplicar() {
        try {
            System.out.println("Você escolheu multiplicar!");
            System.out.println("-----------------------------------------");

            System.out.println("Digite um número");
            int n1multiplicar = scanner.nextInt();

            System.out.println("Digite outro número");
            int n2multiplicar = scanner.nextInt();

            System.out.println("Resultado: " + calculadoraService.multiplicacao(n1multiplicar, n2multiplicar));
        } catch (InputMismatchException e) {
            System.out.println("Erro: você deve digitar apenas números!");
            scanner.nextLine();
        } finally {
            System.out.println("-----------------------------------------");
        }
    }
    private void dividir() {
        try {
            System.out.println("Você escolheu dividir!");
            System.out.println("-----------------------------------------");

            System.out.println("Digite um número: ");
            int n1divisao = scanner.nextInt();

            System.out.println("Digite outro número: ");
            int n2divisao = scanner.nextInt();

            System.out.println("Resultado: " + calculadoraService.divisao(n1divisao, n2divisao));
        } catch (DivisaoPorZeroException e) {
            System.out.println("Erro: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Erro: você deve digitar apenas números!");
            scanner.nextLine();
        } finally {
            System.out.println("-----------------------------------------");
        }
    }

    private void encerrarPrograma() {
        System.out.print("Saindo do programa");

        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public int evitarCrashPrograma() {
        try{
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: digite um número válido!");
            System.out.println("-----------------------------------------");
            scanner.nextLine();
            return -999;
        }
    }
}