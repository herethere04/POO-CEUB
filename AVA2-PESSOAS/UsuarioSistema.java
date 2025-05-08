public class UsuarioSistema extends Pessoa {
    private final String login;
    private final String senha;

    public UsuarioSistema(String nome, String cpf, String endereco, String telefone, String email, String login, String senha) {
        super(nome, cpf, endereco, telefone, email);
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}