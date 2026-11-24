import java.util.Scanner;

public class KubusLimas15 {

    static boolean isGenap(int absen) {
        return absen % 2 == 0;
    }

    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        return (luasPersegi(s) * (double) t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nomor absen Anda: ");
        int noAbsen = sc.nextInt();

        if (!isGenap(noAbsen)) {
            System.out.println("Nomor absen " + noAbsen + " adalah GANJIL (tidak sesuai ketentuan untuk KubusLimas15). Program selesai.");
            sc.close();
            return;
        }

        int pilihan;
        do {
            System.out.println("\n=== MENU BANGUN RUANG (KUBUS & LIMAS PERSEGI - ABSEN GENAP) ===");
            System.out.println("1. Hitung Luas Persegi");
            System.out.println("2. Hitung Volume Kubus");
            System.out.println("3. Hitung Luas Permukaan Kubus");
            System.out.println("4. Hitung Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan sisi (s): ");
                    int s1 = sc.nextInt();
                    System.out.println("Luas Persegi = " + luasPersegi(s1));
                    break;
                case 2:
                    System.out.print("Masukkan sisi (s): ");
                    int s2 = sc.nextInt();
                    System.out.println("Volume Kubus = " + volumeKubus(s2));
                    break;
                case 3:
                    System.out.print("Masukkan sisi (s): ");
                    int s3 = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(s3));
                    break;
                case 4:
                    System.out.print("Masukkan sisi alas (s): ");
                    int s4 = sc.nextInt();
                    System.out.print("Masukkan tinggi limas (t): ");
                    int t4 = sc.nextInt();
                    System.out.println("Volume Limas Persegi = " + volumeLimasPersegi(s4, t4));
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