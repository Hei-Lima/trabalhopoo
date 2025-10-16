public class Combustao extends Veiculo {
    private double autonomiaComb;
    private double capacidadeComb;

    public Combustao(String marca, String modelo, int anoFab, int mesFab, int anoMod, double valor, double autonomiaComb, double capacidadeComb) {
        super(marca, modelo, anoFab, mesFab, anoMod, valor);
        this.autonomiaComb = autonomiaComb;
        this.capacidadeComb = capacidadeComb;
    }

    // Sim, também acho estranho o getter ser de um tipo diferente do que o atributo :P
    @Override
    public int getAutonomia() {
        return (int) autonomiaComb;
    }

    @Override
    public String toString() {
        return super.toString() + " (Combustão)";
    }

}
