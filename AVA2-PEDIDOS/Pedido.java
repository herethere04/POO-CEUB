import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private String identificadorPedido;
    private LocalDateTime dataHora;
    private Vendedor vendedor;
    private Cliente cliente;
    private String statusPedido; // Em processamento, Enviado, Entregue, Cancelado
    private double valorTotal;
    private List<ItemPedido> itensPedido;

    public Pedido(String identificadorPedido, LocalDateTime dataHora, Vendedor vendedor, Cliente cliente, String statusPedido, List<ItemPedido> itensPedido) {
        this.identificadorPedido = identificadorPedido;
        this.dataHora = dataHora;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.statusPedido = statusPedido;
        this.itensPedido = itensPedido;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        this.valorTotal = 0.0;
        for (ItemPedido item : itensPedido) {
            this.valorTotal += item.getPrecoUnitario() * item.getQuantidade();
        }
    }

  
    public String getIdentificadorPedido() {
        return identificadorPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
