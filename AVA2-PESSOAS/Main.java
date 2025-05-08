public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Maria Silva", "12345678900", "Rua A", "11999999999", "maria@email.com", 101);
        cliente.exibirDados();
        cliente.realizarCompra();

        System.out.println();

        Fornecedor fornecedor = new Fornecedor("Carlos Souza", "98765432100", "Rua B", "11888888888", "carlos@empresa.com", "12345678000190", "Distribuidora XYZ");
        fornecedor.exibirDados();
        fornecedor.fornecerProduto();

        System.out.println();

        Empregado empregado = new Empregado("Ana Paula", "45612378900", "Rua C", "11777777777", "ana@empresa.com", 2022, 3000.00);
        empregado.exibirDados();
        System.out.println("Salário: R$ " + empregado.calcularSalario());

        System.out.println();

        Vendedor vendedor = new Vendedor("João Pedro", "78945612300", "Rua D", "11666666666", "joao@empresa.com", 2023, 2500.00, 700.00);
        vendedor.exibirDados();
        System.out.println("Salário com comissão: R$ " + vendedor.calcularSalario());

        System.out.println();

        UsuarioSistema usuario = new UsuarioSistema("Admin", "00000000000", "Rua E", "11555555555", "admin@empresa.com", "admin", "1234");
        usuario.exibirDados();
        System.out.println("Autenticação (admin, 1234): " + usuario.autenticar("admin", "1234"));
    }
}