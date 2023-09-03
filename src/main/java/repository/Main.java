package repository;

import repository.productRepository.ProductRepository;
import repository.productRepository.SQLiteProductRepository;
import repository.product.*;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        String connectionString = "jdbc:sqlite:products.db";
        ProductRepository productRepository = new SQLiteProductRepository(connectionString);

// Создаем таблицу "products" при запуске
        productRepository.createTable();

//// Создаем продукт
//        Candy candy = new Candy("Конфетка", 19.99);
//        Cake cake = new Cake("Тортик", 15.99);
//        Cookie cookie  = new Cookie("Печенька", 22.99);
//        Juice juice  = new Juice("Сочок", 18.50);
//        Sweet sweet = new Sweet( "Сладость", 29.99);
//
//// Добавляем продукт в базу данных
//        productRepository.add(candy);
//        productRepository.add(cake);
//        productRepository.add(cookie);
//        productRepository.add(juice);
//        productRepository.add(sweet);

// Получаем продукт по ID


// Получаем все продукты
        List<Product> allProducts = productRepository.getAll();
        for (Product product : allProducts) {
            System.out.println("Id: " + product.getId());
            System.out.println("Продукт: " + product.getName());

        }

       Order order = new Order();

        OrderItem candypack = new OrderItem(productRepository.getById(1), 5);
        order.addItem(candypack);
        OrderItem cakepack = new OrderItem(productRepository.getById(2), 1);
        order.addItem(cakepack);
        OrderItem jucepack = new OrderItem(productRepository.getById(4), 2);
        order.addItem(jucepack);

        System.out.println("\nЗаказ:");

        List<OrderItem> allOrderedProducts = order.getItems();

        for (OrderItem orderItem : allOrderedProducts) {
            System.out.println("Продукт: " + orderItem.getProduct().getName()
                    + ". Количество: " + orderItem.getQuantity()
                    + " " + orderItem.getProduct().getValue()
                    + " Цена - " + orderItem.getProduct().getPrice()*orderItem.getQuantity()
                    + " руб. ");


        }
    }


}