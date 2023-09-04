package argregator.product;
 public class Product {
    private int id = 0;
    private int currentId ;
    private String name;
    private double price;


    public Product(int id, String name, double price) {
        this.id = id;
        this.currentId++;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.id = currentId;
        this.currentId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}