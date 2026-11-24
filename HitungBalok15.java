public class HitungBalok15 {

    static int hitungLuas(int pjg, int lb) {
        return pjg * lb;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int kurang(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        int p = 4;
        int l = 3;
        int t = 5;

        int volBenar = hitungVolume(t, p, l);
        int volTertukar = hitungVolume(p, l, t);

        System.out.println("hitungVolume(t, p, l) = " + volBenar);
        System.out.println("hitungVolume(p, l, t) = " + volTertukar);

        System.out.println("kurang(10, 3) = " + kurang(10, 3));
        System.out.println("kurang(3, 10) = " + kurang(3, 10));
    }
}