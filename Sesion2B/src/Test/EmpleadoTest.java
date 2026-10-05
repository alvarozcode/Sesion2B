package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sesion2B.Empleado;
import Sesion2B.TipoEmpleado;

class EmpleadoTest {

    private Empleado emp;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        emp = new Empleado();
    }

    @AfterEach
    void tearDown() throws Exception {
    }


    // PRUEBAS DE calculoNominaBruta
    @Test
    void testCalculoNominaBrutaVendedorSinPrimaSinHoras() {
        // Vendedor (2000) + Ventas 999 (prima 0) + 0h extra = 2000
        assertEquals(2000, emp.calculoNominaBruta(TipoEmpleado.Vendedor, 999, 0));
    }

    @Test
    void testCalculoNominaBrutaVendedorPrima100LimiteInferior() {
        // Vendedor (2000) + Ventas 1000 (prima 100) + 0h extra = 2100
        assertEquals(2100, emp.calculoNominaBruta(TipoEmpleado.Vendedor, 1000, 0));
    }

    @Test
    void testCalculoNominaBrutaEncargadoPrima100LimiteSuperior() {
        // Encargado (2500) + Ventas 1499 (prima 100) + 0h extra = 2600
        assertEquals(2600, emp.calculoNominaBruta(TipoEmpleado.Encargado, 1499, 0));
    }

    @Test
    void testCalculoNominaBrutaVendedorPrima200LimiteInferior() {
        // Vendedor (2000) + Ventas 1500 (prima 200) + 0h extra = 2200
        assertEquals(2200, emp.calculoNominaBruta(TipoEmpleado.Vendedor, 1500, 0));
    }

    @Test
    void testCalculoNominaBrutaEncargadoConHorasExtra() {
        // Encargado (2500) + Ventas 2000 (prima 200) + 2h extra (60€) = 2760
        assertEquals(2760, emp.calculoNominaBruta(TipoEmpleado.Encargado, 2000, 2));
    }

    
    // PRUEBAS DE calculoNominaNeta 
    @Test
    void testCalculoNominaNetaSinRetencionLimite() {
        // Nómina 2100€ -> 0% retención -> Devuelve 2100€
        assertEquals(2100, emp.calculoNominaNeta(2100));
    }

    @Test
    void testCalculoNominaNetaRetencion15LimiteInferior() {
        // Nómina 2101€ -> 15% retención -> Devuelve 1785.85€
        assertEquals(2101 * (1 - 0.15f), emp.calculoNominaNeta(2101), 0.01f);
    }

    @Test
    void testCalculoNominaNetaRetencion15LimiteSuperior() {
        // Nómina 2499.99€ -> 15% retención
        assertEquals(2499.99f * (1 - 0.15f), emp.calculoNominaNeta(2499.99f), 0.01f);
    }

    @Test
    void testCalculoNominaNetaRetencion18LimiteInferior() {
        // Nómina 2500€ -> 18% retención -> Devuelve 2050€
        assertEquals(2500 * (1 - 0.18f), emp.calculoNominaNeta(2500), 0.01f);
    }
}