public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Data nasc;

    public Pessoa(String nome, String cpf, int dia, int mes, int ano) {
        this.nome = nome;
        this.cpf = cpf;
        this.nasc = new Data(dia,mes,ano);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Data getNasc() {
        return nasc;
    }

    public String toString() {
        return this.getNome() + " - CPF: " + this.getCpf();
    }


    public int getIdade(Data hoje) {
        return this.nasc.deltaAnos(hoje);
    }
}
