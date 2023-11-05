package lab1;

public class Main {
    public static void main(String[] args) {
        Hero spiderMan = new Hero ("Spider man", new Fly());
        spiderMan.move();
        spiderMan.setStrategy(new Ride());
        spiderMan.move();

        Hero ironMan = new Hero ("Iron man", new Walk());
        ironMan.move();
        ironMan.setStrategy(new Fly());
        ironMan.move();
    }
}
