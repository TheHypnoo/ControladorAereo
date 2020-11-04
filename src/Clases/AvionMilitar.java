package Clases;

public class AvionMilitar extends Aviones {

    private boolean cifrado;
    private String bando;

    public AvionMilitar(String matricula, String marca, String modelo, String fabricante, int capacidad, int tripulantes, String origen, String destino, int autonomia,boolean motor, double altitud, double velocidad, int rumbo, boolean cifrado, boolean trenAterrizaje, String bando) {
      super(matricula,marca, modelo, fabricante, capacidad, tripulantes, origen, destino, autonomia, motor, altitud, velocidad, rumbo, trenAterrizaje);
        this.cifrado = cifrado;
        this.bando = bando;
    }


    public boolean getCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cifrado) {
        this.cifrado = cifrado;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public String getBando() {
        return bando;
    }
}