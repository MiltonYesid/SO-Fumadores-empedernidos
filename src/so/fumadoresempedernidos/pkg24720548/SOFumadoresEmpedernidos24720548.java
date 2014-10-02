/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.fumadoresempedernidos.pkg24720548;

import java.util.Scanner;
import so.fumadoresempedernidos.pkg24720548.LogicaNegocio.Consumidor;
import so.fumadoresempedernidos.pkg24720548.LogicaNegocio.Productor;
import so.fumadoresempedernidos.pkg24720548.LogicaNegocio.supervisorMesa;

/**
 *
 * @author YESID FERNANDEZ
 */
public class SOFumadoresEmpedernidos24720548 {

    /*
     cantidad de iteraciones
     */
    static int cantidadIteracciones = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        solicitarIteraccion();
        /*
         Objecto que comparten
         */
        supervisorMesa mesa = new supervisorMesa();
        /*
         Thread productor 
         */
        Productor productor = new Productor(mesa,cantidadIteracciones);
        /*
         Thread Consumidor o fumador
         A: Papel
         B: Tabaco
         C: Fosforo
         */
        Consumidor fumadorA = new Consumidor(mesa, "A",cantidadIteracciones);
        Consumidor fumadorB = new Consumidor(mesa, "B",cantidadIteracciones);
        Consumidor fumadorC = new Consumidor(mesa, "C",cantidadIteracciones);
        while(cantidadIteracciones>0)
        {
        productor.run();
        fumadorA.run();
        fumadorB.run();
        fumadorC.run();
        cantidadIteracciones--;
        }

    }

    private static void solicitarIteraccion() {
        /*
         Se solicita la cantidad de iteraciones
         */
        System.out.println("**************************************************");
        System.out.println("BIENVENIDO A LA CIGARRERÍA EMPEDERNIDOS");
        System.out.println("**************************************************");
        System.out.println("Se le solicita la cantidad de iteracciones");

        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextLine();
        cantidadIteracciones = Integer.parseInt(entradaTeclado);
    }

}
