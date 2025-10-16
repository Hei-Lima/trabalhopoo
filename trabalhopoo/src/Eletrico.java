public class Eletrico extends Veiculo {
    private double autonomiaBat;
    private double capacidadeBat;

    public Eletrico(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonomiaBat, double capacidadeBat) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaBat = autonomiaBat;
        this.capacidadeBat = capacidadeBat;
    }

    // Sim, também acho estranho o getter ser de um tipo diferente do que o atributo :P
    @Override
    public int getAutonomia() {
        return (int) this.autonomiaBat;
    }

    @Override
    public String toString() {
        return super.toString() + " (Elétrico)";
    }

}
