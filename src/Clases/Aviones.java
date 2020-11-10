package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Aviones {

    static Scanner sc = new Scanner(System.in);

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
    private int autonomia;
    private int rumbo;
    private double velocidad;
    private double altitud;
    private boolean trenAterrizaje;
    private int x;
    private int y;

    public Aviones(String matricula, String marca, String modelo, String fabricante, int capacidad, int tripulantes, String origen, String destino, int autonomia,boolean motor, double altitud, double velocidad, int rumbo, boolean trenAterrizaje, int x,int y) {
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
        this.x = x;
        this.y = y;
    }

    public Aviones(){}

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

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }


    public void CheckMotor() throws InterruptedException {
        System.out.println("ENCENDER");
        System.out.println("APAGAR");
        String escoger = sc.next();
        switch (escoger.toUpperCase()) {
            case "ENCENDER" -> {
                if (!getMotor()) {
                    System.out.println("Encendiendo el motor...");
                    Thread.sleep(3500);
                    System.out.println("Motor en marcha!");
                    setMotor(true);
                } else {
                    System.out.println("El motor ya esta encendido");
                }
                Thread.sleep(1750);
            }
            case "APAGAR" -> {
                if (!getMotor()) {
                    System.out.println("Apagando el motor...");
                    Thread.sleep(3500);
                    System.out.println("Motor apagado!");
                    setMotor(false);
                } else {
                    System.out.println("El motor ya esta apagado");
                }
                Thread.sleep(1750);
            }
        }
    }

    public void CheckVelocidad() throws InterruptedException {
        if (!getMotor()) {
            System.out.println("No puedes modificar la velocidad sin el motor en marcha");
        } else {
            System.out.println("ACELERAR");
            System.out.println("FRENAR");
            String escoger = sc.next();
            switch (escoger.toUpperCase()) {
                case "ACELERAR" -> {
                    System.out.println("A que velocidad quieres acelerar?");
                    double velocidadAcelerar = sc.nextDouble();
                    if (velocidadAcelerar > getVelocidad()) {
                        setVelocidad(velocidadAcelerar);
                        System.out.println("Acelerando...");
                    } else {
                        System.out.println("No puedes ir más lento si estas acelerando");
                    }
                    Thread.sleep(1500);
                }
                case "FRENAR" -> {
                    System.out.println("A que velocidad quieres frenar?");
                    double velocidadFrenar = sc.nextDouble();
                    if (velocidadFrenar < getVelocidad()) {
                        setVelocidad(velocidadFrenar);
                        System.out.println("Frenando...");
                    } else {
                        System.out.println("No puedes ir más rapido si estas frenando");
                    }
                    Thread.sleep(1500);
                }
            }
        }
    }

    public ArrayList<Aviones> CheckAltitud(ArrayList<Aviones> espacioAereo, int i) throws InterruptedException {
        int posAvion = i;
        if (!getMotor()) {
            System.out.println("No puedes modificar la altitud sin el motor en marcha");
            if (getVelocidad() < 180) {
                System.out.println("No puedes despegar");
            }
        } else {
            System.out.println("SUBIR");
            System.out.println("BAJAR");
            String escoger = sc.next();
            switch (escoger.toUpperCase()) {
                case "SUBIR" -> {
                    System.out.println("A que altitud quieres subir?");
                    double subirAltitud = sc.nextInt();
                    if (subirAltitud > getAltitud()) {
                        setAltitud(subirAltitud);
                        System.out.println("Subiendo altitud...");
                        Thread.sleep(1500);
                    } else if (subirAltitud > 50000) {
                        System.out.println("No puedes ir a la estratosfera");
                        Thread.sleep(1500);
                    } else {
                        System.out.println("No puedes ir a una altitud inferior si subes");
                        Thread.sleep(1500);
                    }
                }
                case "BAJAR" -> {

                    if (getX() != 100 || getY() != 100) {
                        String pregunta;
                        System.out.println("Seguro que quieres bajar la altitud?, estas fuera de la zona de la pista de aterrizaje");
                        if (getVelocidad() > 200) {
                            System.out.println("Tu velocidad es superior para poder bajar la altitud, si lo haces, no sabes exactamente lo que sucedera...");
                        }
                        System.out.println("SI");
                        System.out.println("NO");
                        pregunta = sc.next();
                        switch (pregunta.toUpperCase()) {
                            case "SI" -> espacioAereo.remove(posAvion);
                            case "NO" -> System.out.println("Hola");
                        }
                    } else {
                        System.out.println("A que altitud quieres bajar?");
                        double bajarAltitud = sc.nextInt();
                        if (bajarAltitud < getAltitud()) {
                            setAltitud(bajarAltitud);
                            System.out.println("Bajando altitud...");
                            Thread.sleep(1500);
                        } else if (bajarAltitud < 0) {
                            System.out.println("No puedes bajar más de 0");
                            Thread.sleep(1500);
                        } else {
                            System.out.println("No puedes bajar una altitud superior a la que tienes");
                            Thread.sleep(1500);
                        }
                    }
                }
            }
        }
        return espacioAereo;
    }

    public void CheckTrenAterrizaje() {
        if (!getMotor()) {
            System.out.println("No puedes modificar el tren de aterrizaje sin el motor en marcha");
            if(getAltitud() < 500) {
                System.out.println("No puedes modificar el tren de aterrizaje sin tener una altitud minima de 500");
            }
            if(getAltitud() > 500 && getVelocidad() > 300) {
                System.out.println("No puedes modificar el tren de aterrizaje a esa altitud/velocidad");
            }
        } else {
            if(getAltitud() >= 500 && getVelocidad() >= 300){
                System.out.println("No puedes bajar el tren de aterrizaje, hay demasiada altitud o demasiada velocidad");
            } else {
                System.out.println("BAJAR");
            }
            System.out.println("SUBIR");

            String escoger = sc.next();
            switch (escoger.toUpperCase()) {

                case "SUBIR" -> {
                    if (!getTrenAterrizaje()) {
                        System.out.println("El tren de aterrizaje esta subiendo...");
                        setTrenAterrizaje(false);
                    }
                }
                case "BAJAR" -> {
                    if(getAltitud() >= 500 && getVelocidad() >= 300){
                        System.out.println("No puedes bajar el tren de aterrizaje, hay demasiada altitud o demasiada velocidad");
                    } else {
                        if (getTrenAterrizaje()) {
                            System.out.println("Tren de aterrizaje bajando");
                            setTrenAterrizaje(true);
                        }
                    }
                }
            }
        }
    }

    public void CheckRumbo(){
        if (!getMotor()) {
            System.out.println("No puedes modificar el rumbo sin el motor en marcha");
        } else {
            System.out.println("Establece el rumbo: ");
            int rumbo = sc.nextInt();

            if (rumbo >= 0 && rumbo <= 360) {
                setRumbo(rumbo);
            } else {
                System.out.println("El rumbo debe estar entre 0 y 360");
            }
        }
    }

    public void CheckPosicion(){
        System.out.println("Posiciona la X i la Y del avion");
        System.out.println("X:");
        double x = sc.nextDouble();
        System.out.println("Y:");
        double y = sc.nextDouble();

        setX(100);
        setY(100);
    }

}