package repository.product;

public class Cake extends Product{

    public Cake(int id, String name, double price) {
        super(id, name, price);
    }

    public Cake(String name, double price) {
        super(name, price);
    }

    public String getType() {
        return this.getType();
    }

    @Override
    public String getValue() {
        return "шт.";
    }
}