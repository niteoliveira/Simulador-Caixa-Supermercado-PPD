import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {

        final int NUMERO_SIMULACOES = 100;
        final List<Double> mediasAtendimento = new ArrayList<>();

        SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

        simulador.setNumeroCaixas(3);
        simulador.setMediaAtendimentos(100);
        simulador.setMediaTempoAtendimentoPorCliente(5.00);
        simulador.setDesvioPadraoTempoAtendimentoPorCliente(2.0);
        
        for (int i = 0; i < NUMERO_SIMULACOES; i++) {
            double mediaAtendimento = simulador.simular();
            mediasAtendimento.add(mediaAtendimento);
        }

        double media = media(mediasAtendimento);
        double dp = desvioPadrao(mediasAtendimento, media);

        System.out.printf("=== SIMULAÇÃO DE FILA REAL DE SUPERMERCADO ===%n");
        System.out.printf("Configuração:%n");
        System.out.printf("  - Número de caixas: %d%n", simulador.numeroCaixas);
        System.out.printf("  - Total de clientes: %d%n", simulador.mediaAtendimentos);
        System.out.printf("  - Tempo médio por atendimento: %.2f min%n", simulador.mediaTempoAtendimentoPorCliente);
        System.out.printf("  - Desvio padrão: %.2f min%n", simulador.desvioPadraoTempoAtendimentoPorCliente);
        System.out.printf("  - Simulações realizadas: %d%n%n", NUMERO_SIMULACOES);
        
        System.out.printf("Resultados:%n");
        System.out.printf("  - Tempo médio por cliente (fila + atendimento): %.2f min%n", media);
        System.out.printf("  - Desvio padrão das médias: %.2f min%n", dp);
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}