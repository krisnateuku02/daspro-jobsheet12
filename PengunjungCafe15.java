public class PengunjungCafe15 {
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja " + nomorMeja + " - Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        daftarPengunjung(5, "Ali", "Budi", "Citra");
    }
}