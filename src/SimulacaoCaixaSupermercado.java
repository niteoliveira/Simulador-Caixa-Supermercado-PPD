public class SimulacaoCaixaSupermercado {

    public int numeroCaixas;
    public int mediaAtendimentos;

    public double mediaTempoAtendimentoPorCliente;
    public double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;

    private final java.util.Random rng = new java.util.Random(42);

    public void setNumeroCaixas(int n) { this.numeroCaixas = n; }
    public void setMediaAtendimentos(int n) { this.mediaAtendimentos = n; }
    public void setMediaTempoAtendimentoPorCliente(double mu) { this.mediaTempoAtendimentoPorCliente = mu; }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double sigma) { this.desvioPadraoTempoAtendimentoPorCliente = sigma; }

    private double tempoAtendimentoNormalTruncado() {
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente + desvioPadraoTempoAtendimentoPorCliente * z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public double simular() {
        double total = 0.0;
        int clientesBase = mediaAtendimentos / numeroCaixas;
        int resto = mediaAtendimentos % numeroCaixas;
        
        for (int i = 0; i < numeroCaixas; i++) {
            if (i == mediaAtendimentos) break;
            if (i < resto) {
                total += SimularCaixa(clientesBase + 1);
            } else {
                total += SimularCaixa(clientesBase);
            }
        }
        return total / mediaAtendimentos;
    }

    public double SimularCaixa(int numeroClientes) {
        double soma = 0.0;
        double temp = 0.0;
        
        for (int i = 0; i < numeroClientes; i++) {
            soma += tempoAtendimentoNormalTruncado();
            temp += soma;
        }
        return temp;
    }
}