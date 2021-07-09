package ponte;


public class Main {

    
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Carro carro1 = new Carro(buffer, "Carro comum");
        Carro carro2 = new Carro(buffer, "Ambulancia");
        Carro carro3 = new Carro(buffer, "Carro comum");
        Carro carro4 = new Carro(buffer, "Carro comum");
        Carro carro5 = new Carro(buffer, "Viatura policial");
        Ponte ponte = new Ponte(buffer);
        carro1.start();
        carro2.start();
        carro3.start();
        carro4.start();
        carro5.start();
        ponte.start();
    }
    
}
