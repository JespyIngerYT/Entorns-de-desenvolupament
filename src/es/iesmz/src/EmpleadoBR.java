public class EmpleadoBR {

    public static float calculaSalarioBruto(TipoEmpleado tipus, float ventasMes, float horasExtra) {
        if (tipus == null || ventasMes < 0 || horasExtra < 0) {
            return -1;
        }

        float salarioBase = 0;
        switch (tipus) {
            case vendedor -> salarioBase = 1000;
            case encarregat -> salarioBase = 1500;
        }

        if (ventasMes >= 1500) {
            salarioBase += 200;
        } else if (ventasMes >= 1000) {
            salarioBase += 100;
        }

        salarioBase += horasExtra * 20;

        return salarioBase;
    }

    public static float calculaSalarioNeto(float salarioBruto) {
        if (salarioBruto < 0) {
            return -1;
        }

        float retencion;
        if (salarioBruto < 1000) {
            retencion = 0;
        } else if (salarioBruto < 1500) {
            retencion = 16;
        } else {
            retencion = 18;
        }

        return salarioBruto * (1 - retencion / 100);
    }
}