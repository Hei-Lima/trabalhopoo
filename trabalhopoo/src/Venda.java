public class Venda {
    Veiculo veiculo;
    Cliente cliente;
    double desconto;
    Data d;
    String chassi;

    public Venda(Veiculo veiculo, Cliente cliente, Data d, String chassi) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.d = d;
        this.chassi = chassi;
    }

    public double valor() {
        return veiculo.valor - veiculo.valor * desconto;
    }

    public void setDesconto(double desconto, Gerente gerente, String senha) {
        if (gerente.validarAcesso(senha)) {
            this.desconto = desconto;
        }
    }

    public String toString() {
        return "Veiculo: " + veiculo +
                "\nCliente: " + cliente +
                "\nValor: R$" + valor() +
                "\nData: " + d;
    }
}
