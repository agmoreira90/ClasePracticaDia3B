package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Celular implements Precedable<Celular>{
    private Integer numero;
    private String titular;

    public Celular() {
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Numero - " + numero +" - Titular='" + titular + '\'';
    }

    @Override
    public int precedeA(Celular celular) {
        String criterio = "";
        boolean isConfigurado = false;
        int precede = 0;
        try {
            FileReader fr = new FileReader("./configFile");
            BufferedReader br = new BufferedReader(fr);
            while (isConfigurado == false && (criterio = br.readLine()) != null) {
                if (criterio.contains("CRITERIO=")) {
                    criterio = criterio.split("=")[1];
                    isConfigurado = true;
                }
            }
            if (criterio.equals("NUMERO")) {
                precede = this.numero - celular.numero;
            }
            if (criterio.equals("TITULAR")) {
                if (this.titular != "" && celular.titular != "") {
                    precede = this.titular.compareTo(celular.titular);
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
