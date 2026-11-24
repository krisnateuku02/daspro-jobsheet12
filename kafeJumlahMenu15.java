public class kafeJumlahMenu15 {
    public static void main(String[] args) {
        int totalItem = jumlahMenu();
        System.out.println("Jumlah menu yang tersedia: " + totalItem);

        System.out.println("Total porsi jika masing-masing pesan 2: " + (jumlahMenu() * 2));
    }

    public static int jumlahMenu() {
        return 6;
    }
}
