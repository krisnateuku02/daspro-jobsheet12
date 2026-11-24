public class HitungBalok15 {

    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void prosesBalok(int ke, int p, int l, int t) {
        int luasPermukaan = hitungLuasPermukaanBalok(p, l, t);
        int volume = hitungVolume(t, p, l);

        System.out.println("=== Balok ke-" + ke + " ===");
        System.out.println("Luas Permukaan Balok : " + luasPermukaan);
        System.out.println("Volume Balok         : " + volume);
    }

    public static void main(String[] args) {
        prosesBalok(1, 4, 3, 5);
        prosesBalok(2, 6, 2, 4);
        prosesBalok(3, 10, 5, 3);
    }
}