package Sesion2B;

public class Empleado {

	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        if (tipo == null || ventasMes < 0 || horasExtra < 0) {
            return -1; // Manejo básico de entradas inválidas
        }

        float salarioBase = 0;
        if (tipo == TipoEmpleado.Vendedor) {
            salarioBase = 2000;
        } else if (tipo == TipoEmpleado.Encargado) {
            salarioBase = 2500;
        }

        float prima = 0;
        if (ventasMes >= 1500) {
            prima = 200;
        } else if (ventasMes >= 1000) {
            prima = 100;
        }

        float pagoHorasExtra = horasExtra * 30;

        return salarioBase + prima + pagoHorasExtra;
    }

    public float calculoNominaNeta(float nominaBruta) {
        if (nominaBruta < 0) {
            return -1;
        }

        float retencion = 0;
        if (nominaBruta >= 2500) {
            retencion = 0.18f;
        } else if (nominaBruta > 2100) {
            retencion = 0.15f;
        }

        return nominaBruta * (1 - retencion);
    }
	
}
