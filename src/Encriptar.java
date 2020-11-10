import Clases.AvionMilitar;
import Clases.Aviones;

import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encriptar {

    public Aviones encriptar (AvionMilitar avion) {

        String encriptat;
        String arxiu = "hashes/"+avion.getMatricula()+".hash";

        encriptat = Base64.getEncoder().encodeToString(avion.getMatricula().getBytes(StandardCharsets.UTF_8));

        try (FileWriter fw = new FileWriter(arxiu, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            out.println(encriptat);

        } catch (IOException e) {

            e.printStackTrace();

        }

        avion.setMarca(Base64.getEncoder().encodeToString(avion.getMarca().getBytes(StandardCharsets.UTF_8)));
        avion.setFabricante(Base64.getEncoder().encodeToString(avion.getFabricante().getBytes(StandardCharsets.UTF_8)));
        avion.setCapacidad(Base64.getEncoder().encodeToString(avion.getCapacidad().getBytes(StandardCharsets.UTF_8)));
        avion.setModelo(Base64.getEncoder().encodeToString(avion.getModelo().getBytes(StandardCharsets.UTF_8)));
        avion.setCifrado(true);

        return avion;


    }

    public Aviones desencriptar (AvionMilitar avion) {

        String comparacio;
        String hash = "";
        String arxiu = "hashes/" + avion.getMatricula() + ".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu)));
            hash = hash.substring(0, hash.length() - 2);
        } catch (Exception e) {

            e.printStackTrace();

        }

        comparacio = Base64.getEncoder().encodeToString(avion.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(comparacio)) {
            byte[] decodeMarca = Base64.getDecoder().decode(avion.getMarca().getBytes());
            byte[] decodeModel = Base64.getDecoder().decode(avion.getModelo().getBytes());

            avion.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avion.setModelo(new String(decodeModel, StandardCharsets.UTF_8));

            avion.setCifrado(false);

            File file = new File(arxiu);

            file.delete();

        } else {

            System.out.println("Verificació fallada");
        }

        return avion;

    }

}