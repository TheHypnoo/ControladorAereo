import java.util.Scanner;

public class Avion {

    private String matricula;
    private String marca;
    private String model;
    private String fabricant;
    private int capacitat;
    private int tripulants;
    private String origen;
    private String desti;
    //private Missil[] missils;
    private double distanciaDispar;
    //private Coordenada coordenades;
    private int autonomia;
    private int rumb;
    private Motor motor;
    private double velocitat;
    private double alcada;
    private boolean xifrat;


    private boolean trenAterratge;

    Scanner lector = new Scanner(System.in);

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getTripulants() {
        return tripulants;
    }

    public void setTripulants(int tripulants) {
        this.tripulants = tripulants;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }
/*
    public Missil[] getMissils() {
        return missils;
    }

    public void setMissils(Missil[] missils) {
        this.missils = missils;
    }
*/
    public double getDistanciaDispar() {
        return distanciaDispar;
    }

    public void setDistanciaDispar(double distanciaDispar) {
        this.distanciaDispar = distanciaDispar;
    }
/*
    public Coordenada getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(Coordenada coordenades) {
        this.coordenades = coordenades;
    }
*/
    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getRumb() {
        return rumb;
    }

    public void setRumb(int rumb) {
        this.rumb = rumb;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    public double getAlcada() {
        return alcada;
    }

    public void setAlcada(double alcada) {
        this.alcada = alcada;
    }

    public boolean isTrenAterratge() {
        return trenAterratge;
    }

    public void setTrenAterratge(boolean trenAterratge) {
        this.trenAterratge = trenAterratge;
    }
    public boolean isXifrat() {
        return xifrat;
    }

    public void setXifrat(boolean xifrat) {
        this.xifrat = xifrat;
    }
/*
    public Avio generarAvio() {

        Avio avion = new Avio();

        System.out.println("Introdueix el model del avió: ");
        String model = lector.next();
        avion.setModel(model);

        System.out.println("Introdueix el fabricant: ");
        String fabricant = lector.next();
        avion.setFabricant(fabricant);

        System.out.println("Introdueix la capacitat: ");
        int capacitat = lector.nextInt();
        avion.setCapacitat(capacitat);

        System.out.println("Introdueix la matricula: ");
        String matricula = lector.next();
        avion.setMatricula(matricula);

        Motor motor = new Motor();
        motor.apagar();

        avion.setMotor(motor);
        avion.setAlcada(0);

        return avion;

    }
 */
}