public class Fornecedor extends Pessoa {
    private final String cnpj;
    private final String empresa;

    public Fornecedor(String nome, String cpf, String endereco, String telefone, String email, String cnpj, String empresa) {
        super(nome, cpf, endereco, telefone, email);
        this.cnpj = cnpj;
        this.empresa = empresa;
    }

    public void fornecerProduto() {
        System.out.println("Fornecedor " + nome + " forneceu um produto da empresa " + empresa);
    }

    public String getCnpj() {
        return cnpj;
    }
}