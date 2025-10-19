import java.util.ArrayList;

public class Sistema {
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Cliente> clientes;

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public void adicionar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void adicionar(Veiculo veiculo){this.veiculos.add(veiculo);}

    public void adicionar(Gerente gerente){this.gerentes.add(gerente);}

    public void adicionar(Vendedor vendedor){this.vendedores.add(vendedor);}

    public ArrayList<Venda> getVendas(int mes, int ano) {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (Vendedor v : vendedores) {
            System.out.println("Vendedor: " + v.getNome() + " (Salário neste mês: R$" +  v.getSalario(mes, ano) + ")");
            vendas.addAll(v.getVendidos());
        }
        return vendas;
    }

    public ArrayList<Venda> getVendas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (Vendedor v : vendedores) {
            System.out.println("Vendedor: " + v.getNome());
            vendas.addAll(v.getVendidos());
        }
        return vendas;
    }

    public void listarClientes() {
        System.out.println("Clientes cadastrados:");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        }
        else {
            for (Cliente c : this.clientes) {
                System.out.println(c);
            }
        }
    }

    public void listarVendedores() {
        System.out.println("Vendedores cadastrados:");

        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado");
        }
        else {
            for (Vendedor v : this.vendedores) {
                System.out.println(v);
            }
        }
    }

    public void listarGerentes() {
        System.out.println("Gerentes cadastrados:");

        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado");
        }
        else {
            for (Gerente g : this.gerentes) {
                System.out.println(g);
            }
        }
    }

    public void listarVeiculos() {
        System.out.println("Veículos cadastrados:");

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado");
        }
        else {
            for (Veiculo v : this.veiculos) {
                System.out.println(v);
            }
        }
    }

    public Cliente localizarCliente(String cpf) {
        for (Cliente c : this.clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Gerente localizarGerente(String cpf) {
        for (Gerente c : this.gerentes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Vendedor localizarVendedor(String cpf) {
        for (Vendedor c : this.vendedores) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public void atribuirVendaVendedor(Venda venda, Vendedor vendedor) {
        vendedor.addVenda(venda);
    }

    public void relatorio(int ano, int mes) {
        ArrayList<Venda> v = getVendas(mes, ano);
        double total = 0.0;
        for (Venda venda : v) {
            Data data = venda.d;
            if (data.getAno() == ano && data.getMes() == mes) {
                total += venda.valor();
                System.out.println(venda);
                System.out.println("***************************************");
            }
        }
        System.out.println("Total de vendas: " + total);
    }

    public void relatorio(int ano) {
        ArrayList<Venda> v = getVendas();
        double total = 0.0;
        for (Venda venda : v) {
            Data data = venda.d;
            if (data.getAno() == ano) {
                total += venda.valor();
                System.out.println(venda);
                System.out.println("***************************************");
            }
        }
        System.out.println("Total de vendas: " + total);    }

    public void relatorio(Vendedor v) {
        double total = 0.0;
        for (Venda venda : v.getVendidos()) {
            total += venda.valor();
            System.out.println(venda);
            System.out.println("***************************************");
        }
        System.out.println("Total de vendas: " + total);
    }

}
