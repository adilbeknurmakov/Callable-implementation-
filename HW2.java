/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author adilbek.nurmakov
 */
public class HW2  {
/*Adilbek Nurmakov*/
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException  {
     ExecutorService executor = Executors.newCachedThreadPool();
    
      Callable<String> call=() -> {
          String st="gogogo";
          System.out.println("Starts here ");
          Thread.sleep(1000); //sleep for 1 second
          System.out.println("Ends there");
          
          return st;
     };
      
      
     Future<String> future = executor.submit(call);//submission of call to executor service
     Runnable run=() -> {//new thread created to make free the main thread. Output of main thread is printed immediately 
         try {
             System.out.println(future.get()) ;
         } catch (InterruptedException | ExecutionException ex) {
             Logger.getLogger(HW2.class.getName()).log(Level.SEVERE, null, ex);
         }
     };
      executor.submit(run);
      
      System.out.println("DDDD"); 
       executor.shutdown();
    
    }

         
}
    