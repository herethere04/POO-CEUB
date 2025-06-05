package escolar;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private double vlrMensalidade;
    private double percentualDesconto; // Para Aluno, é o desconto direto; para Empresa, é um fator.

    // Construtor Padrão
    public Pessoa() {}

    // POLIMORFISMO: Sobrecarga (Overload) de Construtor
    // Justificativa: Permite criar um objeto Pessoa fornecendo um conjunto mínimo de informações
    // essenciais (nome, email, valor da mensalidade, percentual base de desconto),
    // enquanto outro construtor (abaixo) pode ser usado para fornecer todos os detalhes.
    // O compilador escolhe qual construtor chamar baseado nos argumentos fornecidos.
    public Pessoa(String nome, String email, double vlrMensalidade, double percentualDesconto) {
        this.nome = nome;
        this.email = email;
        this.vlrMensalidade = vlrMensalidade;
        this.percentualDesconto = percentualDesconto;
    }

    // POLIMORFISMO: Sobrecarga (Overload) de Construtor
    // Justificativa: Permite criar um objeto Pessoa fornecendo um conjunto completo de informações.
    // Esta é uma sobrecarga do construtor anterior, diferenciando-se pela quantidade
    // e tipo dos parâmetros. Facilita a instanciação do objeto com diferentes níveis de detalhe.
    public Pessoa(String nome, String endereco, String telefone, String email, double vlrMensalidade, double percentualDesconto) {
        this(nome, email, vlrMensalidade, percentualDesconto); // Chama o construtor sobrecarregado
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e Setters (Padrão CamelCase)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVlrMensalidade() {
        return vlrMensalidade;
    }

    public void setVlrMensalidade(double vlrMensalidade) {
        this.vlrMensalidade = vlrMensalidade;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    // Método abstrato para cálculo de desconto - será implementado nas subclasses
    // Este é o ponto principal para a sobrescrita (Overriding)
    public abstract double calcularDesconto();

    // O método entrarPessoal() conforme descrito (para popular o objeto)
    // será efetivamente realizado através dos setters e construtores,
    // com os dados vindos da interface gráfica.
    // Não haverá um método chamado entrarPessoal() diretamente aqui,
    // pois a entrada de dados é feita pela GUI e os dados são passados
    // para os construtores/setters.

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nEndereço: " + (endereco != null ? endereco : "N/A") +
               "\nTelefone: " + (telefone != null ? telefone : "N/A") +
               "\nEmail: " + email +
               "\nValor Mensalidade: R$" + String.format("%.2f", vlrMensalidade) +
               "\nPercentual Base Desconto: " + String.format("%.2f%%", percentualDesconto * 100);
    }
}