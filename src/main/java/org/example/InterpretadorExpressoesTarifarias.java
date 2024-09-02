package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesTarifarias implements InterpretadorExpressao {

    private InterpretadorExpressao interpretadorInicial;

    public InterpretadorExpressoesTarifarias(String contexto) {
        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new Numero(Double.parseDouble(elemento)));
            } else if (elemento.equals("*")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Numero elementoEsquerda = (Numero) pilhaInterpretadores.pop();
                Numero elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                Multiplicacao interpretador = new Multiplicacao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }
}
