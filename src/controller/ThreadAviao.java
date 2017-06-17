package controller;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadAviao extends Thread implements Runnable {

    private int idThread;
    private static int cta = 0;
    private Semaphore semaforo;
    private String estado;

    public ThreadAviao(int idThread, Semaphore semaforo) {
        this.idThread = idThread;
        this.semaforo = semaforo;
    }

    private synchronized void aviaoAterrissando() {
        System.out.println("O avião #" + idThread + " está Aterrissando");
        int tempo = (int) ((Math.random() * 300) + 100);

        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        }
       // aviaoTaxiandoChegada();
        //this.estado = "TaxiandoChegada";
        this.setPriority(10);
    }

    private synchronized void aviaoDecolando() {
        System.out.println("O avião #" + idThread + " está Decolando");
        int tempo = (int) ((Math.random() * 300) + 400);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        }
       // this.estado = null;
       this.setPriority(9);
    }

    private synchronized void aviaoTaxiandoChegada() {
        System.out.println("O avião #" + idThread + " está taxiando(Chegada)");
        int tempo = (int) ((Math.random() * 200) + 100);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        }
     //   aviaoEstacionado();
       // this.estado = "Estacionado";
       this.setPriority(5);
    }

    private synchronized void aviaoTaxiandoSaida() {
        System.out.println("O avião #" + idThread + " está taxiando(Saida)");
        int tempo = (int) ((Math.random() * 100) + 100);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        }
    //    aviaoDecolando();
      //  this.estado = "Decolando";
      this.setPriority(5);
    }

    private synchronized void aviaoEstacionado() {
        System.out.println("O avião #" + idThread + " está Estacionado");
        int tempo = (int) ((Math.random() * 300) + 500);
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        }
     //   aviaoTaxiandoSaida();
        //this.estado = "TaxiandoSaida";
        this.setPriority(1);
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            aviaoAterrissando();
            aviaoTaxiandoChegada();
            aviaoEstacionado();
            aviaoTaxiandoSaida();
            aviaoDecolando();

        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAviao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            semaforo.release();
        } 
    } 
}
