package Clases;

public class Avion {

    private String matricula;
    private boolean motor;
    private String marca;
    private String modelo;
    private String fabricante;
    private int capacidad;
    private int tripulantes;
    private String origen;
    private String destino;
    //private Missil[] missils;
    private double distanciaDisparo;
    private Cordenada Cordenadas;
    private int autonomia;
    private int rumbo;
    private double velocidad;
    private double altitud;
    private boolean trenAterrizaje;
    private int x;
    private int y;

    public Avion(String matricula, String marca, String modelo, String fabricante, int capacidad, int tripulantes, String origen, String destino, int autonomia,boolean motor, double altitud, double velocidad, int rumbo, boolean trenAterrizaje) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidad = capacidad;
        this.tripulantes = tripulantes;
        this.origen = origen;
        this.destino = destino;
        this.autonomia = autonomia;
        this.motor = motor;
        this.altitud = altitud;
        this.velocidad = velocidad;
        this.rumbo = rumbo;
        this.trenAterrizaje = trenAterrizaje;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    /*
    public Missil[] getMissils() {
        return missils;
    }

    public void setMissils(Missil[] missils) {
        this.missils = missils;
    }
*/

    public void setDistanciaDisparo(double distanciaDisparo) {
        this.distanciaDisparo = distanciaDisparo;
    }

    public double getDistanciaDisparo() {
        return distanciaDisparo;
    }

    public void setCoordenades(Cordenada Cordenadas) {
        this.Cordenadas = Cordenadas;
    }

    public Cordenada getCoordenades() {
        return Cordenadas;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    public int getRumbo() {
        return rumbo;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setTrenAterrizaje(boolean trenAterrizaje) {
        this.trenAterrizaje = trenAterrizaje;
    }

    public boolean getTrenAterrizaje() {
        return trenAterrizaje;
    }

}