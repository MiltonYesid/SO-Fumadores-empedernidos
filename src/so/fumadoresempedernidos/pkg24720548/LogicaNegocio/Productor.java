/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.fumadoresempedernidos.pkg24720548.LogicaNegocio;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YESID FERNANDEZ
 */
public class Productor extends Thread {

    private supervisorMesa mesa;
    private Random r = new Random();
    private int n = 0;

    public Productor(supervisorMesa t, int n) {
        /*
         Copia del objeto
         */
        mesa = t;
        this.n = n;
    }

    private String seleccionarIngredientes() {
        String c = "";
        switch (r.nextInt(9)) {
            case 0:
                c = "AB";
                break;
            case 2:
                c = "AC";
                break;
            case 3:
                c = "BC";
                break;
            case 4:
                c = "AB";
                break;
            case 5:
                c = "AC";
                break;
            case 6:
                c = "BC";
                break;
            case 7:
                c = "AB";
                break;
            case 8:
                c = "AC";
                break;
            case 9:
                c = "BC";
                break;
        }
        if (c == "") {
            c = seleccionarIngredientes();
        } else {
            return c;
        }
        return c;
    }

    public void run() {

        if (mesa.disponibilidadProducir) {
            String ingredientes = this.seleccionarIngredientes();
            System.out.println("El productor seleccionó los ingredientes" + ": " + ingredientes);
            mesa.colocarEnLaMesaIngredientes(ingredientes);
        }

    }

}
