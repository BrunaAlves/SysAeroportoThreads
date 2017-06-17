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
        
        ArrayList<Integer> a = new ArrayList<Integer> ();
        a.add(1);
        a.add(5);
        a.add(9);
        a.add(10);
        
        for(int cta = 1; cta <= 6; cta++){
            Thread t = new ThreadAviao(cta, semaforo);
            Random r = new Random();
            t.setPriority(a.get(r.nextInt(3)));
            t.start();
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
    }
    
}
