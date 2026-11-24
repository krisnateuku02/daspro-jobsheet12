import java.util.Scanner;

public class RekapLaundry15 {

    static String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    // Menginputkan data berat cucian setiap layanan untuk setiap hari
    static void inputData(int[][] data, String[] layanan, Scanner sc) {
        System.out.println("\n=== INPUT DATA BERAT CUCIAN (KG) ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  " + hari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    // Menampilkan seluruh data dalam bentuk tabel
    static void tampilTabel(String[] layanan, int[] hargaPerKg, int[][] data) {
        System.out.println("\n=== REKAP BERAT CUCIAN LAUNDRY (KG) ===");
        System.out.printf("%-16s %-12s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-8s", h);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-16s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    // Mengembalikan total berat cucian satu layanan selama 6 hari
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    // Menampilkan layanan dengan total berat cucian tertinggi (nama layanan dan totalnya)
    static void tampilLayananTertinggi(String[] layanan, int[][] data) {
        int idxTerbanyak = 0;
        int maxTotal = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int totalSaatIni = totalPerLayanan(data, i);
            if (totalSaatIni > maxTotal) {
                maxTotal = totalSaatIni;
                idxTerbanyak = i;
            }
        }

        System.out.println("\nLayanan dengan total berat cucian tertinggi:");
        System.out.println("- Layanan : " + layanan[idxTerbanyak]);
        System.out.println("- Total   : " + maxTotal + " kg");
    }

    // Mengembalikan indeks hari dengan total berat cucian terbesar
    static int hariTersibuk(int[][] data) {
        int jumlahHari = data[0].length;
        int idxHariTerbanyak = 0;
        int maxBeratHari = 0;

        for (int i = 0; i < data.length; i++) {
            maxBeratHari += data[i][0];
        }

        for (int j = 1; j < jumlahHari; j++) {
            int totalHariIni = 0;
            for (int i = 0; i < data.length; i++) {
                totalHariIni += data[i][j];
            }
            if (totalHariIni > maxBeratHari) {
                maxBeratHari = totalHariIni;
                idxHariTerbanyak = j;
            }
        }

        return idxHariTerbanyak;
    }

    // Menghitung dan menampilkan pendapatan setiap layanan serta total pendapatan selama 6 hari
    static void tampilPendapatan(String[] layanan, int[] hargaPerKg, int[][] data) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN ===");
        long totalPendapatan = 0;

        for (int i = 0; i < layanan.length; i++) {
            long totalKg = totalPerLayanan(data, i);
            long pendapatanLayanan = totalKg * hargaPerKg[i];
            totalPendapatan += pendapatanLayanan;
            System.out.printf("%-16s : %3d kg x Rp%-7d = Rp%d%n",
                    layanan[i], totalKg, hargaPerKg[i], pendapatanLayanan);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total pendapatan selama 6 hari : Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        int[][] dataBerat = {
            {12, 15, 10, 18, 20, 25},
            {20, 18, 22, 15, 30, 35},
            {8,  5,  10, 7,  6,  12},
            {3,  6,  2,  5,  8,  10}
        };

        System.out.print("Apakah ingin menginput ulang data berat cucian? (y/n): ");
        String jawab = sc.next();
        if (jawab.equalsIgnoreCase("y")) {
            inputData(dataBerat, layanan, sc);
        }

        tampilTabel(layanan, hargaPerKg, dataBerat);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(dataBerat, i) + " kg");
        }

        tampilLayananTertinggi(layanan, dataBerat);

        int idxSibuk = hariTersibuk(dataBerat);
        System.out.println("\nHari tersibuk: " + hari[idxSibuk]);

        tampilPendapatan(layanan, hargaPerKg, dataBerat);

        sc.close();
    }
}