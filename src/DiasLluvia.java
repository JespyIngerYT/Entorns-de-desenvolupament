public class DiasLluvia {

    private boolean[][] lluvia = new boolean[12][31];

    public boolean registroDia(int dia, int mes, boolean llueve) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        }
        lluvia[mes - 1][dia - 1] = llueve;
        return true;
    }

    public boolean consultarDia(int dia, int mes) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        }
        return lluvia[mes - 1][dia - 1];
    }

    public int contarDiasLluviosos() {
        int contador = 0;
        for (int m = 0; m < 12; m++) {
            for (int d = 0; d < 31; d++) {
                if (lluvia[m][d]) contador++;
            }
        }
        return contador;
    }

    public int trimestreLluvioso() {
        int[] trimestres = new int[4];

        for (int m = 0; m < 12; m++) {
            for (int d = 0; d < 31; d++) {
                if (lluvia[m][d]) {
                    trimestres[m / 3]++;
                }
            }
        }

        int max = 0;
        int indice = 0;

        for (int i = 0; i < 4; i++) {
            if (trimestres[i] > max) {
                max = trimestres[i];
                indice = i;
            }
        }

        return indice + 1;
    }

    public int primerDiaLluvia() {
        int diaAnual = 1;

        for (int m = 0; m < 12; m++) {
            for (int d = 0; d < 31; d++) {
                if (lluvia[m][d]) return diaAnual;
                diaAnual++;
            }
        }
        return -1;
    }
}