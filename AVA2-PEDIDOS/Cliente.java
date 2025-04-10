public class Cliente {
    private String nomeCompleto;
    private String cpf;
    private String enderecoCompleto;
    private String telefone;

    public Cliente(String nomeCompleto, String cpf, String enderecoCompleto, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.enderecoCompleto = enderecoCompleto;
        this.telefone = telefone;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public String getTelefone() {
        return telefone;
    }
}
