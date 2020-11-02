package Clases;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encriptar {

    public void encriptar (AvionMilitar avio) {

        String encriptat;
        String arxiu = "C:/temp/"+avio.getMatricula()+".hash";

        encriptat = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        try (FileWriter fw = new FileWriter(arxiu, true)) {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                try (PrintWriter out = new PrintWriter(bw)) {

                    System.out.println(encriptat);

                }
            }
        } catch (IOException e) {

            e.printStackTrace();

        }

        avio.setMarca(Base64.getEncoder().encodeToString(avio.getMarca().getBytes(StandardCharsets.UTF_8)));
        avio.setModelo(Base64.getEncoder().encodeToString(avio.getModelo().getBytes(StandardCharsets.UTF_8)));
        avio.setCifrado(true);


    }

    public void desencriptar (AvionMilitar avio) {

        String comparacio;
        String hash = "";
        String arxiu = "C:/temp/"+avio.getMatricula()+".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu)));
            hash = hash.substring(0, hash.length() - 2);
        } catch (Exception e) {

            e.printStackTrace();

        }

        comparacio = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(comparacio)) {
            byte[] decodeMarca = Base64.getDecoder().decode(avio.getMarca().getBytes());
            byte[] decodeModel = Base64.getDecoder().decode(avio.getModelo().getBytes());

            avio.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avio.setModelo(new String(decodeModel, StandardCharsets.UTF_8));

            avio.setCifrado(false);

            File file = new File(arxiu);

            file.delete();

        } else {

            System.out.println("Verificació fallada");
        }

    }

}