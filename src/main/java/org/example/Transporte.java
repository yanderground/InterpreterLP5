package org.example;

public class Transporte {
    private double distancia;
    private String tipoTransporte;

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public double calcularTarifa() {
        return Transportadora.calcularTarifa(this.distancia, this.tipoTransporte);
    }
}
