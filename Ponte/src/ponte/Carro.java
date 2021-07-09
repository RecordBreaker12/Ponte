package ponte;

public class Carro extends Thread{
    Buffer buffer;
    String tipo;
    public Carro(Buffer fila, String tipo){
        buffer = fila;
        this.tipo = tipo;
    }
    
    @Override
    public void run(){
        switch(tipo){
                case "Ambulancia":
                    this.setPriority(MAX_PRIORITY);
                    break;
                case "Viatura policial":
                    this.setPriority(5);
                    break;
                case "Carro comum":
                    this.setPriority(MIN_PRIORITY);
            }
        buffer.depositar(tipo);
    }
}