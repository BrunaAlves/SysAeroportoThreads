package view;

import controller.ThreadAviao;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int permissoes = 1;

        Semaphore semaforo = new Semaphore(permissoes);
         System.out.println("Log da Torre de controle:\n");
        for (int i = 1; i <= 6; i++) {
            Thread t = new ThreadAviao("Avião #"+i, semaforo);
            t.start();
            // Random r = new Random();
            //  t.setPriority(a.get(r.nextInt(3)));
           // t.getPriority();
           
            
//            try {
//                t.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }
}
