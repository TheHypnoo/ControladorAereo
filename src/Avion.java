import java.util.ArrayList;
import java.util.Scanner;

public class Avion {

    private String matricula;
    private String marca;
    private String modelo;
    private String fabricante;
    private int capacidad;
    private int tripulantes;
    private String origen;
    private String destino;
    private ArrayList<Misil> Misiles = new ArrayList<Misil>();
    private double distanciaDisparo;
    private Cordenada Cordenadas;
    private int autonomia;
    private int rumbo;
    private Motor motor;
    private double velocidad;
    private double altura;
    private boolean cifrado;


    private boolean trenAterrizaje;

    Scanner sc = new Scanner(System.in);

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public ArrayList<Misil> getMisiles() {
        return Misiles;
    }

    public void setMisiles(ArrayList<Misil> Misiles) {
        this.Misiles = Misiles;
    }

    public double getDistanciaDisparo() {
        return distanciaDisparo;
    }

    public void setDistanciaDisparo(double distanciaDisparo) {
        this.distanciaDisparo = distanciaDisparo;
    }

    public Cordenada getCoordenades() {
        return Cordenadas;
    }

    public void setCoordenadas(Cordenada cordenadas) {
        this.Cordenadas = cordenadas;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getRumbo() {
        return rumbo;
    }

    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isTrenAterrizaje() {
        return trenAterrizaje;
    }

    public void setTrenAterrizaje(boolean trenAterrizaje) {
        this.trenAterrizaje = trenAterrizaje;
    }

    public boolean isCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cifrado) {
        this.cifrado = cifrado;
    }

    public Avion generarAvio() {

        Avion avion = new Avion();

        System.out.println("Introdueix el model del avió: ");
        String modelo = sc.next();
        avion.setModelo(modelo);

        System.out.println("Introdueix el fabricant: ");
        String fabricante = sc.next();
        avion.setFabricante(fabricante);

        System.out.println("Introdueix la capacitat: ");
        int capacidad = sc.nextInt();
        avion.setCapacidad(capacidad);

        System.out.println("Introdueix la matricula: ");
        String matricula = sc.next();
        avion.setMatricula(matricula);

        Motor motor = new Motor();
        motor.apagar();

        avion.setMotor(motor);
        avion.setAltura(0);

        return avion;
    }
}