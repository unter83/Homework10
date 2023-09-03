package repository.product;


public class Juice extends Product{

    public Juice(int id, String name, double price) {
        super(id, name, price);
    }

    public Juice(String name, double price) {
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