package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretadorExpressoesTarifariasTest {

    @Test
    void deveCalcularExpressaoMultiplicacao() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesTarifarias("10 * 2.5");
        assertEquals(25.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoMultiplicacaoComNumerosDecimais() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesTarifarias("7.5 * 3.2");
        assertEquals(24.0, interpretador.interpretar());
    }

    @Test
    void deveRetornarExcecaoExpressaoInvalida() {
        try {
            InterpretadorExpressao interpretador = new InterpretadorExpressoesTarifarias("10 *");
            interpretador.interpretar();
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoElementoInvalido() {
        try {
            InterpretadorExpressao interpretador = new InterpretadorExpressoesTarifarias("10 ^ 2.5");
            interpretador.interpretar();
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }
}
