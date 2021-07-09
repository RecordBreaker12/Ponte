package ponte;

import java.util.ArrayList;


public class Main {
    
    public static void main(String[] args) {
        ArrayList<Carro> fila = new ArrayList<>();
        Ponte ponte = new Ponte(6);
        Carro carro0 = new Carro(ponte, "Policia");
        Carro carro1 = new Carro(ponte, "Carro Comum");
        Carro carro2 = new Carro(ponte, "Ambulancia");
        Carro carro3 = new Carro(ponte, "Carro Comum");
        Carro carro4 = new Carro(ponte, "Carro Comum");
        Carro carro5 = new Carro(ponte, "Policia");
        fila.add(carro0);
        fila.add(carro1);
        fila.add(carro2);
        fila.add(carro3);
        fila.add(carro4);
        fila.add(carro5);
        ponte.start();
        fila.forEach(c -> {
            c.start();
        });
    }
    
}
