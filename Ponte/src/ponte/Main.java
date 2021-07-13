package ponte;

import java.util.ArrayList;


public class Main {
    
    public static void main(String[] args) {
        ArrayList<Carro> fila = new ArrayList<>();
        Ponte ponte = new Ponte();
        fila.add(new Carro(ponte, "Policia"));
        fila.add(new Carro(ponte, "Carro Comum"));
        fila.add(new Carro(ponte, "Ambulancia"));
        fila.add(new Carro(ponte, "Carro Comum"));
        fila.add(new Carro(ponte, "Carro Comum"));
        fila.add(new Carro(ponte, "Policia"));
        ponte.start();
        fila.forEach(c -> {
            c.start();
        });
    }
    
}
