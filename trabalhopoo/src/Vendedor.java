import java.util.ArrayList;
import java.util.Arrays;

public class Vendedor extends Funcionario {
    private double comissao;
    private ArrayList<Venda> vendidos = new ArrayList<>();

    public Vendedor(String nome, String cpf, int dia, int mes, int ano, double salario, double comissao) {
        super(nome, cpf, dia, mes, ano, salario);
        this.comissao = comissao;
    }

    public void addVenda(Venda v) {
        vendidos.add(v);
    }

    public double comissaoTotal(int mes, int ano) {
        double valorTotal = 0;
        for (Venda v : vendidos) {
            Data data = v.d;
            if (data.getAno() == ano && data.getMes() == mes) {
                valorTotal += v.valor();
            };
        };
        return valorTotal * comissao;
    }

    public double comissaoTotal(int ano) {
        double valorTotal = 0;
        for (Venda v : vendidos) {
            Data data = v.d;
            if (data.getAno() == ano) {
                valorTotal += v.valor();
            };
        };
        return valorTotal * comissao;
    }

    @Override
    public double getSalario(int mes, int ano) {
        return super.getSalario(mes, ano) + comissaoTotal(mes, ano);
    }
}
