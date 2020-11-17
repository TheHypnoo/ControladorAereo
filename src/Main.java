import Clases.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    public ArrayList<Aviones> EspacioAereo = new ArrayList<>();
    String [][] EspacioAereoAux = new String [10][20];
    String [] ArrTabla = new String [20];

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();
    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            System.out.println(Ansi.GREEN + "+-------    Controlador Aereo  --------+");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"Añadir un avión");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"Gestionar avión");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"Mostrar el espacio aereo actual");
            System.out.println(Ansi.YELLOW +"4."+Ansi.WHITE+"Cifrar los aviones de combate");
            System.out.println(Ansi.YELLOW +"5."+Ansi.WHITE+"Descifrar los aviones de combate");
            System.out.println(Ansi.YELLOW +"6."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> generaAvion();
                    case 2 -> menuGestionaAviones();
                    case 3 -> taulaAvions();
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
            LimpiaPantalla();
            String matricula;
            System.out.println("Introduce la matricula del avión: ");
            matricula = sc.next();
            int numeroAviones = EspacioAereo.size();

            for (int i = 0; i < EspacioAereo.size(); i++) {

                    Aviones verify = EspacioAereo.get(i);

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
            System.out.println("Ruedas");
            System.out.println("Rumbo");
            System.out.println("Posicionar");
            if(((AvionMilitar)EspacioAereo.get(i)).getMisiles() < 3) {
                System.out.println("Misiles");
            }
            System.out.println("Salir");
            System.out.println(Ansi.CYAN + "-------------------------------------");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.next();
                switch (opcion.toUpperCase()) {
                    case "MOTOR" -> EspacioAereo = EspacioAereo.get(i).CheckMotor(EspacioAereo,i);
                    case "VELOCIDAD" -> EspacioAereo = EspacioAereo.get(i).CheckVelocidad(EspacioAereo,i);
                    case "ALTITUD" -> {
                        EspacioAereo = EspacioAereo.get(i).CheckAltitud(EspacioAereo,i);
                        if(numeroAviones != EspacioAereo.size()) {
                            salir = true;
                            System.out.println("Te has estrellado");
                        }
                    }
                    case "RUEDAS" -> EspacioAereo = EspacioAereo.get(i).CheckTrenAterrizaje(EspacioAereo,i);
                    case "RUMBO" -> EspacioAereo = EspacioAereo.get(i).CheckRumbo(EspacioAereo,i);
                    case "POSICIONAR" -> EspacioAereo = EspacioAereo.get(i).CheckPosicion(EspacioAereo,i);
                    case "MISILES" -> EspacioAereo = EspacioAereo.get(i).Disparar(EspacioAereo,i);
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
        if (checkPista()) {
            System.out.println("Introduce el fabricante: ");
            String fabricante = sc.next();

            System.out.println("Introduce la marca del avion: ");
            String modelo = sc.next();

            System.out.println("Introduce el modelo del avion: ");
            String marca = sc.next();

            System.out.println("Introduce el origen: ");
            String origen = sc.next();

            System.out.println("Introduce el destino: ");
            String destino = sc.next();

            System.out.println("Introduce la capacidad de almacenaje: ");
            int capacidad = sc.nextInt();

            System.out.println("Introduce la cantidad de tripulantes: ");
            int tripulantes = sc.nextInt();

            System.out.println("Introduce la autonomia del avión: ");
            int autonomia = sc.nextInt();
            System.out.println("Tipo de Avion: ");
            System.out.println("COMERCIAL");
            System.out.println("   O    ");
            System.out.println("MILITAR");
            String opcion = sc.next();
            switch (opcion.toUpperCase()){
                case "COMERCIAL" ->{
                    Avion Comercial = new Avion(generarMatricula(),marca, modelo, fabricante, capacidad, tripulantes, origen,destino,autonomia,false,0,0,0,true,100,100);
                    EspacioAereo.add(Comercial);
                }
                case "MILITAR" -> {
                    System.out.println("Bando del Avion Militar:");
                    System.out.println("ALIADO");
                    System.out.println("   O    ");
                    System.out.println("DESCONOCIDO");
                    opcion = sc.next();
                    switch (opcion.toUpperCase()) {
                        case "ALIADO" -> {
                            AvionMilitar AvionMilitar = new AvionMilitar(generarMatricula(), marca, modelo, fabricante, capacidad, tripulantes, origen, destino, autonomia, false, 0, 0, 0, false, true, 100, 100, true, 0);
                            EspacioAereo.add(AvionMilitar);
                        }
                        case "DESCONOCIDO" -> {
                            AvionMilitar AvionMilitar = new AvionMilitar(generarMatricula(), marca, modelo, fabricante, capacidad, tripulantes, origen, destino, autonomia, false, 0, 0, 0, false, true, 100, 100, false, 0);
                            EspacioAereo.add(AvionMilitar);
                        }
                    }

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

    public void FullAtributos()
    {
        ArrTabla[0]="Fabricante ";
        ArrTabla[1]="Matricula ";
        ArrTabla[2]="Marca ";
        ArrTabla[3]="Modelo ";
        ArrTabla[4]="Origen ";
        ArrTabla[5]="Destino ";
        ArrTabla[6]="Tren de Aterrizaje ";
        ArrTabla[7]="Motor ";
        ArrTabla[8]="Altitud ";
        ArrTabla[9]="Velocidad ";
        ArrTabla[10]="Autonomia ";
        ArrTabla[11]="Rumbo ";
        ArrTabla[12]="Capacidad de Tripulantes ";
        ArrTabla[13]="X ";
        ArrTabla[14]="Y ";
        ArrTabla[16]="Capacidad de Pasajeros ";
        ArrTabla[16]="Bando ";
        ArrTabla[17]="Misiles ";
    }

    public void creaTabla(){
        int contador=0;
        int contador2;
        FullAtributos();
        for(int i =0;i<EspacioAereoAux.length && contador < EspacioAereo.size();i++)
        {
            contador2=0;
            for(int j=0;j<EspacioAereoAux.length && contador < EspacioAereo.size() && contador2 !=2;j++)
            {
                EspacioAereoAux[i][j]=EspacioAereo.get(contador).getFabricante();
                EspacioAereoAux[i][j+1]=EspacioAereo.get(contador).getMatricula();
                EspacioAereoAux[i][j+2]=EspacioAereo.get(contador).getMarca();
                EspacioAereoAux[i][j+3]=EspacioAereo.get(contador).getModelo();
                EspacioAereoAux[i][j+4]=EspacioAereo.get(contador).getOrigen();
                EspacioAereoAux[i][j+5]=EspacioAereo.get(contador).getDestino();
                EspacioAereoAux[i][j+8]=String.valueOf(EspacioAereo.get(contador).getTrenAterrizaje());
                EspacioAereoAux[i][j+9]=String.valueOf(EspacioAereo.get(contador).getMotor());
                EspacioAereoAux[i][j+10]=String.valueOf(EspacioAereo.get(contador).getAltitud());
                EspacioAereoAux[i][j+11]=String.valueOf(EspacioAereo.get(contador).getVelocidad());
                EspacioAereoAux[i][j+12]=String.valueOf(EspacioAereo.get(contador).getAutonomia());
                EspacioAereoAux[i][j+13]=String.valueOf(EspacioAereo.get(contador).getRumbo());
                EspacioAereoAux[i][j+14]=String.valueOf(EspacioAereo.get(contador).getTripulantes());
                EspacioAereoAux[i][j+15]=String.valueOf(EspacioAereo.get(contador).getX());
                EspacioAereoAux[i][j+16]=String.valueOf(EspacioAereo.get(contador).getY());
                EspacioAereoAux[i][j+17]=String.valueOf(EspacioAereo.get(contador).getCapacidad());
                try {
                    EspacioAereoAux[i][j + 18] = String.valueOf(((AvionMilitar) EspacioAereo.get(contador)).getBando());
                    EspacioAereoAux[i][j + 19] = String.valueOf(((AvionMilitar) EspacioAereo.get(contador)).getMisiles());
                } catch (ClassCastException e) {
                    System.out.println("Algunas cosas no se mostraran ya que no es militar.");
                }
                contador++;
                contador2=2;
            }
            System.out.println();
        }
    }

    public void taulaAvions()
    {
        creaTabla();
        for (int fila = 0; fila < ArrTabla.length; fila++)
        {
            System.out.print(ArrTabla[fila]);
        }

        System.out.println();

        for (int fila=0;fila<EspacioAereo.size();fila++)
        {
            for (int columna=0;columna<18;columna++)
            {
                System.out.print(EspacioAereoAux[fila][columna]+"\t");
            }
            System.out.println();
        }
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
                System.out.println("X: " + info.getX());
                System.out.println("Y: " + info.getY());
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

                if (check.getX() == 100 && check.getY() == 100) {
                    return false;
                }
            }
        }
        return true;
    }

    public void Encriptar(){
        if(EspacioAereo.size() == 0){
            System.out.println("No hay ningun avión, es imposible encriptarlo");
        } else {
            String matricula;
            Encriptar encriptar = new Encriptar();
            System.out.println("Introduce la matricula del avion: ");
            matricula = sc.next();

            for (Aviones check : EspacioAereo) {

                if (check != null) {

                    if (matricula.equals(check.getMatricula())) {
                        try {
                            encriptar.Encriptar((AvionMilitar) check);
                        } catch (ClassCastException e) {
                            System.out.println("Un avión comercial no se puede cifrar");
                        }
                    } else {

                        System.out.println("El avion no se ha encontrado");

                    }
                }
            }
        }
    }

    public void Desencriptar(){
        if(EspacioAereo.size() == 0){
            System.out.println("No hay ningun avión, es imposible desencriptarlo");
        } else {
            String matricula;
            Encriptar encriptar = new Encriptar();
            System.out.println("Introduce la matricula del avion: ");
            matricula = sc.next();

                for (Aviones check : EspacioAereo) {

                if (check != null) {

                    if (matricula.equals(check.getMatricula())) {
                        try {
                            encriptar.desencriptar((AvionMilitar) check);
                        } catch (ClassCastException e) {
                            System.out.println("Un avión comercial no se puede cifrar");
                        }
                    } else {
                        System.out.println("El avion no se ha encontrado");

                    }
                }
            }
        }
    }

    public void LimpiaPantalla() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }
}