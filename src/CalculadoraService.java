public class CalculadoraService {

    public int adicao(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a - b;
    }

    public int multiplicacao(int a, int b) {
        return a * b;
    }

    public int divisao(int a, int b) {
        if (b == 0) {
            throw new DivisaoPorZeroException();
        }
        return a / b;
    }
}