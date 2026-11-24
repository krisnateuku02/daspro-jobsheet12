import java.util.Scanner;

public class TabungKerucut15 {

    static boolean isGanjil(int absen) {
        return absen % 2 != 0;
    }

    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    static double luasPermukaanTabung(double r, double t) {
        return 2 * Math.PI * r * (r + t);
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nomor absen Anda: ");
        int noAbsen = sc.nextInt();

        if (!isGanjil(noAbsen)) {
            System.out.println("Nomor absen " + noAbsen + " adalah GENAP (tidak sesuai ketentuan untuk TabungKerucut15). Program selesai.");
            sc.close();
            return;
        }

        int pilihan;
        do {
            System.out.println("\n=== MENU BANGUN RUANG (TABUNG & KERUCUT - ABSEN GANJIL) ===");
            System.out.println("1. Hitung Luas Lingkaran");
            System.out.println("2. Hitung Volume Tabung");
            System.out.println("3. Hitung Luas Permukaan Tabung");
            System.out.println("4. Hitung Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r1 = sc.nextDouble();
                    System.out.println("Luas Lingkaran = " + luasLingkaran(r1));
                    break;
                case 2:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r2 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t2 = sc.nextDouble();
                    System.out.println("Volume Tabung = " + volumeTabung(r2, t2));
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r3 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t3 = sc.nextDouble();
                    System.out.println("Luas Permukaan Tabung = " + luasPermukaanTabung(r3, t3));
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r4 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t4 = sc.nextDouble();
                    System.out.println("Volume Kerucut = " + volumeKerucut(r4, t4));
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}