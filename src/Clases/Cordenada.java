package Clases;

public class Cordenada {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Cordenada CordenadaAterrizaje() {

        Cordenada CordenadaAterrizaje = new Cordenada();

        CordenadaAterrizaje.setX(100);
        CordenadaAterrizaje.setY(100);
        CordenadaAterrizaje.setZ(0);

        return CordenadaAterrizaje;

    }

}