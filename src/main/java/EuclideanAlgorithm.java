public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcp(24, 9));
    }

    public static int gcp(int x, int y) {
        int r = x % y;
        if (r == 0) return y;
        return gcp(y, r);
    }
}
