package ponte;

public class Carro extends Thread{
    Ponte ponte;
    String tipo;
    public Carro(Ponte fila, String tipo){
        ponte = fila;
        this.tipo = tipo;
    }
    
    @Override
    public void run(){
        switch(tipo){
            case "Ambulancia":
                this.setPriority(MAX_PRIORITY);
                break;
            case "Policia":
                this.setPriority(NORM_PRIORITY);
                break;
            case "Carro Comum":
                this.setPriority(MIN_PRIORITY);
                break;
        }
        ponte.depositar(tipo);
    }
}