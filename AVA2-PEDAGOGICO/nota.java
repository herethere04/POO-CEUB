public class Nota {
    private double valor;
    private Atividade atividade;

    public Nota(double valor, Atividade atividade) {
        this.valor = valor;
        this.atividade = atividade;
    }

    public double getNota() {
        return valor;
    }

    public Atividade getAtividade() {
        return atividade;
    }
}
