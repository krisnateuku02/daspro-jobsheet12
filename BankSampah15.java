import java.util.Scanner;

public class BankSampah15 {

    // a. Menerima parameter n, membaca berat setoran tiap nasabah, dan mengembalikan array double[]
    static double[] inputSetoran(int n, Scanner sc) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    // b. Menerima parameter array setoran dan menampilkan berat setoran setiap nasabah
    static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DAFTAR SETORAN SAMPAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    // c. Menerima parameter array setoran dan mengembalikan total berat setoran (double)
    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    // d. Menerima parameter berat setoran (kg) dan harga per kg, mengembalikan saldo (double)
    static double hitungSaldo(double beratKg, double hargaPerKg) {
        return beratKg * hargaPerKg;
    }

    // e. Menerima parameter array setoran dan mengembalikan indeks nasabah dengan setoran terbesar (int)
    static int nasabahTerbanyak(double[] setoran) {
        int idxTerbanyak = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxTerbanyak]) {
                idxTerbanyak = i;
            }
        }
        return idxTerbanyak;
    }

    // f. Membaca N dari input pengguna, memanggil seluruh fungsi di atas, dan menampilkan hasilnya
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double HARGA_PER_KG = 3000.0;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n, sc);
        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("\nTotal berat seluruh setoran: " + totalBerat + " kg");

        System.out.println("\n=== SALDO SETIAP NASABAH (Rp3.000 / kg) ===");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah ke-%d : Rp%.0f%n", (i + 1), saldo);
        }

        int idxTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.println("\nNasabah dengan setoran terbanyak: Nasabah ke-" + (idxTerbanyak + 1)
                + " (" + dataSetoran[idxTerbanyak] + " kg)");

        sc.close();
    }
}