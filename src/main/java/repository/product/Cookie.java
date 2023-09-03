package repository.product;

public class Cookie extends Product{

    public Cookie(int id, String name, double price) {
        super(id, name, price);
    }

    public Cookie(String name, double price) {
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
