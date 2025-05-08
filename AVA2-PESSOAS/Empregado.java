public class Empregado extends Pessoa {
    protected int matricula;
    protected double salario;

    public Empregado(String nome, String cpf, String endereco, String telefone, String email, int matricula, double salario) {
        super(nome, cpf, endereco, telefone, email);
        this.matricula = matricula;
        this.salario = salario;
    }

    public double calcularSalario() {
        return salario;
    }
}