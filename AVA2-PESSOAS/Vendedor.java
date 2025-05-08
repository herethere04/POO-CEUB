public class Vendedor extends Empregado {
    private final double comissao;

    public Vendedor(String nome, String cpf, String endereco, String telefone, String email, int matricula, double salario, double comissao) {
        super(nome, cpf, endereco, telefone, email, matricula, salario);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return salario + comissao;
    }
}