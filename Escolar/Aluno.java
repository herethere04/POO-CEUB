package escolar;

public class Aluno extends Pessoa {

    public Aluno() {
        super();
    }

    public Aluno(String nome, String endereco, String telefone, String email, double vlrMensalidade, double percentualDesconto) {
        super(nome, endereco, telefone, email, vlrMensalidade, percentualDesconto);
    }

    public Aluno(String nome, String email, double vlrMensalidade, double percentualDesconto) {
        super(nome, email, vlrMensalidade, percentualDesconto);
    }

    // POLIMORFISMO: Sobrescrita (Override)
    // Justificativa: A classe Aluno herda da classe Pessoa, mas possui uma forma
    // específica de calcular o desconto (valorDesconto = vlrMensalidade * percentualDesconto).
    // A sobrescrita permite que a classe Aluno implemente sua própria lógica para o método
    // calcularDesconto(), mantendo a mesma assinatura do método abstrato definido na superclasse Pessoa.
    // Isso garante que, ao chamar o método calcularDesconto() em um objeto do tipo Pessoa que
    // na verdade é uma instância de Aluno, a implementação correta (de Aluno) seja executada.
    @Override
    public double calcularDesconto() {
        // valorDesconto = vlrMensalidade * percentualDesconto
        return getVlrMensalidade() * getPercentualDesconto();
    }

    @Override
    public String toString() {
        return "--- Aluno --- \n" + super.toString() +
               "\nTipo de Desconto: Direto sobre percentual informado";
    }
}