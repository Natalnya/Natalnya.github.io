package lab1;

public class Hero {
    private String name;
    private Move strategy;

    public Hero(String name, Move strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    void setStrategy (Move strategy) {
        this.strategy = strategy;
    }
    void move(){
        System.out.print(name);
        strategy.move();
    }

}
