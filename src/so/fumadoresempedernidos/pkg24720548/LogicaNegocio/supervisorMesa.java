/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.fumadoresempedernidos.pkg24720548.LogicaNegocio;

/**
 *
 * @author YESID FERNANDEZ
 */
public class supervisorMesa {
    /*
     Cigarrillo
     */

    private final String CIGARRO = "ABC";
    /*
     ingredientes 
     */
    private String ingredientes = "";
    /*
     semáforo para el productor
     */
    public boolean disponibilidadProducir = true;
    /*
     semáforo para los consumidores
     */
    public boolean disponibilidadParaConsumir = false;
    /*
    semaforo para quien fume
    */
    public boolean fumando = false;
    public synchronized void colocarEnLaMesaIngredientes(String c) {
        while (!this.disponibilidadProducir) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        /*
         Seleccionar 2 ingredientes
         */
        this.ingredientes = c;
        /*
         Actualiza los semáforos
         */
        this.disponibilidadProducir = false;
        disponibilidadParaConsumir = true;
        /*
         notificarle a los demas procesos que usan este objeto
         */
        notifyAll();
    }

    public synchronized boolean prepararYFumar(String c) {
        while (!this.disponibilidadParaConsumir) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("el procesos"+c);
        /*
         verificar que los ingrediente si conviene? en caso de que sea 1 fumar
         0: perder el objeto
         */
        if (sePuedeFumar(c)) {
            System.out.println("Ha fumado el usuario:" + c);
            this.disponibilidadParaConsumir = false;
            this.disponibilidadProducir = true;
            notifyAll();
            return true;
            
        }
        notifyAll();
        return false;
        
    }

    public boolean sePuedeFumar(String c) {
        c += this.ingredientes;
        if (c.contains("A")&&c.contains("B")&&c.contains("C")) {
            return true;
        }
        return false;
    }
}
