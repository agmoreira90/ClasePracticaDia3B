package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FactoryPrecedable {
    public static Precedable crearPrecedable(String args[]) {
        Precedable p = null;
        String tipo = "";
        boolean isConfigurado = false;
        try {
            FileReader fr = new FileReader("./configFile");
            BufferedReader br = new BufferedReader(fr);
            while (isConfigurado == false && (tipo = br.readLine()) != null) {
                if (tipo.contains("FACTORY=")) {
                    tipo = tipo.split("=")[1];
                    isConfigurado = true;
                }
            }
            if (tipo.equals("Persona")){
                p = new Persona(args[0],Integer.parseInt(args[1]));
            } else {
                p = new Celular(Integer.parseInt(args[0]), args[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
