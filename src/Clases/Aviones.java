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

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
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

    public ArrayList<Aviones> CheckMotor(ArrayList<Aviones> espacioAereo, int i) throws InterruptedException {
        System.out.println("ENCENDER");
        System.out.println("APAGAR");
        String escoger = sc.next();
        switch (escoger.toUpperCase()) {
            case "ENCENDER" -> {
                if (!espacioAereo.get(i).getMotor()) {
                    System.out.println("Encendiendo el motor...");
                    Thread.sleep(3500);
                    System.out.println("Motor en marcha!");
                    espacioAereo.get(i).setMotor(true);
                } else {
                    System.out.println("El motor ya esta encendido");
                }
                Thread.sleep(1750);
            }
            case "APAGAR" -> {
                if (espacioAereo.get(i).getMotor()) {
                    System.out.println("Apagando el motor...");
                    Thread.sleep(3500);
                    System.out.println("Motor apagado!");
                    espacioAereo.get(i).setMotor(false);
                } else {
                    System.out.println("El motor ya esta apagado");
                }
                Thread.sleep(1750);
            }
        }
        return espacioAereo;
    }

    public ArrayList<Aviones> CheckVelocidad(ArrayList<Aviones> espacioAereo, int i) throws InterruptedException {
        if (!espacioAereo.get(i).getMotor()) {
            System.out.println("No puedes modificar la velocidad sin el motor en marcha");
        } else {
            System.out.println("ACELERAR");
            System.out.println("FRENAR");
            String escoger = sc.next();
            switch (escoger.toUpperCase()) {
                case "ACELERAR" -> {
                    System.out.println("A que velocidad quieres acelerar?");
                    double velocidadAcelerar = sc.nextDouble();
                    if (velocidadAcelerar > espacioAereo.get(i).getVelocidad()) {
                        espacioAereo.get(i).setVelocidad(velocidadAcelerar);
                        System.out.println("Acelerando...");
                    } else {
                        System.out.println("No puedes ir más lento si estas acelerando");
                    }
                    Thread.sleep(1500);
                }
                case "FRENAR" -> {
                    System.out.println("A que velocidad quieres frenar?");
                    double velocidadFrenar = sc.nextDouble();
                    if (velocidadFrenar < espacioAereo.get(i).getVelocidad()) {
                        espacioAereo.get(i).setVelocidad(velocidadFrenar);
                        System.out.println("Frenando...");
                    } else {
                        System.out.println("No puedes ir más rapido si estas frenando");
                    }
                    Thread.sleep(1500);
                }
            }
        }
        return espacioAereo;
    }

    public ArrayList<Aviones> CheckAltitud(ArrayList<Aviones> espacioAereo, int i) throws InterruptedException {
        if (!espacioAereo.get(i).getMotor()) {
            System.out.println("No puedes modificar la altitud sin el motor en marcha");
            if (espacioAereo.get(i).getVelocidad() < 180) {
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
                        espacioAereo.get(i).setAltitud(subirAltitud);
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
                            case "SI" -> espacioAereo.remove(i);
                            case "NO" -> System.out.println("Hola");
                        }
                    } else {
                        System.out.println("A que altitud quieres bajar?");
                        double bajarAltitud = sc.nextInt();
                        if (bajarAltitud < getAltitud()) {
                            espacioAereo.get(i).setAltitud(bajarAltitud);
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

    public ArrayList<Aviones> CheckTrenAterrizaje(ArrayList<Aviones> espacioAereo, int i) {
        if (!espacioAereo.get(i).getMotor()) {
            System.out.println("No puedes modificar el tren de aterrizaje sin el motor en marcha");
            if(espacioAereo.get(i).getAltitud() < 500) {
                System.out.println("No puedes modificar el tren de aterrizaje sin tener una altitud minima de 500");
            }
            if(espacioAereo.get(i).getAltitud() > 500 && espacioAereo.get(i).getVelocidad() > 300) {
                System.out.println("No puedes modificar el tren de aterrizaje a esa altitud/velocidad");
            }
        } else {
            if(espacioAereo.get(i).getAltitud() >= 500 && espacioAereo.get(i).getVelocidad() >= 300){
            } else {
                System.out.println("BAJAR");
            }
            System.out.println("SUBIR");

            String escoger = sc.next();
            switch (escoger.toUpperCase()) {

                case "SUBIR" -> {
                    if (!espacioAereo.get(i).getTrenAterrizaje()) {
                        System.out.println("El tren de aterrizaje esta subiendo...");
                        espacioAereo.get(i).setTrenAterrizaje(false);
                    }
                }
                case "BAJAR" -> {
                    if(espacioAereo.get(i).getAltitud() >= 500 && espacioAereo.get(i).getVelocidad() >= 300){
                        System.out.println("No puedes bajar el tren de aterrizaje, hay demasiada altitud o demasiada velocidad");
                    } else {
                        if (espacioAereo.get(i).getTrenAterrizaje()) {
                            System.out.println("Tren de aterrizaje bajando");
                            espacioAereo.get(i).setTrenAterrizaje(true);
                        }
                    }
                }
            }
        }
        return espacioAereo;
    }

    public ArrayList<Aviones> CheckRumbo(ArrayList<Aviones> espacioAereo, int i){
        if (!espacioAereo.get(i).getMotor()) {
            System.out.println("No puedes modificar el rumbo sin el motor en marcha");
        } else {
            System.out.println("Establece el rumbo: ");
            int rumbo = sc.nextInt();

            if (rumbo >= 0 && rumbo <= 360) {
                espacioAereo.get(i).setRumbo(rumbo);
            } else {
                System.out.println("El rumbo debe estar entre 0 y 360");
            }
        }
        return espacioAereo;
    }

    public ArrayList<Aviones> CheckPosicion(ArrayList<Aviones> espacioAereo, int i){
        System.out.println("Posiciona la X i la Y del avion");
        System.out.println("X:");
        int x = sc.nextInt();
        System.out.println("Y:");
        int y = sc.nextInt();

        espacioAereo.get(i).setX(x);
        espacioAereo.get(i).setY(y);
        return espacioAereo;
    }

    public ArrayList<Aviones> Disparar(ArrayList<Aviones> espacioAereo, int i){
        int numX1 = espacioAereo.get(i).getX()-100;
        int numX2 = espacioAereo.get(i).getX()+100;
        int numY1 = espacioAereo.get(i).getY()-100;
        int numY2 = espacioAereo.get(i).getY()+100;
        int contador = -1;
        for(int encontraenemigo = 0; encontraenemigo < espacioAereo.size() ; encontraenemigo++){
            if(!((AvionMilitar) espacioAereo.get(encontraenemigo)).getBando()) {
                contador = encontraenemigo;
            }
        }

        if(contador != -1) {
            if((espacioAereo.get(contador).getX()>= numX1 && espacioAereo.get(contador).getX()<=numX2) && (espacioAereo.get(contador).getY()>=numY1 && espacioAereo.get(contador).getY()<=numY2)) {
                if(!((AvionMilitar) espacioAereo.get(contador)).getBando()) {
                    System.out.println("Enemigo encontrado, disparando...");
                    espacioAereo.remove(contador);
                    System.out.println("Derribado");
                } else {
                    System.out.println("No hemos encontrado a nadie");
                }
            }
        }

        return espacioAereo;
    }

}