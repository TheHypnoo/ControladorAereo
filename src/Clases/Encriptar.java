package Clases;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encriptar {

    public Aviones Encriptar (AvionMilitar avion) {

        String arxiu = "C:\\Temp/"+avion.getMatricula()+".hash";
        String matricula;
        String aux;
        //Guardo la matricula para luego compararlo si es el mismo entonces desencripto
        matricula = Base64.getEncoder().encodeToString(avion.getMatricula().getBytes(StandardCharsets.UTF_8));

        String motor = String.valueOf(Base64.getEncoder().encodeToString(String.valueOf(avion.getMotor()).getBytes(StandardCharsets.UTF_8)));
        avion.setMotor(Boolean.parseBoolean(motor));
        String marca = Base64.getEncoder().encodeToString(avion.getMarca().getBytes(StandardCharsets.UTF_8));
        avion.setMarca(marca);
        String modelo = Base64.getEncoder().encodeToString(avion.getModelo().getBytes(StandardCharsets.UTF_8));
        avion.setModelo(modelo);
        String fabricante =Base64.getEncoder().encodeToString(avion.getFabricante().getBytes(StandardCharsets.UTF_8));
        avion.setFabricante(fabricante);
        aux = String.valueOf(avion.getCapacidad());
        String capacidad = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setCapacidad(Integer.parseInt(aux));
        aux = String.valueOf(avion.getTripulantes());
        String tripulante = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setTripulantes(Integer.parseInt(aux));
        String origen = Base64.getEncoder().encodeToString(String.valueOf(avion.getOrigen()).getBytes(StandardCharsets.UTF_8));
        avion.setOrigen(origen);
        String destino = (Base64.getEncoder().encodeToString(String.valueOf(avion.getDestino()).getBytes(StandardCharsets.UTF_8)));
        avion.setDestino(destino);
        aux = String.valueOf(avion.getAutonomia());
        String autonomia = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setAutonomia(Integer.parseInt(aux));
        aux = String.valueOf(avion.getRumbo());
        String rumbo = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setRumbo(Integer.parseInt(aux));
        aux = String.valueOf(avion.getBando());
        String bando = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setBando(Boolean.parseBoolean(aux));
        aux = String.valueOf(avion.getVelocidad());
        String velocidad = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setVelocidad(Double.parseDouble(aux));
        aux = String.valueOf(avion.getAltitud());
        String altitud = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setAltitud(Double.parseDouble(aux));
        aux = String.valueOf(avion.getTrenAterrizaje());
        String trenAterrizaje = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setTrenAterrizaje(Boolean.parseBoolean(aux));
        aux = String.valueOf(avion.getX());
        String posX = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setX(Integer.parseInt(aux));
        aux = String.valueOf(avion.getY());
        String posY = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setY(Integer.parseInt(aux));
        aux = String.valueOf(avion.getMisiles());
        String misiles = Base64.getEncoder().encodeToString(aux.getBytes(StandardCharsets.UTF_8));
        avion.setMisiles(Integer.parseInt(aux));



        try (FileWriter fw = new FileWriter(arxiu, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            out.println(matricula);
            out.println(motor);
            out.println(marca);
            out.println(modelo);
            out.println(fabricante);
            out.println(capacidad);
            out.println(tripulante);
            out.println(origen);
            out.println(destino);
            out.println(autonomia);
            out.println(rumbo);
            out.println(bando);
            out.println(velocidad);
            out.println(altitud);
            out.println(trenAterrizaje);
            out.println(posX);
            out.println(posY);
            out.println(misiles);

            System.out.println("Encriptamiento completado!");

        } catch (IOException e) {

            e.printStackTrace();

        }
        avion.setCifrado(true);
        return avion;
    }

    public Aviones desencriptar (AvionMilitar avion) {
        //El desencriptamiento no funciona correctamente...

        String hash = "";
        String arxiu = "C:\\Temp/"+avion.getMatricula()+".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu)));
            hash = hash.substring(0, hash.length() - 2);
        } catch (Exception e) {

            e.printStackTrace();

        }
        //Compruebo que es la misma matricula, asi sabre que de verdad ese es avion y no es otro
        String matricula = Base64.getEncoder().encodeToString(avion.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(matricula)) {
            byte[] decodeMotor = Base64.getDecoder().decode(String.valueOf(avion.getMotor()).getBytes());
            byte[] decodeMarca = Base64.getDecoder().decode(avion.getMarca().getBytes());
            byte[] decodeModelo = Base64.getDecoder().decode(avion.getModelo().getBytes());
            byte[] decodeFabricante = Base64.getDecoder().decode(avion.getFabricante().getBytes());
            byte[] decodeCapacidad = Base64.getDecoder().decode(String.valueOf(avion.getCapacidad()).getBytes());
            byte[] decodeTripulante = Base64.getDecoder().decode(String.valueOf(avion.getTripulantes()).getBytes());
            byte[] decodeOrigen = Base64.getDecoder().decode(String.valueOf(avion.getOrigen()).getBytes());
            byte[] decodeDestino = Base64.getDecoder().decode(String.valueOf(avion.getDestino()).getBytes());
            byte[] decodeAutonomia = Base64.getDecoder().decode(String.valueOf(avion.getAutonomia()).getBytes());
            byte[] decodeRumbo = Base64.getDecoder().decode(String.valueOf(avion.getRumbo()).getBytes());
            byte[] decodeBando = Base64.getDecoder().decode(String.valueOf(avion.getBando()).getBytes());
            byte[] decodeVelocidad = Base64.getDecoder().decode(String.valueOf(avion.getVelocidad()).getBytes());
            byte[] decodeAltitud = Base64.getDecoder().decode(String.valueOf(avion.getAltitud()).getBytes());
            byte[] decodeTrenAterrizaje = Base64.getDecoder().decode(String.valueOf(avion.getTrenAterrizaje()).getBytes());
            byte[] decodePosX = Base64.getDecoder().decode(String.valueOf(avion.getX()).getBytes());
            byte[] decodePosY = Base64.getDecoder().decode(String.valueOf(avion.getY()).getBytes());
            byte[] decodeMisiles = Base64.getDecoder().decode(String.valueOf(avion.getMisiles()).getBytes());

            avion.setMotor(Boolean.parseBoolean(new String(decodeMotor, StandardCharsets.UTF_8)));
            avion.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avion.setModelo(new String(decodeModelo, StandardCharsets.UTF_8));
            avion.setFabricante(new String(decodeFabricante,StandardCharsets.UTF_8));
            avion.setCapacidad(Integer.parseInt(new String(decodeCapacidad, StandardCharsets.UTF_8)));
            avion.setTripulantes(Integer.parseInt(new String(decodeTripulante, StandardCharsets.UTF_8)));
            avion.setOrigen(new String(decodeOrigen,StandardCharsets.UTF_8));
            avion.setDestino(new String(decodeDestino,StandardCharsets.UTF_8));
            avion.setAutonomia(Integer.parseInt(new String(decodeAutonomia, StandardCharsets.UTF_8)));
            avion.setRumbo(Integer.parseInt(new String(decodeRumbo, StandardCharsets.UTF_8)));
            avion.setBando(Boolean.parseBoolean(new String(decodeBando, StandardCharsets.UTF_8)));
            avion.setVelocidad(Integer.parseInt(new String(decodeVelocidad, StandardCharsets.UTF_8)));
            avion.setAltitud(Integer.parseInt(new String(decodeAltitud, StandardCharsets.UTF_8)));
            avion.setTrenAterrizaje(Boolean.parseBoolean(new String(decodeTrenAterrizaje, StandardCharsets.UTF_8)));
            avion.setX(Integer.parseInt(new String(decodePosX, StandardCharsets.UTF_8)));
            avion.setY(Integer.parseInt(new String(decodePosY, StandardCharsets.UTF_8)));
            avion.setMisiles(Integer.parseInt(new String(decodeMisiles, StandardCharsets.UTF_8)));

            avion.setCifrado(false);

            File file = new File(arxiu);

            file.delete();
            System.out.println("Desencriptamiento completado!");

        }

        return avion;

    }

}