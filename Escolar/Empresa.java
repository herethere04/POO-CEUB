package escolar;

public class Empresa extends Pessoa {
    private int qtdColaboradores;

    public Empresa() {
        super();
    }

    // Construtor utilizando a sobrecarga da superclasse que pega todos os campos
    public Empresa(String nome, String endereco, String telefone, String email, double vlrMensalidade, double percentualDesconto, int qtdColaboradores) {
        super(nome, endereco, telefone, email, vlrMensalidade, percentualDesconto);
        this.qtdColaboradores = qtdColaboradores;
    }
    
    // Construtor utilizando a sobrecarga da superclasse que pega campos essenciais
    public Empresa(String nome, String email, double vlrMensalidade, double percentualDesconto, int qtdColaboradores) {
        super(nome, email, vlrMensalidade, percentualDesconto);
        this.qtdColaboradores = qtdColaboradores;
    }

    public int getQtdColaboradores() {
        return qtdColaboradores;
    }

    public void setQtdColaboradores(int qtdColaboradores) {
        this.qtdColaboradores = qtdColaboradores;
    }

    // POLIMORFISMO: Sobrescrita (Override)
    // Justificativa: A classe Empresa herda da classe Pessoa, mas possui uma forma
    // específica de calcular o desconto (valorDesconto = vlrMensalidade * (percentualDesconto * qtdColaboradores)).
    // A sobrescrita permite que a classe Empresa implemente sua própria lógica para o método
    // calcularDesconto(), mantendo a mesma assinatura do método abstrato definido na superclasse Pessoa.
    // Isso garante que, ao chamar o método calcularDesconto() em um objeto do tipo Pessoa que
    // na verdade é uma instância de Empresa, a implementação correta (de Empresa) seja executada.
    @Override
    public double calcularDesconto() {
        // valorDesconto = vlrMensalidade * (percentualDesconto * qtdColaboradores)
        return getVlrMensalidade() * (getPercentualDesconto() * this.qtdColaboradores);
    }

    @Override
    public String toString() {
        return "--- Empresa --- \n" + super.toString() +
               "\nQuantidade de Colaboradores: " + qtdColaboradores +
               "\nTipo de Desconto: Multiplicado pela quantidade de colaboradores";
    }
}