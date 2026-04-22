public class DividirFactorial {

    private int n;
    private int m;

    public DividirFactorial(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public long divisio() {
        if (n == m) return 1;

        long resultat = 1;

        for (int i = m + 1; i <= n; i++) {
            resultat *= i;
        }

        return resultat;
    }
}