/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.fumadoresempedernidos.pkg24720548.LogicaNegocio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YESID FERNANDEZ
 */
public class Consumidor extends Thread {

    private supervisorMesa mesa;
    private int n = 0;
    private String ID = "";

    public Consumidor(supervisorMesa m, String ID, int n) {
        this.ID = ID;
        mesa = m;
        this.n = n;
    }

    public void run() {
        
            if (mesa.disponibilidadParaConsumir) {
                boolean b = this.mesa.prepararYFumar(ID);
            }
        }
    
}
