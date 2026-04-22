public class Hyperpar {

    private long numero;

    public Hyperpar(long numero) {
        this.numero = numero;
    }

    public boolean esHyperPar() {
        long n = numero;

        if (n == 0) return true;

        while (n > 0) {
            long digit = n % 10;
            if (digit % 2 != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}