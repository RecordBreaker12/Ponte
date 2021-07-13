package ponte;

import java.util.ArrayList;

public class Ponte extends Thread {
    ArrayList <String> carros = new ArrayList<>();
    Integer frente, fim; 
    
    public Ponte(){
        frente = -1;
        fim = -1;
    }
    
    public synchronized void depositar(String proximo){
        try{
            fim = fim + 1; 
            carros.add(proximo);
            if (frente == -1) {
                frente = fim; 
            }
            Thread.sleep(1000); 
            notifyAll();          
        }
        catch( InterruptedException e){}
    }
    
    public synchronized String retirar() throws InterruptedException{
        String item;
        while (carros.isEmpty()){
            wait();
        }
        item = carros.get(frente);
        carros.set(frente, null);
        frente++;
        for(int i = 1; i<=10; i++){
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println();
        notifyAll();
        return item;
    }
    
    @Override
    public void run(){
        String item;
        while(true){
            try {
                if(carros.size()==frente){
                    return;
                }
                item = retirar();
                System.out.println("Passou: "+item);
            } catch (InterruptedException ex) {}           
        }
        
    }
}