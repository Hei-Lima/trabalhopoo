public class Main {
    public static void main(String[] args) {
        Veiculo v = new Veiculo("Mercedes", "B2000", 2014, 12, 2015, 12000.99);
        Eletrico e = new Eletrico("BYD", "King", 2022, 10, 2023, 320000.99, 100.29, 212.212);
        Combustao c = new Combustao("Honda", "Civic", 2021, 9, 2022, 120000.10, 100.2, 200.2);
        Hibrido h = new Hibrido("Toyota", "Corolla", 2020, 2, 2021, 2000.212, 100, 2000, 300, 2000);

        System.out.println(v.toString());
        System.out.println(e.toString());
        System.out.println(c.toString());
        System.out.println(h.toString());
    }
}