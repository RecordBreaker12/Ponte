package ponte;

public class Ponte extends Thread {
    Buffer buffer;
    
    public Ponte(Buffer fila){
        buffer = fila; 
    }
    
    @Override
    public void run(){
        String item;
        for (int i = 0; i<5; i++){
            try {
                item = buffer.retirar();
                System.out.println("Passou: "+item);
            } catch (InterruptedException ex) {}           
        }
        
    }
}