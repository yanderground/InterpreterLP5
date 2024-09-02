package org.example;

public class Transportadora {

    public static String formula = "distancia * tarifaBase";

    public static double calcularTarifa(double distancia, String tipoTransporte) {
        double tarifaBase;

        switch (tipoTransporte) {
            case "onibus":
                tarifaBase = 2.50;
                break;
            case "metro":
                tarifaBase = 3.00;
                break;
            case "taxi":
                tarifaBase = 5.00;
                break;
            default:
                throw new IllegalArgumentException("Tipo de transporte inválido");
        }

        String expressao = formula.replace("distancia", Double.toString(distancia))
                .replace("tarifaBase", Double.toString(tarifaBase));
        InterpretadorExpressao interpretador = new InterpretadorExpressoesTarifarias(expressao);
        return interpretador.interpretar();
    }
}

