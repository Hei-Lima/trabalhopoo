import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Heitor Lima e Gabriel Brunetti
 */
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O CODIGO DESSA CLASSE!
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            System.out.println("FILE NOT FOUND!");
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar Cliente\n" +
                "2) Cadastrar Vendedor\n" +
                "3) Cadastrar Gerente\n" +
                "4) Cadastrar Veículo Elétrico\n" +
                "6) Cadastrar Veículo A Combustão\n" +
                "7) Cadastrar Veículo Híbrido\n" +
                "8) Cadastrar Venda\n" +
                "9) Histórico de Vendas Mensal\n" +
                "10) Histórico de Vendas Anual\n" +
                "11) Histórico de Vendas do Vendedor:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 11) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Cliente e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadCliente(Sistema s) {
        s.listarClientes();

        String nome = this.lerLinha("Digite o nome do cliente: ");
        String cpf = this.lerLinha("Digite o cpf do cliente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do cliente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do cliente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do cliente: ");
        String email = this.lerLinha("Digite o email do cliente: ");

        if (s.localizarCliente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Cliente c = new Cliente(nome, cpf, dia, mes, ano, email);
            s.adicionar(c);
        }
        else {
            System.out.println("Erro: CPF duplicado. Cliente não adicionado.");
        }
    }

    public void cadVendedor(Sistema s) {
        s.listarVendedores();
        String nome = this.lerLinha("Digite o nome do vendedor: ");
        String cpf = this.lerLinha("Digite o cpf do vendedor: ");
        int dia = this.lerInteiro("Digite o dia de nascimento do vendedor: ");
        int mes = this.lerInteiro("Digite o mes de nascimento do vendedor: ");
        int ano = this.lerInteiro("Digite o ano de nascimento do vendedor: ");
        double salario = this.lerDouble("Digite salário mensal fixo do vendedor: ");
        double comissao = this.lerDouble("Digite o percentual de comissão desse vendedor: ");

        if (s.localizarVendedor(cpf) == null) {
            Vendedor v = new Vendedor(nome, cpf, dia, mes, ano, salario, comissao);
            s.adicionar(v);
        }
        else {
            System.out.println("Erro: CPF duplicado. Vendedor não adicionado.");
        }
    }

    public void cadGerentes(Sistema s) {
        s.listarGerentes();

        String nome = this.lerLinha("Digite o nome do gerente: ");
        String cpf = this.lerLinha("Digite o cpf do gerente: ");
        int dia = this.lerInteiro("Digite o dia do nascimento do gerente: ");
        int mes = this.lerInteiro("Digite o mês do nascimento do gerente: ");
        int ano = this.lerInteiro("Digite o ano do nascimento do gerente: ");
        double salario = this.lerDouble("Digite salário mensal fixo do gerente: ");
        String senha = this.lerLinha("Digite a senha do gerente: ");

        if (s.localizarGerente(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Gerente g = new Gerente(nome, cpf, dia, mes, ano, salario, senha);
            s.adicionar(g);
        }
        else {
            System.out.println("Erro: CPF duplicado. Cliente não adicionado.");
        }
    }

    public void cadVeiculos(Sistema s) {
        s.listarVeiculos();

        String marca = this.lerLinha("Digite a Marca do veículo: ");
        String modelo = this.lerLinha("Digite a Marca do veículo: ");
        int anoFab = this.lerInteiro("Digite o ano de fabricação do veículo: ");
        int mesFab = this.lerInteiro("Digite o mes de fabricação do veículo: ");
        int anoMod = this.lerInteiro("Digite o ano do modelo do veículo: ");
        double valor = this.lerDouble("Digite o valor do veículo: ");

        int escolha = this.lerInteiro("Escolha o tipo do veículo: \n1) Elétrico\n2) Combustão\n3)Híbrido:\n");

        double capBateria;
        double autBateria;
        double capCombustao;
        double autCombustao;

        switch (escolha) {
            case 1:
                autBateria = this.lerDouble("Digite a autonomia da bateria (em km): ");
                capBateria = this.lerDouble("Digite a capacidade da bateria (em kwH): ");
                Eletrico e = new Eletrico(marca, modelo, anoFab, mesFab, anoMod, valor, autBateria, capBateria);
                s.adicionar(e);
                break;
            case 2:
                autCombustao = this.lerDouble("Digite a autonomia do motor (em km): ");
                capCombustao = this.lerDouble("Digite a capacidade do motor (em kwH): ");
                Combustao c = new Combustao(marca, modelo, anoFab, mesFab, anoMod, valor, autCombustao, capCombustao);
                s.adicionar(c);
                break;
            case 3:
                autCombustao = this.lerDouble("Digite a autonomia do motor (em km): ");
                capCombustao = this.lerDouble("Digite a capacidade do motor (em kwH): ");
                autBateria = this.lerDouble("Digite a autonomia da bateria (em km): ");
                capBateria = this.lerDouble("Digite a capacidade da bateria (em kwH): ");
                Hibrido h = new Hibrido(marca, modelo, anoFab, mesFab, anoMod, valor, autCombustao, capCombustao, autBateria, capBateria);
                s.adicionar(h);
                break;
            }
        }

    public void cadVenda(Sistema s) {
        System.out.println("Vendedores cadastrados: ");
        printVendedores(s);
        Vendedor vendedor = s.localizarVendedor(lerLinha("Digite o CPF do vendedor: "));

        System.out.println("\nVeiculos cadastrados: ");
        printVeiculos(s);
        Veiculo veiculo = s.getVeiculos().get(lerInteiro("Escolha um veículo pelo número: 1") - 1);

        System.out.println("Clientes cadastrados: ");
        printClientes(s);
        Cliente cliente = s.localizarCliente(lerLinha("Digite o CPF do cliente: "));

        double desconto = lerDouble("Digite o desconto (em R$): ");
        int dia = lerInteiro("Digite o dia da venda: ");
        int mes = lerInteiro("Digite o mês da venda: ");
        int ano = lerInteiro("Digite o ano da venda: ");
        String chassi = lerLinha("Digite o chassi do veículo: ");

        Venda venda = new Venda(veiculo, cliente, new Data(dia, mes, ano), chassi);
        venda.setDesconto(desconto);
        s.atribuirVendaVendedor(venda, vendedor);
    }

    public void relatorioMensal(Sistema s) {
        int mes = lerInteiro("Digite o mes de mensal: ");
        int ano = lerInteiro("Digite o ano do mensal: ");

        System.out.println("*** RELATÓRIO DE VENDAS MENSAL DE " + mes + "/" + ano + ": ");
        s.relatorio(ano, mes);
    }

    public void relatorioAnual(Sistema s) {
        int ano = lerInteiro("Digite o ano do anual: ");

        System.out.println("*** RELATÓRIO DE VENDAS ANUAL DE " + ano + ": ");
        s.relatorio(ano);
    }

    public void relatorioVendedor(Sistema s) {
        String cpf = lerLinha("Digite o CPF do Vendedor: ");

        System.out.println("*** RELATÓRIO DE VENDAS DO " + s.localizarVendedor(cpf) + ": ");
        s.relatorio(s.localizarVendedor(cpf));
    }

    private void printVeiculos(Sistema s) {
        for (int i = 0; i < s.getVeiculos().size(); i++) {
            Veiculo v = s.getVeiculos().get(i);
            System.out.println(i + 1 + ") " + v);
        }
    }

    private void printVendedores(Sistema s) {
        for (Vendedor v : s.getVendedores()) {
            System.out.println(v);
        }
    }

    private void printClientes(Sistema s) {
        for (Cliente c : s.getClientes()) {
            System.out.println(c);
        }
    }
}
