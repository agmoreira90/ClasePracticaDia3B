package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Persona implements Precedable<Persona> {
    private String nombre;
    private Integer dni;

    public Persona() {
    }

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' + "- DNI=" + dni;
    }

    @Override
    public int precedeA(Persona persona) {
        String criterio = "";
        boolean isConfigurado = false;
        FileReader fr = null;
        int precede = 0;
        try {
            fr = new FileReader("./configFile");
            BufferedReader br = new BufferedReader(fr);
            while (isConfigurado == false && (criterio = br.readLine()) != null) {
                if (criterio.contains("CRITERIO=")) {
                    criterio = criterio.split("=")[1];
                    isConfigurado = true;
                }
            }
            if (criterio.equals("DNI")) {

                precede = this.dni - persona.dni;
            }
            if (criterio.equals("NOMBRE")) {
                if (this.nombre != "" && persona.nombre != "") {
                    precede = this.nombre.compareTo(persona.nombre);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return precede;
    }
}
