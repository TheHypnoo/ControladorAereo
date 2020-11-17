package Clases;

public class AvionMilitar extends Aviones {

    protected int misiles;
    protected boolean cifrado;
    protected boolean bando;

    public AvionMilitar(String matricula, String marca, String modelo, String fabricante, int capacidad, int tripulantes, String origen, String destino, int autonomia,boolean motor, double altitud, double velocidad, int rumbo, boolean cifrado, boolean trenAterrizaje,int x, int y, boolean bando, int misiles) {
      super(matricula,marca, modelo, fabricante, capacidad, tripulantes, origen, destino, autonomia, motor, altitud, velocidad, rumbo, trenAterrizaje,x,y);
        this.cifrado = cifrado;
        this.bando = bando;
        this.misiles = misiles;
    }




    public void setMisiles(int misiles) {
        this.misiles = misiles;
    }

    public int getMisiles() {
        return misiles;
    }

    public boolean getCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cifrado) {
        this.cifrado = cifrado;
    }

    public void setBando(boolean bando) {
        this.bando = bando;
    }

    public boolean getBando() {
        return bando;
    }
}