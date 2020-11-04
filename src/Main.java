import Clases.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //-Los colores para la ziguiente, gogo!
    //-Meter, empezar videojuego, entrar en un ordenador, meter contraseña...
    //Mostrar diferente el infoAvion();

    static Scanner sc = new Scanner(System.in);
    public ArrayList<Aviones> EspacioAereo = new ArrayList<>();
    Aviones Aviones = new Aviones();

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "-------------------------------------");
            System.out.println(Ansi.GREEN + "Escoge el modo: ");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"Añadir un avión");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"Gestionar avión");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"Mostrar el espacio aereo actual");
            System.out.println(Ansi.YELLOW +"4."+Ansi.WHITE+"Cifrar los aviones de combate");
            System.out.println(Ansi.YELLOW +"5."+Ansi.WHITE+"Descifrar los aviones de combate");
            System.out.println(Ansi.YELLOW +"6."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "-------------------------------------");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> generaAvion();
                    case 2 -> menuGestionaAviones();
                    case 3 -> infoAvion();
                    case 4 -> Encriptar();
                    case 5 -> Desencriptar();
                    case 6 -> {
                        salir = true;
                        System.out.println("Te has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
    }

    public void menuGestionaAviones() {

        if(EspacioAereo.size() == 0){
            System.out.println("No hay ningun avión, es imposible gestionarlo");
        } else {
            String matricula;
            System.out.println("Introduce la matricula del avión: ");
            matricula = sc.next();

            for (Aviones verify : EspacioAereo) {

                if (verify != null) {
                    if (matricula.equals(verify.getMatricula())) {

        String opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "-------------------------------------");
            System.out.println(Ansi.GREEN + "Escoge el modo: ");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.WHITE + "Motor");
            System.out.println("Velocidad");
            System.out.println("Altitud");
            System.out.println("Tren-Aterrizaje");
            System.out.println("Rumbo");
            System.out.println("Posicionar");
            System.out.println("Misiles");
            System.out.println("Salir");
            System.out.println(Ansi.CYAN + "-------------------------------------");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.next();
                switch (opcion.toUpperCase()) {
                    case "MOTOR" -> {
                        Aviones.CheckMotor();
                    }
                    case "VELOCIDAD" -> {
                        Aviones.CheckVelocidad();
                    }
                    case "ALTITUD" -> {
                        Aviones.CheckAltitud();
                    }
                    case "TREN-ATERRIZAJE" -> {
                        Aviones.CheckTrenAterrizaje();
                    }
                    case "RUMBO" -> {
                        Aviones.CheckRumbo();
                    }
                    case "POSICIONAR" -> {
                        Aviones.CheckPosicion();
                    }
                    case "MISILES" -> System.out.println("Null");
                    case "SALIR" -> {
                        salir = true;
                        System.out.println("Has salido de la gestión del avión");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");
                }
            } catch (InputMismatchException | InterruptedException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
                    } else {
                        System.out.println("No se ha encontrado ningun avión con esa matricula");
                    }
                }
            }
        }
    }

    public void generaAvion() {
        Cordenada PistaAterrizaje = new Cordenada();
        if (checkPista()) {
            System.out.println("Introduce la marca del avion: ");
            String modelo = sc.next();

            System.out.println("Introduce el modelo del avion: ");
            String marca = sc.next();

            System.out.println("Introduce el fabricante: ");
            String fabricante = sc.next();

            System.out.println("Introduce la capacidad de almacenaje: ");
            int capacidad = sc.nextInt();

            System.out.println("Introduce la cantidad de tripulantes: ");
            int tripulantes = sc.nextInt();

            System.out.println("Introduce el origen: ");
            String origen = sc.next();

            System.out.println("Introduce el destino: ");
            String destino = sc.next();

            System.out.println("Introduce la autonomia del avión: ");
            int autonomia = sc.nextInt();

            System.out.println("COMERCIAL");
            System.out.println("MILITAR");
            String opcion = sc.next();
            switch (opcion.toUpperCase()){
                case "COMERCIAL" ->{
                    Avion Comercial = new Avion(generarMatricula(),marca, modelo, fabricante, capacidad, tripulantes, origen,destino,autonomia,false,0,0,0,true);
                    Comercial.setCoordenades(PistaAterrizaje.CordenadaAterrizaje());
                    EspacioAereo.add(Comercial);
                }
                case "MILITAR" -> {
                    System.out.println("Introduce el bando del avión: ");
                    String bando = sc.next();
                    AvionMilitar AvionMilitar = new AvionMilitar(generarMatricula(),marca, modelo, fabricante, capacidad, tripulantes, origen,destino,autonomia,false,0,0,0,false,true,bando);
                    AvionMilitar.setCoordenades(PistaAterrizaje.CordenadaAterrizaje());
                    EspacioAereo.add(AvionMilitar);
                }
            }


        } else if (!checkPista()) {
            if(EspacioAereo.size() == 11) {
                System.out.println("No se puede crear más aviones");
            }
            //Si quiero que haga BOOM
            System.out.println("No puedes crear otro avión la pista esta llena");
        }
        System.out.println("✈✈✈✈✈✈✈✈✈✈✈✈✈✈✈");

    }

    public String generarMatricula() {
        StringBuilder matricula = new StringBuilder();
        int a;
        String CaracteresNoDeseados = "AEIOU";
        for (int i = 0; i < 7; i++) {
            if (i < 4) {    // 0,1,2,3 posiciones de numeros
                matricula.insert(0, (int) (Math.random() * 9) + "");

            } else {       // 4,5,6 posiciones de letras
                do {
                    a = (int) (Math.random() * 26 + 65);///
                } while (CaracteresNoDeseados.indexOf(a) >= 0);

                char letra = (char) a;
                if (i == 4) {
                    matricula.append("-").append(letra);
                } else {
                    matricula.append(letra);
                }
            }
        }
        System.out.println("Matricula: "+matricula.toString());
        return matricula.toString();
    }

    public void infoAvion(){
        if(EspacioAereo.size() == 0) {
            System.out.println("No hay ningun avion en el espacio aereo");
        }
        for (int i = 0; i < EspacioAereo.size(); i++) {

            Aviones info = EspacioAereo.get(i);

            if (info != null) {

                System.out.println("Aeronau "+ (i+1));
                System.out.println("Marca: " + info.getMarca());
                System.out.println("Model: " + info.getModelo());
                /*if (info.getCifrado()) {
                    System.out.println("Matricula: ENCRIPTAT");
                } else {
                    System.out.println("Matrícula: " + info.getMatricula());
                }*/
                System.out.println("X: " + info.getCoordenades().getX());
                System.out.println("Y: " + info.getCoordenades().getY());
                System.out.println("Alçada: " + info.getAltitud());
                System.out.println("Velocitat: " + info.getVelocidad());
                System.out.println("Tren aterratge: " + info.getTrenAterrizaje());
                System.out.println("Motor: " + info.getMotor());
                // System.out.println("Misils: " + info.getMissils().length);
                System.out.println("Origen: " + info.getOrigen());
                System.out.println("Desti: " + info.getDestino());
            }
            System.out.println(" ");


        }
    }

    public boolean checkPista() {
        for (Aviones check : EspacioAereo) {

            if (check != null) {

                if (check.getCoordenades().getX() == 100 && check.getCoordenades().getY() == 100) {
                    return false;
                }
            }
        }
        return true;
    }

    //Revisar encriptar y desencriptar!!
    //Encriptar todo menos Matricula!!
    public void Encriptar(){
        if(EspacioAereo.size() == 0){
            System.out.println("No hay ningun avión, es imposible gestionarlo");
        } else {
            String matricula;
            System.out.println("Introdueix la matricula del avió: ");
            matricula = sc.next();

            for (Aviones check : EspacioAereo) {

                if (check != null) {

                    if (matricula.equals(check.getMatricula())) {

                        Encriptar encriptar = new Encriptar();

                        encriptar.encriptar((AvionMilitar) check);

                    } else {

                        System.out.println("L' avio no s'ha trobat o no és un avio militar");

                    }
                }
            }

        }
    }

    public void Desencriptar(){
        if(EspacioAereo.size() == 0){
            System.out.println("No hay ningun avión, es imposible gestionarlo");
        } else {
            String matricula;
            System.out.println("Introdueix la matricula del avió: ");
            matricula = sc.next();


                for (Aviones check : EspacioAereo) {

                if (check != null) {

                    if (matricula.equals(check.getMatricula())) {

                        Encriptar encriptar = new Encriptar();

                        encriptar.desencriptar((AvionMilitar) check);

                    } else {

                        System.out.println("L' avio no s'ha trobat o no és un avio militar");

                    }
                }

            }

        }
    }




}