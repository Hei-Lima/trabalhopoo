public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int deltaAnos(Data outra) {
        int delta = outra.ano - this.ano;
        if (outra.mes < this.mes || (outra.mes == this.mes && outra.dia < this.dia)) {
            delta--;
        }
        return delta;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
