public class SimulacaoCaixaSupermercado {

    public int numeroCaixas;
    public int mediaAtendimentos;

    public double mediaTempoAtendimentoPorCliente;
    public double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;

    private final java.util.Random rng = new java.util.Random(42);

    public void setNumeroCaixas(int numeroCaixas) { this.numeroCaixas = numeroCaixas; }
    public void setMediaAtendimentos(int mediaAtendimentos) { this.mediaAtendimentos = mediaAtendimentos; }
    public void setMediaTempoAtendimentoPorCliente(double media) { this.mediaTempoAtendimentoPorCliente = media; }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double desvio) { this.desvioPadraoTempoAtendimentoPorCliente = desvio; }

    private double tempoAtendimentoNormalTruncado() {
        double numeroAleatorio = rng.nextGaussian();
        double tempoCalculado = mediaTempoAtendimentoPorCliente + desvioPadraoTempoAtendimentoPorCliente * numeroAleatorio;
        return (tempoCalculado < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : tempoCalculado;
    }

    public double simular() {
        double somaTemposTotais = 0.0;
        int clientesPorCaixa = mediaAtendimentos / numeroCaixas;
        int clientesExtras = mediaAtendimentos % numeroCaixas;
        
        for (int caixa = 0; caixa < numeroCaixas; caixa++) {
            if (caixa == mediaAtendimentos) break;
            if (caixa < clientesExtras) {
                somaTemposTotais += SimularCaixa(clientesPorCaixa + 1);
            } else {
                somaTemposTotais += SimularCaixa(clientesPorCaixa);
            }
        }
        return somaTemposTotais / mediaAtendimentos;
    }

    public double SimularCaixa(int numeroClientes) {
        double tempoAcumulado = 0.0;
        double tempoTotalClientes = 0.0;
        
        for (int cliente = 0; cliente < numeroClientes; cliente++) {
            tempoAcumulado += tempoAtendimentoNormalTruncado();
            tempoTotalClientes += tempoAcumulado;
        }
        return tempoTotalClientes;
    }
}