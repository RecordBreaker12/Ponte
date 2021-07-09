package ponte;

import java.util.Objects;

public class Ponte extends Thread {
    String carros[];
    Integer frente, fim, tamanhoMax, tamanhoAtual; 
    
    public Ponte(int tamanhoMax){
        carros = new String[tamanhoMax];
        this.tamanhoMax = tamanhoMax;
        frente = -1;
        fim = -1; 
        this.tamanhoAtual = 0; 
    }
    
    public synchronized void depositar(String proximo){
        try{
            while (Objects.equals(tamanhoAtual, tamanhoMax) ){
                wait(); 
            }
            fim = (fim + 1) % tamanhoMax; 
            carros[fim] = proximo;
            tamanhoAtual++; 
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
        while (tamanhoAtual == 0){
            wait();
        }
        item = carros[frente];
        carros[frente] = null;
        frente = (frente + 1) % tamanhoMax;
        tamanhoAtual--;  
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
        for (int i = 0; i<6; i++){
            try {
                item = retirar();
                System.out.println("Passou: "+item);
            } catch (InterruptedException ex) {}           
        }
        
    }
}