public class Compte {

    private String iban;
    private String titular;

    public Compte(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }

    public boolean compruebaIBAN(String iban) {
        if (iban == null || iban.length() < 4) return false;

        if (!iban.startsWith("ES")) return false;

        String ccc = iban.substring(4) + "ES00";

        StringBuilder numeric = new StringBuilder();

        for (char c : ccc.toCharArray()) {
            if (Character.isLetter(c)) {
                numeric.append((int) c - 55); // E=14, S=28
            } else {
                numeric.append(c);
            }
        }

        java.math.BigInteger num = new java.math.BigInteger(numeric.toString());
        int resta = num.mod(java.math.BigInteger.valueOf(97)).intValue();

        int dc = 98 - resta;

        String dcCalc = String.format("%02d", dc);

        return iban.substring(2, 4).equals(dcCalc);
    }

    public String generaIBAN(String entitat, String oficina, String dc, String compte) {

        if (!valid(entitat, 4)) return null;
        if (!valid(oficina, 4)) return null;
        if (!valid(dc, 2)) return null;
        if (!valid(compte, 10)) return null;

        String ccc = entitat + oficina + dc + compte;

        String base = ccc + "ES00";

        StringBuilder numeric = new StringBuilder();

        for (char c : base.toCharArray()) {
            if (Character.isLetter(c)) {
                numeric.append((int) c - 55);
            } else {
                numeric.append(c);
            }
        }
        java.math.BigInteger num = new java.math.BigInteger(numeric.toString());
        int resta = num.mod(java.math.BigInteger.valueOf(97)).intValue();

        int dcCalc = 98 - resta;

        String dcFinal = String.format("%02d", dcCalc);

        return "ES" + dcFinal + ccc;
    }

    private boolean valid(String s, int length) {
        return s != null && s.length() == length && s.matches("\\d+");
    }
}