//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Entrada io = new Entrada();
        Sistema s = new Sistema();

        int op = io.menu();

        while (op != 0) {
            switch(op) {
                case 1:
                    io.cadCliente(s); break;
                case 2:
                    io.cadVendedor(s); break;
                case 3:
                    io.cadGerentes(s); break;
                case 4:
                    io.cadVeiculos(s); break;
                case 5:
                    io.cadVenda(s); break;
                case 6:
                    io.relatorioMensal(s); break;
                case 7:
                    io.relatorioAnual(s); break;
                case 8:
                    io.relatorioVendedor(s); break;
            }

            op = io.menu();
        }
    }
}