public class HitungBalok15 {
    public static void main(String[] args) {
        int p1 = 4, l1 = 3, t1 = 5;
        int luasPermukaan1 = 2 * (p1 * l1 + p1 * t1 + l1 * t1);
        int volume1 = p1 * l1 * t1;
        System.out.println("=== Balok ke-1 ===");
        System.out.println("Luas Permukaan Balok : " + luasPermukaan1);
        System.out.println("Volume Balok         : " + volume1);

        int p2 = 6, l2 = 2, t2 = 4;
        int luasPermukaan2 = 2 * (p2 * l2 + p2 * t2 + l2 * t2);
        int volume2 = p2 * l2 * t2;
        System.out.println("=== Balok ke-2 ===");
        System.out.println("Luas Permukaan Balok : " + luasPermukaan2);
        System.out.println("Volume Balok         : " + volume2);

        int p3 = 10, l3 = 5, t3 = 3;
        int luasPermukaan3 = 2 * (p3 * l3 + p3 * t3 + l3 * t3);
        int volume3 = p3 * l3 * t3;
        System.out.println("=== Balok ke-3 ===");
        System.out.println("Luas Permukaan Balok : " + luasPermukaan3);
        System.out.println("Volume Balok         : " + volume3);
    }
}