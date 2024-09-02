package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransporteTest {

    @Test
    void deveCalcularTarifaOnibus() {
        Transporte transporte = new Transporte();
        transporte.setDistancia(10);
        transporte.setTipoTransporte("onibus");

        assertEquals(25.0, transporte.calcularTarifa());
    }

    @Test
    void deveCalcularTarifaMetro() {
        Transporte transporte = new Transporte();
        transporte.setDistancia(10);
        transporte.setTipoTransporte("metro");

        assertEquals(30.0, transporte.calcularTarifa());
    }

    @Test
    void deveCalcularTarifaTaxi() {
        Transporte transporte = new Transporte();
        transporte.setDistancia(10);
        transporte.setTipoTransporte("taxi");

        assertEquals(50.0, transporte.calcularTarifa());
    }

    @Test
    void deveRetornarExcecaoTipoTransporteInvalido() {
        try {
            Transporte transporte = new Transporte();
            transporte.setDistancia(10);
            transporte.setTipoTransporte("bicicleta");

            transporte.calcularTarifa();
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Tipo de transporte inválido", e.getMessage());
        }
    }
}
