import java.util.Scanner;

public class RekapLaundry15 {

    static String buatLabelHari(int idxHari) {
        return "Hari ke-" + (idxHari + 1);
    }

    static void inputLayanan(String[] layanan, int[] hargaPerKg, Scanner sc) {
        sc.nextLine(); // membersihkan sisa newline
        for (int i = 0; i < layanan.length; i++) {
            System.out.print("Masukkan nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Masukkan harga per kg untuk " + layanan[i] + " (Rp): ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine(); // membersihkan sisa newline
        }
    }

    static void inputData(int[][] data, String[] layanan, Scanner sc) {
        System.out.println("\n=== INPUT DATA BERAT CUCIAN (KG) ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  " + buatLabelHari(j) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(String[] layanan, int[] hargaPerKg, int[][] data) {
        int jumlahHari = data[0].length;
        System.out.println("\n=== REKAP BERAT CUCIAN LAUNDRY (KG) ===");
        System.out.printf("%-16s %-12s", "Layanan", "Harga/kg");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.printf("%-11s", buatLabelHari(j));
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-16s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf("%-11d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

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

    static void tampilPendapatan(String[] layanan, int[] hargaPerKg, int[][] data) {
        int jumlahHari = data[0].length;
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
        System.out.println("Total pendapatan selama " + jumlahHari + " hari : Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();

        String[] layanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        int[][] dataBerat = new int[jumlahLayanan][jumlahHari];

        inputLayanan(layanan, hargaPerKg, sc);
        inputData(dataBerat, layanan, sc);

        tampilTabel(layanan, hargaPerKg, dataBerat);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(dataBerat, i) + " kg");
        }

        tampilLayananTertinggi(layanan, dataBerat);

        int idxSibuk = hariTersibuk(dataBerat);
        System.out.println("\nHari tersibuk: " + buatLabelHari(idxSibuk));

        tampilPendapatan(layanan, hargaPerKg, dataBerat);

        sc.close();
    }
}