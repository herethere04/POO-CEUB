public class Cliente extends Pessoa {
    private final int codigoCliente;

    public Cliente(String nome, String cpf, String endereco, String telefone, String email, int codigoCliente) {
        super(nome, cpf, endereco, telefone, email);
        this.codigoCliente = codigoCliente;
    }

    public void realizarCompra() {
        System.out.println(nome + " realizou uma compra.");
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }
}